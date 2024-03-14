package hu.preznyak.cmhfinances.helpers;

import hu.preznyak.cmhfinances.domain.Currency;
import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import hu.preznyak.cmhfinances.web.exceptions.CurrencyNotSupportedException;

public class ConversionHelper {
    public static Double getExchangeRateForCurrencyFromInfo(Currency currency, CurrencyInfo currencyInfo) throws CurrencyNotSupportedException {
        switch (currency) {
            case EUR -> {
                return currencyInfo.getEur();
            }
            case HUF -> {
                return currencyInfo.getHuf();
            }
            case RON -> {
                return currencyInfo.getRon();
            }
            case USD -> {
                return currencyInfo.getUsd();
            }
            case GBP -> {
                return currencyInfo.getGbp();
            }
            default -> throw new CurrencyNotSupportedException("Currency not supported.");
        }
    }
}
