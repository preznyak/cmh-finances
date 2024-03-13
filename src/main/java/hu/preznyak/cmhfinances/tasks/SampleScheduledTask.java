package hu.preznyak.cmhfinances.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SampleScheduledTask {

    @Scheduled(cron = "* * * * * *")
    public void sampleTask() {
        System.out.println("Task run at: " + LocalDateTime.now());
    }
}
