package liaison.linkit_db_test.member;

import lombok.Getter;
import lombok.NoArgsConstructor;


import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    private Long id;

    private String email;

    private String member_introduction;

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
