package Group3.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Group3.demo.vehicles.Vehicle;
import Group3.demo.vehicles.VehicleRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Group3.demo.vehicles")
@Log4j2
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
