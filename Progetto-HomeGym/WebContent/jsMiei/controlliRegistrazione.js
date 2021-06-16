function controlPersonaFisica(form){
	var maiusc=false
	var number=false;
	
    $("#errorNome").text("");
    $("#errorCognome").text("");
    $("#errorTel").text("");
    $("#errorEmail").text("");
    $("#errorP1").text("La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola").css({"color":"grey"});
    $("#errorP2").text("");
    $("#error").text("");

	if ($("#cognome").val()===""){
		 $("#errorCognome").text('Non hai inserito il tuo cognome').css({"color":"red"});
		 document.getElementById("cognome").focus();
		 return(false);
	}
	
	if ($("#nome").val()===""){
		$("#errorNome").text('Non hai inserito il tuo nome').css({"color":"red"});
		document.getElementById("nome").focus();
		return(false);
	}

	
	if($("#telefono").val()===""){
		 $("#errorTel").text('Non hai inserito il tuo recapito telefonico').css({"color":"red"});
		 document.getElementById("telefono").focus();
		 return(false);
	}
	
	var regextel = "^\\d{10}$";
	if(!($("#telefono").val().match(regextel))){
		$("#errorTel").text('Non hai inserito un recapito telefonico valido').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	if ($("#email").val()===""){
	     $("#errorEmail").text('Non hai inserito la tua e-mail').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}
	
	var regexEmail = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+$";
	if(!($("#email").val().match(regexEmail))) {
		$("#errorEmail").text('Non hai inserito una e-mail valida').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}

	if ($("#password").val()===""){
		$("#errorP1").text('Inserire una password valida.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	if ($("#password").val().length<8){
		$("#errorP1").text('Inserire una password con almeno 8 caratteri.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	if ($("#password").val().length>16){
		$("#errorP1").text('Inserire una password con massimo 16 caratteri.').css({"color":"red"});
		 document.getElementById("password").focus();
		return(false);
	}

	for(var i=0; i<$("#password").val().length;i++){
		var c=$("#password").val().charAt(i);
		if(isNaN(c) && c.toUpperCase()===c){
			maiusc=true;
		}
	}

	if(maiusc==false){
		$("#errorP1").text('La password deve avere almeno un carattere maiuscolo.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	for(var i=0; i<$("#password").val().length;i++){
		var c=$("#password").val().charAt(i);
		if((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9')){
			number=true;
		}
	}
	if(number===false){
		$("#errorP1").text('La password deve avere almeno un numero.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
		
	if ($("#password2").val()==""){
	   $("#errorP2").text('Devi confermare la tua password').css({"color":"red"});
	   document.getElementById("password2").focus();
	   return(false);
	}

	var p = $("#password").val();
	var p2= $("#password2").val();
	if(!(p==p2)){
		$("#errorP2").text('Le due password non corrispondono').css({"color":"red"});
		document.getElementById("password2").focus();
		return(false);
	}		
    
	emailRegistrata();
	
	return(false);
}

function controlAzienda(form){
	var maiusc=false
	var number=false;
	
    $("#errorRagSoc").text("");
    $("#errorPIVA").text("");
    $("#errorCitta").text("");
    $("#errorInd").text("");
    $("#errorTel").text("");
    $("#errorEmail").text("");
    $("#errorP1").text("La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola").css({"color":"grey"});
    $("#errorP2").text("");
    $("#error").text("");

	if ($("#ragioneSociale").val()===""){
		 $("#errorRagSoc").text('Non hai inserito la tua Ragione Sociale').css({"color":"red"});
		 document.getElementById("ragioneSociale").focus();
		 return(false);
	}
	
	if ($("#partitaIva").val()===""){
		$("#errorPIVA").text('Non hai inserito la tua Partita IVA').css({"color":"red"});
		document.getElementById("partitaIva").focus();
		return(false);
	}

	var regexPIva = "^\\d{11}$";
	if(!($("#partitaIva").val().match(regexPIva))){
		$("#errorPIVA").text('Non hai inserito una Partita IVA valida').css({"color":"red"});
		document.getElementById("partitaIva").focus();
		return(false);
	}
	
	if ($("#citta").val()===""){
		 $("#errorCitta").text('Non hai inserito la citta della sede legale').css({"color":"red"});
		 document.getElementById("citta").focus();
		 return(false);
	}
	
	if ($("#indirizzo").val()===""){
		$("#errorInd").text('Non hai inserito la tua Partita IVA').css({"color":"red"});
		document.getElementById("indirizzo").focus();
		return(false);
	}
	
	if($("#telefono").val()===""){
		 $("#errorTel").text('Non hai inserito il tuo recapito telefonico').css({"color":"red"});
		 document.getElementById("telefono").focus();
		 return(false);
	}
	
	var regextel = "^\\d{10}$";
	if(!($("#telefono").val().match(regextel))){
		$("#errorTel").text('Non hai inserito un recapito telefonico valido').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	if ($("#email").val()===""){
	     $("#errorEmail").text('Non hai inserito la tua e-mail').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}
	
	var regexEmail = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+$";
	if(!($("#email").val().match(regexEmail))) {
		$("#errorEmail").text('Non hai inserito una e-mail valida').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}

	if ($("#password").val()===""){
		$("#errorP1").text('Inserire una password valida.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	if ($("#password").val().length<8){
		$("#errorP1").text('Inserire una password con almeno 8 caratteri.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	if ($("#password").val().length>16){
		$("#errorP1").text('Inserire una password con massimo 16 caratteri.').css({"color":"red"});
		 document.getElementById("password").focus();
		return(false);
	}

	for(var i=0; i<$("#password").val().length;i++){
		var c=$("#password").val().charAt(i);
		if(isNaN(c) && c.toUpperCase()===c){
			maiusc=true;
		}
	}

	if(maiusc==false){
		$("#errorP1").text('La password deve avere almeno un carattere maiuscolo.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	for(var i=0; i<$("#password").val().length;i++){
		var c=$("#password").val().charAt(i);
		if((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9')){
			number=true;
		}
	}
	if(number===false){
		$("#errorP1").text('La password deve avere almeno un numero.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
		
	if ($("#password2").val()==""){
	   $("#errorP2").text('Devi confermare la tua password').css({"color":"red"});
	   document.getElementById("password2").focus();
	   return(false);
	}

	var p = $("#password").val();
	var p2= $("#password2").val();
	if(!(p==p2)){
		$("#errorP2").text('Le due password non corrispondono').css({"color":"red"});
		document.getElementById("password2").focus();
		return(false);
	}		
    
	emailRegistrata();
	
	return(false);
}

function emailRegistrata(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if (xhttp.readyState == 4){
			if(xhttp.responseText === "0"){
				$("#error").text("REGISTRAZIONE NON EFFETTUATA: email o telefono gia presenti").css({"color":"red"});			
				document.getElementById("cognome").focus();
			} else {
				window.location = 'login.jsp';
			}
		}
	}
	xhttp.open('POST', "../RegistrazioneControl", true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhttp.send("action=verifica&email=" + $("#email").val());
}

function startNome(){
    $("#errorNome").text('');
}

function startCognome(){
$("#errorCognome").text('');
}

function startTel(){
	$("#errorTel").text('');
	}


function startEmail(){
$("#errorEmail").text('');
}

function startPassword(){
$("#errorP1").text('La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
}

function startPassword2(){
$("#errorP2").text('');
}