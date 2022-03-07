package by.bsc.iac.monitoringbuildingmaterials.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class MyConfig {

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/miac?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("postgres");
            dataSource.setPassword("allesia");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }



    /////////////////////////////////////////////////////////////////////////////
    private final ApplicationContext applicationContext;
    @Autowired
    public MyConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setAdditionalDialects();

        Set<IDialect> additionalDialects = new HashSet<>();
//        additionalDialects.add(new LayoutDialect());
        additionalDialects.add(new SpringSecurityDialect());
        templateEngine.setAdditionalDialects(additionalDialects);



        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


}
