package com.crossover.trialtest.app.rest;

import com.crossover.trialtest.Application;
import com.crossover.trialtest.domain.Samples;
import com.crossover.trialtest.domain.exam.Exam;
import com.crossover.trialtest.domain.exam.ExamRepo;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.question.Question;
import com.crossover.trialtest.domain.question.QuestionRepo;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class QuestionControllerTest {

    @Test
    public void entityNotFound() throws Exception {
		mockMvc.perform(get("/question/99"))
				.andExpect(status().isNotFound());
	}

    @Test
    public void getEntityById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/question/" + mathQuestion1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$.id", Matchers.is(mathQuestion1.getId())))
                .andExpect(jsonPath("$.title", Matchers.is(mathQuestion1.getTitle())));
    }

    @Test
    public void getEntities() throws Exception {
        String entitiesPath = "$._embedded.questionList";
        mockMvc.perform(get("/question"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath(entitiesPath, hasSize(4)))
                .andExpect(jsonPath(entitiesPath + "[0].id", Matchers.is(mathQuestion1.getId())))
                .andExpect(jsonPath(entitiesPath + "[0].description", Matchers.is(mathQuestion1.getDescription())))
                .andExpect(jsonPath(entitiesPath + "[1].id", Matchers.is(mathQuestion2.getId())))
                .andExpect(jsonPath(entitiesPath + "[1].description", Matchers.is(mathQuestion2.getDescription())))
                .andExpect(jsonPath(entitiesPath + "[2].id", Matchers.is(mathQuestion3.getId())))
                .andExpect(jsonPath(entitiesPath + "[2].description", Matchers.is(mathQuestion3.getDescription())))
                .andExpect(jsonPath(entitiesPath + "[3].id", Matchers.is(mathQuestion4.getId())))
                .andExpect(jsonPath(entitiesPath + "[3].description", Matchers.is(mathQuestion4.getDescription())));
    }

    @Test
    public void postEntity() throws Exception {
        Participant newEmployee = new Participant();
        String json = json(newEmployee);
        mockMvc.perform(post("/question")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void editEmployee() throws Exception {
        mathQuestion1.setTitle("Iji tambah iji");
        String json = json(mathQuestion1);
        mockMvc.perform(post("/question")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        json2Http.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    @Before public void setup() throws Exception {
        questionRepo.deleteAll();
        examRepo.deleteAll();

        Exam math = examRepo.save(Samples.exams.basicMath());
		mathQuestion1 = questionRepo.save(Samples.questions.basicMath1(math));
        mathQuestion2 = questionRepo.save(Samples.questions.basicMath2(math));
        mathQuestion3 = questionRepo.save(Samples.questions.basicMath3(math));
        mathQuestion4 = questionRepo.save(Samples.questions.basicMath4(math));

        mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        json2Http = Iterables.find(Arrays.asList(converters), new Predicate<HttpMessageConverter>() {
            public boolean apply(HttpMessageConverter hmc)
                { return hmc instanceof MappingJackson2HttpMessageConverter; }
        });
        assertNotNull("the JSON message converter must not be null", json2Http);
    }

	MockMvc mockMvc;
    HttpMessageConverter json2Http;

    Question mathQuestion1;
    Question mathQuestion2;
    Question mathQuestion3;
    Question mathQuestion4;

    @Autowired ExamRepo examRepo;
    @Autowired QuestionRepo questionRepo;
    @Autowired WebApplicationContext webApplicationContext;
}
