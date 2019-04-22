package graph;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class graphslip extends windowstemplate {
	private int sr=0,sg=0,sb=0;
	JLabel  colorJLabel=new JLabel();
	
	public graphslip() {
		
//窗口设置*******************************
		setTitle("调色板");
//jlabel组件,jslider组件*****************
		this.palettejlabel(sr, sg, sb);
		add(colorJLabel);
		//监听滑块组件--红
		this.slidermoveListener(50,50,Color.red);
		//监听滑块组件--绿
		this.slidermoveListener(150,50,Color.green);
		//监听滑块组件--蓝
		this.slidermoveListener(250,50,Color.blue);		
	}
	//滑块移动监听方法---利滑块改变颜色
	public void slidermoveListener(int x,int y,Color c){
		JSlider jSlider=this.jslider(x,y,c);
		if(Color.red==c){
			jSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider jss=(JSlider)e.getSource();
				
				sr=jss.getValue();
				Color smecc=new Color(sr,sg,sb);
				colorJLabel.setBackground(smecc);
			}
		});
		}if(Color.green==c){
			jSlider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					JSlider jss=(JSlider)e.getSource();
					
					sg=jss.getValue();
					Color smecc=new Color(sr,sg,sb);
					colorJLabel.setBackground(smecc);
				}
			});
		}if(Color.blue==c){
			jSlider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					JSlider jss=(JSlider)e.getSource();
					
					sb=jss.getValue();
					Color smecc=new Color(sr,sg,sb);
					colorJLabel.setBackground(smecc);
				}
			});
		}
		
	}
	//滑块组件方法
	 public JSlider jslider(int x,int y,Color eColor){
		JSlider colorJSlider=new JSlider(SwingConstants.VERTICAL,0,255,0);
		colorJSlider.setMajorTickSpacing(15);
		colorJSlider.setMinorTickSpacing(5);
		colorJSlider.setPaintLabels(true);
		colorJSlider.setPaintTicks(true);
		colorJSlider.setOpaque(true);
		colorJSlider.setBackground(eColor);
		colorJSlider.setBounds(x, y,60, 400);
		add(colorJSlider);
		return colorJSlider;
	}
	//颜色板初始化方法
	public void palettejlabel(int r,int g,int b){
		Color paletteColor=new Color(r,g,b);
		colorJLabel.setBounds(450,100,200, 250);
		colorJLabel.setBackground(paletteColor);
		colorJLabel.setOpaque(true);
	}
	
	public static void main(String agrs[]){
		new graphslip();
	}
}