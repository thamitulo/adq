package com.ae.adq.maha.interview.rest;

import com.ae.adq.maha.interview.helpers.CommonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class InventoryControllerTest extends MockControllerTest {

    private List<String> codes = Arrays.asList("001", "002", "001", "004","003");

    @Test
    public void shouldReturnTotalPrice() throws Exception {
        MvcResult mvcResult = getMockMvc().perform(MockMvcRequestBuilders.post("/checkout")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(CommonUtils.asJsonString(codes))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("price"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("360"));
    }
}
