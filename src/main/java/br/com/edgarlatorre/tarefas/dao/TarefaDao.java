package br.com.edgarlatorre.tarefas.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.edgarlatorre.tarefas.pojo.Tarefa;
import br.com.edgarlatorre.tarefas.pojo.Usuario;
import br.com.edgarlatorre.tarefas.util.HibernateUtil;

public class TarefaDao {
	private static final Logger log = Logger.getLogger(TarefaDao.class);

	public void salva(Tarefa tarefa) {
		log.info("Salvando tarefa " + tarefa.getNome());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(tarefa);
		session.getTransaction().commit();
		session.close();
	}
	
	public void atualiza(Tarefa tarefa) {
		log.info("Atualizando tarefa " + tarefa.getNome());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(tarefa);
		session.getTransaction().commit();
		session.close();
	}

	public void remove(Tarefa tarefa) {
		log.info("Removendo tarefa " + tarefa.getNome());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(tarefa);
		session.getTransaction().commit();
		session.close();
	}

	public List<Tarefa> listaPorIdUsuario(Long usuarioId) {
		log.info("Buscando tarefas do usuario " + usuarioId);
		String stringQuery = "select tarefa from Tarefa as tarefa where tarefa.usuario.id = :usuarioId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(stringQuery);
		query.setParameter("usuarioId", usuarioId);
		List<Tarefa> tarefas = query.list();
		session.close();
		return tarefas;
	}

	public Tarefa buscaPorIdTarefa(Long id) {
		log.info("Buscando tarefa por id: " + id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Tarefa tarefa = null;
		tarefa = (Tarefa) session.load(Tarefa.class, id);
		return tarefa;
	}
}
