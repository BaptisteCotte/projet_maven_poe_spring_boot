<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/table.css" />
<title>Liste des equipes</title>

</head>
<body>

	<div class="teamTitle">
		<h1>TEAMS</h1>
	</div>


	<hr class="mainHr">

	<div class="addChar">
		<c:if test="${ fn:length(equipes) < 3 }">
			<a href="ajouter" class="pricing-button is-featured">New Team</a>
		</c:if>
	</div>
	<div class="background">
		<div class="container">
			<div class="panel pricing-table">

				<c:forEach var="equipe" items="${ equipes }">

					<div class="pricing-plan">
						<img
							src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png"
							alt="" class="pricing-img">
						<ul class="pricing-features">
							<li class="pricing-features-item">Equipe : ${ equipe.id }</li>
							<li class="pricing-features-item">joueur1 : ${ equipe.per1.name }
								<br> Classe :${ equipe.per1.getClass().toString().split("\\.")[3]}
								<br> Race :${ equipe.per1.race } <br> Level :${ equipe.per1.lvl }
								<br> XP : ${ equipe.per1.xp } <br> HP : ${ equipe.per1.hp }
								<br> Base Dommage : ${ equipe.per1.baseDmg } <br> Etat
								: ${ equipe.per1.state }
							</li>
							<li class="pricing-features-item">joueur2 : ${ equipe.per2.name }
								<br> Classe :${ equipe.per2.getClass().toString().split("\\.")[3]}
								<br> Race :${ equipe.per2.race } <br> Level :${ equipe.per2.lvl }
								<br> XP : ${ equipe.per2.xp } <br> HP : ${ equipe.per2.hp }
								<br> Base Dommage : ${ equipe.per2.baseDmg } <br> Etat
								: ${ equipe.per2.state }
							</li>
							<li class="pricing-features-item">joueur3 : ${ equipe.per3.name }
								<br> Classe :${ equipe.per3.getClass().toString().split("\\.")[3]}
								<br> Race :${ equipe.per3.race } <br> Level :${ equipe.per3.lvl }
								<br> XP : ${ equipe.per3.xp } <br> HP : ${ equipe.per3.hp }
								<br> Base Dommage : ${ equipe.per3.baseDmg } <br> Etat
								: ${ equipe.per3.state }
							</li>
						</ul>

						<span class="pricing-price"></span> <input type="checkbox"
							name="readyForBattle" value="${ equipe.id }"> <label
							for="readyForBattle">Ready for Battle</label> <a
							href="modifier?id=<c:out value="${ equipe.id }" />"
							class="pricing-button is-featured">Edit</a> <a
							href="supprimer?id=${ equipe.id }"
							class="pricing-button is-featured">Delete</a>
					</div>

				</c:forEach>
			</div>
			<div>
				<a href="combat?idEquipe1=<c:out value= "dbRes[0].value"/>&idEquipe2=<c:out value="dbRes[1].value"/>" class="pricing-button is-featured" name="battle"
					id="battle" onclick="count_chkBox()">Battle</a>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function count_chkBox() {
			var dbRes = [];
			var nbre_check = 0;
			var dbEl = document.getElementsByName("readyForBattle");
			for (i = 0; i < dbEl.length; i++) {
				if (dbEl[i].checked) {
					dbRes.push(dbEl[i].value);
					nbre_check++;
				}
			}

			if (nbre_check != 2) {
				alert(dbRes[0] );
				alert(dbRes.length + "Vous devez sélectionner deux équipes");
			} 
		}
	</script>

</body>
</html>