package com.crossover.trialtest;

import com.crossover.trialtest.domain.Samples;
import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.exam.ExamRepo;
import com.crossover.trialtest.domain.participant.ParticipantRepo;
import com.crossover.trialtest.domain.question.QuestionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    @Profile("QA")
    CommandLineRunner init(final ParticipantRepo participantRepo, final ExamRepo examRepo,
                           final QuestionRepo questionRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                participantRepo.save(Samples.participants.all);
                examRepo.save(Samples.exams.all);

                Exam math = examRepo.getByCode("MATH");
                questionRepo.save(Samples.questions.all(math));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setAdditionalProfiles("QA");
        ConfigurableApplicationContext ctx = app.run(args);
    }
}
