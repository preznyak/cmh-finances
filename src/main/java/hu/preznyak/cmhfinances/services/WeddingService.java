package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.Wedding;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeddingService {

    Optional<Wedding> findById(UUID id);
    Wedding save(Wedding wedding);
    void deleteById(UUID id);
    List<Wedding> findAll();
    List<Wedding> findByDateBetween(LocalDate start, LocalDate end);
}
