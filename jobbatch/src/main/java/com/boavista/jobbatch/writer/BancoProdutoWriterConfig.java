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

import com.boavista.jobbatch.dominio.Produto;

@Configuration
public class BancoProdutoWriterConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(BancoProdutoWriterConfig.class);
	
	@Bean
	public JdbcBatchItemWriter<Produto> bancoProdutoWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Produto>()
				.dataSource(dataSource)
				.sql("INSERT INTO FATLOG_PRODUTO (sistema, assunto, descricao, quantidade, data_prodt) VALUES (?, ?, ?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementeSetter())
				.build();
			
		
	}

	private ItemPreparedStatementSetter<Produto> itemPreparedStatementeSetter() {
		return new ItemPreparedStatementSetter<Produto>() {
			
			@Override
			public void setValues (Produto produto, PreparedStatement ps) throws SQLException {
				ps.setString(1, produto.getSistema());
				ps.setString(2, produto.getAssunto());
				ps.setString(3, produto.getDescricao());
				ps.setInt(4, produto.getQuantidade());
				ps.setDate(5, new Date(produto.getData_prodt().getTime()));
			}
			
		};
	}
}
