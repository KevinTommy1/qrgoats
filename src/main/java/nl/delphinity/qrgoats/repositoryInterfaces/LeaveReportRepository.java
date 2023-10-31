package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveReportRepository extends JpaRepository<LeaveReport, Integer> {
}