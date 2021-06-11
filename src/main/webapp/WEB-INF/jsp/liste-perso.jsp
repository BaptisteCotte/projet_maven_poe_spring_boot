<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/table.css" />
<title>Liste des personnages</title>

</head>
<body>

	<div class="teamTitle">
		<h1>TEAM</h1>
	</div>

	<hr class="mainHr">

<div class="addChar">
		<c:if test="${ fn:length(personnages) < 1500 }">
			<a href="ajouter" class="pricing-button is-featured">New
				character</a>
		</c:if>

	</div>
	<div class="background">
		<div class="container">
			<div class="panel pricing-table">

				<c:forEach var="personnage" items="${ personnages }">

					<div class="pricing-plan">
						<img
							src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png"
							alt="" class="pricing-img">
						<h2 class="pricing-header">${ personnage.name }</h2>
						<ul class="pricing-features">
							<li class="pricing-features-item">ID : ${ personnage.id }</li>
							<li class="pricing-features-item">Age : ${ personnage.age }</li>
							<li class="pricing-features-item">Race : ${ personnage.race }</li>
							<li class="pricing-features-item">Level : ${ personnage.lvl }</li>
							<li class="pricing-features-item">XP : ${ personnage.xp }</li>
							<li class="pricing-features-item">Current HP : ${ personnage.hp }</li>
							<li class="pricing-features-item">Max HP : ${ personnage.maxHp }</li>
							<li class="pricing-features-item">Base Damage : ${ personnage.baseDmg }</li>
							<li class="pricing-features-item">State : ${ personnage.state }</li>
						</ul>
						<span class="pricing-price"></span> <a
							href="modifier?id=<c:out value="${ personnage.id }" />"
							class="pricing-button is-featured">Edit</a> <a
							href="supprimer?id=${ personnage.id }"
							class="pricing-button is-featured">Delete</a>
					</div>

				</c:forEach>



			</div>
		</div>
	</div>

</body>
</html>