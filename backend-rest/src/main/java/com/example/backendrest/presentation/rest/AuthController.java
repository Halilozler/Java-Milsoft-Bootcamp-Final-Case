package com.example.backendrest.presentation.rest;

import com.example.backendrest.base.Util.JwtUtils;
import com.example.backendrest.base.exception.NotFoundException;
import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.*;
import com.example.backendrest.business.service.abstracts.AuthService;
import com.example.backendrest.business.service.concretes.UserDetailsImpl;
import com.example.backendrest.data.entity.ERole;
import com.example.backendrest.data.entity.Role;
import com.example.backendrest.data.entity.Users;
import com.example.backendrest.data.repository.RoleRepository;
import com.example.backendrest.data.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AuthService authService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public BaseResponse<UserDto> getUserNameAndEmail(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        Users user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
        BaseResponse<Integer> basketSize = authService.GetBasketCount(userId);
        if(basketSize.isSuccessful() == false){
            return BaseResponse.fail(basketSize.getErrors(), 500);
        }
        return BaseResponse.Success(new UserDto(user.getUsername(), user.getEmail(), basketSize.getData()), 200);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(BaseResponse.Success(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()), 200));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(BaseResponse.fail("Error: Username is already taken!", 404));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(BaseResponse.fail("Error: Email is already in use!", 404));
        }

        // Create new user's account
        Users user = new Users(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        /*
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });

        }
        */
        return ResponseEntity.ok(
                BaseResponse.Success("User registered successfully!", 201)
        );
    }
}
