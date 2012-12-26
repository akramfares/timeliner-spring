/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import DAO.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

/**
 *
 * @author afares01
 */
@Controller
public class HomeController {
	@Autowired
	private UserService userService;	
	
	@RequestMapping(value="/index.htm",method=RequestMethod.GET)
	protected ModelAndView indexProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            ModelAndView mv = new ModelAndView("index"); 
                mv.addObject("connecte",isConnecte(request));
                return mv;
        }

	@RequestMapping(value="/inscription.htm", method=RequestMethod.POST)
	  protected ModelAndView inscriptionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
                mv.addObject("connecte",isConnecte(request));
		String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String sexe = request.getParameter("sexe");
                String adresse = request.getParameter("adresse");
                String login = request.getParameter("login");
		String motdepasse = request.getParameter("motdepasse");
		mv.addObject("titre","Résultat de l'inscription");
		if(userService.inscription(nom, prenom, sexe, adresse, login, motdepasse))
			mv.addObject("resultat","Inscription réussie");
		else
			mv.addObject("resultat", "Erreur d'inscription");
		
	  	return mv; 
	  }

	@RequestMapping(value="/connexion.htm", method=RequestMethod.POST)
	  protected ModelAndView connexionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
                mv.addObject("connecte",isConnecte(request));
		String login = request.getParameter("login");
		String motdepasse = request.getParameter("motdepasse");
		mv.addObject("titre","Résultat de la connexion");
		if(userService.connexion(login, motdepasse)){
			
			HttpSession session=request.getSession(false); // pas de création !
			User u = userService.getUserDAO().findByName(login);
			session.setAttribute("user",u);
			mv.addObject("resultat","Connexion réussie "+u.getLogin());
		}
		else
			mv.addObject("resultat", "Erreur de connexion");
		
	  	return mv; 
	  }	
        
        private boolean isConnecte(HttpServletRequest request){
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            if(userSession == null) return false;
            else return true;
        }
}
