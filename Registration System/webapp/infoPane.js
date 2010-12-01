function sendForm( evt ) {
	
    // get userName data
    var fullname = document.getElementById('fullname');
    var address = document.getElementById('address');
    var email = document.getElementById('email');
    var phone = document.getElementById('phone');
    
    var xmlDoc = document.implementation.createDocument(null, null, null);
    //create the xml document
    var xml = xmlDoc.createElement('info');
    xml.appendChild( xmlDoc.createElement('fullname').createTextNode(fullname.value) );
    xml.appendChild( xmlDoc.createElement('address').createTextNode(address.value) );
    xml.appendChild( xmlDoc.createElement('email').createTextNode(email.value) );
    xml.appendChild( xmlDoc.createElement('phone').createTextNode(phone.value) );
    xmlDoc.appendChild( xml );
    
    var xml = xmlDoc.createElement('courses');
    xml.appendChild( xmlDoc.createTextNode( password.value) );
    xmlDoc.appendChild( xml );
    

	    // transmit the document
	    var req = new XMLHttpRequest();
	    req.open("POST","account", true );	
	    req.onreadystatechange = function() {
		if ( req.readyState == 4) {
		    displayResult( req )
		}
	    }
	    req.send( xmlDoc );
    
}

// used to toggle display of the infotable 
function pers(){
	document.getElementById('infotable').style.display='block';
	document.getElementById('coursetable').style.display='none';
	document.getElementById('regtable').style.display='none';
	document.getElementById('cctable').style.display='none';
}

function crses(){
	document.getElementById('coursetable').style.display='block';
	document.getElementById('infotable').style.display='none';
	document.getElementById('regtable').style.display='none';
	document.getElementById('cctable').style.display='none';
}

function regInfo(){
	document.getElementById('regtable').style.display='block';
	document.getElementById('infotable').style.display='none';
	document.getElementById('coursetable').style.display='none';
	document.getElementById('cctable').style.display='none';
}

function courseCreation(){
	document.getElementById('cctable').style.display='block';
	document.getElementById('infotable').style.display='none';
	document.getElementById('regtable').style.display='none';
	document.getElementById('coursetable').style.display='none';
}

function submitRegistration(){
	
}

function openCourseList(){
	window.open('courses.html','Course Listings','width=400,height=1000,resizable=no,scrollbars=yes,status=no,menubar=no');
}

function displayResult( req ) {
    var d = req.responseXML.documentElement;
    var info = d.getElementsByTagName( 'info' );
    var courses = d.getElementsByTagName( 'courses' );
    document.getElementById('fullname').value = info[0].textContent;
    document.getElementById('address').value = info[1].textContent;
    document.getElementById('email').value = info[2].textContent;
    document.getElementById('phone').value = info[3].textContent;
}

function clearResults( ) {
   
	document.getElementById('fullname').value = '';
    document.getElementById('address').value = '';
    document.getElementById('email').value = '';
    document.getElementById('phone').value = '';

}

function initializeForm() 
{
	var q = document.getElementById('personal');
	q.addEventListener('click', sendForm, false);
     var b = document.getElementById( 'infotable' );
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
}