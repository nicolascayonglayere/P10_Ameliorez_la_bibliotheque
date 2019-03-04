<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

		<header>

     		 <div class="navbar navbar-expand-md navbar-light navbar-fixed-top" id="menuTop">
      			<div class="container align-items-center">
      				<!--  <div class="row align-items-center">-->
      					
						<!--  <div class="navbar-header">-->
							
	      					<s:a class="navbar-brand" action="index" namespace="/"><s:text name="entete.titre"/></s:a>	
	      				<!--  </div>--> 
	      			
			      		<div class="collapse navbar-collapse" id="maBarreMenuTop" >
				      		<ul class="navbar-nav mr-auto nav-fill">
					     	   <li class="hidden"><a href="#page-top"></a></li>
					     	   <li class="nav-item active">
					     	   		<s:a action="go_recherche" namespace="/" cssClass="nav-link"><s:text name="entete.recherche"/></s:a>
					     	   </li>
					     	   <li class="nav-item active">
					     	   		<s:a action="go_login" namespace="/" cssClass="nav-link"><s:text name="login.titre"/></s:a>
					     	   </li>					     	   
				      		</ul>
			      		</div>
			      	

      			
      				
      				</div>
		      	<!--  </div>-->
    		 </div>		
		</header>