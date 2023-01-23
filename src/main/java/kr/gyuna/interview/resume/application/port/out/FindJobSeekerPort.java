package kr.gyuna.interview.resume.application.port.out;


import kr.gyuna.interview.resume.domain.UserId;
import kr.gyuna.interview.resume.event.user.domain.JobSeeker;

public interface FindJobSeekerPort {

    JobSeeker findJobSeekerById(UserId userId);
}
