package org.imz.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDatareader {

    public static Object[][] getLoginData(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode accountsArray = rootNode.get("validaccounts");

            Object[][] loginData = new Object[accountsArray.size()][2];

            for (int i = 0; i < accountsArray.size(); i++) {
                loginData[i][0] = accountsArray.get(i).get("username").asText();
                loginData[i][1] = accountsArray.get(i).get("password").asText();
            }

            return loginData;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0]; // Return an empty array if an error occurs
        }
    }
}
