/* ajax example, that appends to a list */
function sendForm( evt ) {
	
    // get userName data
    var fullname = document.getElementById('fullname');
    var address = document.getElementById('address');
    var email = document.getElementById('email');
    var phone = document.getElementById('phone');
    
    var xmlDoc = document.implementation.createDocument(null, null, null);

    var xml = xmlDoc.createElement('info');
    var xml.appendChild( xmlDoc.createElement('fullname').createTextNode(fullname.value) );
    xml.appendChild( xmlDoc.createElement('address').createTextNode(address.value) );
    xml.appendChild( xmlDoc.createElement('email').createTextNode(email.value) );
    xml.appendChild( xmlDoc.createElement('phone').createTextNode(phone.value) );
    xmlDoc.appendChild( xml );
    
    var xml = xmlDoc.createElement('courses');
    xml.appendChild( xmlDoc.createTextNode( password.value) );
    xmlDoc.appendChild( xml );
    
    
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

function personal(){
	
}
function courses(){
	
}
function regInfo(){
	
}
function courseCreation(){
	
}

function login(){
	alert(thePass.value);
	var theName = document.getElementById('userName');
	var thePass = document.getElementById('password');
	if (theName.value == 'root') {
		   alert(thePass.value);
		clearResults();
		checkPass();
		initializeForm();
	}
	
		
}

function register(){
	var theName = document.getElementById('userName');
	var thePass = document.getElementById('password');
	if (theName == 'root'){
		clearResults();
		rootReg();
		//initializeForm();
	}
	else {
		clearResults();
		checkReg(theName.value, thePass.value);
		//initializeForm();
	}
}

function displayResult( req ) {
    var d = req.responseXML.documentElement
    var info = d.getElementsByTagName( 'info' );
    var courses = d.getElementsByTagName( 'courses' );
    document.getElementById('fullname').value = info[0].textContent;
    document.getElementById('address').value = info[1].textContent;
    document.getElementById('email').value = info[2].textContent;
    document.getElementById('phone').value = info[3].textContent;
    }
}

function clearResults( ) {
   
	var selectObj = document.getElementById('userName');
	var selectParentNode = selectObj.parentNode;
	var newSelectObj = selectObj.cloneNode(false); // Make a shallow copy
	selectParentNode.replaceChild(newSelectObj, selectObj);
	//return newSelectObj;


/**
   var list = document.getElementById('list');
     while( list.hasChildNodes() ) {
	 list.parentNode.removeChild( list );
     }
**/

}

function initializeForm() 
{
     var b = document.getElementById( 'loginButton' );
     b.addEventListener('click', sendForm, false );

}

window.addEventListener("load", initializeForm, false);

function getData(){
    
    var req = new XMLHttpRequest();
    req.open("GET",'info', true );   	
    req.onreadystatechange = function() {
        if ( req.readyState == 4) {
        	var d = req.responseXML.documentElement	
		    displayResult( req )    
		}
    }
    req.send( xmlDoc );
    // clear text area
    //text.value = '';	
}