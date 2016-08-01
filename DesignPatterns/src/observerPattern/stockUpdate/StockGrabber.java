package observerPattern.stockUpdate;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

	List<Observer> observerList;
	private double ibmPrice, applPrice, googPrice;

	public StockGrabber() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void unregisterObserver(Observer observer) {
		System.out.println(observerList.indexOf(observer)+1 + " removed");
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observerList) {
			o.update(ibmPrice, applPrice, googPrice);
		}
	}

	public void setIbmPrice(double newIbmPrice) {
		ibmPrice = newIbmPrice;
		notifyObservers();
	}

	public void setApplPrice(double newApplPrice) {
		applPrice = newApplPrice;
		notifyObservers();
	}

	public void setGoogPrice(double newGoogPrice) {
		googPrice = newGoogPrice;
		notifyObservers();
	}

}
