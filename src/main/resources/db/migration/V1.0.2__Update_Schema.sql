CREATE TABLE team (
    team_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_profile_id BIGINT NOT NULL
);

CREATE TABLE team_member (
    team_member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(member_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);

INSERT INTO team (team_id, team_profile_id)
SELECT team_profile_id, team_profile_id FROM team_profile;

INSERT INTO team_member (member_id, team_id)
SELECT member_id FROM member, team_id FROM team;

UPDATE team_profile tp
JOIN team_member tm ON tp.member_id = tm.member_id
SET tp.team_id = tm.team_id;

ALTER TABLE team_profile
DROP FOREIGN KEY FKpyrvxxmirphvn0xo0v85nmgpt;

ALTER TABLE team_profile
DROP COLUMN member_id;

ALTER TABLE team_profile
ADD CONSTRAINT FK_team_profile_team FOREIGN KEY (team_id) REFERENCES team(team_id);
