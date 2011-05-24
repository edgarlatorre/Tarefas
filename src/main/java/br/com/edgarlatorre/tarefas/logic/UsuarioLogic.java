package br.com.edgarlatorre.tarefas.logic;

import org.apache.log4j.Logger;
import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import org.vraptor.i18n.Message;
import org.vraptor.plugin.hibernate.Validate;
import org.vraptor.scope.ScopeType;
import org.vraptor.validator.StringValidation;
import org.vraptor.validator.ValidationErrors;

import br.com.edgarlatorre.tarefas.dao.UsuarioDao;
import br.com.edgarlatorre.tarefas.pojo.Usuario;

@Component
public class UsuarioLogic {
	private static final Logger log = Logger.getLogger(UsuarioLogic.class);
	private Usuario usuario;
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public void formulario() {}
	public void login() {}

	@Validate(params={"usuario.email", "usuario.senha"})
	public void cadastra(Usuario usuario) {
		usuarioDao.salva(usuario);
	}
	
	public void validateCadastra(ValidationErrors errors, Usuario usuario) {
		if(usuarioDao.buscaUsuarioPorEmail(usuario.getEmail())  != null) {
			errors.add(new Message("email","Email existe"));
		}
		if(StringValidation.isBlank(usuario.getEmail()) || StringValidation.isEmpty(usuario.getEmail())) {
			errors.add(new Message("emailVazio","Preencha o campo email"));
		}
		
		if(StringValidation.isBlank(usuario.getSenha()) || StringValidation.isEmpty(usuario.getSenha())) {
			errors.add(new Message("senha","Preencha o campo senha"));
		}
	}
	
	public String logar(Usuario usuario){
		log.info("Logando usuario " + usuario.getEmail());
		this.usuario = usuarioDao.buscaUsuarioPorEmailESenha(usuario);
		
		if(this.usuario != null) {
			return "ok";
		} else {
			return "invalido";
		}
	}
	
	public void logout(){
		this.usuario = null;
	}
	
	@Out(scope=ScopeType.SESSION)
	public Usuario getUsuario() {
		return usuario;
	}
}
