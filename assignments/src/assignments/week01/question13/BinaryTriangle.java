package assignments.week01.question13;

/**
 * represents a binary triangle
 * 
 * @author john.w.brown.jr@gmail.com
 */
public class BinaryTriangle {
	public int height;		// number of lines used to print triangle
	private int phase;		// an abstract dimension of the triangle state
	private String current; // holds the current string to use to draw
	
	public BinaryTriangle()
	{
		this.height = 1; // default height when none is specified
		this.phase = 1; // must be 1 for the design to work as specified
		this.current = "0"; // first character
	}
	
	/**
	 * @return String
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < this.height; i++ ) {
			
			if ( (sb.length() % 2) == 0 ) {
				sb.append( this.current );
			} else {
				sb.insert(0, this.current );
			}
			
			this.advance();
			
			output.append( sb ).append("\n");
		}
		
		return String.valueOf( output );
	}
	
	/**
	 * advances triangle state to determine what
	 * character will be used next
	 */
	private void advance()
	{
		if ( this.phase == 0 ) {
			this.phase++;
		} else {
			this.phase = 0;
			this.toggleCurrentCharacter();
		}
	}
	
	/**
	 * toggles the character used by the triangle
	 * between a 1 or 0
	 */
	private void toggleCurrentCharacter()
	{
		if ( this.current == "0" ) {
			this.current = "1";
		} else {
			this.current = "0";
		}
	}
}
