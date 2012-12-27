<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
			
    <div id="contenu">
            <h1>Inscription</h1>
            <form method='post' action='/SpringTimeliner/inscription.htm' name='formulaire1'>
                    <p>Nom : <input type='text' name='nom'/></p>
                    <p>Prénom : <input type='text' name='prenom'/></p>
                    <p>Sexe : <select name='sexe'>
                    <option value="m">Masculin</option>
                    <option value="f">Féminin</option>
                                </select>
                    <p>Email : <input type='text' name='login'/></p>
                    <p>Mot de passe : <input type='password' name='motdepasse'/></p>
                    <p>Adresse : <textarea name='adresse'></textarea></p>
                    <input type='submit' value='Envoyer'/>
            </form>
            <h1>Connexion</h1>
            <form method='post' action='/SpringTimeliner/connexion.htm' name='formulaire2'>
                    <p>Email : <input type='text' name='login'/></p>
                    <p>Mot de passe : <input type='password' name='motdepasse'/></p>
                    <input type='submit' value='Envoyer'/>
            </form>
    </div>
		
 <c:import url="/footer.htm"></c:import>
