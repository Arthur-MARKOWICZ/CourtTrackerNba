package com.CourtTrackerNba.users;


import com.CourtTrackerNba.exceptions.UserAlreadyExistsException;
import com.CourtTrackerNba.security.TokenService;
import com.CourtTrackerNba.users.dto.UsersCreatDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final TokenService tokenService;
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;

    }

}
