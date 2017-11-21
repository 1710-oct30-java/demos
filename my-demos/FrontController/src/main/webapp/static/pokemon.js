function findPokemon() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = () => {
		console.log(`state change ${xhttp.readyState}`);
		if(xhttp.readyState == 4) {
			console.log('we have a response ready');
			console.log(`response text: ${xhttp.responseText}`);
			let pokemon = JSON.parse(xhttp.responseText);
			document.getElementById('pokemon').innerText = pokemon.name;
		} else if(xhttp.readyState ===4) {
			alert('failed to load')
		}
	}
	let pokemonid = document.getElementById('pokeid').value
	xhttp.open('GET', 'https://pokeapi.co/api/v2/pokemon/778');
	xhttp.send();
}