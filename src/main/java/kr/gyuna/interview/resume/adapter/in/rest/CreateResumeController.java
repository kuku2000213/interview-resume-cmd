package kr.gyuna.interview.resume.adapter.in.rest;

import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.adapter.in.rest.request.CreateResumeReq;
import kr.gyuna.interview.resume.application.port.in.CreateResumeCommand;
import kr.gyuna.interview.resume.application.port.in.CreateResumeUseCase;
import kr.gyuna.interview.resume.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateResumeController {

    private final CreateResumeUseCase createResumeUseCase;

    @PostMapping("/v1/resumes")
    public ResponseEntity<DefaultResponse> createResume(
            @RequestBody CreateResumeReq createResumeReq
    ) {
        CreateResumeCommand command = CreateResumeCommand.builder()
                .userId(UserId.of(createResumeReq.getUserId()))
                .resumeTitle(createResumeReq.getTitle())
                .resumeContent(createResumeReq.getContent())
                .build();

        DefaultResponse response = createResumeUseCase.createResume(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
