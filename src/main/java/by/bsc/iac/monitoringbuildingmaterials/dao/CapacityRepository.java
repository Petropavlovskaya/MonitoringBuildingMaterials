package by.bsc.iac.monitoringbuildingmaterials.dao;

import by.bsc.iac.monitoringbuildingmaterials.entity.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacityRepository extends JpaRepository<Capacity, Integer> {
}
