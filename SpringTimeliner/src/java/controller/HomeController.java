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
// Dans ce Controller se trouvent toutes les pages qui ne sont pas relatives directement à la partie "réseau social"
@Controller
public class HomeController {
	@Autowired
	private UserService userService;
        @Autowired
	private NotificationService notificationService;
	
        // Page d'accueil de l'application
	@RequestMapping(value="/index.htm",method=RequestMethod.GET)
	protected ModelAndView indexProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            ModelAndView mv = new ModelAndView("index"); 
                return mv;
        }
        
        // Haut de page qui va être inclu sur chacune des pages du site
        @RequestMapping(value="/header.htm",method=RequestMethod.GET)
	protected ModelAndView headerProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            
            ModelAndView mv = new ModelAndView("header"); 
                mv.addObject("connecte",isConnecte(userSession));
                mv.addObject("userConnecte",userSession);
                if(isConnecte(userSession)){
                    mv.addObject("count_notifications",notificationService.countByProprio(userSession));
                    mv.addObject("count_amis",userService.countDemandesAmi(userSession));
                }
                return mv;
        }
        
        // Bas de page qui va être inclu sur chacune des pages du site
        @RequestMapping(value="/footer.htm",method=RequestMethod.GET)
	protected ModelAndView footerProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            
            ModelAndView mv = new ModelAndView("footer"); 
                mv.addObject("connecte",isConnecte(userSession));
                mv.addObject("userConnecte",userSession);
                return mv;
        }
        
        // Cette page s'occupe d'afficher l'image de profile de l'utilisateur avec des dimensions données
         @RequestMapping(value="/image.htm",method=RequestMethod.GET)
	protected ModelAndView imageProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
             // Récupération de l'utilisateur connecté
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            
            ModelAndView mv = new ModelAndView("image"); 
            String w = request.getParameter("w");    // Width
            String h = request.getParameter("h");    // Height
            String user_id = request.getParameter("user"); // Id de l'utilisateur
            User user = userService.getUserById(Integer.parseInt(user_id)); // Récupération de l'utilisateur à partir de son Id
                mv.addObject("w",w);
                mv.addObject("h",h);
                mv.addObject("user",user);
                return mv;
        }

         // Page de validation du formulaire d'inscription
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
                
                // Validation de l'inscription par le service UserService
		if(userService.inscription(nom, prenom, sexe, adresse, login, motdepasse))
			mv.addObject("resultat","Inscription réussie");
		else
			mv.addObject("resultat", "Erreur d'inscription");
		
	  	return mv; 
	  }

        // Page de validation de la connexion de l'utilisateur
	@RequestMapping(value="/connexion.htm", method=RequestMethod.POST)
	  protected ModelAndView connexionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
		String login = request.getParameter("login");
		String motdepasse = request.getParameter("motdepasse");
		mv.addObject("titre","Résultat de la connexion");
                
                // Validation de la connexion par le service UserService
		if(userService.connexion(login, motdepasse)){
			HttpSession session=request.getSession(false); 
			User u = userService.getUserDAO().findByName(login);
			session.setAttribute("user",u);
                        mv.addObject("connecte",true);
			mv.addObject("resultat","Connexion réussie <b>"+u.getPrenom()+"</b>");
		}
		else
			mv.addObject("resultat", "Erreur de connexion");
		
	  	return mv; 
	  }	
        
        // Page de déconnexion de l'utilisateur
        @RequestMapping(value="/deconnexion.htm", method=RequestMethod.GET)
	  protected ModelAndView deconnexionProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
		mv.addObject("titre","Résultat de la deconnexion");
                
                // Suppresion de l'attribut user
                HttpSession session=request.getSession(false); 
                session.removeAttribute("user");
                
		mv.addObject("resultat","Deconnexion réussie ");
	  	return mv; 
	  }
        
        // Fonction qui retourne si l'utilisateur est connecté ou pas
        private boolean isConnecte(User userSession){
            if(userSession == null) return false;
            else return true;
        }
}
