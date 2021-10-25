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

import com.boavista.jobbatch.dominio.ProdutoCliente;
import com.boavista.jobbatch.job.reader.ProdutoReaderConfig;

@Configuration
public class produtoClienteStepConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(produtoClienteStepConfig.class);
	
		@Autowired
		public StepBuilderFactory stepBuilderFactory;

		@Bean
		public Step produtoClienteStep(
				ItemReader<ProdutoCliente> produtoClienteReader,
				ItemWriter<ProdutoCliente> produtoClienteWriter) {
			return stepBuilderFactory
					.get("produtoClienteStep")
					.<ProdutoCliente, ProdutoCliente>chunk(1)
					.reader(produtoClienteReader)
					.writer(produtoClienteWriter)
					.build();
		}
	}



