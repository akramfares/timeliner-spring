/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.User;
import DAO.UserDAO;

/**
 *
 * @author afares01
 */
public interface UserService {
	

	public boolean inscription(String nom, String prenom, String sexe, String adresse, String login, String motdepasse);
	public boolean connexion(String login, String motdepasse);
	public String getAllUsers();
	public UserDAO getUserDAO();
}