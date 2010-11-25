/* ajax example, that appends to a list */
function sendForm( evt ) {
    // get userName data
    var text = document.getElementById('userName');


    var xmlDoc = document.implementation.createDocument(null, null, null);

    var xml = xmlDoc.createElement('element');
    xml.appendChild( xmlDoc.createTextNode( text.value) );
    xmlDoc.appendChild( xml );

    var userName = document.getElementsByTagName('username');
    
    if (userName=='root'){ 	
	    // transmit the document
	    var req = new XMLHttpRequest();
	    req.open("POST","list/a", true );	
	    req.onreadystatechange = function() {
		if ( req.readyState == 4) {
		    displayResult( req )
		}
	    }
	    req.send( xmlDoc );
	    // clear text area
	    text.value = '';
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
     b.addEventListener('click', userName, false );

}

window.addEventListener("load", initializeForm, false);

function login(){
    var text = document.getElementById('userName');

    var xmlDoc = document.implementation.createDocument(null, null, null);

//    var xml = xmlDoc.createElement('element');
//    xml.appendChild( xmlDoc.createTextNode( text.value) );
 //   xmlDoc.appendChild( xml );
	
    var req = new XMLHttpRequest();
    req.open("GET",'list/login', true );   	
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

function register(){
}