import demo.DemoPlatform;
import demo.arjun.Arjun;
import demo.kushal.Kushal;
import demo.siddharth.Siddharth;
import ecomm.Platform;
import ecomm.Seller;
import java.util.*;
public class PlatformMain {
// this is our platform main class , entry point is here
	public static void main(String[] args) {
		// creates a new demo platform and adds 3 types of sellers arjun,kushal and siddharth
		Platform pf = new DemoPlatform();  // replace with appropriate derived class
		Seller arjun=new Arjun("Seller1");
		arjun.addPlatform(pf);
		Seller kushal=new Kushal("Seller2");
		kushal.addPlatform(pf);
		Seller siddharth=new Siddharth("Seller3");
		siddharth.addPlatform(pf);
		TimerTask timerTask = new TimerTask() {
			public void run() {
				pf.processRequests();
			}
		};
		new Timer().scheduleAtFixedRate(timerTask, 0, 60*100);
	}
}
