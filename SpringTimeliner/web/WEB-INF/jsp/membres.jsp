<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
    <div id="contenu">
        <h2>Liste des membres</h2>
        <c:forEach items="${users}" var="current">
            <!-- Feed Entry -->
            <div class="row">
              <div class="two columns mobile-one"><img src="http://placehold.it/80x80&text=[img]" /></div>
              <div class="ten columns">
                  <p><strong>${current.nom} ${current.prenom}</strong></p>
                <ul class="inline-list">
                  <li><a href="ajouter_ami.htm?ami_id=${current.id}">+ Ajouter à mes amis</a></li>
                </ul>
              </div>
            </div>
            <!-- End Feed Entry -->

            <hr />
        </c:forEach>
    </div>
<c:import url="/footer.htm"></c:import>
