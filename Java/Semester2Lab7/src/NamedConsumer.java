
public class NamedConsumer implements Runnable {
	NamedProducer producer;
	String name;
	
	NamedConsumer(String name, NamedProducer producer) {
		this.producer = producer;
		this.name = name;
	}
	
	public void run( ) {
		while ( true ) {
			String message = producer.getMessage( );
			System.out.println(name + " got message: " + message);
			try {
				Thread.sleep( 2000 );
			} catch ( InterruptedException e ) { }
		}
	}
	
	public static void main(String args[]) {
		// Producer
		NamedProducer producer = new NamedProducer( );
		new Thread( producer ).start( );
		// Consumer 1
		NamedConsumer consumer = new NamedConsumer( "One", producer );
		new Thread( consumer ).start( );
		// Consumer 2
		consumer = new NamedConsumer( "Two", producer );
		new Thread( consumer ).start( );
	}
}