package com.crmiv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "leeds")
public class Leeds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@Column(name="nome")
	private String nome;
	
	@NonNull
	@Column(name="telefone")
	private String telefone;
	
	@NonNull
	@Column(name="email")
	private String email;
	
	@Column(name="isFechado")
	private Boolean isFechado;
	
	@Column(name="dataFechamento")
	private String dataFechamento;
	
}
