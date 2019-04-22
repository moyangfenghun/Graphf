package graph;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;



public class windowstemplate extends JFrame{
	public windowstemplate(){
		
		setSize(800,500);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				int closexx=JOptionPane.showConfirmDialog(null, "确定退出？", "退出", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(closexx==0){
					System.exit(0);
				}else {
				}
			}
		});
	}
	
}
