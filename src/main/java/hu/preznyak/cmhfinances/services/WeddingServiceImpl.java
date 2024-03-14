package hu.preznyak.cmhfinances.services;

import hu.preznyak.cmhfinances.domain.Wedding;
import hu.preznyak.cmhfinances.repositories.WeddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WeddingServiceImpl implements WeddingService {

    private final WeddingRepository weddingRepository;

    @Override
    public Optional<Wedding> findById(UUID id) {
        return weddingRepository.findById(id);
    }

    @Override
    public Wedding save(Wedding wedding) {
        return weddingRepository.save(wedding);
    }

    @Override
    public void deleteById(UUID id) {
        weddingRepository.deleteById(id);
    }

    @Override
    public List<Wedding> findAll() {
        return weddingRepository.findAll();
    }

    @Override
    public List<Wedding> findByDateBetween(LocalDate start, LocalDate end) {
        return weddingRepository.findByDateBetween(start, end);
    }
}
