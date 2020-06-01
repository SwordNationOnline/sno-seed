package br.com.nation.sdk.json.deserializer;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONDeserializer {

    private final Gson gson = new Gson();

    public <T> T deserialize(File file, Class<T> clazz) {
        try {
            return gson.fromJson(new FileReader(file), clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T deserialize(String text, Class<T> clazz) {
        return gson.fromJson(text, clazz);
    }

}
