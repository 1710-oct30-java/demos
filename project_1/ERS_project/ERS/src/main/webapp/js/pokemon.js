function findPokemonById() {
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = () => {
		console.log(`state changed ${xhttp.readyState}`);
		if(xhttp.readyState === 4 && xhttp.status === 200) {
			console.log('we have the response ready');
			console.log(`response text: ${xhttp.responseText}`);
			let pokemon = JSON.parse(xhttp.responseText);
			document.getElementById("pokemon").innerText = pokemon.name;
		}
		else if(xhttp.readyState === 4){
			alert("Failed to load pokemon!");
		}
	}	
	
	let num = document.getElementById("pokemon-number").innerText = document.getElementById("pokemon-number").value;
	xhttp.open('GET', `https://pokeapi.co/api/v2/pokemon/${num}`);
	xhttp.send();
}