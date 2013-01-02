/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Ami;
import DAO.AmiDAO;
import DAO.User;
import DAO.UserDAO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author afares01
 */
@Service("AnnuaireService")
public class UserServiceImpl implements UserService{
	@Autowired
	public UserDAO users;
	@Autowired
	public AmiDAO amiDAO;

	@Override
	public boolean inscription(String nom, String prenom, String sexe, String adresse,String login, String motdepasse) {
		if(login.isEmpty() || motdepasse.isEmpty())
			return false;
		else {
			users.save(new User( login,  motdepasse, nom,  prenom, new Date(),  sexeBoolean(sexe),  adresse));
			return true;
		}
	}

	@Override
	public boolean connexion(String login, String motdepasse) {
		User u = new User(login, motdepasse);
		if(users.checkConnexion(u)) return true;
		else return false;
	}

	@Override
	public List<User> getAllUsers() {
		return users.findAll();
	}

	@Override
	public UserDAO getUserDAO() {
		return users;
	}
        
        @Override
	public User getUserById(Integer id) {
		return users.findById(id);
	}

    private boolean sexeBoolean(String sexe) {
        if(sexe.equals("m")) return true;
        else return false;
    }

    @Override
    public boolean ajouterAmi(User userSession, User ami) {
        if(ami != null || userSession != null){
            Ami a = new Ami();
            a.setProprio(userSession);
            a.setDestinataire(ami);
            a.setEtat(false);
            amiDAO.addAmi(a);
            return true;
        }
        else return false;
    }

    @Override
    public List<User> getDemandesAmi(User userSession) {
        return amiDAO.getDemandesAmi(userSession);
    }
    
    @Override
    public List<User> getAmis(User userSession) {
        return amiDAO.getAmis(userSession);
    }

    @Override
    public boolean confirmerAmi(User userSession, User ami) {
        if(ami != null || userSession != null){
            amiDAO.confimer(userSession, ami);
            return true;
        }
        else return false;
    }

    @Override
    public void modifierPhoto(User userSession) {
        userSession.setPhotoprofile(Boolean.TRUE);
        users.update(userSession);
    }

    @Override
    public Integer countDemandesAmi(User userSession) {
        return amiDAO.getDemandesAmi(userSession).size();
    }

	
}
