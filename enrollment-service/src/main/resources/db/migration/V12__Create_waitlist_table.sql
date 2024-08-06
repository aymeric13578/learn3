CREATE TABLE "Waitlist" (
    waitlist_id UUID PRIMARY KEY,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
