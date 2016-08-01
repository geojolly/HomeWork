package observerPattern.stockUpdate;

public class StockObserver implements Observer {

	private double ibmPrice, applPrice, googPrice;
	private static int observerIdTracker = 0;
	private int observerId;
	private StockGrabber stockGrabber;
	
	 public StockObserver(StockGrabber stockGrabber) {
		this.observerId = ++observerIdTracker;
		this.stockGrabber= stockGrabber;
		stockGrabber.registerObserver(this);
	}
	
	@Override
	public void update(double ibmPrice, double applPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.applPrice = applPrice;
		this.googPrice = googPrice;

		printPrice();
	}

	private void printPrice() {
		System.out.println("Observer id: "+observerId+ "\nibmPrice: " + ibmPrice + "\napplPrice: " + applPrice + "\ngoogPrice: " + googPrice + "\n");

	}

}
