function checkDatiPag(form){
	$("errorNumCarta").text("");
	$("errorCVV").text("");
	$("errorData").text("");

	if ($("#carta").val()===""){
	     $("#errorNumCarta").text('Non hai inserito il numero della tua carta').css({"color":"red"});
		 document.getElementById("carta").focus();
		 return(false);
	}
	
	var regexpCarta = "^\\d{16}$";
	if(!($("#carta").val().match(regexpCarta))){
		$("#errorNumCarta").text('Non hai inserito un numero di carta di credito valido').css({"color":"red"});
		document.getElementById("carta").focus();
		return(false);
	}
	
	if ($("#cvv").val()===""){
		$("#errorCVV").text('Non hai inserito il CVV.').css({"color":"red"});
		document.getElementById("cvv").focus();
		return(false);
	}
	
	var regexpCVV = "^\\d{3}$";
	if(!($("#cvv").val().match(regexpCVV))){
		$("#errorCVV").text('Non hai inserito un CVV valido').css({"color":"red"});
		document.getElementById("cvv").focus();
		return(false);
	}
	
	if($("#data").val()==""){
		$("#errorData").text('Non hai inserito la data di scadenza').css({"color":"red"});
		document.getElementById("data").focus();
		return(false);
	}
	
	var dataOggi = new Date();
	var dataScadenza = new Date($("#data").val());
	if(dataScadenza < dataOggi){
		$("#errorData").text('Non hai inserito una data di scadenza valida').css({"color":"red"});
		document.getElementById("data").focus();
		return(false);
	}
	
	return (true);
}

function startNumCarta(){
	$("#errorNumCarta").text('');
}

function startCVV(){
	$("#errorCVV").text('');
}

function startData(){
	$("#errorData").text('');
}