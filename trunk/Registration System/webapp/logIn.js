/* ajax example, that appends to a list */
function sendForm( evt ) {
	alert("yo");
    // get userName data
    var userName = document.getElementById('userName');
    var password = document.getElementById('password');

    var xmlDoc = document.implementation.createDocument(null, null, null);

    var xml = xmlDoc.createElement('element');
    xml.appendChild( xmlDoc.createTextNode( userName.value) );
    xmlDoc.appendChild( xml );
    
    var xml = xmlDoc.createElement('element');
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

function login(){
	var theName = document.getElementById('userName');
	var thePass = document.getElementById('password');
	if (theName.value == 'root') {

		clearResults();
		checkPass(thePass.value);
		//initializeForm();
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
    var e = d.getElementsByTagName( 'element' );
    var list = document.getElementById('list');
    for( var i = 0 ; i < e.length; i++ ) {
	var li = document.createElement('li');
	var res = e[i].textContent;
	li.appendChild( document.createTextNode( res ));
	list.appendChild( li );
    }
}

function clearResults( ) {
   
	var selectObj = document.getElementById('list');
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
     var b = document.getElementById( 'sendButton' );
     b.addEventListener('click', sendForm, false );

}

window.addEventListener("load", initializeForm, false);

function checkPass(){
    var text = document.getElementById('userName');
	var thePass = document.getElementById('password');

    var xmlDoc = document.implementation.createDocument(null, null, null);

//    var xml = xmlDoc.createElement('element');
//    xml.appendChild( xmlDoc.createTextNode( text.value) );
 //   xmlDoc.appendChild( xml );
	
    var req = new XMLHttpRequest();
    req.open("GET",'login/root', true );   	
    req.onreadystatechange = function() {
        if ( req.readyState == 4) {
	   // var d = req.responseXML.documentElement	
		    displayResult( req )    
		}
    }
    req.send( xmlDoc );
    // clear text area
    text.value = '';	
}