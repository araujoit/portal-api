package br.com.araujoit;

import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import br.com.araujoit.helpers.DatetimeHelper;

@SpringBootApplication(scanBasePackages = "br.com.araujoit")
@PropertySource("file:application.properties")
public class PortalApiApplication implements DatetimeHelper {

	public static void main(String[] args) {
		SpringApplication.run(PortalApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			Timestamp timestamp = now();
			System.out.println("Started at " + timestamp);
		};
	}
}
