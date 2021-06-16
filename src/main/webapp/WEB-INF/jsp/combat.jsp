<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/table.css" />
<title>Combat</title>

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
						<li class="pricing-features-item">Equipe : 1</li>
						<li class="pricing-features-item">joueur1 : ${ equipe1.per1.name }
							<br> Classe :${ equipe1.per1.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per1.race } <br> Level :${ equipe1.per1.lvl }
							<br> XP : ${ equipe1.per1.xp } <br> HP : ${ equipe1.per1.hp }
							<br> Base Dommage : ${ equipe1.per1.baseDmg } <br> Etat
							: ${ equipe1.per1.state }
						</li>
						<li class="pricing-features-item">joueur2 : ${ equipe1.per2.name }
							<br> Classe :${ equipe1.per2.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per2.race } <br> Level :${ equipe1.per2.lvl }
							<br> XP : ${ equipe1.per2.xp } <br> HP : ${ equipe1.per2.hp }
							<br> Base Dommage : ${ equipe1.per2.baseDmg } <br> Etat
							: ${ equipe1.per2.state }
						</li>
						<li class="pricing-features-item">joueur3 : ${ equipe1.per3.name }
							<br> Classe :${ equipe1.per3.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe1.per3.race } <br> Level :${ equipe1.per3.lvl }
							<br> XP : ${ equipe1.per3.xp } <br> HP : ${ equipe1.per3.hp }
							<br> Base Dommage : ${ equipe1.per3.baseDmg } <br> Etat
							: ${ equipe1.per3.state }
						</li>
					</ul>
				</div>
				<div class="pricing-plan">
					<ul class="pricing-features">
						<p id="texte"> ${ texte } </p>
						<li class="pricing-features-item"><input type="radio"
							name="action" value="attack" checked> <label for="attack">Attack</label>
							<input type="radio" name="action" value="heal">
							<label for="heal">Heal</label></li>
						<label>Personnage </label>
						<input type="text" name="personnage"
							pattern="^[A-Z]+[\-]{0,1}([a-z]{1,}[\-]{0,1}){0,}[a-z]$" required>
						<p>
							Doit etre nommé ainsi : e1p1 <br> e1=>équipe1 <br>p1=>personnage1
						</p>

						<li class="pricing-features-item">
							<button class="favorite styled" type="button"
								onclick="count_chkBox()">Validate</button>
						</li>
					</ul>


				</div>
				<div class="pricing-plan">
					<img
						src="https://www.pngkey.com/png/detail/6-61715_knight-drawing-helmet-iron-man-armour-knight-drawing.png"
						alt="" class="pricing-img">
					<ul class="pricing-features">
						<li class="pricing-features-item">Equipe : 2</li>
						<li class="pricing-features-item">joueur1 : ${ equipe2.per1.name }
							<br> Classe :${ equipe2.per1.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per1.race } <br> Level :${ equipe2.per1.lvl }
							<br> XP : ${ equipe2.per1.xp } <br> HP : ${ equipe2.per1.hp }
							<br> Base Dommage : ${ equipe2.per1.baseDmg } <br> Etat
							: ${ equipe2.per1.state }
						</li>
						<li class="pricing-features-item">joueur2 : ${ equipe2.per2.name }
							<br> Classe :${ equipe2.per2.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per2.race } <br> Level :${ equipe2.per2.lvl }
							<br> XP : ${ equipe2.per2.xp } <br> HP : ${ equipe2.per2.hp }
							<br> Base Dommage : ${ equipe2.per2.baseDmg } <br> Etat
							: ${ equipe2.per2.state }
						</li>
						<li class="pricing-features-item">joueur3 : ${ equipe2.per3.name }
							<br> Classe :${ equipe2.per3.getClass().toString().split("\\.")[3]}
							<br> Race :${ equipe2.per3.race } <br> Level :${ equipe2.per3.lvl }
							<br> XP : ${ equipe2.per3.xp } <br> HP : ${ equipe2.per3.hp }
							<br> Base Dommage : ${ equipe2.per3.baseDmg } <br> Etat
							: ${ equipe2.per3.state }
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>