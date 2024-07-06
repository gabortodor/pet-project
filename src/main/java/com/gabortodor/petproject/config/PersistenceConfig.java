package com.gabortodor.petproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for configuring JPA and database persistence settings.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.gabortodor.petproject.repository")
@EnableJpaAuditing
public class PersistenceConfig {
}
