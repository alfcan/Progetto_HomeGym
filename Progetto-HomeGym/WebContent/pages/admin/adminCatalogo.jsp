<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body>
		<%@ include file="/fragments/header.jsp" %>
		<%@ include file="/fragments/menu.jsp" %>
		<h1>Gestione Catalogo</h1>		
		<%
		ArrayList<ProductBean> prodotti = (ArrayList<ProductBean>) request.getAttribute("listaProdotti");
		if(prodotti != null){
		%>
		<table>
			<tr>
				<thead>	
					<th>Codice</th>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Iva</th>
				</thead>
			</tr>
				<tbody>
					<%for (ProductBean p : prodotti) {%>
					<tr>
						<td><%=p.getCodice()%></td>
						<td><%=p.getNome()%></td>
						<td><%=p.getPrezzo()%></td>
						<td><%=p.getIva()%></td>
						<form method="post" action="pages/admin/modificaProdotti.jsp">
		                    <input type="hidden" name="codice" value="<%=p.getCodice()%>">
		                    <input type="hidden" name="nome" value="<%=p.getNome()%>">
		                    <input type="hidden" name="descrizione" value="<%=p.getDescrizione()%>">
		                    <input type="hidden" name="prezzo" value="<%=p.getPrezzo()%>">
		                    <input type="hidden" name="iva" value="<%=p.getIva()%>">
		                    <input type="hidden" name="categoria" value="<%=p.getIdCategoria()%>">
		                    <input type="hidden" name="immagine" value="<%=p.getUrlImmagine()%>">
		                    <td><button type="submit">Modifica</button></td>
	                    </form>
	                    <!--<form method="get" action="/Progetto-HomeGym/AdminControl">
		                    <input type="hidden" name="prodotto" value="">
		                    <input type="hidden" name="action" value="eliminaProdotto">
		                    <td><button type="submit">Elimina</button></td>
	                    </form>-->
	             	</tr>
                    <%} %>
				</tbody>	
		</table>
		<%} %>
		<hr>	
		<form method="post" action="pages/admin/aggiungiProdotto.jsp">
		    <button type="submit">Aggiungi un prodotto</button>
	    </form>		
		
		<%@ include file="/fragments/footer.jsp" %>
	</body>
</html>