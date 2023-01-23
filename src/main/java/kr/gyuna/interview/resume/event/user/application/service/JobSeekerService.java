package kr.gyuna.interview.resume.event.user.application.service;

import jakarta.transaction.Transactional;
import kr.gyuna.interview.resume.event.user.domain.JobSeeker;
import kr.gyuna.interview.resume.event.user.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;
    public void createJobSeeker(JobSeeker jobSeeker) {

        jobSeekerRepository.save(jobSeeker);
    }
}
