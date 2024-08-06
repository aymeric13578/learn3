CREATE TABLE "Review" (
    review_id UUID PRIMARY KEY,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
