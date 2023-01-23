package kr.gyuna.interview.resume.adapter.in.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.gyuna.interview.resume.event.user.application.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Slf4j
@Component
public class IntroductionEventConsumer {

//    @Value("${kafka.topics.user-info}")
//    private String topic;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JobSeekerService jobSeekerService;

    @KafkaListener(topics = "${kafka.topics.user-info}", groupId = "${kafka.consumer.group-id}")
    void listen(String message) throws JsonProcessingException {
        log.info("Consumer.listen: " + message);
        NewUserEvent event = objectMapper.readValue(message, NewUserEvent.class);

        if(event.isEnterprise()){
            jobSeekerService.createJobSeeker(event.toJobSeeker());
        }
    }
}
