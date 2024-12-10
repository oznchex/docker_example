package liaison.linkit_db_test.test;

import liaison.linkit_db_test.member.Member;
import liaison.linkit_db_test.member.MemberRepository;
import liaison.linkit_db_test.member.MemberRequest;
import liaison.linkit_db_test.team.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TestService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final TeamProfileRepository teamProfileRepository;

    public void createMemberAndTeamProfile(final MemberRequest memberRequest) {
        final Member member = memberRepository.save(new Member(memberRequest.getEmail()));
//        final TeamProfile teamProfile = teamProfileRepository.save(new TeamProfile(member));
    }

    public void getTeam(final Long teamId, final Long teamProfileId) {
        final Team team = teamRepository.findById(teamId).orElseThrow();
        final TeamProfile teamProfile = teamProfileRepository.findById(teamProfileId).orElseThrow();


    }

    public void deleteTeamMember() {
        final Member member = new Member(1L, "testEmail");
        final Member savedMember = memberRepository.save(member);

        final Team team = new Team(1L);
        final Team savedTeam = teamRepository.save(team);

        final TeamMember teamMember = new TeamMember(savedMember, savedTeam);
        final TeamMember savedTeamMember = teamMemberRepository.save(teamMember);
    log.info("teamMember가 생성되었습니다.");

//        teamMemberRepository.delete(savedTeamMember);
//        log.info("teamMember가 삭제되었습니다.");
    }
}
