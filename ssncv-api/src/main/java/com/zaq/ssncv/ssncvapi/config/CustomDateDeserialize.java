package com.zaq.ssncv.ssncvapi.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZAQ
 */
public class CustomDateDeserialize extends JsonDeserializer<Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonParser paramJsonParser,
                            DeserializationContext paramDeserializationContext) throws IOException {
        String str = paramJsonParser.getText().trim();
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            // Handle exception here
        }
        return paramDeserializationContext.parseDate(str);
    }
}
