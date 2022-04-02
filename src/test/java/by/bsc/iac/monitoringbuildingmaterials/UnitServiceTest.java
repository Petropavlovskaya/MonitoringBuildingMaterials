package by.bsc.iac.monitoringbuildingmaterials;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import by.bsc.iac.monitoringbuildingmaterials.exception_handling.NoSuchUnitException;
import by.bsc.iac.monitoringbuildingmaterials.service.UnitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UnitService.class})
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class UnitServiceTest {

    @Resource
    private UnitService unitService;

    @Test
    public void whenSaveUnitThenUnitIsNonNull() {
        Unit saveUnit = unitService.saveOrUpdate(new Unit("kg"));
        Unit foundUnit = unitService.findById(saveUnit.getId());
        assertNotNull(foundUnit);
    }

    @Test
    public void whenSaveUnitThenGetTheSameUnit() {
        Unit saveUnit = unitService.saveOrUpdate(new Unit("kg"));
        Unit foundUnit = unitService.findById(saveUnit.getId());
        assertEquals(saveUnit, foundUnit);
    }

    @Test
    public void whenUpdateUnitThenOk() {
        Unit saveUnit = unitService.saveOrUpdate(new Unit("kg"));
        saveUnit.setName("kilogram");
        unitService.saveOrUpdate(saveUnit);
        Unit foundUnit = unitService.findById(saveUnit.getId());
        assertEquals(saveUnit, foundUnit);
    }

    @Test
    public void whenSaveFiveUnitThenGetFiveUnit() {
        Unit saveUnit1 = unitService.saveOrUpdate(new Unit("kg1"));
        Unit saveUnit2 = unitService.saveOrUpdate(new Unit("kg2"));
        Unit saveUnit3 = unitService.saveOrUpdate(new Unit("kg3"));
        Unit saveUnit4 = unitService.saveOrUpdate(new Unit("kg4"));
        Unit saveUnit5 = unitService.saveOrUpdate(new Unit("kg5"));

        List<Unit> allUnits = unitService.findAll();
        assertEquals(5, allUnits.size());

    }

/*    @Test
    public void whenSaveTheSameUnitThenUnitDoesNotSave(){
        Unit saveUnit4 = unitService.saveOrUpdate(new Unit("kg"));
        Unit saveUnit5 = unitService.saveOrUpdate(new Unit("kg"));

        List<Unit> allUnits = unitService.findAll();
        assertEquals(1, allUnits.size());

    }*/

    @Test
    public void whenSaveTheSameUnitThenGetException() {
        unitService.saveOrUpdate(new Unit("kg"));

        List<Unit> allUnits = unitService.findAll();
        assertThrows(NoSuchUnitException.class, () -> {
            unitService.saveOrUpdate(new Unit("kg"));
        });
        assertEquals(1, allUnits.size());

    }

}