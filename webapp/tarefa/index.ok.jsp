<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../jsp/header.jsp"%>
		<div id="tarefas">
			<p>
			<table>
				<tr>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Status</th>
					<th></th>
					<th></th>
				</tr>
				
				<c:forEach var="tarefa" items="${tarefas}">
					<tr>
						<td>${tarefa.nome}</td>
						<td>${tarefa.descricao}</td>
						<td>${tarefa.status}</td>
						<td><a href="tarefa.remove.logic?tarefa.id=${tarefa.id}">remover</a></td>
						<td><a href="tarefa.edita.logic?tarefa.id=${tarefa.id}">editar</a></td>
					</tr>
				</c:forEach>
			</table>
			</p>
		</div>
		<div class="form" id="formulario_tarefa">
			<a href="javascript:void(0);" onclick="$('#formulario_tarefa').children().toggle();">
				Nova Tarefa
			</a>
			<div id="formulario" style="display:none;">
				<h3>Cadastrar Tarefa</h3>
				<form action="tarefa.salva.logic" method="post">
					<div class="field">
						<label>Nome: </label><br />
						<input type="text" name="tarefa.nome"><br /><br />
					</div>
					<div class="field">
						<label>Status: </label><br />
						<select name="tarefa.status">
							<option value="PENDENTE" selected="true">PENDENTE</option>
							<option value="ANDAMENTO">EM ANDAMENTO</option>
							<option value="CONCLUIDA">CONCLUIDA</option>
						</select> <br /><br />
					</div>
					<div class="field">
						<label>Descrição: </label><br />
						<textarea name="tarefa.descricao" rows="7" cols="30"></textarea>
						<br /><br />
					</div>
					<div class="formbutton">
						<input type="submit" value="Cadastrar">
						<a href="javascript:void(0);" onclick="$('#formulario_tarefa').children().toggle();">
							Cancelar
						</a>
					</div>
				</form>
			</div>			
		</div>
		<br />
		

<%@include file="../jsp/footer.jsp"%>
<script src="javascript/jquery-1.6.1.min.js"></script>