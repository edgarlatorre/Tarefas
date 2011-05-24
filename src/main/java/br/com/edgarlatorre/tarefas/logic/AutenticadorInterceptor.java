package br.com.edgarlatorre.tarefas.logic;

import org.vraptor.Interceptor;
import org.vraptor.LogicException;
import org.vraptor.LogicFlow;
import org.vraptor.annotations.In;
import org.vraptor.scope.ScopeType;
import org.vraptor.view.ViewException;

import br.com.edgarlatorre.tarefas.pojo.Usuario;


public class AutenticadorInterceptor implements Interceptor{
	@In(scope=ScopeType.SESSION, required=false)
	private Usuario usuario;

	public void intercept(LogicFlow flow) throws LogicException, ViewException {
		if(this.usuario == null) {
			try {
				flow.getLogicRequest().getResponse().sendRedirect("usuario.login.logic");
			} catch (Exception e) {
				throw new LogicException();
			}
		} else {
			flow.execute();
		}
	}

}
