package br.com.edgarlatorre.tarefas.pojo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;
import org.hibernate.validator.Email;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Usuario {
	private static final Logger log = Logger.getLogger(Usuario.class);
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@Email(message="Verifique o formato do email")
	private String email;

	private String senha;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Tarefa> tarefas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		if(senha != null && senha.trim() != "") {
			this.senha = hash_senha(senha);
		}
	}
	public String getSenha() {
		return senha;
	}
	
	private String hash_senha(String senha) {
		String hash_senha = null;
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hash_senha = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			log.error("Erro ao criar o hash da senha", e);
		}
		
		return hash_senha;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
}
