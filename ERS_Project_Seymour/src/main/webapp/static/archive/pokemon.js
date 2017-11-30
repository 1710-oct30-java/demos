function findPokemon(){
    let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = () => {
   console.log(`state changed ${xhttp.readyState}`);
   if (xhttp.readyState === 4 && xhttp.status === 200) {
       let pokemon = JSON.parse(xhttp.responseText);
       document.getElementById('pokemon').innerText = pokemon.name;
   }
  if(xhttp.readyState === 4) {
      console.log('we have the response ready');
      console.log(`response text: ${xhttp.responseText}`);
  }    
}
let pokemonid = document.getElementById('pokeid').value;
xhttp.open(`GET`, `https://pokeapi.co/api/v2/pokemon/${pokemonid}`);
xhttp.send();
}