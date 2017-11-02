package com.revature.launcher;

import com.revature.scopes.Scopes;

public class Launcher {
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		
		Scopes scope = new Scopes();
		scope.instanceLevel = 10;
		scope.classLevel = 10;
		
		Scopes otherScopeObject = new Scopes();
		System.out.println("instance level: "+otherScopeObject.instanceLevel);
		System.out.println("class level: " + otherScopeObject.classLevel);
		
		int i = 5;
		scope.myMethod(i);
		System.out.println("after method " + i);
	}

}
