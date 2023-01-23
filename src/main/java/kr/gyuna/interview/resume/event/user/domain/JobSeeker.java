package kr.gyuna.interview.resume.event.user.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kr.gyuna.interview.resume.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeeker {

    @EmbeddedId
    private UserId userId;

    @Enumerated(value = EnumType.STRING)
    private JobSeekerState jobSeekerState;
}
