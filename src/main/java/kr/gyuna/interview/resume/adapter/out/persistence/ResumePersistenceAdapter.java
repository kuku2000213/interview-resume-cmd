package kr.gyuna.interview.resume.adapter.out.persistence;

import kr.gyuna.interview.resume.application.port.out.CreateResumePort;
import kr.gyuna.interview.resume.application.port.out.DeleteResumePort;
import kr.gyuna.interview.resume.application.port.out.FindResumePort;
import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeId;
import kr.gyuna.interview.resume.domain.UserId;
import kr.gyuna.interview.resume.repository.ResumeDSL;
import kr.gyuna.interview.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ResumePersistenceAdapter implements
        CreateResumePort,
        FindResumePort,
        DeleteResumePort
{

    private final ResumeRepository resumeRepository;
    private final ResumeDSL resumeDSL;

    @Override
    public ResumeId createResume(Resume resume) {

        Resume createdResume = resumeRepository.save(resume);

        return createdResume.getResumeId();
    }

    @Override
    public Resume findResumeById(ResumeId resumeId) {

        Optional<Resume> resumeOpt = resumeRepository.findById(resumeId);


        return resumeOpt.orElseThrow(() ->
                new NullPointerException("해당 이력서가 존재하지 않습니다. >> " + resumeId.toString())
        );
    }

    @Override
    public List<Resume> findExistingResume(UserId userId) {

        return resumeDSL.findMainResumesByUserId(userId);
    }

    @Override
    public void deleteResumeById(ResumeId resumeId) {
        resumeRepository.deleteById(resumeId);
    }
}
