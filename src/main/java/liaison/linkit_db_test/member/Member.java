package liaison.linkit_db_test.member;

import jakarta.persistence.*;
import liaison.linkit_db_test.team.TeamMember;
import liaison.linkit_db_test.team.TeamProfile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    private String member_introduction;

    // TeamMember와 일대다 관계
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> teamMembers = new ArrayList<>();

    public Member(
            final Long id,
            final String email
    ) {
        this.id = id;
        this.email = email;
    }

    public Member(
            final String email
    ) {
        this(null, email);
    }
}
