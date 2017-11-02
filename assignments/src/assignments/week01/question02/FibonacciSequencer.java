package assignments.week01.question02;

import java.util.LinkedList;

/**
 * encapsulates a fibonacci sequence
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class FibonacciSequencer {
	/**
	 * keep track of the last three numbers in the sequence
	 * to be able to determine the next one
	 */
	private LinkedList<Integer> history;
	
	public FibonacciSequencer()
	{
		this.initializeHistory();
	}
	
	/**
	 * remove the first node in the collection
	 * and add the next integer in the sequence as
	 * the new last node
	 * 
	 */
	public void increment() {
//		System.out.println( this.history );
		this.history.remove(0);
		
		if ( this.history.getLast() < 1 ) {
			this.history.add(1);
		} else {
			this.history.add( this.sumOfHistory() );
		}
	}
	
	public int getCurrent()
	{
		return this.history.getLast();
	}
	
	private Integer sumOfHistory()
	{
		return this.history.stream().mapToInt( number -> number ).sum();
	}
	
	/**
	 * prepare the history buffer for initial use
	 */
	private void initializeHistory()
	{
		this.history = new LinkedList<>();
		
		this.history.add(0);
		this.history.add(0);
		this.history.add(0);
	}
}
