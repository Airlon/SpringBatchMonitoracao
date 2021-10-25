package com.boavista.jobbatch.dominio;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdutoCliente {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoCliente.class);
	
	private String codigoPrimario;
	private String codigoSecundario;
	private String nomeCliente;
	private String sistema;
	private String assunto;
	private int quantidade;
	private String faturamentoPrimario;
	private String faturamentoSecundario;
	private Date data_fat;
	
	
	public String getCodigoPrimario() {
		return codigoPrimario;
	}
	public void setCodigoPrimario(String codigoPrimario) {
		this.codigoPrimario = codigoPrimario;
	}
	public String getCodigoSecundario() {
		return codigoSecundario;
	}
	public void setCodigoSecundario(String codigoSecundario) {
		this.codigoSecundario = codigoSecundario;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getFaturamentoPrimario() {
		return faturamentoPrimario;
	}
	public void setFaturamentoPrimario(String faturamentoPrimario) {
		this.faturamentoPrimario = faturamentoPrimario;
	}
	public String getFaturamentoSecundario() {
		return faturamentoSecundario;
	}
	public void setFaturamentoSecundario(String faturamentoSecundario) {
		this.faturamentoSecundario = faturamentoSecundario;
	}
	public Date getData_fat() {
		return data_fat;
	}
	public void setData_fat(Date data_fat) {
		this.data_fat = data_fat;
	}
	
	@Override
	public String toString() {
		return "ProdutoCliente{" +
	                " Codigo Primario='" + codigoPrimario + "'" +
	                ", Codigo Secundario ='" + codigoSecundario + "'" +
	                ", Nome Cliente ='" + nomeCliente + "'" +
	                ", Sistema ='" + sistema + "'" +
	                ", Assunto ='" + assunto + "'" +
	                ", Quantidade ='" + quantidade + "'" +
	                ", Faturamento Primario ='" + faturamentoPrimario + "'" +
	                ", Faturamento Secundario='" + faturamentoSecundario + "'" +
	                ", Data ='" + data_fat + "'" +
	                '}';
	
}

	}
	
