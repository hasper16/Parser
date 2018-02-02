package ua.org.hasper.Parser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {


    @Resource
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{Application.class}, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {

        };
    }
}
