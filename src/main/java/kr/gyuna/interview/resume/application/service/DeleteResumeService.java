package kr.gyuna.interview.resume.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.DeleteResumeCommand;
import kr.gyuna.interview.resume.application.port.in.DeleteResumeUseCase;
import kr.gyuna.interview.resume.application.port.out.DeleteResumePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteResumeService implements DeleteResumeUseCase {

    private final DeleteResumePort deleteResumePort;


    @Override
    public DefaultResponse deleteResumeById(DeleteResumeCommand command) {

        deleteResumePort.deleteResumeById(command.toResumeId());

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "이력서가 정상적으로 삭제되었습니다.",
                command.toResumeId().toString()
        );
    }
}
