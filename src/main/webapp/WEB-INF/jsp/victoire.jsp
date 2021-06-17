<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/table.css" />
<div class="navHeader">
<ul>
  <li><a href="/menu/liste">Home</a></li>
  <li><a href="/personnage/liste">Characters</a></li>
  <li><a href="/equipe/liste">Teams</a></li>
</ul>
</div>

</head>
<body>
	
	
	
	<div class="background">
		<div class="container">
			<div class="panel pricing-table">
				<div class="pricing-plan">	
				<img src="/assets/img/victory.png" alt=""
										class="pricing-img victory">
				<h1>Victory !</h1>
	<p>Winner team : </p>
	<ul class="pricing-features">
		<li class="pricing-features-item">Team : ${ equipe.id }</li>
		<li class="pricing-features-item">Player 1 : ${ equipe.per1.name }
			<br> Class :${ equipe.per1.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per1.race } <br> Level :${ equipe.per1.lvl }
			<br> XP : ${ equipe.per1.xp } <br> HP : ${ equipe.per1.hp }
			<br> Base Damage : ${ equipe.per1.baseDmg } <br> State : ${ equipe.per1.state }
		</li>
		<li class="pricing-features-item">Player 2 : ${ equipe.per2.name }
			<br> Class :${ equipe.per2.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per2.race } <br> Level :${ equipe.per2.lvl }
			<br> XP : ${ equipe.per2.xp } <br> HP : ${ equipe.per2.hp }
			<br> Base Damage : ${ equipe.per2.baseDmg } <br> State : ${ equipe.per2.state }
		</li>
		<li class="pricing-features-item">Player 3 : ${ equipe.per3.name }
			<br> Class :${ equipe.per3.getClass().toString().split("\\.")[3]}
			<br> Race :${ equipe.per3.race } <br> Level :${ equipe.per3.lvl }
			<br> XP : ${ equipe.per3.xp } <br> HP : ${ equipe.per3.hp }
			<br> Base Damage : ${ equipe.per3.baseDmg } <br> State : ${ equipe.per3.state }
		</li>
	</ul>
	</div>
	</div>
	</div>
	</div>
</body>
</html>