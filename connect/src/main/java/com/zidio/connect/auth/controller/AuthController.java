package com.zidio.connect.auth.controller;

import com.zidio.connect.auth.dto.*;
import com.zidio.connect.auth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private StudentAuthService studentService;
    @Autowired
    private RecruiterAuthService recruiterService;
    @Autowired
    private AdminAuthService adminService;

    @PostMapping("/student/register")
    public LoginResponse registerStudent(@RequestBody RegisterRequest request) {
        return studentService.register(request);
    }

    @PostMapping("/student/login")
    public ResponseEntity<LoginResponse> loginStudent(@RequestBody LoginRequest request) {
        LoginResponse response = studentService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recruiter/register")
    public LoginResponse registerRecruiter(@RequestBody RegisterRequest request) {
        return recruiterService.register(request);
    }

    @PostMapping("/recruiter/login")
    public LoginResponse loginRecruiter(@RequestBody LoginRequest request) {
        return recruiterService.login(request);
    }

    @PostMapping("/admin/register")
    public LoginResponse registerAdmin(@RequestBody RegisterRequest request) {
        return adminService.register(request);
    }

    @PostMapping("/admin/login")
    public LoginResponse loginAdmin(@RequestBody LoginRequest request) {
        return adminService.login(request);
    }
}