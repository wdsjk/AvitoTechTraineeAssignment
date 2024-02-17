package wdsjk.project.avitotechtrainee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wdsjk.project.avitotechtrainee.entity.UserEntity;
import wdsjk.project.avitotechtrainee.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<String> addUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}
