function checkLogin(form){
	$("errorEmail").text("");
	$("errorP").text("");

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
		$("#errorP").text('Non hai inserito la tua password.').css({"color":"red"});
		document.getElementById("password").focus();
		return(false);
	}
	
	$.post("../Login",$(form).serialize(),function(msg){
		if(msg === "0"){
			$("#error").text("Login non riuscito").css({"color":"red"});
			document.getElementById("email").focus();
		} else {
			window.location = 'areaUtente.jsp';
		}
	});
		
	return (false);
}

function startEmail(){
	$("#errorEmail").text('');
}

function startPassword(){
	$("#errorP").text('');
}

/*var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function(){
	if (xhttp.readyState == 4){
		if(xhttp.responseText === "0"){
			console.log("prova: " + xhttp.responseText);
			$("#error").text("Login non riusciuto").css({"color":"red"});
			document.getElementById("email").focus();
		} else {
			window.location = 'areaUtente.jsp';
		}
	}
}
xhttp.open('POST', "../Login", true);
xhttp.send("email=" + $("#email").val()+"&password="+$("#password").val());*/
