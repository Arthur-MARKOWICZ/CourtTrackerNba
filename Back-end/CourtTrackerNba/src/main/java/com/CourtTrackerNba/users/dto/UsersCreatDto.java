package com.CourtTrackerNba.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsersCreatDto(@Email String email, @NotBlank String password,@NotBlank  String username) {
}
