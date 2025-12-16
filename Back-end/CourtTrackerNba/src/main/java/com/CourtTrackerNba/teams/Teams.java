package com.CourtTrackerNba.teams;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String abbreviation;
    @NotBlank
    private String city;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Conference conference;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime creatAt;
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

}
