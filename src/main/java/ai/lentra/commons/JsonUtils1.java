package ai.lentra.commons;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils1 {
    private ObjectMapper mapper;

    public JsonUtils1() {
        this.mapper = (new ObjectMapper()).registerModule(new JavaTimeModule()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
    }

    public ObjectMapper mapper() {
        return this.mapper;
    }
}
