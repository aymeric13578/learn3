# Video Service

The Video Service is a microservice responsible for tracking and managing video progress in an e-learning platform. It supports functionality for updating, retrieving, syncing, and analyzing video progress data.

## Features

- **Track Video Progress:** Update and retrieve progress for individual videos.
- **Sync Progress:** Sync progress data across multiple devices.
- **Progress Summary:** Get summaries of progress statistics for specific videos.
- **Engagement Metrics:** Retrieve engagement metrics for users.
- **Real-Time Updates:** Handle real-time progress updates.

## Endpoints

### 1. Update Progress

**POST /progress/update**

Updates or creates progress for a video for a specific user.

**Request Body:**

```json
{
  "userId": "UUID",
  "videoId": "UUID",
  "watchedDuration": "INT",
  "lastWatched": "ISO8601-DATE"
}
```
### 2. Get Progress

**GET /progress/{userId}/{videoId}**

Retrieves the progress of a specific video for a user.

**Response Body:**

```json
{
  "userId": "UUID",
  "videoId": "UUID",
  "watchedDuration": "INT",
  "lastWatched": "ISO8601-DATE"
}

```

### 3. Sync Progress

**POST /progress/sync**

Syncs progress data from multiple devices.

**Request Body:**

```json
{
  "userId": "UUID",
  "progressData": [
    {
      "videoId": "UUID",
      "watchedDuration": "INT",
      "lastWatched": "ISO8601-DATE"
    }
  ]
}

```
### 4. Get All Progress for User

**GET /progress/{userId}**

Updates or creates progress for a video for a specific user.

**Response Body:**

```json
{
  "userId": "UUID",
  "progressData": [
    {
      "videoId": "UUID",
      "watchedDuration": "INT",
      "lastWatched": "ISO8601-DATE"
    }
  ]
}

```
### 5. Delete Progress

**DELETE /progress/{userId}/{videoId}**

Deletes progress data for a specific video for a user.

**Response Body:**

```json
{
  "message": "Progress deleted successfully"
}


```
### 6. Get Progress Summary

**GET /progress/summary/{videoId}**

Retrieves a summary of progress statistics for a specific video, such as average watched duration and completion rate.

**Response Body:**

```json
{
  "videoId": "UUID",
  "averageWatchedDuration": "INT",
  "completionRate": "FLOAT"
}

```
### 7. Get User Engagement Metrics

**GET /progress/engagement/{userId}**

Retrieves engagement metrics for a user, such as total watched duration and most frequently watched videos.

**Response Body:**

```json
{
  "userId": "UUID",
  "totalWatchedDuration": "INT",
  "mostWatchedVideos": [
    {
      "videoId": "UUID",
      "watchedDuration": "INT"
    }
  ]
}

```
### 8. Real-Time Progress Updates

**POST /progress/realtime**

Receives real-time updates about progress changes.


**Request Body:**

```json
{
  "userId": "UUID",
  "videoId": "UUID",
  "watchedDuration": "INT",
  "lastWatched": "ISO8601-DATE"
}

```


