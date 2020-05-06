package br.com.nation.sdk.json;

import br.com.nation.sdk.json.deserializer.JSONDeserializer;
import br.com.nation.sdk.json.serializer.JSONSerializer;

public class JSONProvider {

    private static JSONProvider jsonProvider;

    public static JSONProvider getInstance() {
        if(jsonProvider == null) jsonProvider = new JSONProvider();

        return jsonProvider;
    }

    public final static JSONSerializer JSON_SERIALIZER = new JSONSerializer();
    public final static JSONDeserializer JSON_DESERIALIZER = new JSONDeserializer();

}
