<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../jsp/header.jsp"%>
		<h3>Login:</h3>
		<br />
		<c:if test="${not empty param['usuario.email']}">
			<p>Login/Senha inválido</p>
		</c:if>
		<div class="form">
			<form action="usuario.logar.logic" method="post">
				<div class="field">
					<label>Email: </label><br />
					<input type="text" name="usuario.email"><br /><br />
				</div>
				<div class="field">
					<label>Senha: </label><br />
					<input type="password" name="usuario.senha"><br /><br />
				</div>
				<div class="formbutton">
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
		<br />
		
<%@include file="../jsp/footer.jsp"%>
