<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/assets/css/login.css" />
<title>Connexion</title>

</head>
<body>

		<c:if test="${ param.erreur == true }">
			<div class="alert">
				Username or password is incorrect
			</div>
		</c:if>
	<div class="container" id="container">
	
		<div class="form-container sign-in-container">
			<form method="POST" action="perform_login">
				<input type="hidden" name="${ _csrf.parameterName }"
					value="${ _csrf.token }" /> 
					
					<h3>Connect your account</h3>
					
					<input type="text"
					placeholder="Username" name="username" required /> <input
					type="password" placeholder="Password" name="password" required />
				<button class="signInButton" type="submit">Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">

					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">

					<img
						src="https://static.vecteezy.com/ti/vecteur-libre/p1/153380-bataille-de-cavalerie-et-d-infanterie-gratuit-vectoriel.jpg">
				</div>
			</div>
		</div>
	</div>


</body>
</html>