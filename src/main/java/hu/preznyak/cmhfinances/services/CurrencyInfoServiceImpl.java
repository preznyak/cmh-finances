package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import hu.preznyak.cmhfinances.helpers.ConversionHelper;
import hu.preznyak.cmhfinances.repositories.CurrencyInfoRepository;
import hu.preznyak.cmhfinances.web.dto.CurrencyConversionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CurrencyInfoServiceImpl implements CurrencyInfoService {

    private final CurrencyInfoRepository repository;

    @Override
    public CurrencyInfo findByDate(LocalDate date) {
        return repository.findByDate(date).orElseThrow();
    }

    @Override
    public CurrencyConversionDto convert(CurrencyConversionDto currencyConversionDto){
        CurrencyInfo latest = findByDate(LocalDate.now());
        if (latest.getBase().equals(currencyConversionDto.getFrom())) {
            currencyConversionDto.setResult(
                    currencyConversionDto.getAmountToBeExchanged() *
                            ConversionHelper.getExchangeRateForCurrencyFromInfo(currencyConversionDto.getIn(),
                                    latest)
            );
        }
        return currencyConversionDto;
    }

}
