package snakedemo;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import graph.windowstemplate;

public class showgame extends windowstemplate {
	public showgame(){
		//final JDesktopPane desktopPane=new JDesktopPane();
		//desktopPane.setOpaque(false);
		setTitle("贪吃蛇");
		final snakegame js=new snakegame();
		js.setFocusable(true);
		Runnable runnable=js;
		Thread thread=new Thread(runnable);
		thread.start();	
		js.setLayout(new BorderLayout());
		
		JToolBar toolBar=new JToolBar();
		toolBar.setFloatable(false);

		final JButton start=new JButton("开始");
		final JButton stop=new JButton("暂停");
		JButton reset=new JButton("重置");
		//JButton option=new JButton("设置");
		
		stop.setEnabled(false);
		
		JPanel ePanel=new JPanel();
		ePanel.setLayout(null);
		ePanel.setPreferredSize(new Dimension(150,440));
		Color bgColor=new Color(100, 149, 254);
		Color fsColor=new Color(200, 200, 200);
		ePanel.setBackground(bgColor);
		
		JLabel goal=new JLabel("得分");
		JLabel level=new JLabel("等级");
		final JLabel fsjl=new JLabel("排行：");
		final JLabel fs1=new JLabel("");
		final JLabel fs2=new JLabel("");
		final JLabel fs3=new JLabel("");
		
		final JTextField goaltext=new JTextField();
		final JTextField leveltext=new JTextField();
		
	
		goal.setBounds(20, 50, 28, 30);
		level.setBounds(20, 100,28, 30);
		fsjl.setOpaque(true);
		fsjl.setBackground(fsColor);
		fsjl.setBounds(20,160, 100,20);
		fs1.setOpaque(true);
		fs1.setBackground(fsColor);
		fs1.setBounds(20,180, 100,30);
		fs2.setOpaque(true);
		fs2.setBackground(fsColor);
		fs2.setBounds(20,210, 100,30);
		fs3.setOpaque(true);
		fs3.setBackground(fsColor);
		fs3.setBounds(20,240, 100,30);
		
		
		goaltext.setEditable(false);
		goaltext.setBounds(50, 50, 70, 30);
		leveltext.setEditable(false);
		leveltext.setBounds(50, 100, 70, 30);
		leveltext.setText("         "+js.lv);
		
		
		ePanel.add(goal);
		ePanel.add(level);
		ePanel.add(goaltext);
		ePanel.add(leveltext);
		ePanel.add(fsjl);
		ePanel.add(fs1);
		ePanel.add(fs2);
		ePanel.add(fs3);
		
		
		toolBar.add(start);
		toolBar.add(stop);
		toolBar.add(reset);
		//toolBar.add(option);
		
		js.add(toolBar,BorderLayout.NORTH);
		js.add(ePanel,BorderLayout.EAST);
		//js.add(desktopPane,BorderLayout.CENTER);
		add(js);
		js.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method 
				
				int key=e.getKeyCode();
				final int up=KeyEvent.VK_UP,down=KeyEvent.VK_DOWN,left=KeyEvent.VK_LEFT,right=KeyEvent.VK_RIGHT,space=KeyEvent.VK_SPACE;
				switch (key) {
				case up:
					if(js.direction==1){
					}else{
						if(js.direction==3){
							
						}else{
						   js.direction=1;
						}
					}
					break;
				case down:
					if(js.direction==3){
					}else{
						if(js.direction==1){
							
						}else{
							js.direction=3;
						}
					}
					break;
				case left:
					if(js.direction==4){
					}else{
						if(js.direction==2){
							
						}else{
							js.direction=4;
						}
					}
					break;
				case right:
					if(js.direction==2){
					}else{
						if(js.direction==4){
							
						}else{
							js.direction=2;
						}
					}
					break;
				case space:
					if(js.start){
						start.setEnabled(true);
						stop.setEnabled(false);
						js.start=false;
					}else {
						js.requestFocus();
						start.setEnabled(false);
						stop.setEnabled(true);
						js.start=true;
					}
				default:
					break;
				}
			}
			
		});
		
		js.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				js.requestFocus();
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				js.requestFocus();
				start.setEnabled(false);
				stop.setEnabled(true);
				js.start=true;
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start.setEnabled(true);
				stop.setEnabled(false);
				js.start=false;
				
			}
		});
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop.setEnabled(false);
				start.setEnabled(true);
				js.resnake();
				js.start=false;
				js.enint=1;
				js.life=true;
				repaint();
			}
		});
		/*//final JInternalFrame inter=new JInternalFrame("设置",false,true,false,false);
		//inter.setBounds(210, 120, 200, 100);
		
		
		option.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				desktopPane.add(inter);
				inter.setVisible(true);
				
			}
		});
		*/
		File file=new File("text/fs.text");
		if(!file.exists())   
	    {   
	        try {   
	            file.createNewFile();   
	        } catch (IOException e) {   
	            // TODO Auto-generated catch block   
	            e.printStackTrace();   
	        }   
	    }
		//定时器	
		Timer asTimer1=new Timer();
		asTimer1.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				File file1 =new File("music/bgmusic.wav"); 
				URL url;
				try {
					url = file1.toURL();
					AudioClip sound1 = Applet.newAudioClip(url); 
					sound1.play();
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//sound1.loop();hhnhh
				//sound1.stop();
			}
		},300,34800);

		Timer asTimer=new Timer();
		asTimer.schedule(new TimerTask(){
			
			public void run(){
				int fs=js.length-2;
				goaltext.setText("         "+fs);
				leveltext.setText("         "+js.lv);
				
				
				String oldtexts[]={"","",""};
				File file=new File("text/fs.text");   
			    FileInputStream out;
				try {
					out = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(out);  
		            int tempchar,i=0,m=0,fss[]=new int[3];
		            while ((tempchar = isr.read()) != -1) {
		            	
		            	if(tempchar>=48&&tempchar<=57){
		            		oldtexts[i]=oldtexts[i]+(char)tempchar;
		            		m++;
		            		if(m%4==0){
			            		i++;
			            	}
		            	}
		            	
		            }
		            if(m==0){
		            	String fstext="first"+1000+"second"+1000+"third"+1000;
						byte bt[] = new byte[1024];  
					    bt = fstext.getBytes();
						FileOutputStream in = new FileOutputStream(file);
						in.write(bt, 0, bt.length);  
			            in.close();
			            
		            }else{
		            	i=0;
		            	while (i<3) {
							fss[i]=Integer.parseInt(oldtexts[i]);
		            		i++;
						}
		            	fs1.setText("first:         "+(fss[0]-1000));
		            	fs2.setText("secod:      "+(fss[1]-1000));
		            	fs3.setText("third:         "+(fss[2]-1000));
		            	if(js.life){
		            		
		            	}else{
		            		if((fs+1000)>fss[0]){
					            fss[0]=fs+1000;
					            String fstext="first"+fss[0]+"second"+fss[1]+"third"+fss[2];
								byte bt[] = new byte[1024];  
								bt = fstext.getBytes();
								FileOutputStream in = new FileOutputStream(file);
								in.write(bt, 0, bt.length);  
						        in.close();	
					            }else {
					            	if((fs+1000)>fss[1]&&(fs+1000)<fss[0]){
							            fss[1]=fs+1000;
							            String fstext="first"+fss[0]+"second"+fss[1]+"third"+fss[2];
										byte bt[] = new byte[1024];  
										bt = fstext.getBytes();
										FileOutputStream in = new FileOutputStream(file);
										in.write(bt, 0, bt.length);  
								        in.close();	
							            }else {
							            	if((fs+1000)>fss[2]&&(fs+1000)<fss[1]){
									            fss[2]=fs+1000;
									            String fstext="first"+fss[0]+"second"+fss[1]+"third"+fss[2];
												byte bt[] = new byte[1024];  
												bt = fstext.getBytes();
												FileOutputStream in = new FileOutputStream(file);
												in.write(bt, 0, bt.length);  
										        in.close();	
									            }
										}
								}
			            } 
		            }
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		
			}
		}, 100,1000);
		
		setVisible(true);
	}
	public static void main(String args[]) {
		new showgame();
		
	}
}
