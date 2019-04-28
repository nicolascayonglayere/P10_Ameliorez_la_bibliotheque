<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="_head.jsp" %>

		<title>Accueil</title>
	</head>
	
	
	<body>
		<%@include file="_navigation.jsp" %>
		<div id=blocPge>
			<div class = "container">

				<h1 id="titre">Bienvenue sur cette application de la bibliotheque OC<!--<s:text name="index.bienvenue"/>--></h1>
				<s:actionmessage/>
				<s:if test="#session.utilisateur">
					<p><!--<s:text name="index.bonjour"/>-->Bonjour <s:property value="#session.utilisateur.pseudo"/></p>	
				</s:if>
				<s:else>
					<p>
						<s:a action="go_login" namespace="/"><!--<s:text name="index.connexion"/>-->AUTHENTIFICATION</s:a>					
					</p>
				</s:else>	
					
				<div class="row" id="blocImgTopo">
					<s:iterator value="livresAccueil" var="livreType">
				    	<div class="col-lg-3" id="imageTopo" >
				    		<s:a action="go_livre" namespace="/">
				    			<!-- mettre l'image de couv -->
								<s:url action="ImageAction" namespace="/" var="URLTag">
									<s:param name="imageId" value="%{#livreType.id}"/>
								</s:url>
								<img src="<s:property value="#URLTag"/>" class="thumbnail, rounded" />			    			
				            	<figcaption><s:property value="#livreType.titre"/></figcaption>
			                    <s:param name="idLivre" value="#livreType.id" />	
			               	</s:a>
				    	</div>
				 	</s:iterator>
				</div>
	  			
	  			
				  				
			</div>
		</div>	
		<%@include file="_footer.jsp" %>			
	</body>
</html>