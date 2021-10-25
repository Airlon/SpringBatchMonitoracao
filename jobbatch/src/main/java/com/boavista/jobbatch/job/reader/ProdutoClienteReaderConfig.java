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
import org.springframework.validation.BindException;

import com.boavista.jobbatch.dominio.ProdutoCliente;

@Configuration
public class ProdutoClienteReaderConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoClienteReaderConfig.class);
	
	@StepScope
	@Bean
	public FlatFileItemReader<ProdutoCliente> produtoClienteReader() {
		return new FlatFileItemReaderBuilder<ProdutoCliente>()	
				.name("produtoClienteReader")
				.resource(new FileSystemResource("C:/Projetos/File/FATLOG_PRODUTO_CLIENTE.txt"))
				.delimited()
				.delimiter(";")
				.names(new String [] {"codigoPrimario", "codigoSecundario", "nomeCliente", "sistema", "assunto", "quantidade", "faturamentoPrimario", "faturamentoSecundario", "data_fat" })
				.addComment("")
				.fieldSetMapper(fieldSetMapper())
				.build();

	}


	private FieldSetMapper<ProdutoCliente> fieldSetMapper() {
		return new FieldSetMapper<ProdutoCliente>() {
			
			
			@Override
			public ProdutoCliente mapFieldSet(FieldSet fieldSet) throws BindException {
				ProdutoCliente produtoCliente = new ProdutoCliente ();
				produtoCliente.setAssunto(fieldSet.readString("assunto"));
				produtoCliente.setCodigoPrimario(fieldSet.readString("codigoPrimario"));
				produtoCliente.setCodigoSecundario(fieldSet.readString("codigoSecundario"));
				produtoCliente.setSistema(fieldSet.readString("sistema"));
				produtoCliente.setNomeCliente(fieldSet.readString("nomeCliente"));
				produtoCliente.setNomeCliente(fieldSet.readString("nomeCliente"));
			    produtoCliente.setFaturamentoPrimario(fieldSet.readString("faturamentoPrimario"));
			    produtoCliente.setFaturamentoSecundario(fieldSet.readString("faturamentoSecundario"));
			    produtoCliente.setData_fat(new Date (fieldSet.readDate("data_fat","yyyyMMdd").getTime()));
			    produtoCliente.setQuantidade(fieldSet.readInt("quantidade"));
				return produtoCliente;
				
			}
		};
	}

}


