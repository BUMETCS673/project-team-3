package Employee_Management_System;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("Employee_Management_System.*")
@MapperScan("Employee_Management_System.*.mapper")
@SpringBootApplication
public class EmsV1Application {
    public static void main(String[] args) {
        SpringApplication.run(EmsV1Application.class, args);
    }
}
