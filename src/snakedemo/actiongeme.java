package snakedemo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.rmi.server.RMIClassLoader;

import javax.swing.ImageIcon;

public class actiongeme {
	rolesnake snake;
	roesfood food;
	Image image=new ImageIcon("image/gameover.png").getImage();
	public actiongeme(){
		
	}
	public actiongeme(rolesnake snake,roesfood food){
		this.snake=snake;
		this.food=food;
	}
	//控制蛇头的移动
	public void directionaction(int direction,hinder hin[]){
		int i=0;
		
		while (i<hin.length) {
			if(hin[i]==null){
				break;
			}else{
			    if(hin[i].life){
			    }else{
				    if(snake.Axisx==hin[i].Axisx&&snake.Axisy==hin[i].Axisy){
				    	if(i%2==0){
				    		snake.Axisx=hin[i+1].Axisx;
				    		snake.Axisy=hin[i+1].Axisy;
				    		hin[i].life=true;
				    		hin[i+1].life=true;
				    		break;
				    	}else{
				    		snake.Axisx=hin[i-1].Axisx;
				    		snake.Axisy=hin[i-1].Axisy;
				    		hin[i].life=true;
				    		hin[i-1].life=true;
				    		break;
				    	}
				    }
			    }
			}
			i++;
		}
		switch (direction) {
		case 1:
			snake.Axisy-=20;
			break;
		case 3:
			snake.Axisy+=20;
			break;
		case 4:
			snake.Axisx-=20;
			
			break;
		case 2:
			snake.Axisx+=20;
			break;
			
		default:
			break;
		}
	}
	//判断蛇是否存活
	public boolean lifejude(boolean life,int length,hinder hin[]){
		int m=0;
		
		environment wall=new environment();
		rolesnake em=snake;
		if(snake.Axisx==(wall.getWallleft()-20)){
			life=false;	
		}if(snake.Axisy==(wall.getWalltop()-20)){
			life=false;
		}
		if(snake.Axisx==(wall.getWallright()+20)){
			life=false;	
			
		}if(snake.Axisy==wall.getWalldown()){
			life=false;
			
		}
		while(m<length){
			m++;
			if(m==1){
				continue;
			}
			em=em.next;
			if(snake.Axisx==em.Axisx&&snake.Axisy==em.Axisy){
				life=false;
			}
		}
		m=0;
		while (m<hin.length) {
			if(hin[m]==null){
				
			}else{
				if(hin[m].kind==1){
					if(snake.Axisx==hin[m].Axisx&&snake.Axisy==hin[m].Axisy){
						life=false;
					}
				}else {
					if(snake.Axisx==hin[m].Axisx&&snake.Axisy==hin[m].Axisy){
						if(m==0||m==1){
							hin[0].life=false;
							hin[1].life=false;
						}
						if(m==2||m==3){
							hin[2].life=false;
							hin[3].life=false;
						}
						if(m==4||m==5){
							hin[4].life=false;
							hin[5].life=false;
						}
						if(m==6||m==7){
							hin[6].life=false;
							hin[7].life=false;
						}
					}
				}
			}
			m++;
		}
		
		return life;
	}
	//食物判定
	public int[] foodjude(int enint){
		int i[]={1,0},oldenint=enint;
		if(food.Axisx==snake.Axisx&&food.Axisy==snake.Axisy){
			if(food.kind==1){
				enint=(int) (Math.random()*3+1);
				while(true){
					if(oldenint==enint){
						enint=(int) (Math.random()*3+1);
					}else{
						break;
					}
				}
			}
			food.life=false;
			i[0]=2;
			
		}
		i[1]=enint;
		return i;
	}
	
	
	public void createfood(int length,hinder hin[]){
		int x[]=new int[31],i=0,h=0,w=0,y[]=new int[22];
		hinder meHinder[]=new hinder[hin.length+length];
		while (w<(hin.length+length)) {
			meHinder[w]=new hinder();
			w++;
		}
		
		rolesnake huan=snake;
		if(food.life){
		}else
		{
		while (i<620) {
			x[h]=i;
			h++;
			i+=20;
		}
		i=0;
		h=0;
		while (i<440) {
			y[h]=i;
			h++;
			i+=20;
		}
		i=(int) (Math.random()*31);
		h=(int) (Math.random()*22);
		w=0;
		while(w<length){
			meHinder[w].Axisx=huan.Axisx;
			meHinder[w].Axisy=huan.Axisy;
			w++;
		    huan=huan.next;
		}
		if(hin[0]==null){
			w=0;
			while(w<length){
				if(x[i]==meHinder[w].Axisx&&(y[h]+30)==meHinder[w].Axisy){
					i=(int) (Math.random()*31);
					h=(int) (Math.random()*22);
					w=0;
				}else {
					w++;
				}	
			}
		}else{
			while (w<hin.length) {
				meHinder[w].Axisx=hin[w-length].Axisx;
				meHinder[w].Axisy=hin[w-length].Axisy;
				w++;
			}
			w=0;
			while(w<(length+hin.length)){
				
				if(x[i]==meHinder[w].Axisx&&(y[h]+30)==meHinder[w].Axisy){
					i=(int) (Math.random()*31);
					h=(int) (Math.random()*22);
					w=0;
				}else {
					w++;
				}
			}
			
		}
		food.Axisx=x[i];
		food.Axisy=y[h]+30;
		food.life=true;
		food.kind=(int) (Math.random()*3);
		}
	}
	
