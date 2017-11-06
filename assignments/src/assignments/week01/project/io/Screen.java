package assignments.week01.project.io;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen 
{
	private static Screen instance = new Screen();
	
	private int width;
	private int height;
	
	/**
	 * return singleton instance
	 * 
	 * @return Screen
	 */
	public static Screen getInstance()
	{
		return instance;
	}
	
	private Screen()
	{
		 Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		 this.width = dimensions.width;
		 this.height = dimensions.height;
	}
	
	/**
	 * return width of the screen
	 * 
	 * @return int
	 */
	public int getWidth()
	{
		return this.width;
	}
	
	/**
	 * return height of screen
	 * 
	 * @return int
	 */
	public int getHeight()
	{
		return this.height;
	}
	
	/**
	 * simulates a clearing of the console
	 * by returning lines for the height of
	 * the screen
	 */
	public void clear()
	{
		for(int i = 0; i < this.getHeight(); i++ ) {
			System.out.println("\r\n");
		}
	}

}
