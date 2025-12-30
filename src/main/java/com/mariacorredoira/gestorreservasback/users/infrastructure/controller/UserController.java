package com.mariacorredoira.gestorreservasback.users.infrastructure.controller;

import com.mariacorredoira.gestorreservasback.security.SecurityUser;
import com.mariacorredoira.gestorreservasback.shared.PageResponse;
import com.mariacorredoira.gestorreservasback.users.application.*;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.mapper.UserControllerMapper;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.LoginRequest;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.UserRequest;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.LoginResponse;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserDetailResponse;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

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

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long id, @RequestBody @Valid UserRequest request) {
        User user = updateUserUseCase.execute(id, request);
        UserResponse userResponse = UserControllerMapper.toUserResponse(user);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PageResponse<UserDetailResponse>> getAllUsers(@RequestParam Integer page,
                                                                        @RequestParam Integer size,
                                                                        @RequestParam(required = false) String name,
                                                                        @RequestParam(required = false) String firstSurname,
                                                                        @RequestParam(required = false) String secondSurname) {
        PageResponse<User> users = getUsersUseCase.execute(name, firstSurname, secondSurname, page, size);
        PageResponse<UserDetailResponse> userResponses = UserControllerMapper.toUserResponsePage(users);
        return ResponseEntity.ok(userResponses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponse> getUserByIdUseCase(@PathVariable long id) {
        User user = getUserByIdUseCase.execute(id);
        UserDetailResponse userResponse = UserControllerMapper.toUserDetailResponse(user);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<UserDetailResponse> getUserByInfo(@AuthenticationPrincipal SecurityUser securityUser) {
        User user = securityUser.getUser();
        UserDetailResponse userResponse = UserControllerMapper.toUserDetailResponse(user);
        return ResponseEntity.ok(userResponse);

    }

}