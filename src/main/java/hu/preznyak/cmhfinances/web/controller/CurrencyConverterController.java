package hu.preznyak.cmhfinances.web.controller;

import hu.preznyak.cmhfinances.services.CurrencyInfoServiceImpl;
import hu.preznyak.cmhfinances.web.dto.CurrencyConversionDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/finances/convert")
@RestController
public class CurrencyConverterController {

    @Autowired
    CurrencyInfoServiceImpl currencyInfoService;

    @PostMapping
    public ResponseEntity<CurrencyConversionDto> convert(@Valid @RequestBody CurrencyConversionDto currencyConversionDto){
        CurrencyConversionDto result = currencyInfoService.convert(currencyConversionDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
