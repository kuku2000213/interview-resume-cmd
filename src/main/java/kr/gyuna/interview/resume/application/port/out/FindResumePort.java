package kr.gyuna.interview.resume.application.port.out;

import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeId;
import kr.gyuna.interview.resume.domain.UserId;

import java.util.List;

public interface FindResumePort {

    Resume findResumeById(ResumeId resumeId);
    List<Resume> findExistingResume(UserId userId);
}
