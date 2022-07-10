package com.crmiv.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Consultores")
public class Consultores{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String nome;
	
	@NonNull
	@Column(unique=true)
	private String login;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NonNull
	private String senha;
	
	private Boolean isAdmin;

	
}
