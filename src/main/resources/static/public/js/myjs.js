function showAlert(name){
	let date = new Date().toISOString().slice(0, 10);;
	alert("Today is: " + date + "\nHello " + name);
}
function pageRedirect(pageUrl){	
	window.location.href = pageUrl;
}

function sendPost(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "/logout", true);
	xhttp.send();	
}