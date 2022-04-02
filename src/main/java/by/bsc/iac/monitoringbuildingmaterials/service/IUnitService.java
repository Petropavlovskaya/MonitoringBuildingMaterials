package by.bsc.iac.monitoringbuildingmaterials.service;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;

public interface IUnitService extends IService<Unit> {
    Unit findByName(String name);

}
