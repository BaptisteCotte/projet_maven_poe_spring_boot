<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Victoire</h1>
	<p>L'équipe victorieuse est l'équipe :</p>
	<ul class="pricing-features">
		<li class="pricing-features-item">Equipe : ${ equipe.id }</li>
		<li class="pricing-features-item">joueur1 : ${ equipe.per1.name }
			<br> Classe :${ equipe.per1.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per1.race } <br> Level :${ equipe.per1.lvl }
			<br> XP : ${ equipe.per1.xp } <br> HP : ${ equipe.per1.hp }
			<br> Base Dommage : ${ equipe.per1.baseDmg } <br> Etat : ${ equipe.per1.state }
		</li>
		<li class="pricing-features-item">joueur2 : ${ equipe.per2.name }
			<br> Classe :${ equipe.per2.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per2.race } <br> Level :${ equipe.per2.lvl }
			<br> XP : ${ equipe.per2.xp } <br> HP : ${ equipe.per2.hp }
			<br> Base Dommage : ${ equipe.per2.baseDmg } <br> Etat : ${ equipe.per2.state }
		</li>
		<li class="pricing-features-item">joueur3 : ${ equipe.per3.name }
			<br> Classe :${ equipe.per3.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per3.race } <br> Level :${ equipe.per3.lvl }
			<br> XP : ${ equipe.per3.xp } <br> HP : ${ equipe.per3.hp }
			<br> Base Dommage : ${ equipe.per3.baseDmg } <br> Etat : ${ equipe.per3.state }
		</li>
	</ul>
</body>
</html>