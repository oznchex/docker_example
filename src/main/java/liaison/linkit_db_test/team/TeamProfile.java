package liaison.linkit_db_test.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import static lombok.AccessLevel.PROTECTED;


@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamProfile {

    private Long id;


    private String teamIntroduction;

    private Team team;

    public TeamProfile(final Team team, final String teamIntroduction) {
        this.team = team;
        this.teamIntroduction = teamIntroduction;
    }
}
