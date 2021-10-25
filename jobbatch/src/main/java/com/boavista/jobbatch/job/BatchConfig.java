package com.boavista.jobbatch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;


	@Bean
	public Job leituraDoArquivoJob (
			@Qualifier("produtoStep") Step produtoStep, 
			@Qualifier("produtoClienteStep") Step produtoClienteStep) {
		return jobBuilderFactory
				.get("leituraDoArquivoJob")
				.start(produtoStep)
				.next(produtoClienteStep)
				.incrementer(new RunIdIncrementer())
				.build();
		
	}
}
