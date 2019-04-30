package bot.config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Data;

import java.io.InputStreamReader;
import java.io.Reader;

@Data
public class ConfigWrapper {
    private String token;
    private String prefix;

    public ConfigWrapper(String filename) {
        Gson gson = new Gson();
        JsonReader jsonReader;
        Reader reader = new InputStreamReader(getClass().getResourceAsStream(filename));
        jsonReader = new JsonReader(reader);
        ConfigWrapper configWrapper = gson.fromJson(jsonReader, ConfigWrapper.class);
        this.token = configWrapper.token;
        this.prefix = configWrapper.prefix;

    }
}
