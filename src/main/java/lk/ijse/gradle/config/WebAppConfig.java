package lk.ijse.gradle.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.gradle")
public class WebAppConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
