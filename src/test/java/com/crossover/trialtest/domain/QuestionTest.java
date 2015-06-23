package com.crossover.trialtest.domain;

import com.crossover.trialtest.domain.question.Question;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTest {
    @Test
    public void can_add_multiple_answer_to_question() {
        Question question = new Question();
        question.setTitle("One plus one always 2?");
        question.setDescription("What do you think when people say that 1 + 1 doesn't always equals 2?");
        question.addOption("Very true, just examine binary!");
        question.addOption("One plus one doesn't always equals two, French will prefer to say 'deux'");
        question.addOption("Even my crying baby know that 1 + 1 = 2!", true);
        question.addOption("In binary, 1 + 1 = 10, but 10 is just a notation, the quantity is still 2", true);

        assertThat(question.getTitle()).isEqualTo("One plus one always 2?");
        assertThat(question.getDescription()).isEqualTo("What do you think when people say that 1 + 1 doesn't always equals 2?");
        assertThat(question.getOptions()).hasSize(4);
        assertThat(question.getCorrectAnswers()).hasSize(2);
        assertThat(question.isMultipleAnswers()).isTrue();
    }
}
