package com.example.demo.interview;

import com.example.demo.model.SumPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

//    @Before
//    public void setUp() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    void shouldShowSimpleAssertion() throws Exception {
        SumPayload product = new SumPayload(1, 2);

        String inputJson = new ObjectMapper().writeValueAsString(product);

        this.mockMvc.perform(post("/sum").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("3")));
    }
}