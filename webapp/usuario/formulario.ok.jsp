<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../jsp/header.jsp"%>
		<h3>Cadastrar Usuário:</h3><br /><br />
		<c:forEach var="error" items="${errors.iterator}">
			<p>${error.key}</p>
		</c:forEach>
		<div class="form">
			<form action="usuario.cadastra.logic" method="post">
				<div class="field">
					<label>Email: </label><br />
					<input type="text" name="usuario.email"><br /><br />
				</div>
				<div class="field">
					<label>Senha: </label><br />
					<input type="password" name="usuario.senha"><br /><br />
				</div>
				<div class="formbutton">
					<input type="submit" value="Cadastrar">
				</div>
			</form>
		</div>
		<br />
		
<%@include file="../jsp/footer.jsp"%>