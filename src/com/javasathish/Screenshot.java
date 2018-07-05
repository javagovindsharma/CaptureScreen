package com.javasathish;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Simple class to capture screenshot
 * 
 * @author Govind Sharma
 *
 */
public class Screenshot extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Robot robot;
	public Screenshot() {
		setTitle("Screenshot using Java");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 150);
		setLocationRelativeTo(null);
		JButton btn = new JButton("Capture Screen");
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				setVisible(false);
				BufferedImage image = robot.createScreenCapture(new Rectangle(screenSize));
				setVisible(true);
				try {
					ImageIO.write(image, "jpg", new File("/home/tattva/screenshot.jpg"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("Screnshot saved");

			}
		});
		getContentPane().add(btn);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Screenshot();
	}

}
