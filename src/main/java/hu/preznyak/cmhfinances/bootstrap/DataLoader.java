package hu.preznyak.cmhfinances.bootstrap;

import hu.preznyak.cmhfinances.domain.Currency;
import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import hu.preznyak.cmhfinances.repositories.CurrencyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final CurrencyInfoRepository repository;

    @Override
    public void run(String... args) {
        // Should be commented out when running the application and calling real API
        loadCurrencyInfo();
    }

    private void loadCurrencyInfo() {
        if (repository.count() == 0) {
            CurrencyInfo currencyInfo = CurrencyInfo.builder()
                    .base(Currency.EUR)
                    .date(LocalDate.now())
                    .huf(395.4)
                    .usd(1.09)
                    .ron(4.96)
                    .gbp(0.85)
                    .eur(1.0)
                    .build();

            repository.save(currencyInfo);
        }
    }
}
