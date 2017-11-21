function apply2(callback) {
  callback(2);
}

function logInput(input) {
  console.log(input);
}

apply2(logInput);

function sumArgs(... args) {
	return args.reduce((acc, cur) => {
    return acc + cur;
  }, '')
}

sumArgs( 5,215321,1235,1235);