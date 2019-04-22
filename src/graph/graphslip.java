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
		
//��������*******************************
		setTitle("��ɫ��");
//jlabel���,jslider���*****************
		this.palettejlabel(sr, sg, sb);
		add(colorJLabel);
		//�����������--��
		this.slidermoveListener(50,50,Color.red);
		//�����������--��
		this.slidermoveListener(150,50,Color.green);
		//�����������--��
		this.slidermoveListener(250,50,Color.blue);		
	}
	//�����ƶ���������---������ı���ɫ
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
	//�����������
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
	//��ɫ���ʼ������
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