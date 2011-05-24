<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Minhas Tarefas</title>
		<style type="text/css">
			<%@ include file="../stylesheets/styles.css" %>
		</style>
	</head>
	<body>
		<div id="wrap">
			<div class="header">
				<div class="title">
				<h1>Minhas Tarefas</h1>
			</div>
			<div class="nav">
				<ul>
					<c:if test="${logado}">
						<li><a href="tarefa.index.logic">Tarefas</a></li>
						<li><a href="usuario.logout.logic">Sair</a></li>
					</c:if>
					
					<c:if test="${not logado}">
						<li><a href="/tarefas">Home</a></li>
						<li><a href="usuario.formulario.logic">Cadastrar</a></li>
						<li><a href="usuario.login.logic">Login</a></li>
					</c:if>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="pagewrapper">
			<div class="innerpagewrapper">
				<div class="page">
					<div class="content">