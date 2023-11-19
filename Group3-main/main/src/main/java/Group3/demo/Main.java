package Group3.demo;
// Jake Wursteisen
// Andrew Yum

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Group3.demo")
@Log4j2
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}