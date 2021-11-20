package by.kirill.sportsman.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorRef")
public class AuditConfiguration {

	@Bean
	public AuditAware auditorRef() {
		return new AuditAware();
	}
}
