package kr.gyuna.interview.resume.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.CreateResumeCommand;
import kr.gyuna.interview.resume.application.port.in.CreateResumeUseCase;
import kr.gyuna.interview.resume.application.port.out.CreateResumePort;
import kr.gyuna.interview.resume.application.port.out.FindJobSeekerPort;
import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Transactional
@Service
@RequiredArgsConstructor
public class CreateResumeService implements CreateResumeUseCase {

    private final CreateResumePort createResumePort;
    private final FindJobSeekerPort findJobSeekerPort;

    @Override
    public DefaultResponse createResume(CreateResumeCommand command) {

        findJobSeekerPort.findJobSeekerById(command.getUserId());

        Resume resume = command.toEntity();

        ResumeId resumeId = createResumePort.createResume(resume);


        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                "이력서가 정상적으로 등록되었습니다.",
                resumeId.toString()
        );
    }
}
