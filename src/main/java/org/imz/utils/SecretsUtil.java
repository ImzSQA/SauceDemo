package org.imz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretsUtil {
    private static final Logger LOGGER = Logger.getLogger(SecretsUtil.class.getName());
    private static final Path SECRETS_PATH = Path.of("secrets.json");


    public static List<LoginModel> loadSecrets() {

        List<LoginModel> validAccounts = null;
        try {
            String content = Files.readString(SECRETS_PATH);
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize the JSON string into the Java object
            AccountsWrapper accountsWrapper = objectMapper.readValue(content, AccountsWrapper.class);

            // Get the list of valid accounts
            validAccounts = accountsWrapper.getValidaccounts();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return validAccounts;
    }
}
