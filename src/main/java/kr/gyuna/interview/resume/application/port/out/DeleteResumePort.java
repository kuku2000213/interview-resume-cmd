package kr.gyuna.interview.resume.application.port.out;

import kr.gyuna.interview.resume.domain.ResumeId;

public interface DeleteResumePort {
    void deleteResumeById(ResumeId resumeId);
}
