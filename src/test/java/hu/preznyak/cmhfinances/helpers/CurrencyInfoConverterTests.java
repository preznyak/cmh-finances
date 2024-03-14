package hu.preznyak.cmhfinances.helpers;


import com.fasterxml.jackson.databind.ObjectMapper;
import hu.preznyak.cmhfinances.domain.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        System.out.println(CurrencyInfoConverter.stringToCurrencyInfo(responseString));
        System.out.println("Value of EUR: " + Currency.valueOf("EUR"));
    }
}
