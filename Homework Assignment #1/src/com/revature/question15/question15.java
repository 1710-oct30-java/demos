package com.revature.question15;

class question15 implements NewInterface
{
	//this adds the two integer parameters
	@Override
	public int add (int i, int j) {
		
		return i + j;
		
	}
	@Override
	//subtracts the two integer parameters
	public int subtract (int i, int j) {
		return i-j;
	}
    @Override
	public int multiplication ( int i, int j) {
		return i * j;
		
		
	}
	@Override
	public int division ( int i, int j) {
		return i/j;
		
		
	}

}
