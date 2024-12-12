package liaison.linkit_db_test.team;


import liaison.linkit_db_test.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamMember {

    private Long id;
    private Member member;

    private Team team;

    public TeamMember(final Member member, final Team team) {
        this.member = member;
        this.team = team;
    }
}
