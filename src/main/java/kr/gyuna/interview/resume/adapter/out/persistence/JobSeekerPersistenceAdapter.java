package kr.gyuna.interview.resume.adapter.out.persistence;

import kr.gyuna.interview.resume.application.port.out.FindJobSeekerPort;
import kr.gyuna.interview.resume.domain.UserId;
import kr.gyuna.interview.resume.event.user.domain.JobSeeker;
import kr.gyuna.interview.resume.event.user.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class JobSeekerPersistenceAdapter implements FindJobSeekerPort {

    private final JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeeker findJobSeekerById(UserId userId) {

        Optional<JobSeeker> enterpriseOpt =
                jobSeekerRepository.findById(userId);

        return enterpriseOpt.orElseThrow(() ->
                new NullPointerException("해당 회원이 존재하지 않거나, 일반 회원이 아닙니다.")
        );
    }
}
