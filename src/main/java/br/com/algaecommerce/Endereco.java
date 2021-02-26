package br.com.algaecommerce;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {
	
	@NotNull
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	@Column(length = 9)
	private String cep;
	
	@NotBlank
	@Column(length = 100)
	private String logradouro;
	
	@NotBlank
	@Column(length = 10)
	private String numero;
	
	@Column(length = 50)
	private String complemento;
	
	@NotBlank
	@Column(length = 50)
	private String bairro;
	
	@NotBlank
	@Column(length = 50)
	private String cidade;
	
	@NotBlank
	@Size(max = 2, min = 2)
	@Column(length = 2)
	private String estado;
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
