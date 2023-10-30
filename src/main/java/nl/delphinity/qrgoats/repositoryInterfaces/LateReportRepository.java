package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.LateReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LateReportRepository extends JpaRepository<LateReport, Integer> {
}