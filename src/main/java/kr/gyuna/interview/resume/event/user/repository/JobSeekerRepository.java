package kr.gyuna.interview.resume.event.user.repository;


import kr.gyuna.interview.resume.domain.UserId;
import kr.gyuna.interview.resume.event.user.domain.JobSeeker;
import org.springframework.data.repository.CrudRepository;

public interface JobSeekerRepository extends CrudRepository<JobSeeker, UserId> {
}
