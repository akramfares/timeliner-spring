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
			<form method='post' action='/SpringTimeliner/ajouter_status_profile.htm?user=${user.id}' name='formulaire'  enctype="multipart/form-data">
				
                                    <p>Exprimez-vous :<textarea name='contenu'></textarea></p>
                                    <p>Pièce jointe : <input type='file' name='piece'/></p>
                                <input type='submit' value='Envoyer'/>
                        </form>	
                        
                           <script type='text/javascript' src='https://cdn.firebase.com/v0/firebase.js'></script>
                            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
                            <c:forEach items="${list_status}" var="current">
                               <!-- Feed Entry -->
                                <div class="row">
                                  <div class="two columns mobile-one">
                                      <c:import url="/image.htm?w=80&h=80&user=${current.proprio.id}"></c:import>
                                  </div>
                                  <div class="ten columns">
                                    <p><strong>${current.proprio.nom} ${current.proprio.prenom} said :</strong> 
                                        <c:choose>
                                            <c:when test="${not empty current.piecejointe}">
                                            <p><img src="/SpringTimeliner/uploads/status/${current.piecejointe}" width="300"/></p>
                                            </c:when>

                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                        ${current.contenu}
                                    </p>
                                    <ul class="inline-list">
                                      <!-- J'aime & Commentaires-->
                                      <script type='text/javascript'>
                                          var data${current.id} = new Firebase('https://timeliner.firebaseio.com/id/${current.id}');
                                          var n${current.id};
                                          // Ne pas faire attention aux erreurs
                                          data${current.id}.on('value', function(snapshot) {

                                            if(snapshot.val()) {
                                               $('#status_${current.id}').text(snapshot.val().nbr);
                                               n${current.id} = snapshot.val().nbr;
                                            }
                                            else{
                                                $('#status_${current.id}').text('0');
                                               n${current.id} = 0;
                                            }
                                                
                                          });
                                          
                                          function jaime${current.id}(){
                                              $('#status_${current.id}').text(n${current.id}++);
                                              data${current.id}.set({nbr : n${current.id}++});
                                          }
                                      </script>
                                      <li><a href="javascript:jaime${current.id}();">[<span id="status_${current.id}"></span>] J'aime</a></li>
                                      <!-- End J'aime & Commentaires-->
                                    </ul>
                                  </div>
                                </div>
                                <!-- End Feed Entry -->

                                <hr />
                            </c:forEach>                               
			</div>
		
 <c:import url="/footer.htm"></c:import>