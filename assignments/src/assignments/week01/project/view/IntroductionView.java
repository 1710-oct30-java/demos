package assignments.week01.project.view;

import assignments.week01.project.bretty.console.view.MenuView;

/**
 * initial view
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class IntroductionView extends MenuView 
{
	public IntroductionView()
	{
		super("Welcome to Console Banking", "Login");
		
		this.menuItems.add( new Login() );
	}
}
