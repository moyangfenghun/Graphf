package snakedemo;

import gamedemo.role;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class snakegame extends JPanel  implements Runnable{
	rolesnake snake;
	boolean life=true,eat=false,start=false;
	int length,direction,enint=1,lv=1,i=4;
	roesfood newroesfood=new roesfood();
	hinder hin[]=new hinder[6];
	//初始化蛇
	public snakegame(){
		
		rolesnake first=new rolesnake();
		first.setAxisx(280);
		first.setAxisy(230);
		first.part=1;
		snake=first;
		rolesnake second=new rolesnake();
		second.setAxisx(300);
		second.setAxisy(230);
		second.part=2;
		snake.next=second;
		second.last=snake;
		length=2;
		direction=4;
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
		Graphics2D gs=(Graphics2D)g;
		setBackground(Color.white);
		actiongeme enActiongeme=new actiongeme();
		
		
		enActiongeme.environmentjude(gs,enint,hin,i);
		if(newroesfood.life){
			if(i%3==0){
			 enActiongeme.drawfood(newroesfood,gs,enint);
			}
		}
		traverse(gs);//绘制蛇
		if(life){
		}else{
			enActiongeme.gameover(gs);//绘制结束标画面
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub	
		while (true) {
			System.out.print("");
			if(life){
			actiongeme snakeAction=new actiongeme(snake,newroesfood);
			snakeAction.createfood(length,hin);
			i++;
			int lvs=5-lv;
			if(i%lvs==lvs-1){
			if (start) {
				this.delive();//移动蛇身
				snakeAction.directionaction(direction,hin);//控制蛇头移动
				
			}
			
			int jude[],hlv=lv*2+4;
			jude=snakeAction.foodjude(enint);
			enint=jude[1];
			hin=snakeAction.createenvir(length, enint,hlv,hin);
			
			if(jude[0]==2){
				addnode();//添加长度
				//改变速度
				if(length%12==0){
					if(lv==4){
					}else{
					lv++;
					}
				}
			}
			life=snakeAction.lifejude(life,length,hin);
			}
			
			
			try {
				Thread.sleep(100);
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}
	//添加蛇节点
	public void addnode(){
		rolesnake newnode=new rolesnake();
		rolesnake endnode=new rolesnake();
		endnode=snake;
		int loop=1;
		while (loop<length) {
			loop++;
			endnode=endnode.next;
		}
		newnode.Axisx=endnode.Axisx;
		newnode.Axisy=endnode.Axisy;
		newnode.part=endnode.part+1;
		endnode.next=newnode;
		newnode.last=endnode;
		length++;
	}
	//蛇身的移动
	public void delive(){
		rolesnake de=this.endnode();
		rolesnake second=new rolesnake();
		int l=1;
		while(l<length){
			l++;
			if(eat){
				if(de.part==length){
					de=de.last;
				}else{
				second=de;
				de=de.last;
				second.Axisx=de.Axisx;
				second.Axisy=de.Axisy;
				}
			}else{
				second=de;
				de=de.last;
				second.Axisx=de.Axisx;
				second.Axisy=de.Axisy;
			}
			
		}
		
	}
	//蛇的尾节点
	public rolesnake endnode(){
		rolesnake endnode=new rolesnake();
		endnode=snake;
		int i=1;
		while(i<length){
			i++;
			endnode=endnode.next;
		}
		return endnode;
	}
	//绘制蛇
	public void traverse(Graphics2D gs){
		int i=0;
		rolesnake endsnake=snake;
		while(i<length){
			i++;
			if(endsnake.part==1){
		    gs.drawImage(endsnake.image,endsnake.Axisx,endsnake.Axisy, null);
		}else{
			gs.drawImage(endsnake.image2,endsnake.Axisx,endsnake.Axisy, null);
		}
		    endsnake=endsnake.next;
		}
	}
	public void resnake(){
		actiongeme act=new actiongeme(snake,newroesfood);
		act.createfood(length,hin);
		hin=new hinder[6];
		rolesnake first=new rolesnake();
		first.setAxisx(280);
		first.setAxisy(230);
		first.part=1;
		snake=first;
		rolesnake second=new rolesnake();
		second.setAxisx(300);
		second.setAxisy(230);
		second.part=2;
		snake.next=second;
		second.last=snake;
		length=2;
		direction=4;
	}
}