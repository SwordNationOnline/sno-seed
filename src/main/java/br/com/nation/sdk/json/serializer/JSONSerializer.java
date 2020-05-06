package br.com.nation.sdk.json.serializer;

import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class JSONSerializer {

    private final Gson gson = new Gson();

    public void serialize(File file, Class<?> clazz, Object object) {
        try {
            Files.write(gson.toJson(object, clazz).getBytes(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String serialize(Class<?> clazz, Object object) {
        return gson.toJson(object, clazz);
    }

}
