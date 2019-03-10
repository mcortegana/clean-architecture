package com.github.mcortegana.adapter.dataprovider.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.github.mcortegana.adapter.dataprovider.jpa.entity"})
@EnableJpaRepositories(basePackages = {"com.github.mcortegana.adapter.dataprovider.jpa.repository"})
public class JpaConfig {
}
