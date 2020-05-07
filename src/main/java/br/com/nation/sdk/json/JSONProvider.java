package br.com.nation.sdk.json;

import br.com.nation.sdk.json.deserializer.JSONDeserializer;
import br.com.nation.sdk.json.serializer.JSONSerializer;

public class JSONProvider {

    private final JSONSerializer jsonSerializer = new JSONSerializer();
    private final JSONDeserializer jsonDeserializer = new JSONDeserializer();

    public JSONDeserializer getDeserializer() {
        return jsonDeserializer;
    }

    public JSONSerializer getSerializer() {
        return jsonSerializer;
    }

}
