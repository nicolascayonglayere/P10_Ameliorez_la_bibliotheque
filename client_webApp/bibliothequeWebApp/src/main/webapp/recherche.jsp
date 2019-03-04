<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="_head.jsp" %>
		<title>Recherche d'ouvrages</title>
	</head>

	<body>
		<%@include file="_navigation.jsp" %>
		<div id=blocPge>
			<div class = "container">
	  			<!-- un formulaire de recherche de livre a partir de auteur, genre, titre -->	
				<h2 id="titre"><s:text name="index.recherche"/></h2>
				<h3><s:text name="index.explication"></s:text></h3>
				<s:form action="rechMulti" cssClass="form-vertical" namespace="/" validate="true">
					<s:textfield name="titre" placeholder="titre" label="%{getText('form.titre')}" requiredLabel="true"/>
					<s:textfield name="nomAuteur" placeholder="nomAuteur" label="%{getText('form.auteur')}" requiredLabel="true"/>
					<s:select name="selectedGenre" label="%{getText('livre.genre')}" list="listGenre" size="1" />
					<s:submit class="btn btn-default" value="%{getText('bouton.valider')}">
						<!--<s:param name="nom" value="topo.nomTopo"/>-->
					</s:submit>					
				</s:form>	
				
				<s:actionmessage/>
				<s:if test="listResultat">
					<s:iterator value="listResultat" var="livreType">
						<s:a action="go_livre" namespace="/">				
							<p id="listLivreType">
								<li><s:property value="#livreType.titre"/> <s:property value="#livreType.auteurs.nom"/> <s:property value="#livreType.genre"/></li>	
								<s:param name="idLivre" value="#livreType.id" />										
							</p>
						</s:a>
					</s:iterator>
				</s:if>		
			</div>
		</div>	
		<%@include file="_footer.jsp" %>	
	</body>
</html>