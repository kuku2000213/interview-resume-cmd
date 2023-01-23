package kr.gyuna.interview.resume.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.gyuna.interview.resume.domain.Resume;
import kr.gyuna.interview.resume.domain.ResumeState;
import kr.gyuna.interview.resume.domain.UserId;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.gyuna.interview.resume.domain.QResume.resume;

@Transactional
@Repository
public class ResumeDSL {

    private final JPAQueryFactory jpaQueryFactory;

    public ResumeDSL(
            EntityManager entityManager
    ) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Resume> findMainResumesByUserId(UserId userId) {
        return jpaQueryFactory.selectFrom(resume)
                .where(resume.userId.eq(userId)
                        .and(resume.resumeState.eq(ResumeState.MAIN))
                )
                .fetch();
    }
}
