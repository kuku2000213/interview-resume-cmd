package kr.gyuna.interview.resume.application.port.out;

import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeId;

public interface CreateResumePort {
    ResumeId createResume(Resume resume);
}
