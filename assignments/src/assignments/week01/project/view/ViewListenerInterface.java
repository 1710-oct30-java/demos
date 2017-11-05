package assignments.week01.project.view;

/**
 * the contract for all objects that listen
 * to view events
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public interface ViewListenerInterface 
{
	/**
	 * perform some action upon a triggered event
	 * 
	 * @param String event
	 * @param String caller
	 */
	public void listen(String event, Object data);
	
}
