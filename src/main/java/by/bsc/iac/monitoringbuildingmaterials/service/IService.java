package by.bsc.iac.monitoringbuildingmaterials.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(int id);
    T saveOrUpdate(T t);
    void delete(T t);


}
