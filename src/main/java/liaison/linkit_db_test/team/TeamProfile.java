package liaison.linkit_db_test.team;

import jakarta.persistence.*;
import liaison.linkit_db_test.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class TeamProfile {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "team_profile_id")
    private Long id;

    @Column(name = "team_introduction")
    private String teamIntroduction;

    // Team과 일대일 관계
    @OneToOne(mappedBy = "teamProfile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Team team;

    public TeamProfile(final Team team, final String teamIntroduction) {
        this.team = team;
        this.teamIntroduction = teamIntroduction;
    }
}
