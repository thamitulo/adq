package com.ae.adq.maha.interview.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public MockMvc getMockMvc() {
        return mockMvc;
    }

}
