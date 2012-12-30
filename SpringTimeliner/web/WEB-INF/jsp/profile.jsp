<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
			<div id="contenu">
                            <!-- Feed Entry -->
                            <div class="row">
                              <div class="two columns mobile-one">
                                  <c:import url="/image.htm?w=100&h=100&user=${user.id}"></c:import>
                              </div>
                              <div class="ten columns">
                                <p><strong>${user.nom} ${user.prenom}</strong></p>
                                <p><strong>Né le </strong>${user.datenaissance}</p>
                                <p><strong>Habite à</strong> ${user.adresse}</p>
                                
                              </div>
                            </div>
                            <!-- End Feed Entry -->
                            <br>
			<form method='post' action='/SpringTimeliner/ajouter_status_profile.htm?user=${user.id}' name='formulaire'>
				
                                    <p>Exprimez-vous :<textarea name='contenu'></textarea></p>
                                <input type='submit' value='Envoyer'/>
                        </form>	
                        
                            <c:forEach items="${list_status}" var="current">
                               <!-- Feed Entry -->
                                <div class="row">
                                  <div class="two columns mobile-one">
                                      <c:import url="/image.htm?w=80&h=80&user=${current.proprio.id}"></c:import>
                                  </div>
                                  <div class="ten columns">
                                    <p><strong>${current.proprio.nom} ${current.proprio.prenom} said :</strong> ${current.contenu}</p>
                                    <ul class="inline-list">
                                      <li><a href="">Reply</a></li>
                                      <li><a href="">Share</a></li>
                                    </ul>
                                  </div>
                                </div>
                                <!-- End Feed Entry -->

                                <hr />
                            </c:forEach>                          
			</div>
		
 <c:import url="/footer.htm"></c:import>