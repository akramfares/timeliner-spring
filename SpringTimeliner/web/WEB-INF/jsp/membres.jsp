<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
 <c:import url="/header.htm"></c:import>
    <div id="contenu">
        <h2>Demandes d'ajout</h2>
        <c:forEach items="${demandes_ami}" var="current">
            <!-- Feed Entry -->
            <div class="row">
              <div class="two columns mobile-one">
                  <c:import url="/image.htm?w=80&h=80&user=${current.id}"></c:import>
              </div>
              <div class="ten columns">
                  <p><strong>${current.nom} ${current.prenom}</strong></p>
                <ul class="inline-list">
                  <li><a href="confirmer_ami.htm?ami_id=${current.id}">+ Confirmer</a></li>
                </ul>
              </div>
            </div>
            <!-- End Feed Entry -->

            <hr />
        </c:forEach>
            <h2>Liste d'amis</h2>
        <c:forEach items="${amis}" var="current">
            <!-- Feed Entry -->
            <div class="row">
              <div class="two columns mobile-one">
                  <c:import url="/image.htm?w=80&h=80&user=${current.id}"></c:import>
              </div>
              <div class="ten columns">
                  <p><strong><a href="/SpringTimeliner/profile.htm?user=${current.id}">${current.nom} ${current.prenom}</a></strong></p>
                <ul class="inline-list">
                </ul>
              </div>
            </div>
            <!-- End Feed Entry -->

            <hr />
        </c:forEach>
            
        <h2>Liste des membres</h2>
        <c:forEach items="${users}" var="current">
            <!-- Feed Entry -->
            <div class="row">
              <div class="two columns mobile-one">
                  <c:import url="/image.htm?w=80&h=80&user=${current.id}"></c:import>
              </div>
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
