package edu.my;

public class Threads {

	public static void main(String args[]) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();

		///////////////////////////////////////////////////

		System.out.println(Thread.currentThread().getName());
		HelloRunnable helloRunnable = new HelloRunnable();
		Thread t1 = new Thread(helloRunnable);
		// t1.start();
		// Thread.sleep(4);
		// t.interrupt();

		HelloThread helloThread = new HelloThread();
		helloThread.join();
		// helloThread.start();

		///////////////////////////////////////////////////

		// Delay, in milliseconds before
		// we interrupt MessageLoop
		// thread (default one hour).
		long patience = 10 * 60;

		// If command line argument
		// present, gives patience
		// in seconds.
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argument must be an integer.");
				System.exit(1);
			}
		}

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop
		// thread exits
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			// Wait maximum of 1 second
			// for MessageLoop thread
			// to finish.
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// Shouldn't be long now
				// -- wait indefinitely
				t.join();
			}
		}
		threadMessage("Finally!");
	}

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}

		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
		}
	}

	// Display a message, preceded by
	// the name of the current thread
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
					"A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					if (Thread.interrupted())
						System.out.println("i am being interrupted");
					// Pause for 4 seconds
					Thread.sleep(4000);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}
}

class HelloRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.print("Hello Runnable" + i + " ");
			if (Thread.interrupted()) {
				System.out.println("interuprted - no more execution");
				return;
			}
		}
	}
}

class HelloThread extends Thread {

	@Override
	public void run() {
		System.out.println("\nHello Thread ");
	}

}