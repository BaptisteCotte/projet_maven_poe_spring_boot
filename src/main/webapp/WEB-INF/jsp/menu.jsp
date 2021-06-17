<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/menu.css" />
<title>Menu</title>

</head>
<body>
<div class="menuMain">
<div class="container">
  <div class="card">
    <div class="header">
      <h3>Menu<i class="fas fa-angle-down iconM"></i></h3>
    </div>
    <div class="body">
      <ul>
        <li><i class="fas fa-home icon"></i> Introduction</li>
        <li><i class="fab fa-wpforms icon"></i> Characters
          <ul>
            <li><i class="fas fa-pencil-alt icon"></i> <a
							href="../personnage/liste"
							class="pricing-button is-featured">Characters List</a></li>
            <li><i class="fas fa-paper-plane icon"></i> <a
							href="../personnage/ajouter"
							class="pricing-button is-featured">Create a new character</a></li>
          </ul>
        </li>
       <li><i class="fab fa-wpforms icon"></i> Teams
          <ul>
            <li><i class="fas fa-pencil-alt icon"></i><a
							href="../equipe/liste"
							class="pricing-button is-featured"> Team list</a></li>
            <li><i class="fas fa-paper-plane icon"></i><a
							href="../equipe/ajouter"
							class="pricing-button is-featured"> Create a new team</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>
</div>
</body>
</html>