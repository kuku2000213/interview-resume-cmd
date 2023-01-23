package kr.gyuna.interview.resume.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.UpdateResumeDetailCommand;
import kr.gyuna.interview.resume.application.port.in.UpdateResumeUseCase;
import kr.gyuna.interview.resume.application.port.out.FindResumePort;
import kr.gyuna.interview.resume.domain.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Transactional
@Service
public class UpdateResumeService implements UpdateResumeUseCase {

    private final FindResumePort findResumePort;

    @Override
    public DefaultResponse updateResumeDetail(UpdateResumeDetailCommand command) {

        Resume resume = findResumePort.findResumeById(command.getResumeId());

        resume.modifyResume(command.toResumeDetail());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "이력서 수정이 정상적으로 완료되었습니다. >> ",
                command.getResumeId().toString()
        );
    }
}
