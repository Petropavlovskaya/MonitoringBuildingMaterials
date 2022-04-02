package by.bsc.iac.monitoringbuildingmaterials.dao;

import by.bsc.iac.monitoringbuildingmaterials.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
