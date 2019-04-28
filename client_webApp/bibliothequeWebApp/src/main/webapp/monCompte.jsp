<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="_head.jsp" %>
		<title>Mon compte</title>
	</head>
	
	<body>
		<%@include file="_navigation.jsp" %>
		<div id=blocPge>
			<div class="container">
				<div class="col-lg-9" id="titreCompteUser">
					<h1 id="titre"><!--<s:text name="compteUser.titre"/>-->Compte utilisateur de <s:property value="utilisateur.pseudo"/></h1>
					<h3 id="titre"><!--<s:text name="compteUser.bonjour"/>-->Bonjour <s:property value="utilisateur.nom"/> <s:property value="utilisateur.prenom"/></h3>
					<s:form action="rappel_option" namespace="/utilisateur">
						<h2>
							<s:checkbox name="rappelOption" value="utilisateur.rappelOption" label="RAPPEL "/>
						</h2> 
						<s:submit value="ENVOYER LES MODIFICATIONS" class="btn btn-default" />
					</s:form>
					
					<s:actionmessage/>
				</div>				
			</div>

			<div class="col-lg-9">	
				<h4 id="titre"><!--<s:text name="compteUser.emprunt"/>-->Vos livres empruntes</h4>
				
				<!-- un tab recapitulatif des enmprunts en cours-->
				<s:iterator value="listEmprunt"> <!--   var="livreEmpruntType" status="stat">-->
					<ul>
						<li id="empruntLivre">
							<div><s:property value="key.ouvrage.titre"/> <!--  "#livreEmpruntType.ouvrage.titre"/>--> </div>
							<div>
								<!--<s:text name="compteUser.dateEmprunt"/>-->Date d'emprunt : <s:property value="key.dateEmprunt"/> <!--  "#livreEmpruntType.dateEmprunt"/>-->
								<!--<s:text name="compteUser.dateRetour"/>-->Date de retour limite : <s:property value="value"/> <!--  "%{listDate.get(stat.index)}"/>-->
							</div>
							<!-- un bouton pour le retour -->
				    		<s:a action="retour_ouvrage" namespace="/utilisateur">
				    			<s:param name="idEmprunt" value="key.id"/>
				    			<s:submit class="btn btn-default" value="RETOUR"/>
				    		</s:a>	
				    		<!-- un bouton pour la prolongation -->
				    		<s:if test="%{key.prolongation==false}">
					    		<s:a action="prolongation_ouvrage" namespace="/utilisateur">
					    			<s:param name="idEmprunt" value="key.id"/>
					    			<s:submit class="btn btn-default" value="PROLONGER"/>
					    		</s:a>
				    		</s:if>
						</li>
				   	</ul>
				</s:iterator>		
			</div>
			
			<div class="col-lg-9">	
				<h4 id="titre"><!--<s:text name="compteUser.reservation"/>--> Vos livres reserves </h4>
				
				<!-- un tab recapitulatif des reservations en cours-->
				<s:iterator value="listReservation"> <!--   var="livreEmpruntType" status="stat">-->
					<ul>
						<li id="empruntLivre">
							<div><s:property value="key.livre.titre"/> <!--  "#livreEmpruntType.ouvrage.titre"/>--> </div>
							<div>
								<!--<s:iterator value="value">-->
									<div>
										<!--<s:text name="compteUser.empruntPossible"/>-->Date de disponibilite de l'ouvrage :  <s:property value="key"/> <!--  "#livreEmpruntType.dateEmprunt"/>-->
										<!--<s:text name="compteUser.rangReservation"/>-->Position sur la liste d'attente : <s:property value="value"/> <!--  "%{listDate.get(stat.index)}"/>-->
									</div>	
					    		<!--</s:iterator>-->
				    		</div>
							<!-- un bouton pour l'annulation -->
				    		<s:a action="annuler_reservation" namespace="/utilisateur">
				    			<s:param name="idResa" value="key.id"/>
				    			<s:submit class="btn btn-default" value="ANNULER"/>
				    		</s:a>				    		
						</li>
				   	</ul>
				</s:iterator>		
			</div>				
		</div>	
		
					
		<%@include file="_footer.jsp" %>
	</body>
</html>