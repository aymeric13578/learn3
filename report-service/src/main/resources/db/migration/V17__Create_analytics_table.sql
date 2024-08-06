CREATE TABLE "Analytics" (
    analytics_id UUID PRIMARY KEY,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    activity_type VARCHAR NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
