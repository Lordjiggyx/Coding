
public class ProducerConsumerTest {
   public static void main(String[] args) {
      CubbyHole c = new CubbyHole();
      MyProducer p1 = new MyProducer(c, 1);
      MyConsumer c1 = new MyConsumer(c, 2);
      p1.start(); 
      c1.start();
   }
}

class CubbyHole {
   private int contents;
   private boolean available = false;
   
   public synchronized int get() {
      while (available == false) {
         try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
      available = false;
      notifyAll();
      return contents;
   }
   
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         }
         catch (InterruptedException e) { 
         } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}

class MyConsumer extends Thread {
   private CubbyHole cubbyhole;
   private int number;
   public MyConsumer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   }
   public void run() {
      int value = 0;
         for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
         }
   }
}

class MyProducer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public MyProducer(CubbyHole c, int number) {
		cubbyhole = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			cubbyhole.put(i);
			System.out.println("Producer #" + this.number + " put: " + i);
			try {
				sleep((int)(Math.random() * 100));
			} 
			catch (InterruptedException e) { }
		}
	}
}