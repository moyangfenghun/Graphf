package graph;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Window;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.w3c.dom.css.RGBColor;


class windowsdemo{
	JFrame testFrame=new JFrame("ͼ�β��Դ���");
	JLabel f=new JLabel("��ʼ",JLabel.CENTER);
	void windowsrun(){
		//��ʼ������ 
		testFrame.setSize(400,300);
		testFrame.setVisible(true);//��ʾ����
		testFrame.setLocationRelativeTo(null);//���ھ���
		testFrame.setResizable(false);//���ڳߴ粻�ɱ�
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����رմ���
		testFrame.setLayout(null);//���ַ�ʽ
		//��������
		//Jlabel����
		JLabel  f2=new JLabel();
		f.setOpaque(true);//jlabel��͸����
		
		Font jFont=new Font("����",Font.BOLD,50);
		f.setFont(jFont);
		FontMetrics metricswh=f.getFontMetrics(jFont);
		
		Date timeDate=new Date();
		timeDate.getTime();
		SimpleDateFormat timess=new SimpleDateFormat("HH:mm:ss");//�������ʹ��?���ָ�ʽת������DecimalFormat

		int widths=metricswh.stringWidth(timess.format(timeDate));//��ȡ�ı��Ŀ��
		int highs=metricswh.getAscent();//��ȡ�ı��ĸ߶�
		f.setBounds((400-widths)/2,(300-highs)/2,widths,highs);
		f.setBackground(new Color(120,143,160));
		testFrame.add(f);
		//ʱ�䣬��ʱ��
		Timer asTimer=new Timer();
		asTimer.schedule(new TimerTask(){
			int  ss=1,k=192,g=62,c=255;
			public void run(){
				ss++;			
				if(ss%2==0){
					for(;g<182;){
					k+=9;
					g+=24;
					c-=47;
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					f.setForeground(new Color(k,g,c));
					}
				}else {
					for(;g>62;){
						k-=9;
						g-=24;
						c+=47;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						f.setForeground(new Color(k,g,c));
					}
				}
                Date timeDate=new Date();
				
				SimpleDateFormat timess=new SimpleDateFormat("HH:mm:ss");//�������͸�ʽ���?���ָ�ʽת������DecimalFormat
				f.setText(timess.format(timeDate));
				}
			
		}, 100,1000);
	}
}
public class graphtest {
	public static void main(String []args){
		new windowsdemo().windowsrun();
	}
}
