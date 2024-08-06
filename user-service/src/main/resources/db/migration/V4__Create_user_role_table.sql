CREATE TABLE "UserRole" (
    user_role_id UUID PRIMARY KEY,
    user_id UUID REFERENCES "User" (user_id) ON DELETE CASCADE,
    role_id UUID REFERENCES "Role" (role_id) ON DELETE CASCADE
);
