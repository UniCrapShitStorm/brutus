
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		class Timer extends Thread{
			public Timer(){
				this.setDaemon(true);
			}
		
			public void run(){
				while(true)
				{
					try{
						
						this.sleep(1000);
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					System.out.println("Timeout");
				}
			}
		}
		new Timer().start();
		
		while(true)
			;

	}
	
	
}