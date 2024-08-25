package com.globant.academy.dataManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    private static final String JSON_FILE_PATH = "src/test/resources/data/testData.json";
    static ObjectMapper mapper = new ObjectMapper();

    public static String getUserName() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get("userName").asText();
    }

    public static String getPassword() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get("password").asText();
    }

    public static String getThankYouMessage() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get("thankYouMessage").asText();
    }

    public static int getQuantityOfProductToPurchase() throws IOException {
        return mapper.readTree(new File(JSON_FILE_PATH)).get("quantityOfProductToPurchase").asInt();
    }

}
