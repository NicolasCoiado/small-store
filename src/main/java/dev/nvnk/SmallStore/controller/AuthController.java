package dev.nvnk.SmallStore.controller;

import dev.nvnk.SmallStore.controller.dto.request.LoginEmailRequest;
import dev.nvnk.SmallStore.controller.dto.request.UserAccountRequest;
import dev.nvnk.SmallStore.controller.dto.response.UserAccountResponse;
import dev.nvnk.SmallStore.entity.UserAccount;
import dev.nvnk.SmallStore.security.TokenService;
import dev.nvnk.SmallStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register (@RequestBody UserAccountRequest userRequest){
        UserAccountResponse savedUser = userService.registerUserAccount(userRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "The user has been successfully registered. Check your email to verify your account.");
        response.put("User details", savedUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUsingEmail (@RequestBody LoginEmailRequest loginEmailRequest) {
        var authToken = new UsernamePasswordAuthenticationToken(loginEmailRequest.email(), loginEmailRequest.password());
        var auth = authenticationManager.authenticate(authToken);

        var token = tokenService.generateToken((UserAccount) auth.getPrincipal());

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Login successful.");
        response.put("Token", token);

        return ResponseEntity.ok(response);
    }

}
