console.log('script started')
function containerClicked() {
    alert('container mouse out triggered');
}

function innerClick(event) {
    console.log('inner clicked');
}

function outerClicker() {
    console.log('outer clicked');
}

function removeOuter() {
    document.getElementById('out');
}

let id = 5;
document.getElementById('outer').innerHTML += `
    
`

function apply2(callback) {
    callback(2);
}

function logInput(input) {
    console.log(input);
}

apply2(logInput); //logs 2

function sumArgs(... args) {
    return args.reduce((acc, cur) => {
        return acc + cur;
    }, ' ');
}