/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.User;
import DAO.UserDAO;
import java.util.Date;
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
	public String getAllUsers() {
		String resultat = "";	
		for(User u : users.findAll()){
			 resultat += "<option value='"+u.getId()+"'>"+u.getLogin()+"</option>";
		}
		return resultat;
	}

	@Override
	public UserDAO getUserDAO() {
		return users;
	}

    private boolean sexeBoolean(String sexe) {
        if(sexe.equals("m")) return true;
        else return false;
    }

	
}
