package br.com.edgarlatorre.tarefas.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.vraptor.annotations.Component;
import org.vraptor.annotations.In;
import org.vraptor.annotations.InterceptedBy;
import org.vraptor.annotations.Out;
import org.vraptor.scope.ScopeType;

import br.com.edgarlatorre.tarefas.dao.TarefaDao;
import br.com.edgarlatorre.tarefas.pojo.Tarefa;
import br.com.edgarlatorre.tarefas.pojo.Usuario;

@Component
@InterceptedBy(AutenticadorInterceptor.class)
public class TarefaLogic {
	private static final Logger log = Logger.getLogger(TarefaLogic.class);
	@In(scope=ScopeType.SESSION)
	@Out(scope=ScopeType.SESSION)
	private Usuario usuario;
	private boolean logado = true;
	private List<Tarefa> tarefas;
	private TarefaDao tarefaDao = new TarefaDao();
	private Tarefa tarefa;
	
	public void index(){
		tarefas = tarefaDao.listaPorIdUsuario(this.usuario.getId());
	}
	
	public void salva(Tarefa tarefa) {
		tarefa.setUsuario(usuario);
		tarefaDao.salva(tarefa);
		tarefas = tarefaDao.listaPorIdUsuario(this.usuario.getId());
	}
	
	public void atualiza(Tarefa tarefa) {
		//tarefa.setUsuario(usuario);
		tarefaDao.atualiza(tarefa);
		tarefas = tarefaDao.listaPorIdUsuario(this.usuario.getId());
	}
	
	public void remove(Tarefa tarefa) {
		tarefaDao.remove(tarefa);
		tarefas = tarefaDao.listaPorIdUsuario(this.usuario.getId());
	}
	
	public void edita(Tarefa tarefa) {
		this.tarefa = tarefaDao.buscaPorIdTarefa(tarefa.getId());
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public boolean isLogado() {
		return logado;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}
}
