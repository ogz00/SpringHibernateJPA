package com.crossover.trialtest.domain;

import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.question.Question;
import com.google.common.collect.Lists;
import org.joda.time.Duration;

import java.util.List;

public class Samples {

    public static class participants {

        public static Participant suyama() {
            Participant participant = new Participant();
            participant.setUserName("aelsu");
            participant.setPassword("aelsup");
            participant.setFullName("Michael Suyama");
            return participant;
        }

        public static Participant nancy() {
            Participant participant = new Participant();
            participant.setUserName("cydav");
            participant.setPassword("cydavp");
            participant.setFullName("Nancy Davolio");
            return participant;
        }

        public static List<Participant> all = Lists.newArrayList(suyama(), nancy());
    }

    public static class exams {

        public static Exam basicMath() {
            Exam exam = new Exam();
            exam.setCode("MATH");
            exam.setName("Basic Math");
            exam.setDescription("Basic mathematic examination");
            exam.setPassScore(75);
            exam.setDuration(Duration.standardSeconds(20));
            return exam;
        }

        public static Exam basicEnglish() {
            Exam exam = new Exam();
            exam.setCode("ENG");
            exam.setName("Basic English");
            exam.setDescription("Elementary English that can be passed in less than 5 seconds");
            exam.setPassScore(75);
            exam.setDuration(Duration.standardSeconds(5));
            return exam;
        }

        public static List<Exam> all = Lists.newArrayList(basicMath(), basicEnglish());

    }

    public static class questions {

        public static Question basicMath1(Exam exam) {
            Question q1 = exam.createQuestion();
            q1.setCode(exam.getCode() + 1);
            q1.setTitle("1 + 1");
            q1.setDescription("x = 1 + 1, find x!");
            q1.addOption("2", true);
            q1.addOption("3");
            q1.addOption("4");
            q1.addOption("10, in binary", true);
            return q1;
        }

        public static Question basicMath1() {
            return basicMath1(exams.basicMath());
        }

        public static Question basicMath2(Exam exam) {
            Question q2 = exam.createQuestion();
            q2.setCode(exam.getCode() + 2);
            q2.setTitle("2 + 2");
            q2.setDescription("x = 2 + 2, find x!");
            q2.addOption("4", true);
            q2.addOption("100");
            q2.addOption("101, in binary");
            q2.addOption("3");
            return q2;
        }

        public static Question basicMath2() {
            return basicMath2(exams.basicMath());
        }

        public static Question basicMath3(Exam exam) {
            Question q3 = exam.createQuestion();
            q3.setCode(exam.getCode() + 3);
            q3.setTitle("Hex number plus one");
            q3.setDescription("0x4D4F + 1");
            q3.addOption("0x5D4F");
            q3.addOption("0x4D4F1");
            q3.addOption("0x4D50", true);
            q3.addOption("0x4D40");
            return q3;
        }

        public static Question basicMath3() {
            return basicMath3(exams.basicMath());
        }

        public static Question basicMath4(Exam exam) {
            Question q4 = exam.createQuestion();
            q4.setCode(exam.getCode() + 4);
            q4.setTitle("What is sin?");
            q4.setDescription("Choose the correct definition of sin");
            q4.addOption("Something that will be increased when you commit prohibition", true);
            q4.addOption("Ratio between far edge and hypotenuse", true);
            q4.addOption("Ratio between bottom edge and hypotenuse");
            q4.addOption("Ratio between far edge and bottom edge");
            return q4;
        }

        public static Question basicMath4() {
            return basicMath4(exams.basicMath());
        }

        public static List<Question> all(Exam math) {
            return Lists.newArrayList(basicMath1(math), basicMath2(math), basicMath3(math), basicMath4(math));
        }

        public static List<Question> all() {
            return all(exams.basicMath());
        }
    }
}
