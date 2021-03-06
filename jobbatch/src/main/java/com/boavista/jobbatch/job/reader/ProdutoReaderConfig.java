package com.boavista.jobbatch.job.reader;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindException;

import com.boavista.jobbatch.dominio.Produto;


@Configuration
public class ProdutoReaderConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoReaderConfig.class);
	
	@StepScope
	@Bean
	public FlatFileItemReader<Produto> produtoReader() {
		return new FlatFileItemReaderBuilder<Produto>()	
				.name("produtoReader")
				.resource(new FileSystemResource("C:/Projetos/File/FATLOG_PRODUTO.txt"))
				.delimited()
				.delimiter(";")
				.names(new String [] {"sistema", "assunto", "descricao", "quantidade", "data_prodt"})
				.addComment("")
				.fieldSetMapper(fieldSetMapper())
				.build();
		

	}

	private FieldSetMapper<Produto> fieldSetMapper() {
		return new FieldSetMapper<Produto>() {
			
			
			@Override
			public Produto mapFieldSet(FieldSet fieldSet) throws BindException {
				Produto produto = new Produto ();
				produto.setAssunto(fieldSet.readString("assunto"));
				produto.setDescricao(fieldSet.readString("descricao"));
				produto.setSistema(fieldSet.readString("sistema"));
				produto.setData_prodt(new Date (fieldSet.readDate("data_prodt","yyyyMMdd").getTime()));
				produto.setQuantidade(fieldSet.readInt("quantidade"));
				return produto;
				
			}
		};
	}

}

