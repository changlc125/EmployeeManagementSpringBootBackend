package com.example.emailservice.util;

import com.example.emailservice.domain.Email;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(Email email){

        String result = null;

        try {
            //object to json
            result = objectMapper.writeValueAsString(email);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Email deserialize(String string){
        Email email  = null;

        try {
            //json to object
            email = objectMapper.readValue(string, Email.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return email;
    }

}
