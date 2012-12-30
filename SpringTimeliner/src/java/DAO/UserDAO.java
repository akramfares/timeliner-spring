/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author afares01
 */
@Repository("UserDAO")
public class UserDAO {
	@PersistenceContext(unitName="SpringTimelinerPU")
	private EntityManager em;
	
	@Transactional
	public void save(User i){
		i.setPhotoprofile(Boolean.FALSE);
		em.persist(i);
	}
	
	@Transactional
	public void update(User i){
		em.merge(i);
	}
	
	@Transactional
	public void delete(User i){
		em.remove(em.merge(i));
	}

	
	

	@Transactional
	public ArrayList<User> findAll(){
		Query q = em.createQuery("SELECT p FROM User p");
		return (ArrayList) q.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public boolean checkConnexion(User u) {
		Query q = em.createQuery("SELECT p FROM User p WHERE p.login=? AND p.motDePasse=?");
		q.setParameter(1, u.getLogin());
		q.setParameter(2, u.getMotDePasse());
		if(!q.getResultList().isEmpty()) return true;
		else return false;
	}

	
	@Transactional
	public User findById(Integer proprio) {
		return em.find(User.class, proprio);
	}

	public User findByName(String login) {
		Query q = em.createQuery("SELECT p FROM User p WHERE p.login=?");
		q.setParameter(1, login);
		return (User) q.getResultList().get(0);
	}
}
