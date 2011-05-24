<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../jsp/header.jsp"%>
	<div id="formulario">
		<h3>Editar Tarefa</h3>
		<form action="tarefa.atualiza.logic" method="post">
			<input type="hidden" name="tarefa.id" value="${tarefa.id}">
			<input type="hidden" name="tarefa.usuario.id" value="${tarefa.usuario.id}">
			<div class="field">
				<label>Nome: </label><br />
				<input type="text" name="tarefa.nome" value="${tarefa.nome}"><br /><br />
			</div>
			<div class="field">
				<label>Status: </label><br />
				<select name="tarefa.status">
					<option value="${tarefa.status}" selected="true">${tarefa.status}</option>
					<option value="PENDENTE">PENDENTE</option>
					<option value="ANDAMENTO">EM ANDAMENTO</option>
					<option value="CONCLUIDA">CONCLUIDA</option>
				</select> <br /><br />
			</div>
			<div class="field">
				<label>Descrição: </label><br />
				<textarea name="tarefa.descricao" rows="7" cols="30">${tarefa.descricao}</textarea>
			</div>
			<div class="formbutton">
				<input type="submit" value="Atualizar">
			</div>
		</form>
	</div>			

<%@include file="../jsp/footer.jsp"%>