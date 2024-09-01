package com.example.video_service.service;

import com.example.course_service.model.Video;
import com.example.video_service.model.*;
import com.example.video_service.repository.VideoProgressRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VideoProgressService {

    @Autowired
    private VideoProgressRepository videoProgressRepository;

    private final CourseClient courseClient;

    @Autowired
    public VideoProgressService(CourseClient courseClient) {
        this.courseClient = courseClient;
    }

    @CircuitBreaker(name = "courseServiceCircuitBreaker", fallbackMethod = "getVideoDetailsFallback")
    public Video getVideoDetails(UUID videoId) {
        return courseClient.getVideoById(videoId);
    }

    public Video getVideoDetailsFallback(UUID videoId, Throwable throwable) {
        // Log the exception for monitoring and debugging
        System.err.println("Failed to retrieve video details for videoId: " + videoId);
        throwable.printStackTrace();

        // Return a default video object or null as a fallback
        return new Video(
                videoId,
                null, // Default or null CourseContent
                "Default Video URL",
                0, // Default duration
                LocalDateTime.now(), // Default last watched time
                0 // Default watched duration
        );
    }

    public VideoProgress saveOrUpdateProgress(VideoProgress videoProgress) {
        return videoProgressRepository.save(videoProgress);
    }

    public VideoProgress getProgress(UUID userId, UUID videoId) {
        return videoProgressRepository.findByUserIdAndVideoId(userId, videoId);
    }

    public void syncProgress(SyncProgressRequest request) {
        for (VideoProgress videoProgress : request.getProgressData()) {
            saveOrUpdateProgress(videoProgress);
        }
    }

    public List<VideoProgress> getAllProgressForUser(UUID userId) {
        return videoProgressRepository.findByUserId(userId);
    }

    public void deleteProgress(UUID userId, UUID videoId) {
        VideoProgress existingProgress = videoProgressRepository.findByUserIdAndVideoId(userId, videoId);
        if (existingProgress != null) {
            videoProgressRepository.delete(existingProgress);
        }
    }

    public ProgressSummary getProgressSummary(UUID videoId) {
        List<VideoProgress> progressList = videoProgressRepository.findByVideoId(videoId);
        int totalDuration = progressList.stream().mapToInt(VideoProgress::getWatchedDuration).sum();
        float completionRate = calculateCompletionRate(videoId, progressList);
        return new ProgressSummary(videoId, totalDuration, completionRate);
    }

    public float calculateCompletionRate(UUID videoId, List<VideoProgress> progressList) {
        // Calculate the total watched duration for the given video
        int totalWatchedDuration = progressList.stream()
                .filter(progress -> progress.getVideoId().equals(videoId))
                .mapToInt(VideoProgress::getWatchedDuration)
                .sum();

        // Fetch actual video details from course-service to get the correct duration
        Video videoDetails = getVideoDetails(videoId);
        int totalVideoDuration = videoDetails != null ? videoDetails.getDuration() : 3600; // Default to 1 hour if not found

        // Calculate completion rate
        if (totalVideoDuration == 0) {
            return 0.0f; // Avoid division by zero
        }
        return Math.min(1.0f, (float) totalWatchedDuration / totalVideoDuration);
    }

    public UserEngagement getUserEngagementMetrics(UUID userId) {
        List<VideoProgress> progressList = videoProgressRepository.findByUserId(userId);
        int totalWatchedDuration = progressList.stream().mapToInt(VideoProgress::getWatchedDuration).sum();
        List<VideoEngagement> mostWatchedVideos = getMostWatchedVideos(progressList);
        return new UserEngagement(userId, totalWatchedDuration, mostWatchedVideos);
    }

    public List<VideoEngagement> getMostWatchedVideos(List<VideoProgress> progressList) {
        // Group by videoId and sum watchedDuration
        Map<UUID, Integer> videoDurationMap = progressList.stream()
                .collect(Collectors.groupingBy(
                        VideoProgress::getVideoId,
                        Collectors.summingInt(VideoProgress::getWatchedDuration)
                ));

        // Sort videos by total watched duration in descending order
        List<Map.Entry<UUID, Integer>> sortedEntries = videoDurationMap.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .collect(Collectors.toList());

        // Limit to top 10 most watched videos (or any other number as needed)
        return sortedEntries.stream()
                .limit(10)
                .map(entry -> new VideoEngagement(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public int calculateAverageWatchedDuration(UUID videoId, List<VideoProgress> progressList) {
        return progressList.stream().mapToInt(VideoProgress::getWatchedDuration).sum() / progressList.size();
    }

    public int calculateTotalWatchedDuration(List<VideoProgress> progressList) {
        return progressList.stream().mapToInt(VideoProgress::getWatchedDuration).sum();
    }
}
