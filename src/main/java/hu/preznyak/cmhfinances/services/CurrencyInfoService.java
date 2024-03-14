package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;

import java.time.LocalDate;

public interface CurrencyInfoService {

    CurrencyInfo save(CurrencyInfo currencyInfo);
    CurrencyInfo findByDate(LocalDate date);
}
