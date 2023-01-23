package kr.gyuna.interview.resume.adapter.in.rest;


import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.SetMainResumeCommand;
import kr.gyuna.interview.resume.application.port.in.SetMainResumeUseCase;
import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SetMainResumeController {

    private final SetMainResumeUseCase setMainResumeUseCase;

    @PostMapping("/v1/resumes/{id}/main")
    public ResponseEntity<DefaultResponse> setMainResume(
            @PathVariable(name = "id") String resumeId
    ) {
        SetMainResumeCommand command = SetMainResumeCommand.builder()
                .resumeId(ResumeId.of(resumeId))
                .build();

        DefaultResponse response = setMainResumeUseCase.setMainResume(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
