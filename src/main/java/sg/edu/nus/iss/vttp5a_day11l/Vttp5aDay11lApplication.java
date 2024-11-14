package sg.edu.nus.iss.vttp5a_day11l;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

@SpringBootApplication
public class Vttp5aDay11lApplication {

	@Bean
	public CommonsRequestLoggingFilter logging() {
		CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter();
		crlf.setIncludeClientInfo(true);
		crlf.setIncludeQueryString(true);
		return crlf;
	}

	public static void main(String[] args) {
		// SpringApplication.run(Vttp5aDay11lApplication.class, args);

		SpringApplication app = new SpringApplication(Vttp5aDay11lApplication.class);

		String port = "3000";
		ApplicationArguments argsOptions = new DefaultApplicationArguments(args);

		if (argsOptions.containsOption("port")) {
			port = argsOptions.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		String dirFile = "";
		if (argsOptions.containsOption("file")) {
			dirFile = argsOptions.getOptionValues("file").get(0);

			System.out.println("Directory file: " + dirFile);
		}

		app.run(args);

	}

}
