package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import hu.preznyak.cmhfinances.web.dto.CurrencyConversionDto;

import java.time.LocalDate;

public interface CurrencyInfoService {
    CurrencyInfo findByDate(LocalDate date);
    CurrencyConversionDto convert(CurrencyConversionDto currencyConversionDto);
}
