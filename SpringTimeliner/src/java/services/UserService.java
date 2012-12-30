/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.User;
import DAO.UserDAO;
import java.util.List;

/**
 *
 * @author afares01
 */
public interface UserService {
	

	public boolean inscription(String nom, String prenom, String sexe, String adresse, String login, String motdepasse);
	public boolean connexion(String login, String motdepasse);
	public List<User> getAllUsers();
	public UserDAO getUserDAO();
        public User getUserById(Integer id);
        public boolean ajouterAmi(User userSession, User ami);
        public List<User> getDemandesAmi(User userSession);
        public List<User> getAmis(User userSession);
        public boolean confirmerAmi(User userSession, User ami);
        public void modifierPhoto(User userSession);
        
}
