package com.CourtTrackerNba.auth;

import com.CourtTrackerNba.users.Users;
import com.CourtTrackerNba.users.dto.UsersCreatDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> create(@RequestBody UsersCreatDto dto){
        logger.info("action=create_user_request, email={}", authService.maskEmail(dto.email()));

        try {
            Users user = authService.create(dto);

            logger.info("action=create_user_success, userId={}, email={}",
                    user.getId(), authService.maskEmail(user.getEmail()));

            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (Exception e) {
            logger.error("action=create_user_error, email={}, error={}",
                    authService.maskEmail(dto.email()), e.getMessage(), e);
            throw e;
        }
    }
}
