CREATE TABLE "Course" (
    course_id UUID PRIMARY KEY,
    title VARCHAR NOT NULL,
    description TEXT,
    instructor_id UUID REFERENCES "User" (user_id),
    price NUMERIC,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
