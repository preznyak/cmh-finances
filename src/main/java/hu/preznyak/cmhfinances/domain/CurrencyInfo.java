package hu.preznyak.cmhfinances.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CurrencyInfo {

    @Id
    @UuidGenerator
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Currency base;

    @Column(unique = true)
    private LocalDate date;

    private Double eur;
    private Double usd;
    private Double huf;
    private Double ron;
    private Double gbp;
}
