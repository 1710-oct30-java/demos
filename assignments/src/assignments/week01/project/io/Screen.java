package assignments.week01.project.io;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen 
{
	private static Screen instance = new Screen();
	
	
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
		super();
	}
	
	/**
	 * return width of the screen
	 * 
	 * @return int
	 */
	public int getWidth()
	{
		return this.getDimensions().width;
	}
	
	/**
	 * return height of screen
	 * 
	 * @return int
	 */
	public int getHeight()
	{
		return this.getDimensions().height;
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
	
	/**
	 * get the Dimension object to get the current size of
	 * the console screen
	 * 
	 * @return Dimension
	 */
	private Dimension getDimensions()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

}
