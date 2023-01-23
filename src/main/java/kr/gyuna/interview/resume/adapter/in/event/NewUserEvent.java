package kr.gyuna.interview.resume.adapter.in.event;

import kr.gyuna.interview.resume.domain.UserId;
import kr.gyuna.interview.resume.event.user.domain.JobSeeker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserEvent {

    private String userId;
    private String userType;

    public boolean isEnterprise(){
        return userType.equals("JOB_SEEKER");
    }

    public JobSeeker toJobSeeker(){
        return JobSeeker.builder()
                .userId(UserId.of(this.userId))
                .build();
    }
}
