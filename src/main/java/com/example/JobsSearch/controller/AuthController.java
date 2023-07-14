package com.example.JobsSearch.controller;

import com.example.JobsSearch.model.User;
import com.example.JobsSearch.payload.Request.LoginRequest;
import com.example.JobsSearch.payload.Request.SignupRequest;
import com.example.JobsSearch.payload.Response.ResponseObject;
import com.example.JobsSearch.service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest) {
        User user = authService.signup(signupRequest);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new ResponseObject("failed", "sign up failed", ""));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseObject("ok","sign up successfully", user));
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        // Lấy thông tin authentication của người dùng hiện tại
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // Xóa thông tin authentication và phiên làm việc hiện tại
            new SecurityContextLogoutHandler().logout(request, null, authentication);
        }

        return ResponseEntity.ok("Đăng xuất thành công");
    }
}
