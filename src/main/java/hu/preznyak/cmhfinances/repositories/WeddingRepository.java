package hu.preznyak.cmhfinances.repositories;

import hu.preznyak.cmhfinances.domain.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface WeddingRepository extends JpaRepository<Wedding, UUID> {
    List<Wedding> findByDateBetween(LocalDate start, LocalDate end);
}
