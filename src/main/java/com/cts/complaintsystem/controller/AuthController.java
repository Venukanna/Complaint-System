package com.cts.complaintsystem.controller;




import com.cts.complaintsystem.dto.LoginRequest;
import com.cts.complaintsystem.dto.RegisterRequest;
import com.cts.complaintsystem.model.User;
import com.cts.complaintsystem.service.UserService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req){
        User user = new User();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest req){
        return userService.login(req.getEmail(), req.getPassword());
    }
}
