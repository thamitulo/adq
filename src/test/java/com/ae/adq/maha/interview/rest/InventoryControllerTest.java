package com.ae.adq.maha.interview.rest;

import com.ae.adq.maha.interview.helpers.CommonUtils;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InventoryControllerTest extends MockControllerTest {

    @Test
    public void shouldReturnOk() throws Exception {
        MvcResult mvcResult = getMockMvc().perform(MockMvcRequestBuilders.post("/checkout")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(CommonUtils.asJsonString(Arrays.asList("1", "2")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }
}