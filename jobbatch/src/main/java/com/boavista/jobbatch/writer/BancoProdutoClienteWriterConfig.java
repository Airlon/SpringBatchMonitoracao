package com.boavista.jobbatch.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boavista.jobbatch.dominio.ProdutoCliente;

@Configuration
public class BancoProdutoClienteWriterConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(BancoProdutoClienteWriterConfig.class);
			
	@Bean
	public JdbcBatchItemWriter<ProdutoCliente> bancoProdutoClienteWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<ProdutoCliente>()
				.dataSource(dataSource)
				.sql("INSERT INTO FATLOG_PRODUTO_CLIENTE (codigoPrimario, codigoSecundario, nomeCliente, sistema, assunto, quantidade, faturamentoPrimario, faturamentoSecundario, data_fat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementeSetter())
				.build();
			
		
	}

	private ItemPreparedStatementSetter<ProdutoCliente> itemPreparedStatementeSetter() {
		return new ItemPreparedStatementSetter<ProdutoCliente>() {
			
			@Override
			public void setValues (ProdutoCliente produtoCliente, PreparedStatement ps) throws SQLException {
				ps.setString(1, produtoCliente.getCodigoPrimario());
				ps.setString(2, produtoCliente.getCodigoSecundario());
				ps.setString(3, produtoCliente.getNomeCliente());
				ps.setString(4, produtoCliente.getSistema());
				ps.setString(5, produtoCliente.getAssunto());
				ps.setInt(6, produtoCliente.getQuantidade());
				ps.setString(7, produtoCliente.getFaturamentoPrimario());
				ps.setString(8, produtoCliente.getFaturamentoSecundario());
				ps.setDate(9, new Date(produtoCliente.getData_fat().getTime()));
		
			}
			
		};
	}
}
