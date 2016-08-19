import java.awt.EventQueue;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

//import java.awt.*;
//import java.awt.Image.*;
//import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Frame1 {

	private JFrame frame;
	private JLabel lblStatus;
	private BufferedImage icon;
	private File selectedFile;
	//private icon Image;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		//frame.setIconImage(icon);
		
		JButton btnImportXml = new JButton("Import XML");
		btnImportXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Hello");
				lblStatus.setText("Status1");
				JFileChooser chooser = new JFileChooser();
				//Scanner in = null;
				int returnVal = chooser.showOpenDialog(null);
				String myString = null;
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File selectedFile = chooser.getSelectedFile();
					myString = "Opening: " + selectedFile.getName() + ".";
					lblStatus.setText("<html>" + myString + "<html>");
//					ReadZebrisXML.main(selectedFile);
				} else {
					myString = "Open command cancelled by user.";
					lblStatus.setText("<html>" + myString + "<html>");	
					//in = new Scanner(selectedFile);
					//int lineNumber = 1;
					//final int Max_lines = 10;
					//while(in.has net)
					
				}
			}
		});
		
		
		
		btnImportXml.setBounds(221, 162, 124, 23);
		frame.getContentPane().add(btnImportXml);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(155, 30, 307, 89);
		frame.getContentPane().add(lblStatus);
	}
}
