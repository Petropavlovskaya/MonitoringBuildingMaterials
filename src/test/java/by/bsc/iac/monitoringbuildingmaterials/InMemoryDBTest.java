package by.bsc.iac.monitoringbuildingmaterials;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import by.bsc.iac.monitoringbuildingmaterials.service.UnitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//org.junit.jupiter.api.Assertions

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThatObject;

//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UnitService.class})
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class InMemoryDBTest {

    @Resource
    private UnitService unitService;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Unit saveUnit = unitService.saveOrUpdate(new Unit("kg"));
        Unit foundUnit = unitService.findById(saveUnit.getId());
        assertThatObject(foundUnit).isNotNull();
        assertThatObject(foundUnit).hasSameHashCodeAs(saveUnit);
    }

    @Test
    public void givenStudent_whenSave_thenGetThisOk() {
        Unit saveUnit = unitService.saveOrUpdate(new Unit("kg"));
        Unit foundUnit = unitService.findById(saveUnit.getId());
        assertThatObject(foundUnit).hasSameHashCodeAs(saveUnit);
    }

}
