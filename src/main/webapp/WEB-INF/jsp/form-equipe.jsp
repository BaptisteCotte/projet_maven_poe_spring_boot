<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team</title>
<link href="/assets/css/styleForm.css" rel="stylesheet" type="text/css">
<div class="navHeader">
<ul>
  <li><a href="/menu/liste">Home</a></li>
  <li><a href="/personnage/liste">Personnages</a></li>
  <li><a href="/equipe/liste">Equipes</a></li>
</ul>
</div>

</head>


<!-- Tab content -->
<div id="ajouter" class="container">
	<div class="leftbox"></div>

	<div class="rightbox">
		<form method="POST" modelAttribute="equipe">
			<input type="hidden" name="${ _csrf.parameterName }"
					value="${ _csrf.token }" /> 
			<div class="profile">
				<h1>Add Team</h1>
				<div>
					<label>Character 1 : </label> <select name="personnageR1">
						<c:forEach var="personnage" items="${ personnages }">

							<option selected value="${ personnage.id }">${ personnage.id }
								${ personnage.name } ${ personnage.getClass().toString().split("\\.")[3]}
								${personnage.lvl }</option>
						</c:forEach>
					</select>
				</div>
				<br>
				<div>
					<label>Character 2 : </label> <select name="personnageR2">
						<c:forEach var="personnage" items="${ personnages }">
							<option selected value="${ personnage.id }">${ personnage.id }
								${ personnage.name } ${ personnage.getClass().toString().split("\\.")[3]}
								${personnage.lvl }</option>
						</c:forEach>
					</select>
				</div>
				<br>
				<div>
					<label>Character 3 : </label> <select name="personnageR3">
						<c:forEach var="personnage" items="${ personnages }">
							<option selected value="${ personnage.id }">${ personnage.id }
								${ personnage.name } ${ personnage.getClass().toString().split("\\.")[3]}
								${personnage.lvl }</option>
						</c:forEach>
					</select>
				</div>
				<br>

				<div>
					<br> <br>
					<button class="btn" type="submit" value="Edit">Submit</button>
				</div>
		</form>
	</div>
</div>
</body>
</html>