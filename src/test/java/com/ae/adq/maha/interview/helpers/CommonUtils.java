package com.ae.adq.maha.interview.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
