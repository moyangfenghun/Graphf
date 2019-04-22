package snakedemo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class rolesnake {
	public int part=0,Axisx,Axisy;
	public Image image=new ImageIcon("image/sbake.png").getImage(),
			image2=new ImageIcon("image/sbake2.png").getImage();
	public rolesnake last,next;

	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getAxisx() {
		return Axisx;
	}
	public void setAxisx(int axisx) {
		Axisx = axisx;
	}
	public int getAxisy() {
		return Axisy;
	}
	public void setAxisy(int axisy) {
		Axisy = axisy;
	}
	public rolesnake getHead() {
		return last;
	}
	public void setHead(rolesnake head) {
		this.last = head;
	}
	public rolesnake getOffal() {
		return next;
	}
	public void setOffal(rolesnake offal) {
		this.next = offal;
	}
	
}
