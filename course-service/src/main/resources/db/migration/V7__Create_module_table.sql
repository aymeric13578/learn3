CREATE TABLE "Module" (
    module_id UUID PRIMARY KEY,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    title VARCHAR NOT NULL,
    content TEXT,
    "order" INT
);
