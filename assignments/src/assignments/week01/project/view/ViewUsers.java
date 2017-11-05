package assignments.week01.project.view;

import assignments.week01.project.Session;
import assignments.week01.project.bean.User;
import assignments.week01.project.bretty.console.view.ActionView;
import assignments.week01.project.db.adapter.UsersTableAdapter;

/**
 * view for displaying a list of system users
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class ViewUsers extends ActionView
{
	public ViewUsers( )
	{
		super( "All System Users", "View Users");
		
	}

	@Override
	public void executeCustomAction() {

		User currentUser = (User)Session.getInstance().retrieve("user");
		
		this.println();
		this.println("ID  NAME            TYPE            STATUS   C");
		this.println("===============================================");
		
		for(User user: UsersTableAdapter.getInstance().getAll() ) {
			String line = String.format("%03d %-15s %-15s %-8s %s", 
				user.id,
				user.identity,
				( user.type == User.TYPE_ADMIN) ? "Administrator" : "Normal",
				( user.status == User.STATUS_ACTIVE ) ? "ACTIVE" : "INACTIVE",
				( user.id == currentUser.id ) ? "Y" : " "
			);
			
			this.println( line );
		}
		
		this.pause();
		
	}
	
}
