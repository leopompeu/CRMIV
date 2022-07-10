package com.crmiv.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leeds")
public class Leeds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NonNull
	@Column(name="nome")
	private String nome;
	
	@NonNull
	@Column(name="telefone")
	private String telefone;
	
	@NonNull
	@Column(name="email")
	private String email;
	
	@Column(name="isfechado")
	private Boolean isFechado;
	
	@Column(name="datafechamento")
	private Date dataFechamento;
	
}
