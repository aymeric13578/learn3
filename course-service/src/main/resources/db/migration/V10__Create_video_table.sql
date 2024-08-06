CREATE TABLE "Video" (
    video_id UUID PRIMARY KEY,
    course_content_id UUID REFERENCES "CourseContent" (content_id) ON DELETE CASCADE,
    video_url TEXT NOT NULL,
    duration INT
);
