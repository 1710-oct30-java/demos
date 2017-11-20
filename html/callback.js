function apply2(callback) {
    callback(2);
}

function logInput(input) {
    console.log(input);
}

apply2(logInput);