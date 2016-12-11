	package observer;

	/**
	 * @author: KOMA NIANFO LOEW
	 * @version : 1.0
	 */
public interface Observable {
	/**
	 * addObserver
	 * @param obs
	 */
	public void addObserver(Observer obs);
	/**
	 * 
	 */
	public void removeObserver();
	/**
	 * notifyObserver:
	 * @param str
	 */
	public void notifyObserver(String str);
}
