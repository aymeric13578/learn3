CREATE TABLE "CourseContent" (
    content_id UUID PRIMARY KEY,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    content_type VARCHAR NOT NULL,
    content_data TEXT
);
