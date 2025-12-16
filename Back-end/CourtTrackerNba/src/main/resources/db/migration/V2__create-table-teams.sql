CREATE TABLE teams (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       abbreviation VARCHAR(3) NOT NULL,
                       city VARCHAR(100) NOT NULL,
                       conference VARCHAR(4) NOT NULL,
                       division VARCHAR(50),
                       logo_url VARCHAR(500),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_teams_conference ON teams(conference);
CREATE INDEX idx_teams_abbreviation ON teams(abbreviation);