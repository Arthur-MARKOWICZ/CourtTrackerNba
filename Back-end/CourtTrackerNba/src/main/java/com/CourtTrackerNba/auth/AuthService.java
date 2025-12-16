package com.CourtTrackerNba.auth;

import com.CourtTrackerNba.exceptions.UserAlreadyExistsException;
import com.CourtTrackerNba.security.TokenService;
import com.CourtTrackerNba.users.UserRepository;
import com.CourtTrackerNba.users.UserService;
import com.CourtTrackerNba.users.Users;
import com.CourtTrackerNba.users.dto.UsersCreatDto;
import io.swagger.v3.oas.annotations.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder encoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.tokenService = tokenService;
    }
    public Users create(UsersCreatDto dto){
        logger.debug("action=create_user_start, email={}", maskEmail(dto.email()));


        if (userRepository.existsByEmail(dto.email())) {
            logger.warn("action=create_user_validation_failed, reason=email_exists, email={}",
                    maskEmail(dto.email()));
            throw new UserAlreadyExistsException("Email already registered");
        }


        String passwordEncode = encoder.encode(dto.password());
        Users user = new Users();
        user.setEmail(dto.email());
        user.setPassword(passwordEncode);
        user.setUsername(dto.username());
        user.setCreated(LocalDateTime.now());
        user.setActive(true);
        user.setUpdated(LocalDateTime.now());

        logger.debug("action=save_user_db, email={}", maskEmail(dto.email()));
        userRepository.save(user);

        logger.info("action=create_user_complete, userId={}, username={}",
                user.getId(), user.getUsername());

        return user;

    }
    public String maskEmail(String email) {
        if (email == null) return "null";
        int atIndex = email.indexOf('@');
        if (atIndex <= 1) return "***" + email.substring(atIndex);
        return email.substring(0, 2) + "***" + email.substring(atIndex);
    }
}
