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
import services.StatusService;

/**
 *
 * @author afares01
 */
@Controller
public class StatusController {
	@Autowired
	private StatusService status;	
	
	@RequestMapping(value="/mur.htm", method=RequestMethod.GET)
	  protected ModelAndView formAjouterProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
                HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
            
		ModelAndView mv = new ModelAndView("mur");
                mv.addObject("connecte",isConnecte(request));
		mv.addObject("titre","Ajouter une personne");
		mv.addObject("action","ajouter_status");
                mv.addObject("list_status",status.getMur(userSession));
	  	return mv; 
	  }
	
	@RequestMapping(value="/ajouter_status.htm", method=RequestMethod.POST)
	  protected ModelAndView ajouterProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
                mv.addObject("connecte",isConnecte(request));
		String contenu = request.getParameter("contenu");
		HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
		mv.addObject("titre","Résultat de l'ajout du status");
                
		if(status.ajouter(contenu,userSession))
			mv.addObject("resultat","Status ajouté avec succès");
		else
			mv.addObject("resultat", "Erreur dans le formulaire");
		
	  	return mv; 
	  }
        
        private boolean isConnecte(HttpServletRequest request){
            HttpSession session=request.getSession(false); 
	    User userSession = (User) session.getAttribute("user");
            if(userSession == null) return false;
            else return true;
        }

}
