package com.mariacorredoira.gestorreservasback.users.infrastructure.controller;

import com.mariacorredoira.gestorreservasback.users.application.CreateUserUseCase;
import com.mariacorredoira.gestorreservasback.users.application.LoginUserUseCase;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.mapper.UserControllerMapper;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.LoginRequest;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.UserRequest;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.LoginResponse;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest request) {
        User user = createUserUseCase.execute(request);
        UserResponse userResponse = UserControllerMapper.toUserResponse(user);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody @Valid LoginRequest request) {
        String jwtToken = loginUserUseCase.execute(request);
        LoginResponse loginResponse = UserControllerMapper.toLoginResponse(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }


}