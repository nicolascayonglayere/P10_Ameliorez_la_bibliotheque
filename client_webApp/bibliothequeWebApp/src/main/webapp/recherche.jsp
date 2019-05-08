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
				<h2 id="titre"><!--<s:text name="index.recherche"/>-->RECHERCHE D'UN OUVRAGE</h2>
				<h3><!--<s:text name="index.explication"></s:text>-->Saisissez le titre et l'auteur du livre ainsi que son genre</h3>
				<s:form action="rechMulti" cssClass="form-vertical" namespace="/" validate="true">
					<s:textfield name="titre" placeholder="titre" label="Titre" requiredLabel="true"/>
					<s:textfield name="nomAuteur" placeholder="nomAuteur" label="Nom de l'auteur" requiredLabel="true"/>
					<s:select name="selectedGenre" label="GENRE" list="listGenre" size="1" />
					<s:submit class="btn btn-default" value="VALIDER">
						<!--<s:param name="nom" value="topo.nomTopo"/>-->
					</s:submit>					
				</s:form>	
				
				<s:actionmessage/>
				
				<!-- Ajouter un cadre résultat disponible -->
				<s:if test="listResultatDispo">
					<s:iterator value="listResultatDispo" var="livreType">
						<s:a action="go_livre" namespace="/">				
							<p id="listLivreType">
								<li><s:property value="#livreType.titre"/> <s:property value="#livreType.auteurs.nom"/> <s:property value="#livreType.genre"/></li>	
								<s:param name="idLivre" value="#livreType.id" />										
							</p>
						</s:a>
					</s:iterator>
				</s:if>		
				
				<!-- Ajouter un cadre résultat reserve -->
				<s:if test="listResultatResa">
					<s:iterator value="listResultatResa">
						<s:a action="go_livre" namespace="/">				
							<p id="listLivreType">
								<li><s:property value="key.titre"/> <s:property value="key.auteur.nom"/> <s:property value="key.genre"/></li>	
								<s:param name="idLivre" value="key.id" />										
							</p>
							<s:iterator value = "value">
								<div>
									<!--<s:text name="compteUser.empruntPossible"/>-->Date de disponibilite de l'ouvrage :  <s:property value="key"/> <!--  "#livreEmpruntType.dateEmprunt"/>-->
									<!--<s:text name="compteUser.rangReservation"/>-->Position sur la liste d'attente : <s:property value="value"/> <!--  "%{listDate.get(stat.index)}"/>-->
								</div>							
							</s:iterator>
						</s:a>
					</s:iterator>
				</s:if>				
				
			</div>
		</div>	
		<%@include file="_footer.jsp" %>	
	</body>
</html>