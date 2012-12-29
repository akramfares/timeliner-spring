/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fares
 */
@Repository("AmiDAO")
public class AmiDAO {
    @PersistenceContext(unitName="SpringTimelinerPU")
    private EntityManager em;
    
    @Transactional
    public void addAmi(Ami a) {
        em.persist(em.merge(a));
    }
    
    @Transactional
    public List<User> getDemandesAmi(User u) {
        Query q = em.createQuery("SELECT DISTINCT a.proprio FROM Ami a, User u WHERE a.destinataire = ? AND etat = false");
        q.setParameter(1, u);
	return (ArrayList) q.getResultList();
    }
    
    @Transactional
    public List<User> getAmis(User u) {
        Query q = em.createQuery("SELECT DISTINCT a.proprio FROM Ami a, User u WHERE a.destinataire = ? AND etat = true");
        q.setParameter(1, u);
        Query q2 = em.createQuery("SELECT DISTINCT a.destinataire FROM Ami a, User u WHERE a.proprio = ? AND etat = true");
        q2.setParameter(1, u);
        ArrayList<User> amis = new ArrayList<User>();
        amis.addAll(q.getResultList());
        amis.addAll(q2.getResultList());
	return amis;
    }
    
    @Transactional
    public void confimer(User userSession, User ami) {
        Query q = em.createQuery("UPDATE Ami a SET etat = true WHERE a.destinataire = ? AND a.proprio = ? AND etat = false");
        q.setParameter(1, userSession);
        q.setParameter(2, ami);
        q.executeUpdate();
    }
}
