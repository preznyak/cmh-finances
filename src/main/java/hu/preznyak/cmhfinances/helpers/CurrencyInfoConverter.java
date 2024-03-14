package hu.preznyak.cmhfinances.helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.preznyak.cmhfinances.domain.Currency;
import hu.preznyak.cmhfinances.domain.CurrencyInfo;

import java.time.LocalDate;

public class CurrencyInfoConverter {

    public static CurrencyInfo stringToCurrencyInfo(String string) {
        JsonObject jsonObject = JsonParser.parseString(string).getAsJsonObject();

        return CurrencyInfo.builder()
                .date(LocalDate.parse(jsonObject.get("date").getAsString()))
                .base(Currency.valueOf(jsonObject.get("base").getAsString()))
                .usd(jsonObject.getAsJsonObject("rates").get("USD").getAsDouble())
                .eur(jsonObject.getAsJsonObject("rates").get("EUR").getAsDouble())
                .huf(jsonObject.getAsJsonObject("rates").get("HUF").getAsDouble())
                .ron(jsonObject.getAsJsonObject("rates").get("RON").getAsDouble())
                .gbp(jsonObject.getAsJsonObject("rates").get("GBP").getAsDouble())
                .build();
    }
}
