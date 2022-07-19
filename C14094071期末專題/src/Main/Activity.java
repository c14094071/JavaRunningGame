package Main;

public class Activity extends Thread{
	GamePanel p;

	public Activity(GamePanel p) {
		this.p = p;
	}
	
	public void run() {
		while(!p.isFinish()) {
			p.repaint();
			try {
				Thread.sleep(p.FRESH);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
