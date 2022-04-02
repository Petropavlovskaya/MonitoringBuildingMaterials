package by.bsc.iac.monitoringbuildingmaterials.dao;

import by.bsc.iac.monitoringbuildingmaterials.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
