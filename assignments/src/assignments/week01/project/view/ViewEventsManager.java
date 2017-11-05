package assignments.week01.project.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ViewEventsManager 
{
	private static ViewEventsManager instance = new ViewEventsManager();
	
	private List<ViewListenerInterface> listeners;
	
	/**
	 * returns the singleton instance
	 * 
	 * @return ViewEventsManager
	 */
	public static ViewEventsManager getInstance()
	{
		return instance;
	}
	
	private ViewEventsManager()
	{
		this.listeners = new LinkedList<>();
	}
	
	/**
	 * attach a listener to the event manager
	 * 
	 * @param listener
	 */
	public void attach(ViewListenerInterface listener)
	{
		this.listeners.add( listener );
	}
	
	/**
	 * triggers an event, propagating it to all listeners
	 * 
	 * @param String event
	 * @param ViewListenerInterface caller
	 */
	public void trigger(String event, Object data)
	{
		this.listen( event, data );
	}
	
	/**
	 * propagate all events to all listeners
	 * 
	 * @param String event
	 * @param ViewListenerInterface caller
	 */
	public void listen(String event, Object data )
	{
		/*
		 * << edge case >>
		 * 
		 * have to get a copy of the list first to avoid
		 * ConcurrentModificationExceptions while iterating over
		 * the list, since the behavior of the listeners
		 * could cause new elements to be added to the list
		 * 
		 * Example::
		 * 		MyAccounts views listen for a "person.accounts:updated" event
		 * 		and rebuilds it's menu
		 * 
		 * 		each account view that is added to the MyAccounts menu during
		 * 		the rebuild adds itself to the EventManager as a listener to listen for 
		 * 		their respective "account.transactions:updated" events
		 * 
		 * 		it doesn't matter what is added to the list after the iteration
		 * 		begins, only items that were previously there need to be updated
		 * 		new items are pulling the latest data directly from the data
		 * 		structure anyway during the loop
		 */
		List<ViewListenerInterface> copy = new ArrayList<>();
		copy.addAll( this.listeners );
		copy.stream().forEach( listener -> listener.listen(event, data) );
		
	}
}
