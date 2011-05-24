package br.com.edgarlatorre.tarefas.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.edgarlatorre.tarefas.pojo.Usuario;
import br.com.edgarlatorre.tarefas.util.HibernateUtil;

public class UsuarioDao {
	private static final Logger log = Logger.getLogger(UsuarioDao.class);
	
	public void salva(Usuario usuario) {
		log.info("Salvando usuario " + usuario.getEmail());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public List<Usuario> lista() {
		log.info("Listando usuarios");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).list(); 
		session.close();
		return usuarios;
		
	}
	
	public Usuario buscaUsuarioPorId(Long idUsuario) {
		log.info("Buscando usuario por id: " + idUsuario);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario usuario = null;
		session.load(Usuario.class, idUsuario);
		return usuario;
	}

	public Usuario buscaUsuarioPorEmailESenha(Usuario usuario) {
		log.info("Buscando usuario " + usuario.getEmail());
		String stringQuery = "select usuario from Usuario as usuario where usuario.email = :email and usuario.senha = :senha";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(stringQuery);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		usuario = (Usuario) query.uniqueResult();
		session.close();
		
		return usuario;
	}

	public void remove(Usuario usuario) {
		log.info("Removendo usuario " + usuario.getEmail());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public Usuario buscaUsuarioPorEmail(String email) {
		log.info("Buscando usuario por email" + email);
		String stringQuery = "select usuario from Usuario as usuario where usuario.email = :email";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(stringQuery);
		query.setParameter("email", email);
		Usuario usuario = (Usuario) query.uniqueResult();
		session.close();
		
		return usuario;
	}
}
