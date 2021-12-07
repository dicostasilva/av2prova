package com.newton.aaw.hr.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.newtonpaiva.av2.microempresa.api.MicroEmpresaDto;

@Document
public class MicroEmpresa {

	@Id
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDateTime dataDeCadastro;
	
	
	public MicroEmpresa() {
	}

	public MicroEmpresa(String id, String nome, String cnpj, String email, LocalDateTime dataDeCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.dataDeCadastro = dataDeCadastro;
	}


	public MicroEmpresa(MicroEmpresaDto microEmpresaDto) {
		if(microEmpresaDto != null) {
			this.id = microEmpresaDto.getId();
			this.nome = microEmpresaDto.getNome();
			this.cnpj = microEmpresaDto.getCnpj();
			this.email = microEmpresaDto.getEmail();
			this.dataDeCadastro = microEmpresaDto.getDataDeCadastro();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
}