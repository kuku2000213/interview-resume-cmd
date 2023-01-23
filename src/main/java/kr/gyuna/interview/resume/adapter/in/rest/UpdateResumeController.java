package kr.gyuna.interview.resume.adapter.in.rest;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.adapter.in.rest.request.UpdateResumeDetailReq;
import kr.gyuna.interview.resume.application.port.in.UpdateResumeDetailCommand;
import kr.gyuna.interview.resume.application.port.in.UpdateResumeUseCase;
import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Transactional
public class UpdateResumeController {

    private final UpdateResumeUseCase updateResumeUseCase;

    @PutMapping("/v1/resumes/{id}/detail")
    public ResponseEntity<DefaultResponse> updateResumeDetail(
            @RequestBody UpdateResumeDetailReq updateResumeDetailReq,
            @PathVariable(name = "id") String resumeId
    ) {
        UpdateResumeDetailCommand command = UpdateResumeDetailCommand.builder()
                .resumeId(ResumeId.of(resumeId))
                .resumeTitle(updateResumeDetailReq.getTitle())
                .resumeContent(updateResumeDetailReq.getContent())
                .build();

        DefaultResponse response = updateResumeUseCase.updateResumeDetail(command);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

}
