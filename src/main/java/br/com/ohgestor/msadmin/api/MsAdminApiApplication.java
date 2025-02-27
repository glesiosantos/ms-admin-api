package br.com.ohgestor.msadmin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsAdminApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminApiApplication.class, args);

	}
}
