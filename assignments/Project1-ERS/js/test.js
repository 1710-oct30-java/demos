let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = () => {
    console.log('state changed ${xhttp.readyState}');
    if(xhttp.readyState === 4){
        console.log('we have the response ready');
        console.log('response text: ${xhttp.responseText}');
    }
}

xhttp.open('GET', 'http://pokeapi.co/api/v2/pokemon/1');
xhttp.send();