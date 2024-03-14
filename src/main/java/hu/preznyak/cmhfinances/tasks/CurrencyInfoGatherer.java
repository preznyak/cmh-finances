package hu.preznyak.cmhfinances.tasks;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import hu.preznyak.cmhfinances.helpers.CurrencyInfoConverter;
import hu.preznyak.cmhfinances.repositories.CurrencyInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CurrencyInfoGatherer {

    private final String baseUrl;
    private final String accessKey;
    private final String symbols;

    private final RestTemplate restTemplate;

    @Autowired
    CurrencyInfoRepository currencyInfoRepository;

    public CurrencyInfoGatherer(@Value("${fixer.baseUrl}") String baseUrl,
                                @Value("${fixer.access_key}") String accessKey,
                                @Value("${fixer.symbols}") String symbols,
                                RestTemplateBuilder restTemplateBuilder) {
        this.baseUrl = baseUrl;
        this.accessKey = accessKey;
        this.symbols = symbols;
        this.restTemplate = restTemplateBuilder.build();
    }

    // Annotations should be commented out when running the application only for testing purposes.
    //@Scheduled(cron = "${cron.expression.daily}")
    //@Scheduled(cron = "${cron.expression.twiceaminute}")
    public void gatherCurrencyInfo() {
        ResponseEntity<String> response = restTemplate.getForEntity(getUrl(), String.class);
        if (HttpStatus.OK.equals(response.getStatusCode())) {
            CurrencyInfo currencyInfo = CurrencyInfoConverter.stringToCurrencyInfo(response.getBody());
            log.info("Currency info to be saved...");
            log.info(currencyInfo.toString());
            currencyInfoRepository.save(currencyInfo);
        }
    }

    private String getUrl() {
        return new StringBuilder()
                .append(baseUrl)
                .append("?access_key=")
                .append(accessKey)
                .append("&symbols=")
                .append(symbols)
                .toString();
    }

}
