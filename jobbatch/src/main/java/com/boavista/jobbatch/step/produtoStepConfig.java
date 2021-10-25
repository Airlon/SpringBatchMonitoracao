package com.boavista.jobbatch.step;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boavista.jobbatch.dominio.Produto;

@Configuration
public class produtoStepConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(produtoStepConfig.class);
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step produtoStep(
			ItemReader<Produto> produtoReader,
			ItemWriter<Produto> produtoWriter) {
		return stepBuilderFactory
				.get("produtoStep")
				.<Produto, Produto>chunk(1)
				.reader(produtoReader)
				.writer(produtoWriter)
				.build();
	}
}

