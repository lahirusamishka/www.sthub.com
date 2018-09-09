package lk.ijse.sthub.main;




import lk.ijse.sthub.repository.TeacherRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan("lk.ijse.sthub")
@EnableJpaRepositories(basePackageClasses = TeacherRepository.class)
@EnableTransactionManagement
public class WebAppConfig {
}
