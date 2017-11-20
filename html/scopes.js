// var is function scoped and let is block scoped
function myFun() {
    
    
        if(true) {
            var a = 5;
            let b = 10;
    
        }
    
        console.log('a = ' + a);
        console.log('b = ' + b);
    }