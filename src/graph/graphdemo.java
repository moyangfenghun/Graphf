package graph;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class hei{
  static void asd(){
	    
	}
}


public class graphdemo {
	public static void main(String []args){
		File file1 =new File("music/bgmusic.wav"); 
		URL url;
		try {
			url = file1.toURL();
			AudioClip sound1 = Applet.newAudioClip(url); 
			sound1.play();
			System.out.print(url);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//sound1.loop();hhnhh
		//sound1.stop();
	}
}
