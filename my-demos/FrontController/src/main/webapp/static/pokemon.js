function findPokemon() {
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = () => {
    console.log(`state changed ${xhttp.readyState}`);
    if(xhttp.readyState === 4 && xhttp.status === 200) {
      console.log('we have the response ready');
      console.log(`response text: ${xhttp.responseText}`)
      let pokemon = JSON.parse(xhttp.responseText);
      document.getElementById('pokemon').innerText = pokemon.name;
  
    } else if(xhttp.readyState === 4) {
      alert('failed to load the pokemon you requested');
    }
  }
  let pokemonid = document.getElementById('pokeid').value
  xhttp.open('GET', `https://pokeapi.co/api/v2/pokemon/${pokemonid}/`);
  xhttp.send();
}



