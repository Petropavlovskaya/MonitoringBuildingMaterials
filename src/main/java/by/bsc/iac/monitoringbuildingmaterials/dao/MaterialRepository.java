package by.bsc.iac.monitoringbuildingmaterials.dao;

import by.bsc.iac.monitoringbuildingmaterials.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
