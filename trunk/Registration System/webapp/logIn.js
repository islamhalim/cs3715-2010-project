function sendForm( evt ) {
	
    // get userName data
    var userName = document.getElementById('userName');
    var password = document.getElementById('password');
    
    var xmlDoc = document.implementation.createDocument(null, null, null);
  //create the xml document
    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlstatus = xmlDoc.createElement('status');
    var xmlhead = xmlDoc.createElement('login');
    xmlDoc.appendChild(xmlhead);
    xmlhead.appendChild( xmluser );
    xmlhead.appendChild( xmlpass);
    xmlhead.appendChild( xmlstatus);
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
	initializeForm();
}

function displayResult( req ) {
    
    var d = req.responseXML.documentElement;
    var e = d.getElementsByTagName( 'username' )[0].textContent;
    var f = d.getElementsByTagName( 'password' )[0].textContent;
	var g = d.getElementsByTagName( 'status' )[0].textContent;
	if (g.equals("ok") {window.location="infoPane.html"
    }
	else alert("Invalid username/password");

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

/* send a username and password as xml data to the servlet as login credentials */
function checkPass(){
    var text = document.getElementById('userName');
	var thePass = document.getElementById('password');
    var xmlDoc = document.implementation.createDocument(null, null, null);
    
    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlstatus = xmlDoc.createElement('status');
    var xmlhead = xmlDoc.createElement('login');
    xmlDoc.appendChild(xmlhead);
    xmlhead.appendChild( xmluser );
    xmlhead.appendChild( xmlpass );
    xmlhead.appendChild( xmlstatus );
    xmluser.appendChild( xmlDoc.createTextNode( text.value ) );
    xmlpass.appendChild( xmlDoc.createTextNode( thePass.value ) );
    /*check if user has root/admin access and send to the correct URL*/ 
    if (text.value = "root"){
    	var req = new XMLHttpRequest();
    	req.open("POST",'login/root', true );   	
    	req.onreadystatechange = function() {
    		if ( req.readyState == 4) {
    			displayResult( req )    
    		}
    	}
    }
    else {
    	var req = new XMLHttpRequest();
    	req.open("POST",'login/user', true );   	
    	req.onreadystatechange = function() {
    		if ( req.readyState == 4) {
    			displayResult( req )    
    		}
    	}
    }
    req.send( xmlDoc );
}

/*submit a username and password as xml data to servlet to determine if the account can be created*/
function checkReg(){
	var text = document.getElementById('userName');
	var thePass = document.getElementById('password');
    var xmlDoc = document.implementation.createDocument(null, null, null);
    
    var xmluser = xmlDoc.createElement('username');
    var xmlpass = xmlDoc.createElement('password');
    var xmlstatus = xmlDoc.createElement('status');
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
		    displayResult( req )    
		}
    }
    req.send( xmlDoc );
}