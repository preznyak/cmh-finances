package hu.preznyak.cmhfinances.web.dto;

import hu.preznyak.cmhfinances.domain.Currency;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversionDto {

    @NotNull
    private Currency from;

    @NotNull
    private Currency in;

    @NotNull
    private Double amountToBeExchanged;

    @Null
    private Double result;
}
