
public class ConsumerTwo implements Runnable {
	ProducerTwo producer;
	ConsumerTwo( ProducerTwo producer ) {
		this.producer = producer;
	}
	
	public void run( ) {
		while ( true ) {
			String message = producer.getMessage( );
			System.out.println("Got message: " + message);
			try {
				Thread.sleep( 2000 );
			} catch ( InterruptedException e ) { }
		}
	}

	public static void main(String args[]) {
		ProducerTwo producer = new ProducerTwo( );
		new Thread( producer ).start( );
		ConsumerTwo consumer = new ConsumerTwo( producer );
		new Thread( consumer ).start( );
	}
}