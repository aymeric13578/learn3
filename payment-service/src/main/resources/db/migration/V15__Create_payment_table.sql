CREATE TABLE "Payment" (
    payment_id UUID PRIMARY KEY,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    course_id UUID REFERENCES "Course" (course_id) ON DELETE CASCADE,
    amount NUMERIC NOT NULL,
    status VARCHAR NOT NULL,
    transaction_id VARCHAR,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
