package by.bsc.iac.monitoringbuildingmaterials.service;

import by.bsc.iac.monitoringbuildingmaterials.dao.UnitRepository;
import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import by.bsc.iac.monitoringbuildingmaterials.exception_handling.NoSuchUnitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService implements IUnitService{

    @Autowired
    UnitRepository repository;

    @Override
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @Override
    public Unit findById(int id) {
        return repository.getById(id);
    }

    @Override
    public Unit saveOrUpdate(Unit unit) {
        Unit alreadyExistUnit = findByName(unit.getName());
        if (alreadyExistUnit!=null){
            throw new NoSuchUnitException("The unit with name \""+ unit.getName()+ "\" already exist in Database");
        }
        return repository.save(unit);
    }

    @Override
    public void delete(Unit unit) {
        repository.deleteById(unit.getId());
    }

    @Override
    public Unit findByName(String name) {
        return repository.findByName(name);
    }
}
