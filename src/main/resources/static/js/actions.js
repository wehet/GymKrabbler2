
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

async function fillProgressBar() {

	var progressBarContainer = document.getElementById("progressID");
	var progressBarFilling = document.getElementById("progressFillID");
	var loadingText = document.getElementById("loadingID");
	progressBarContainer.style.display = "block";
	progressBarFilling.style.display = "block";
	loadingText.style.display = "block";
	var i= 2;
	//progressBarFilling.style.width = (i + 15) + "%";

	do {	
		const result = await wait1Second();
		i = i + 1;
		progressBarFilling.style.width = (i) + "%";
		console.log(result);
	} while (i<90);
	
}

async function finishFilling() {
	var progressBarContainer = document.getElementById("progressID");
	var progressBarFilling = document.getElementById("progressFillID");
	var loadingText = document.getElementById("loadingID");
	progressBarFilling.style.width = "100%";
	const result = await wait1Second();
	progressBarFilling.style.display = "none";
	progressBarContainer.style.display = "none";
	loadingText.style.display = "none";
	console.log(result);
	displayError();

}

function wait1Second() {
	return new Promise((resolve) => {
		setTimeout(() => {
			resolve("finished")
		}, 500);
	});
}

function displayError() {
	var errorMessage = document.getElementById("errorMessage");
	if (errorMessage.innerHTML != "") {
		if(errorMessage.innerHTML !== "ok") {
			var displayedError = errorMessage.innerHTML.slice(0, errorMessage.innerHTML.length - 2);
			window.alert("Die Daten des Gyms " + displayedError + 
					" konnten nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com");	
		}
		
	}
}