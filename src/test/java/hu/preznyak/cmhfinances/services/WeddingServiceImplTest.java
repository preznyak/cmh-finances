package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.Currency;
import hu.preznyak.cmhfinances.domain.Wedding;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class WeddingServiceImplTest {

    private static Wedding wedding;

    @Autowired
    WeddingServiceImpl weddingService;

    @Test
    @Order(1)
    void save() {
        //given
        wedding = Wedding.builder()
                .date(LocalDate.of(2024,6,18))
                .price(new BigDecimal(300))
                .currency(Currency.EUR)
                .build();
        //when
        Wedding saved = weddingService.save(wedding);

        //then
        assertEquals(wedding.getDate(), saved.getDate());

    }

    @Test
    @Order(2)
    void deleteById() {
        //given
        wedding = Wedding.builder()
                .date(LocalDate.of(2024,6,18))
                .price(new BigDecimal(300))
                .currency(Currency.EUR)
                .build();

        //when
        Wedding saved = weddingService.save(wedding);
        UUID savedId = saved.getId();
        weddingService.deleteById(savedId);
        Optional<Wedding> result = weddingService.findById(savedId);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    @Order(3)
    void findAll() {
        //when
        List<Wedding> weddings = weddingService.findAll();

        //then
        assertFalse(weddings.isEmpty());
        assertEquals(1, weddings.size());
    }

    @Test
    @Order(4)
    void findByDateBetween() {
        //given
        wedding = Wedding.builder()
                .date(LocalDate.of(2024,7,5))
                .price(new BigDecimal(400))
                .currency(Currency.EUR)
                .build();
        //when
        weddingService.save(wedding);
        List<Wedding> betweenJune1AndAug31 = weddingService.findByDateBetween(
                LocalDate.of(2024,6,1),
                LocalDate.of(2024,8,31)
        );

        List<Wedding> betweenAug31AndOct15 = weddingService.findByDateBetween(
                LocalDate.of(2024,8,31),
                LocalDate.of(2024,10,15)
        );

        //then
        assertEquals(2, betweenJune1AndAug31.size());
        assertTrue(betweenAug31AndOct15.isEmpty());
    }
}