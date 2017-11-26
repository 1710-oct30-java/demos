// Purpose: This file forms the root for all of the other JS files.
// It checks to see if a given module has been loaded before running the root function in each of them.

window.onload = init;

function init()
{
    if(loginjs)
    {
        loginjs();
    }

    if(navbarjs)
    {
        navbarjs();
    }
}

