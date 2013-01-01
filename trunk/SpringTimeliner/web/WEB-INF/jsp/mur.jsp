<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
			<div id="contenu">
			<form method='post' action='/SpringTimeliner/${action}.htm' name='formulaire' enctype="multipart/form-data">
				
                                    <p>Quoi de neuf ? <textarea name='contenu'></textarea></p>
                                    <p>Pièce jointe : <input type='file' name='piece'/></p>
                                <input type='submit' value='Envoyer'/>
                        </form>	
                        
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