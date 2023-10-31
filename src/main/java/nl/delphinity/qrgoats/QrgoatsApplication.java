package nl.delphinity.qrgoats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableWebSecurity
public class QrgoatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrgoatsApplication.class, args);
	}

}
