package com.crossover.trialtest.app.rest;

import com.crossover.trialtest.Application;
import com.crossover.trialtest.domain.Samples;
import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.participant.ParticipantRepo;
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
public class ParticipantControllerTest {

    @Test
    public void entityNotFound() throws Exception {
		mockMvc.perform(get("/participant/99"))
				.andExpect(status().isNotFound());
	}

    @Test
    public void getEntityById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/participant/" + suyama.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$.id", Matchers.is(suyama.getId())))
                .andExpect(jsonPath("$.userName", Matchers.is(suyama.getUserName())));
    }

    @Test
    public void getEntities() throws Exception {
        String entitiesPath = "$._embedded.participantList";
        mockMvc.perform(get("/participant"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath(entitiesPath, hasSize(2)))
                .andExpect(jsonPath(entitiesPath + "[0].id", Matchers.is(suyama.getId())))
                .andExpect(jsonPath(entitiesPath + "[0].fullName", Matchers.is(suyama.getFullName())))
                .andExpect(jsonPath(entitiesPath + "[1].id", Matchers.is(nancy.getId())))
                .andExpect(jsonPath(entitiesPath + "[1].fullName", Matchers.is(nancy.getFullName())));
    }

    @Test
    public void postEntity() throws Exception {
        Participant newEmployee = new Participant();
        String json = json(newEmployee);
        mockMvc.perform(post("/participant")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void editEmployee() throws Exception {
        suyama.setFullName("Mikhail Suyama");
        String json = json(suyama);
        mockMvc.perform(post("/participant")
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
        suyama = Samples.participants.suyama();
        nancy = Samples.participants.nancy();
		mockMvc = webAppContextSetup(webApplicationContext).build();

        participantRepo.deleteAll();
		suyama = participantRepo.save(suyama);
		nancy = participantRepo.save(nancy);
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

    Participant suyama;
    Participant nancy;

    @Autowired ParticipantRepo participantRepo;
    @Autowired WebApplicationContext webApplicationContext;
}
