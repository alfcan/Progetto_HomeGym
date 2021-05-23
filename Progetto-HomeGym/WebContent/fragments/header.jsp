<%@page import="it.unisa.model.DAOS.*"%>
<%@page import="it.unisa.model.beans.*"%>
<%@page import="it.unisa.controller.*"%>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomeGym</title>
 
    <link rel="stylesheet" href="Stili/header.css">
</head>
<body>
     <!-- example 7 - center on mobile 2-->
<nav id="navbar1" class="navbar navbar-expand-lg">
  <div class="d-flex flex-grow-1">
      <span class="w-100 d-lg-none d-block"><!-- hidden spacer to center brand on mobile --></span>
      <a class="navbar-brand" href="index.jsp">
         <img src="foto/logo.jpg" alt="HomeGym" id="logo">
      </a>
      <div class="w-100 text-right">
          <button id="tastino1" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavbar7">
              <span class="navbar-toggler-icon"><img src="foto/om.png" alt=""></span>
          </button>
      </div>
  </div>
  <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar7">
      <ul class="navbar-nav ml-auto flex-nowrap">
          <li class="nav-item">
              <a id="collegamento2" href="<%=request.getContextPath()%>/pages/faq.html" class="nav-link">Domande Frequenti</a>
          </li>
          <%if(session.getAttribute("Utente")==null){ %>
	          <li class="nav-item">
	              <a id="collegamento" href="<%=request.getContextPath()%>/pages/login.jsp" class="nav-link">Accedi</a>
	          </li>
          <%} else{%>
          <li class="nav-item">
              <a id="collegamento" href="<%=request.getContextPath()%>/servletLogout" class="nav-link">Logout</a>
          </li>
          <li class="nav-item">
              <a id="collegamento" href="<%=request.getContextPath()%>/pages/areaUtente.jsp" class="nav-link">Area Utente</a>
          </li>
          <%} %>
          <li class="nav-item">
            <a href="<%=request.getContextPath()%>/pages/carrello.jsp"><button type="button" class="btn btn-secondary bottone" id="carrello"><img src="foto/car.png"></button></a>
          </li>
          
      </ul>
  </div>
</nav>

<!-- example 8 - center logo on mobile, search right -->
<nav id="navbar2" class="navbar navbar-expand-lg">
  <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar8">
      <ul class="navbar-nav mr-auto">
          <li class="nav-item">
              <a id="collegamento3" class="nav-link" href="<%=request.getContextPath()%>/ProductControl?action=ViewProdotti&cat=1">FITNESS</a>
          </li>
          <li class="nav-item">
              <a id="collegamento3" class="nav-link" href="<%=request.getContextPath()%>/ProductControl?action=ViewProdotti&cat=2">BODYBULDING</a>
          </li>
          <li class="nav-item">
            <a id="collegamento3" class="nav-link" href="<%=request.getContextPath()%>/ProductControl?action=ViewProdotti&cat=3">MANUBRI</a>
          </li>
          <li class="nav-item">
            <a id="collegamento3" class="nav-link" href="<%=request.getContextPath()%>/ProductControl?action=ViewProdotti&cat=4">ACCESSORI</a>
          </li>
          
   
      </ul>
  </div>
  <div class="w-100 d-flex flex-nowrap">
      <div class="w-100">
          <button id="tastino2" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavbar8">
              <span class="navbar-toggler-icon"><img src="foto/tshirt.png" alt=""></span>
          </button>
      </div>
      <div class="d-flex w-100 justify-content-end order-3">
          <form class="d-flex flex-nowrap align-items-center" method="post" action="AltreRicerche">
              <input type="hidden" name="action" value="SearchNome">
              <input class="form-control border-right-0 mr-n1" name="daCercare" type="search" size="50" placeholder="Cerca" aria-label="Search">
              <button id="cerca" class="btn btn-outline-secondary" type="submit"><i class="fa fa-search">Search</i></button>
            </form>
      </div>
  </div>
</nav>

</body>
