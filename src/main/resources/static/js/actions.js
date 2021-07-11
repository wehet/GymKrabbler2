
function myFunction() {
	// Declare variables
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

function fillProgressBar() {
	//var data;
//	loadJSON(function(response) {
//		  // Parse JSON string into object
//		    var actual_JSON = JSON.parse(response);
//		    console.log("this is our json: " + actual_JSON)
//		 });
	//window.alert(data[0].url)
	
	var progressBarContainer, progressBarFilling;
	progressBarContainer = document.getElementById("progressID")
	progressBarFilling = document.getElementById("progress-fill-ID")
	setInterval(function () {
		progressBarFilling.style.width = i + "%";
    }, 1000);
		progressBarContainer.style.display = "inline";
	progressBarFilling.style.display = "inline";
	progressBarFilling.style.width = "80%";
	//window.alert("something happened: " + document.getElementById("test").textContent)	
}

//function loadJSON(callback) {   
//
//    var xobj = new XMLHttpRequest();
//    xobj.overrideMimeType("application/json");
//    xobj.open('GET', 'http://localhost:8081/gymData.json', true); // Replace 'my_data' with the path to your file
//    xobj.onreadystatechange = function () {
//          if (xobj.readyState == 4 && xobj.status == "200") {
//            // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
//            callback(xobj.responseText);
//          }
//    };
//    xobj.send(null);  
// }
