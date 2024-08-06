CREATE TABLE "UserRolePerm" (
    user_role_perm_id UUID PRIMARY KEY,
    role_id UUID REFERENCES "Role" (role_id) ON DELETE CASCADE,
    perm_id UUID REFERENCES "Permission" (perm_id) ON DELETE CASCADE
);
