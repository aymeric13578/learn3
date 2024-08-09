package com.example.video_service.service;

@Entity
@Table(name = "progress")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProgressService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID progressId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(name = "last_watched")
    private LocalDateTime lastWatched;

    @Column(name = "watched_duration")
    private Integer watchedDuration;
}
