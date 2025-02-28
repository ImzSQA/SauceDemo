package org.imz.utils;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretsUtil {
    private static final Logger LOGGER = Logger.getLogger(SecretsUtil.class.getName());
    private static final Path SECRETS_PATH = Path.of("secrets.json");
    private static final JSONObject SECRETS;

    static {
        SECRETS = loadSecrets();
    }

    private static JSONObject loadSecrets() {
        try {
            String content = Files.readString(SECRETS_PATH);
            return new JSONObject(new JSONTokener(content));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load secrets.json", e);
            throw new RuntimeException("Could not read secrets.json. Ensure the file exists.", e);
        }
    }

    public static String getSecret(String key) {
        return SECRETS.optString(key, null);
    }
}
