package kr.gyuna.interview.resume.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.common.response.DefaultResponse;
import kr.gyuna.interview.resume.application.port.in.SetMainResumeCommand;
import kr.gyuna.interview.resume.application.port.in.SetMainResumeUseCase;
import kr.gyuna.interview.resume.application.port.out.FindResumePort;
import kr.gyuna.interview.resume.domain.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class SetMainResumeService implements SetMainResumeUseCase {

    private final FindResumePort findResumePort;

    @Override
    public DefaultResponse setMainResume(SetMainResumeCommand command) {

        Resume mainResume = findResumePort.findResumeById(command.toValue());
        List<Resume> resumes = findResumePort.findExistingResume(mainResume.getUserId());

        resumes.forEach(Resume::toNormalResume);

        mainResume.toMainResume();

        return new DefaultResponse(
                HttpStatus.OK.value(),
                "메인 이력서가 정상적으로 설정되었습니다.",
                command.toValue().toString()
        );
    }
}
