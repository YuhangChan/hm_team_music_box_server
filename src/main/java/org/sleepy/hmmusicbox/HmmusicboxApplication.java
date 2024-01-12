package org.sleepy.hmmusicbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HmmusicboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmmusicboxApplication.class, args);
	}

}
