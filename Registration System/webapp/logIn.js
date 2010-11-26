/* ajax example, that appends to a list */
function sendForm( evt ) {
	
    // get userName data
    var userName = document.getElementById('userName');
    var password = document.getElementById('password');
    
    var xmlDoc = document.implementation.createDocument(null, null, null);

    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlhead = xmlDoc.createElement('login');
    xmlDoc.appendChild(xmlhead);
    xmlhead.appendChild( xmluser );
    xmlhead.appendChild( xmlpass);
    xmluser.appendChild( xmlDoc.createTextNode( text.value) );
    xmlpass.appendChild( xmlDoc.createTextNode( thePass.value) );
    
    if (userName.value =='root'){ 	
	    // transmit the document
	    var req = new XMLHttpRequest();
	    req.open("POST","login/root", true );	
	    req.onreadystatechange = function() {
		if ( req.readyState == 4) {
		    displayResult( req )
		}
	    }
	    req.send( xmlDoc );
	    // clear text area
    }
    
    else{
    	var req = new XMLHttpRequest();
	    req.open("POST","login/user", true );	
	    req.onreadystatechange = function() {
		if ( req.readyState == 4) {
		    displayResult( req )
		}
	    }
	    req.send( xmlDoc );
	    // clear text area
    }
    password.text = '';
    
}

function login(){
	
	var theName = document.getElementById('userName');
	var thePass = document.getElementById('password');
		checkPass();
		initializeForm();
		clearResults();	
}

function register(){
	var theName = document.getElementById('userName');
	var thePass = document.getElementById('password');
		clearResults();
		checkReg();
		//initializeForm();
}

function displayResult( req ) {
    
    var d = req.responseXML.documentElement;
    var e = d.getElementsByTagName( 'username' )[0].textContent;
    alert(e);
    var f = d.getElementsByTagName( 'password' )[0].textContent;
    alert(f);
	document.getElementById('test').value = e;
	var g = d.getElementsByTagName( 'status' )[0].textContent;
	if (g == "ok"){ window.location="index.html"}
    }

function clearResults( ) {
   
//	document.getElementById('userName').value = '';
//	document.getElementById('password').value = '';

}

function initializeForm() 
{
     var b = document.getElementById( 'loginButton' );
     b.addEventListener('click', sendForm, false );
     var r = document.getElementById( 'registerButton' );
     b.addEventListener('click', sendForm, false );
}

window.addEventListener("load", initializeForm, false);

function checkPass(){
    var text = document.getElementById('userName');
	var thePass = document.getElementById('password');
    var xmlDoc = document.implementation.createDocument(null, null, null);
    
    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlhead = xmlDoc.createElement('login');
    xmlDoc.appendChild(xmlhead);
    xmlhead.appendChild( xmluser );
    xmlhead.appendChild( xmlpass );
    xmluser.appendChild( xmlDoc.createTextNode( text.value ) );
    xmlpass.appendChild( xmlDoc.createTextNode( thePass.value ) );
    

    var req = new XMLHttpRequest();
    req.open("POST",'login/root', true );   	
    req.onreadystatechange = function() {
        if ( req.readyState == 4) {
	   // var d = req.responseXML.documentElement	
		    displayResult( req )    
		}
    }
    req.send( xmlDoc );
    // clear text area
//    text.value = '';	
}
function checkReg(){
	var text = document.getElementById('userName');
	var thePass = document.getElementById('password');
    var xmlDoc = document.implementation.createDocument(null, null, null);
    
    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlhead = xmlDoc.createElement('login');
    xmlDoc.appendChild(xmlhead);
    xmlhead.appendChild( xmluser );
    xmlhead.appendChild( xmlpass );
    xmluser.appendChild( xmlDoc.createTextNode( text.value ) );
    xmlpass.appendChild( xmlDoc.createTextNode( thePass.value ) );
    var req = new XMLHttpRequest();
    
    req.open("POST",'login/new', true );   	
    req.onreadystatechange = function() {
        if ( req.readyState == 4) {
	   // var d = req.responseXML.documentElement	
		    displayResult( req )    
		}
    }
    req.send( xmlDoc );
}