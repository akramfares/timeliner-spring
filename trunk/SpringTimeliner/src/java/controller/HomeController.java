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
import services.NotificationService;
import services.UserService;

/**
 *
 * @author afares01
 */
@Controller
public class HomeController {
	@Autowired
	private UserService userService;
        @Autowired
	private NotificationService notificationService;
	
	@RequestMapping(value="/index.htm",method=RequestMethod.GET)
	protected ModelAndView indexProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            ModelAndView mv = new ModelAndView("index"); 
                return mv;
        }
        
        @RequestMapping(value="/header.htm",method=RequestMethod.GET)
	protected ModelAndView headerProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            ModelAndView mv = new ModelAndView("header"); 
                mv.addObject("connecte",isConnecte(userSession));
                mv.addObject("userConnecte",userSession);
                //mv.addObject("count_notifications",notificationService.countByProprio(userSession));
                //mv.addObject("count_amis",userService.countDemandesAmi(userSession));
                return mv;
        }
        
        @RequestMapping(value="/footer.htm",method=RequestMethod.GET)
	protected ModelAndView footerProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            ModelAndView mv = new ModelAndView("footer"); 
                mv.addObject("connecte",isConnecte(userSession));
                mv.addObject("userConnecte",userSession);
                return mv;
        }
        
         @RequestMapping(value="/image.htm",method=RequestMethod.GET)
	protected ModelAndView imageProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            ModelAndView mv = new ModelAndView("image"); 
            String w = request.getParameter("w");    
            String h = request.getParameter("h");
            String user_id = request.getParameter("user");
            User user = userService.getUserById(Integer.parseInt(user_id));
                mv.addObject("w",w);
                mv.addObject("h",h);
                mv.addObject("user",user);
                return mv;
        }


	@RequestMapping(value="/inscription.htm", method=RequestMethod.POST)
	  protected ModelAndView inscriptionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
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
        
        @RequestMapping(value="/deconnexion.htm", method=RequestMethod.GET)
	  protected ModelAndView deconnexionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
		mv.addObject("titre","Résultat de la deconnexion");
                HttpSession session=request.getSession(false); 
                session.setAttribute("user",null);
		mv.addObject("resultat","Deconnexion réussie ");

	  	return mv; 
	  }
        
        private boolean isConnecte(User userSession){
            if(userSession == null) return false;
            else return true;
        }
}