	public void drawfood(roesfood food,Graphics2D gs,int enint) {
		if(food.kind==0||food.kind==2){
			if(enint==1||enint==2){
				gs.drawImage(food.image,food.Axisx, food.Axisy, null);
			}else{
				gs.drawImage(food.image2,food.Axisx, food.Axisy, null);
			}
		}
		if(food.kind==1){
			gs.drawImage(food.image3,food.Axisx, food.Axisy, null);
		}
	}
	//绘制环境
	public void environmentjude(Graphics2D gs,int enint,hinder hin[],int id){
		environment EN=new environment();
		if(enint==1){
			gs.drawImage(EN.getImage(), 0,30, null);
		}
		if(enint==2){
			gs.drawImage(EN.getImage2(), 0,30, null);
			int i=0;
			if(hin[i]==null){
				
			}else{
				while (i<hin.length) {
					gs.drawImage(hin[i].zaiImage,hin[i].Axisx,hin[i].Axisy, null);
					i++;
				}
			}
		
		}
		if(enint==3){
			gs.drawImage(EN.getImage3(), 0,30, null);
			if(id%15==0)
			{	
			}else {
				int i=0;
				if(hin[i]==null){
					
				}else{
					while (i<hin.length) {
						gs.drawImage(hin[i].zaiImage2,hin[i].Axisx,hin[i].Axisy, null);
						i++;
					}
				}
			}
			
		}
		
		
	}
	public void gameover(Graphics2D gs) {
		gs.drawImage(image,0,30, null);
	}
	//产生障碍
	public hinder[] createenvir(int length,int enint,int lv,hinder hin[]) {
		int x[]=new int[31],y[]=new int[22],i=0,h=0,w=0,wo=0,ww=0;
		rolesnake huan=snake;
		while (i<620) {
			x[h]=i;
			h++;
			i+=20;
		}
		i=0;
		h=0;
		while (i<440) {
			y[h]=i;
			h++;
			i+=20;
		}
		if(food.life){
		}else{
			if(food.kind==1){
				
				if(enint==2){
					hin=new hinder[lv];
					while (wo<lv) {
						hinder newHinder=new hinder();
						i=(int) (Math.random()*31);
						h=(int) (Math.random()*22);
						while(w<length){
							w++;
						if((x[i]==huan.Axisx&&(y[h]+30)==huan.Axisy)) {
							i=(int) (Math.random()*31);
							h=(int) (Math.random()*22);
							huan=snake;
							w=0;
						}else{
							ww=0;
							while (ww<wo) {
								if(x[i]==hin[ww].Axisx&&(y[h]+30)==hin[ww].Axisy){
									i=(int) (Math.random()*31);
									h=(int) (Math.random()*22);
									huan=snake;
									w=0;
								}
								ww++;
							}
							
						}
						if(w==0){
							
						}else {
							huan=huan.next;
						}
						}
						newHinder.Axisx=x[i];
						newHinder.Axisy=y[h]+30;
						newHinder.kind=1;
						newHinder.life=true;
						hin[wo]=newHinder;
						wo++;
					}
					
				}else{
					if(enint==3){
						hin=new hinder[lv-4];
						while (wo<lv-4) {
							hinder newHinder=new hinder();
							i=(int) (Math.random()*31);
							h=(int) (Math.random()*22);
							while(w<length){
								w++;
							if(x[i]==huan.Axisx&&(y[h]+30)==huan.Axisy) {
								i=(int) (Math.random()*31);
								h=(int) (Math.random()*22);
								huan=snake;
								w=0;
							}else{
								ww=0;
								while (ww<wo) {
									if((x[i]==hin[ww].Axisx&&(y[h]+30)==hin[ww].Axisy)){
										i=(int) (Math.random()*31);
										h=(int) (Math.random()*22);
										huan=snake;
										w=0;
									}
									ww++;
								}
							}
							if(w==0){
								
							}else {
								huan=huan.next;
							}
							}
							newHinder.Axisx=x[i];
							newHinder.Axisy=y[h]+30;
							newHinder.kind=2;
							newHinder.life=true;
							hin[wo]=newHinder;
							wo++;
						}
					}else{
						hin=new hinder[lv];
					}
					
			    }
			}
		}
		return hin;
	}
}
