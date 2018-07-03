package io.pivotal.retail.util;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This wrapper class exists to help ensure the List of JSON strings being returned doesn't
 * contain a bunch of \"escaped strings\".
 * <p>
 * Ref. https://stackoverflow.com/questions/15507064/return-literal-json-strings-in-spring-mvc-responsebody
 */
public class JsonString {

    private final String value;

    public JsonString(String value) {
        this.value = value;
    }

    @JsonValue
    @JsonRawValue
    public String value() {
        return value;
    }

}
