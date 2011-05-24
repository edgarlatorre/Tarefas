package br.com.edgarlatorre.tarefas.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	private String status;
	
	@ManyToOne
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
}
