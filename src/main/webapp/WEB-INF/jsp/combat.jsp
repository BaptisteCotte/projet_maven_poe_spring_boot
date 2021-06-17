<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/table.css" />
<title>Combat</title>

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
		<h1>Battle</h1>
	</div>
	<hr class="mainHr">

	<div class="background">
		<div class="container">
			<div class="panel pricing-table">
				<div class="pricing-plan">
					<img
						src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png"
						alt="" class="pricing-img">
					<ul class="pricing-features">
						<li class="pricing-features-item">Team 1</li>
						<li class="pricing-features-item">Player 1 : ${ equipe1.per1.name }
							<br> Class :${ equipe1.per1.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per1.race } <br> Level :${ equipe1.per1.lvl }
							<br> XP : ${ equipe1.per1.xp } <br> HP : ${ equipe1.per1.hp }
							<br> Base Damage : ${ equipe1.per1.baseDmg } <br> State
							: ${ equipe1.per1.state }
						</li>
						<li class="pricing-features-item">Player 2 : ${ equipe1.per2.name }
							<br> Class :${ equipe1.per2.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per2.race } <br> Level :${ equipe1.per2.lvl }
							<br> XP : ${ equipe1.per2.xp } <br> HP : ${ equipe1.per2.hp }
							<br> Base Damage : ${ equipe1.per2.baseDmg } <br> State
							: ${ equipe1.per2.state }
						</li>
						<li class="pricing-features-item">Player 3 : ${ equipe1.per3.name }
							<br> Class :${ equipe1.per3.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per3.race } <br> Level :${ equipe1.per3.lvl }
							<br> XP : ${ equipe1.per3.xp } <br> HP : ${ equipe1.per3.hp }
							<br> Base Damage : ${ equipe1.per3.baseDmg } <br> State
							: ${ equipe1.per3.state }
						</li>
					</ul>
				</div>
				
				<div class="pricing-plan">
					<p>Tour de : ${ player.name }</p>
					<img src="https://static.vecteezy.com/ti/vecteur-libre/p1/153380-bataille-de-cavalerie-et-d-infanterie-gratuit-vectoriel.jpg">
					<ul class="pricing-features">
						<p id="texte"> ${ texte } </p>
						<form method="POST">
						<input type="hidden" name="${ _csrf.parameterName }"value="${ _csrf.token }" />
						<input type="hidden" name="playerId"value="${ player.id }" />
						<li class="pricing-features-item"><input type="radio"
							name="action" value="attack" checked> 
							<label for="attack">Attack</label>
							<c:if test="${ isHealer }">
								<input type="radio" name="action" value="heal">
								<label for="heal">Heal</label></li>
							</c:if>
						<label>Personnage </label>
						<input type="text" name="cible" patern="^e[1,2]p[1,2,3]$" required>
						<p>
							Doit etre nommé ainsi : e1p1 <br> e1=>équipe1 <br>p1=>personnage1
						</p>

						<li class="pricing-features-item">
							<button class="favorite styled pricing-button is-featured" type="submit" value="combat">Confirm</button>
						</li>
						</form>
					</ul>
				</div>
				
				<div class="pricing-plan">
					<img
						src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png"
						alt="" class="pricing-img">
					<ul class="pricing-features">
						<li class="pricing-features-item">Team 2</li>
						<li class="pricing-features-item">Player 1 : ${ equipe2.per1.name }
							<br> Class :${ equipe2.per1.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per1.race } <br> Level :${ equipe2.per1.lvl }
							<br> XP : ${ equipe2.per1.xp } <br> HP : ${ equipe2.per1.hp }
							<br> Base Damage : ${ equipe2.per1.baseDmg } <br> State
							: ${ equipe2.per1.state }
						</li>
						<li class="pricing-features-item">Player 2 : ${ equipe2.per2.name }
							<br> Class :${ equipe2.per2.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per2.race } <br> Level :${ equipe2.per2.lvl }
							<br> XP : ${ equipe2.per2.xp } <br> HP : ${ equipe2.per2.hp }
							<br> Base Damage : ${ equipe2.per2.baseDmg } <br> State
							: ${ equipe2.per2.state }
						</li>
						<li class="pricing-features-item">Player 3 : ${ equipe2.per3.name }
							<br> Class :${ equipe2.per3.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per3.race } <br> Level :${ equipe2.per3.lvl }
							<br> XP : ${ equipe2.per3.xp } <br> HP : ${ equipe2.per3.hp }
							<br> Base Damage : ${ equipe2.per3.baseDmg } <br> State
							: ${ equipe2.per3.state }
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
