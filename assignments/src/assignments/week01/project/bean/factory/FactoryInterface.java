package assignments.week01.project.bean.factory;

import java.util.Map;

/**
 * contract for all factory classes
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public interface FactoryInterface<T> {

	/**
	 * creates an instance
	 * 
	 * @param Map<String, String> data
	 * 
	 * @return T
	 */
	public T create( Map<String, String> data );
}
