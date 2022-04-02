package by.bsc.iac.monitoringbuildingmaterials.dao;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Unit findByName(String name);
}
