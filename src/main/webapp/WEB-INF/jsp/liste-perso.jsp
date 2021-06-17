<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/table.css" />
<title>Liste des personnages</title>

<div class="navHeader">
<ul>
  <li><a href="/menu/liste">Home</a></li>
  <li><a href="/personnage/liste">Characters</a></li>
  <li><a href="/equipe/liste">Teams</a></li>
</ul>
</div>

</head>
<body>

	<div class="teamTitle">
		<h1>Characters</h1>
	</div>

	<hr class="mainHr">
	
	

	<div class="addChar">
		
			<a href="ajouter" class="pricing-button is-featured">New
				character</a>

	</div> 
	
	<div class="background">
		<div>
			<div class="panel pricing-table">

				<c:forEach var="personnage" items="${ personnages }">

					<div class="pricing-plan">
						<c:choose>

							<c:when test="${ personnage.race == 'ORC'}">
								<c:if
									test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Knight\")}">
									<img src="/assets/img/chevalier/orcChevalier.gif" alt=""
										class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Priest\")}">
									<img src="/assets/img/pretre/orcPretre.gif" alt="" 
									class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Sorcerer\")}">
									<img src="/assets/img/sorcier/orcSorcier.gif" alt=""
										class="pricing-img">
								</c:if>
							</c:when>
							
							<c:when test="${ personnage.race == 'DWARF' }">
								<c:if
									test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Knight\")}">
									<img src="/assets/img/chevalier/nainChevalier.gif" alt=""
										class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Priest\")}">
									<img src="/assets/img/pretre/nainPretre.gif" alt="" 
									class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Sorcerer\")}">
									<img src="/assets/img/sorcier/nainSorcier.gif" alt=""
										class="pricing-img">
								</c:if>
							</c:when>
							<c:when test="${ personnage.race == 'ELF' }">
								<c:if
									test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Knight\")}">
									<img src="/assets/img/chevalier/elfChevalier.gif" alt=""
										class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Priest\")}">
									<img src="/assets/img/pretre/elfPretre.gif" alt="" 
									class="pricing-img">
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Sorcerer\")}">
									<img src="/assets/img/sorcier/elfSorcier.gif" alt=""
										class="pricing-img">
								</c:if>
							</c:when>
							<c:when test="${ personnage.race == 'HUMAN' }">
									<c:if
									test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Knight\")}">
									<img src="/assets/img/chevalier/humainChevalier.gif" alt=""
										class="pricing-img">
								</c:if>
									<br>
									<br>
									<br>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Priest\")}">
									<img src="/assets/img/pretre/humainPretre.gif" alt="" 
									class="pricing-img">	
										<br>						
								</c:if>
								<c:if test="${personnage.getClass().toString().split(\"\\\.\")[3].equals(\"Sorcerer\")}">
									<img src="/assets/img/sorcier/humainSorcier.gif" alt=""
										class="pricing-img">
								</c:if>
							</c:when>
						</c:choose>
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