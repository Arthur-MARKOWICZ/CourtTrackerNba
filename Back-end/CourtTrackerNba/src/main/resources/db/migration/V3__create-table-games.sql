CREATE TABLE games (
                       id BIGSERIAL PRIMARY KEY,
                       home_team_id INTEGER NOT NULL REFERENCES teams(id),
                       away_team_id INTEGER NOT NULL REFERENCES teams(id),
                       game_date DATE NOT NULL,
                       game_time TIME,
                       season VARCHAR(10) NOT NULL,
                       season_type VARCHAR(20) NOT NULL,
                       status VARCHAR(20) NOT NULL,
                       home_score INTEGER,
                       away_score INTEGER,
                       arena VARCHAR(100),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_games_date ON games(game_date DESC);
CREATE INDEX idx_games_home_team ON games(home_team_id);
CREATE INDEX idx_games_away_team ON games(away_team_id);
CREATE INDEX idx_games_status ON games(status);
CREATE INDEX idx_games_season ON games(season);