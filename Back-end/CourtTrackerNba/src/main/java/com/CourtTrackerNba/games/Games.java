package com.CourtTrackerNba.games;

import com.CourtTrackerNba.teams.Teams;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id", nullable = false)
    private Teams HomeTeam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id", nullable = false)
    private Teams AwayTeam;
    @Column(name = "game_date", nullable = false)
    private LocalDate gameDate;

    @Column(name = "game_time")
    private LocalTime gameTime;

    @Column(nullable = false, length = 10)
    private String season;

    @Column(name = "season_type", nullable = false, length = 20)
    private String seasonType;

    @Column(nullable = false, length = 20)
    private String status;

    private Integer homeScore;
    private Integer awayScore;

    @Column(length = 100)
    private String arena;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}


