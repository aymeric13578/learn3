CREATE TABLE "Feedback" (
    feedback_id UUID PRIMARY KEY,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    feedback_type VARCHAR NOT NULL,
    feedback_data TEXT
);
