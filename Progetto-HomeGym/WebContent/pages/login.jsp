<%@page import="it.unisa.model.DAOS.*"%>
<%@page import="it.unisa.model.beans.*"%>
<%@page import="it.unisa.controller.*"%>
<%@page import="it.unisa.database.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../Stili/login.css">
		<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<script src="../jsMiei/footer.js"></script> 
		<meta charset="UTF-8">
		<title>HomeGym-Login</title>
	</head>

<body>

    <%@ include file="../fragments/header.jsp" %>

    <div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                      
                        <div class="card rounded-0 CDtot">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Login</h3>
                            </div>
      
                                <form action="/Progetto-HomeGym/Login" method="post">
                                    <div class="form-group">
                                        <label for="uname1" class="grassetto"><img src="foto/ominologin.PNG" alt="">&nbspEmail</label>
                                        <input type="email" class="form-control form-control-lg rounded-0 BORDO" name="email" id="email" required="">
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDO" name="password" id="password" required="" autocomplete="new-password">
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Accedi</button>
                                    <div>
                                     <p>Non hai un Account? <a id="linkReg" href="registerPersonaFisica.jsp">Registrati qui.</a> </p> 
                                     <p>Sei un'azienda e non sei ancora registrata? <a id="linkReg" href="registerAzienda.jsp">Registrati qui.</a> </p> 
									
                                    </div>
                                </form>
                            </div>
                           
                    </div>
    
    
                </div>
               
   
            </div>
           
        </div>
      
    </div>

  
     <%@ include file="../fragments/footer.jsp" %>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="../js/bootstrap.min.js"></script>
</body>
</html>
