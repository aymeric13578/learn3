CREATE TABLE "CourseMaterial" (
    material_id UUID PRIMARY KEY,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    material_type VARCHAR NOT NULL,
    material_data TEXT
);
