package lk.blacky.ijse.assignment_2.config;

import lk.blacky.ijse.assignment_2.AppInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = AppInitializer.class)
public class WebRootConfig {
}
