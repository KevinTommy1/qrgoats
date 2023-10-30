package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.SickReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SickReportRepository extends JpaRepository<SickReport, Integer> {
}