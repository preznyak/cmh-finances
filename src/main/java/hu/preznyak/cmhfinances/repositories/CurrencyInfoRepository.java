package hu.preznyak.cmhfinances.repositories;

import hu.preznyak.cmhfinances.domain.CurrencyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface CurrencyInfoRepository extends JpaRepository<CurrencyInfo, UUID> {
    Optional<CurrencyInfo> findByDate(LocalDate date);
}
