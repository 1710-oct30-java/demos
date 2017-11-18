
/*
* Question 1:1: Fibonacci Sequencer
*/
let FibonacciSequence = {
	historyDepth: 10,
	history: [0, 0, 0, 0],

	getPrevious: function() {
		let index = this.getLastIndex() - 1;

		return this.history[index];
	},
	getCurrent: function() {
		let index = this.getLastIndex();

		return this.history[index];
	},
	getLastIndex: function() {
		return this.history.length - 1;
	},
	increment: function() {
		let previous = this.getPrevious();
		let current = this.getCurrent();
		let next = previous + current;

		if ( current === 0 ) {
			next = 1;
		}
		this.history.shift();
		this.history.push( next );
	},
	reset: function() {
		this.history.length = 0;

		for( let i = 0; i < this.historyDepth; i++ ) {
			this.history.push(0);
		}
	},

};

/*
* Question 1:2: Fibonacci Sequencer
*/
function fib(n) {
	FibonacciSequence.reset();
	let sequence = [];

	for( let i = 0; i < n; i++ ) {
		FibonacciSequence.increment();
	}

	return FibonacciSequence.getCurrent();
}


 /*
* Question 2: Bubble Sort
*/
function bubbleSort( numArray ) {
	let sorted = false;
	let lastIndex = numArray.length - 1;

	for(let i = 0; i < lastIndex; i++ ) {
		let current = numArray[i];
		let next = numArray[i + 1];

		if ( current > next ) {
			sorted = true;
			numArray[i] = next;
			numArray[i + 1] = current;
		}
	}

	if ( sorted ) {
		return bubbleSort( numArray );
	} else {
		return numArray;
	}
}

 /*
* Question 3: Reverse String
*/
function reverseString( str ) {
	return str.split('').reverse().join('');
}

 /*
* Question 4: Factorial
*/function factorial( number ) {
	if ( number === 1 ) {
		return 1;
	}

	return number * factorial( number - 1);
}


/*
* Question 5: Substring
*/
function substring(str, length, offset) {
	switch( true ) {
		case ( str.length === 0 ) :
			alert("string must not be of zero length");
			return str;
			break;
		case ( length < 1 ) :
			alert("you must select 1 or more characters");
			return str;
			break;
		case ( offset >= str.length ) :
			alert("starting position must come before the start of the string");
			return str;
			break;
		default :
			return str.substr(offset, length);

	}
}

/*
* Question 6: Even Number
*/
function isEven( number ) {
	let strValue = number.toString(2);
	let lastDigit = strValue.substr( strValue.length - 1, 1);

	return ( lastDigit === "0" );
}

/*
* Question 7: Palindrome
*/
function isPalindrome(str, caseSensitive = false) {
	let strLen = str.length;
	let halfLen = Math.floor( strLen / 2);
	let firstHalf = str.substr( 0, halfLen );
	let secondHalf = str.substr(halfLen  + (strLen % 2) ).split("").reverse().join("");

	if ( caseSensitive === false ) {
		firstHalf = firstHalf.toLowerCase();
		secondHalf = secondHalf.toLowerCase();
	}

	return ( firstHalf === secondHalf );
}

/*
* Question 8: Print Shape
*/
Shape = {
	type: null,
	height: null,
	character: "*",

	setType: function( type ) {
		this.type = type.toLowerCase();
		return this;
	},
	setHeight: function( height ) {
		this.height = height;
		return this;
	},
	setCharacter: function( char ) {
		this.character = char.substr(0,1);
		return this;
	},
	display: function() {
		switch( this.type ) {
			case "triangle" :
				this.displayTriangle();
				break;
			case "square" :
				this.displaySquare();
				break;
			case "diamond" :
				this.displayDiamond();
				break;

		}
	},
	displayTriangle: function() {
		let width = 1;
		let line = [];

		for( let i = 0; i < this.height; i++ ) {
			line.length = 0;

			for( let j = 0; j < width; j++ ) {
				line.push( this.character );
			}

			console.log( line.join("") );
			width += 2;
		}
	},
	displaySquare: function() {
		let line = [];

		for(let i = 0; i < this.height; i++ ) {
			line.push( this.character );
		}

		for( let j = 0; j < this.height; j++ ) {
			console.log( line.join("") );
		}
	},
	displayDiamond: function() {
		let halfWidth = Math.floor( this.height / 2);
		let spaces = halfWidth;
		let line = [];

		for(let i = 0; i <= halfWidth; i++ ) {
			line.length = 0;

			for(let j = 0; j < halfWidth; j++ ) {
				if ( j < spaces ) {
					line.push(" ");
				} else {
					line.push( this.character );
				}
			}
			spaces--;

			if ( (this.height % 2) > 0 ) {
				console.log( line.join("") + this.character + line.reverse().join("") );
			} else {
				console.log( line.join("") + line.reverse().join("") );
			}
			
		}

		if ( (this.height % 2) === 0 ) {
			spaces++;
		} else {
			spaces+=2;
		}

		for(let i = 1; i <= halfWidth; i++ ) {
			line.length = 0;

			for(let j = 0; j < halfWidth; j++ ) {
				if ( j < spaces ) {
					line.push(" ");
				} else {
					line.push( this.character );
				}
			}

			spaces++;

			if ( (this.height % 2) > 0 ) {
				console.log( line.join("") + this.character + line.reverse().join("") );
			} else {
				console.log( line.join("") + line.reverse().join("") );
			}
			
		}


	},
	calculateInitial: function(value) {
		return Math.floor( value / 2) + ( value % 2);
	}
};

function printShape(type, height, character ) {
	Shape
		.setType(type)
		.setHeight(height)
		.setCharacter(character)
		.display();
}



/*
* Question 9: Object Literal
*/
function traverseObject( object ) {
	for( prop in object) {
		console.log(`Object.${prop} = ${object[prop]}`);
	}
}


/*
* Question 10: Delete Element
*/
function deleteElement( someArr ) {
	delete someArr[2];
	return someArr;
}

/*
* Question 11: Splice Element
*/
function spliceElement( someArr ) {
	return someArr.splice(2, 1);
}

/*
* Question 12: Object Function Constructor
*/
function Person(name, age) {
	this.name = name;
	this.age = age;
}

/*
* Question 13: Object Literal
*/
function getPerson(name, age) {
	return {
		name: name,
		age: age,
	};
}