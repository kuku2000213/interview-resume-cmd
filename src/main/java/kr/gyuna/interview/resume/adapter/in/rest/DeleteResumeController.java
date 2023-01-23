package kr.gyuna.interview.resume.adapter.in.rest;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.DeleteResumeCommand;
import kr.gyuna.interview.resume.application.port.in.DeleteResumeUseCase;
import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteResumeController {

    private final DeleteResumeUseCase deleteResumeUseCase;

    @DeleteMapping("/v1/resumes/{id}")
    public ResponseEntity<DefaultResponse> deleteResume(
            @PathVariable(name = "id") String resumeId
    ) {
        DeleteResumeCommand command = DeleteResumeCommand.builder()
                .resumeId(ResumeId.of(resumeId))
                .build();

        DefaultResponse response = deleteResumeUseCase
                .deleteResumeById(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
