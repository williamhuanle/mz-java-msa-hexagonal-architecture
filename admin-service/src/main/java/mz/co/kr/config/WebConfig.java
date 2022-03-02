package mz.co.kr.config;

//import mz.co.kr.adapters.EmployeeJpaAdapterImpl;
import mz.co.kr.adapters.EmployeeMongoDbAdapterImpl;
import mz.co.kr.admin.domain.services.EmployeeServiceImpl;
import mz.co.kr.admin.ports.api.EmployeeServicePort;
import mz.co.kr.admin.ports.spi.EmployeePersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public EmployeePersistencePort employeePersistence(){
        return new EmployeeMongoDbAdapterImpl();
    }

    @Bean
    public EmployeeServicePort employeeService(){
        return new EmployeeServiceImpl(employeePersistence());
    }

}
