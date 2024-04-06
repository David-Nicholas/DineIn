package com.ic.dinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DininWebAppEmbeddedDb {


	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(DininWebAppEmbeddedDb.class)
				.profiles(
						SpringProfiles.DEV,
						SpringProfiles.EMBEDDED_DB_H2,
						SpringProfiles.TEST_DATA_SEED
				)
				.run(args);
	}

}

