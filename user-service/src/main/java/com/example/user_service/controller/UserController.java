package com.example.user_service.controller;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/activity")
    public String getUserActivity(@RequestParam String userId) {
        return userService.getUserActivity(userId);
    }
}
