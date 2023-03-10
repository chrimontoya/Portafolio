package cl.grupopi.portafolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class PortafolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortafolioApplication.class, args);
    }

}
