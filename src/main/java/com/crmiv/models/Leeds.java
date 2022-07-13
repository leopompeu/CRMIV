package com.crmiv.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name = "id")
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
	
	@Temporal(TemporalType.DATE)
	@Column(name="datafechamento")
	private Date dataFechamento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="consultorId", referencedColumnName = "id")
	private Consultores consultor;
	
}
