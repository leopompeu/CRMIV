package com.crmiv.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "enderecos")
public class Enderecos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="numero")
	private int numero;
	
	@NonNull
	@Column(name="bairro")
	private String bairro;
	
	@NonNull
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="cep")
	private String cep;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="leedId", referencedColumnName = "id")
	private Leeds leed;
}
