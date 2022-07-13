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

@Data
@Entity
@Table(name = "observacoes")
public class Observacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="consultorId", referencedColumnName = "id")
	private Consultores consultor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="leedId", referencedColumnName = "id")
	private Leeds leeds;
}
