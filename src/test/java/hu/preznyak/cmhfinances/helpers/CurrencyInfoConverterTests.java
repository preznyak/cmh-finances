package hu.preznyak.cmhfinances.helpers;


import com.fasterxml.jackson.databind.ObjectMapper;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CurrencyInfoConverterTests {

    private String responseString;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() throws IOException {
        responseString = new String(Files.readAllBytes(Paths.get("src/test/resources/test-files/sample-response.json")));
    }

    @Test
    void testConvertStringToCurrencyInfo(){
        //when
        CurrencyInfo currencyInfo = CurrencyInfoConverter.stringToCurrencyInfo(responseString);

        //then
        assertEquals("EUR", currencyInfo.getBase().toString());
        assertEquals("2024-03-13", currencyInfo.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
        assertEquals(0.855074, currencyInfo.getGbp());
        assertEquals(395.475, currencyInfo.getHuf());
        assertEquals(161.702088, currencyInfo.getRon());
        assertEquals(1, currencyInfo.getEur());
        assertEquals(1.548, currencyInfo.getUsd());

    }
}
