package com.ic.dinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DininWebAppLocalMssql {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(DininWebAppLocalMssql.class)
				.profiles(
						SpringProfiles.DEV,
						SpringProfiles.LOCAL_MS_SQL
				)
				.run(args);
	}

}

