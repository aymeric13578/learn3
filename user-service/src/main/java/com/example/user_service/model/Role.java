package com.example.user_service.model;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    private UUID roleId;

    private String name;

}
