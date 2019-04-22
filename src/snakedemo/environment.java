package snakedemo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class environment {
	private int walltop=30,wallleft=0,wallright=620,walldown=470;
	private Image image=new ImageIcon("image/cjstart.jpg").getImage(),
			image2=new ImageIcon("image/cj1.jpg").getImage(),
			image3=new ImageIcon("image/cj2.jpg").getImage();
	roesfood food[]={new roesfood()};
	hinder der[]={new hinder()};
	public environment() {
		// TODO Auto-generated constructor stub
	}
	public int getWalltop() {
		return walltop;
	}
	public Image getImage2() {
		return image2;
	}

	public Image getImage3() {
		return image3;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setWalltop(int walltop) {
		this.walltop = walltop;
	}

	public int getWallleft() {
		return wallleft;
	}

	public void setWallleft(int wallleft) {
		this.wallleft = wallleft;
	}

	public int getWallright() {
		return wallright;
	}

	public void setWallright(int wallright) {
		this.wallright = wallright;
	}

	public int getWalldown() {
		return walldown;
	}

	public void setWalldown(int walldown) {
		this.walldown = walldown;
	}
	
	
	
}
