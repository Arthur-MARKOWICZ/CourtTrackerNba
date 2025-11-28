package com.CourtTrackerNba.users;

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
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UsersCreatDto dto){
        logger.info("action=create_user_request, email={}", userService.maskEmail(dto.email()));

        try {
            Users user = userService.create(dto);

            logger.info("action=create_user_success, userId={}, email={}",
                    user.getId(), userService.maskEmail(user.getEmail()));

            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (Exception e) {
            logger.error("action=create_user_error, email={}, error={}",
                    userService.maskEmail(dto.email()), e.getMessage(), e);
            throw e;
        }
    }
}
