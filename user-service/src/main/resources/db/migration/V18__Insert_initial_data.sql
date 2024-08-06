-- Insert initial roles
INSERT INTO "Role" (role_id, name) VALUES
    ('e6e6f1cb-1b37-4b8b-9de8-72ed2a2e7e28', 'Admin'),
    ('b6e9d5e8-2f27-4b9d-9a16-78706b7ae5ee', 'Instructor'),
    ('dba3e370-185c-4e2e-9d2a-26b4099f850b', 'Student');

-- Insert initial permissions
INSERT INTO "Permission" (perm_id, name) VALUES
    ('d9e48d27-6bde-4b9f-9b79-9d6c065e6b69', 'View Courses'),
    ('1f3b3f4d-39e6-4de0-a1b7-39b2d7d1b6d6', 'Enroll in Courses'),
    ('b8a0a6f8-4523-45e6-a5dc-42b8820e2b2f', 'Manage Users');

-- Insert initial users
INSERT INTO "User" (user_id, username, email, password, first_name, last_name) VALUES
    ('f934a0de-8c09-4f1d-b48e-0ebc0380f4c1', 'admin', 'admin@example.com', 'adminpass', 'Admin', 'User'),
    ('6e0e9f5b-d28c-4624-b7eb-34d66ed6a0dc', 'instructor', 'instructor@example.com', 'instructorpass', 'John', 'Doe'),
    ('7c8df7e7-cf59-4f71-8acb-4a78e0d29c68', 'student', 'student@example.com', 'studentpass', 'Jane', 'Smith');

-- Insert initial user-role mappings
INSERT INTO "UserRole" (user_role_id, user_id, role_id) VALUES
    ('7c787fc6-7baf-4b44-93e7-4e5c80f79c46', 'f934a0de-8c09-4f1d-b48e-0ebc0380f4c1', 'e6e6f1cb-1b37-4b8b-9de8-72ed2a2e7e28'),
    ('e19f14e4-0d78-4f93-841c-2f6e3eae6b58', '6e0e9f5b-d28c-4624-b7eb-34d66ed6a0dc', 'b6e9d5e8-2f27-4b9d-9a16-78706b7ae5ee'),
    ('39ed2d24-8b6e-4487-8a8f-fc3f057d8ec6', '7c8df7e7-cf59-4f71-8acb-4a78e0d29c68', 'dba3e370-185c-4e2e-9d2a-26b4099f850b');
