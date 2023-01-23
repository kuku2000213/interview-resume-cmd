package kr.gyuna.interview.resume.repository;

import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeId;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume, ResumeId> {
}
