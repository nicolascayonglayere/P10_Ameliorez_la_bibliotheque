<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="_head.jsp" %>
		<title>Login</title>
	</head>

	<body>
		<%@include file="_navigation.jsp" %>
		<div id=blocPge>
			<s:actionmessage/>
			<div class="container">
				<h1 id="titre"><s:text name="login.titre"/></h1>
				<s:actionerror/>
				<!-- un if test de la session pour eviter la connexion alors qu'on est deja connecte -->
				<s:if test="#session.utilisateur==null">
					<s:form id="idLoginForm" action="loginUser" cssClass="form-vertical" namespace="/" validate="true">
						<s:textfield name="pseudo" placeholder="pseudo" label="%{getText('form.pseudo')}" requiredLabel="true"/>
						<s:password name="motDePasse" placeholder="mot de passe" label="%{getText('form.mdp')}" requiredLabel="true"/>
						<s:submit id="btOK" class="btn btn-default" value="%{getText('login.titre')}">	
		       				<s:param name="pseudo">${pseudo }</s:param>
		      				<s:param name="motDePasse">${motDePasse }</s:param>
		     			 </s:submit>
		     			 <s:token/>		
					</s:form>	
				</s:if>
				<s:else>
					<h2 id="titre"><s:text name="login.message"/></h2>
				</s:else>
				<!-- Lien pour créer un utilisateur -->
				<!--<s:text name="login.inscription"/>
				<s:url var="goInscription" action="inscription" namespace="/"/>
				<s:a href="%{goInscription}">
					<s:text name="creerUser.titre"/>
				</s:a>-->		
			</div>
		</div>	
		<%@include file="_footer.jsp" %>	
	</body>
</html>