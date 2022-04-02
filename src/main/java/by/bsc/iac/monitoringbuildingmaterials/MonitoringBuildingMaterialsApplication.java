package by.bsc.iac.monitoringbuildingmaterials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"by.bsc.iac"})
public class MonitoringBuildingMaterialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringBuildingMaterialsApplication.class, args);
    }

}
