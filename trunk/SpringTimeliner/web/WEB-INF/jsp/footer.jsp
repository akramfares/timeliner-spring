<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
</div>


    <!-- Nav Sidebar -->
    <!-- This is source ordered to be pulled to the left on larger screens -->
    <div class="three columns pull-six" style="right:70%">
      <div class="panel">
          <c:choose>
                <c:when test="${connecte}">
                    <a href="/SpringTimeliner/photoprofile.htm">
                        <c:import url="/image.htm?w=300&h=240&user=${userConnecte.id}"></c:import>
                    </a>
                  <h5><a href="#">${userConnecte.nom} ${userConnecte.prenom}</a></h5>
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
          

        <dl class="vertical tabs">
          <dd><a href="#">Section 1</a></dd>
          <dd><a href="#">Section 2</a></dd>
          <dd><a href="#">Section 3</a></dd>
          <dd><a href="#">Section 4</a></dd>
          <dd><a href="#">Section 5</a></dd>
          <dd><a href="#">Section 6</a></dd>
        </dl>

      </div>
    </div>


    <!-- Right Sidebar -->



  <!-- Footer -->

  <footer class="row">
    <div class="twelve columns">
      <hr />
      <div class="row">
        <div class="six columns">
          <p>&copy; Copyright no one at all. Go to town.</p>
        </div>
        <div class="six columns">
          <ul class="inline-list right">
            <li><a href="#">Section 1</a></li>
            <li><a href="#">Section 2</a></li>
            <li><a href="#">Section 3</a></li>
            <li><a href="#">Section 4</a></li>
            <li><a href="#">Section 5</a></li>
            <li><a href="#">Section 6</a></li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- Included JS Files -->
  <script src="/SpringTimeliner/js/templates.js"></script>