package liaison.linkit_db_test.test;

import jakarta.validation.Valid;
import liaison.linkit_db_test.member.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/test/linkit/database")
    public ResponseEntity<?> TestDatabase(
            @RequestBody @Valid final MemberRequest memberRequest
    ) {
        testService.createMemberAndTeamProfile(memberRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/teamMember")
    public ResponseEntity<?> DeleteTeamMember() {
        testService.deleteTeamMember();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
