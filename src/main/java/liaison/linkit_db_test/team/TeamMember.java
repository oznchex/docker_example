package liaison.linkit_db_test.team;

import jakarta.persistence.*;
import liaison.linkit_db_test.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.file.Files;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamMember {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "team_member_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public TeamMember(final Member member, final Team team) {
        this.member = member;
        this.team = team;
    }
}
