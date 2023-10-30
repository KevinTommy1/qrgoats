package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.CardLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardLogRepository extends JpaRepository<CardLog, Integer> {
}