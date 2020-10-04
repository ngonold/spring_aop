package test.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan(value = {"test"})
@PropertySource("classpath:application.yml")
@EnableAspectJAutoProxy
@EnableScheduling
public class AnnotationConfiguration {

}
