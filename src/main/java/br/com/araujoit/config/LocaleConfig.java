package br.com.araujoit.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LocaleConfig {

	@PostConstruct
	void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
}
