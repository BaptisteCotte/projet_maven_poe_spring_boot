<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
<link href="/assets/css/styleForm.css" rel="stylesheet" type="text/css">

<div class="navHeader">
<ul>
  <li><a href="/menu/liste">Home</a></li>
  <li><a href="/personnage/liste">Personnages</a></li>
  <li><a href="/equipe/liste">Equipes</a></li>
</ul>
</div>
</head>
<body>
	<div class="container">
		<div class="leftbox"></div>

		<div class="rightbox">
			<form method="POST">
				<input type="hidden" name="${ _csrf.parameterName }"
					value="${ _csrf.token }" /> 
				<div class="profile">
					<h1>Edit Character</h1>
					</br> <label>Name</label> </br> <input type="text" name="name"
						value="${ personnage.name }"
						pattern="^[A-Z]+[\-]{0,1}([a-z]{1,}[\-]{0,1}){0,}[a-z]$" required />

					<p>	
						Character's name must begin with a low case. It might contain some hyphens but can't contain any digits, nor white spaces.
						
						</p>


					<div>
						</br> </br> <label>Age</label> </br> <input type="text" name="age"
							value="${ personnage.age }" pattern="^[\d]{0,}$" required />
						<p>
					
						Character's age can't be negative.
						</p>
					</div>

					<div>

						</br> </br>



						<button class="btn" type="submit" value="Edit">Submit</button>
					</div>




				</div>
			</form>
		</div>
	</div>
</body>
</html>