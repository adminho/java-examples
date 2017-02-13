package com.cuttingfile;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame{	//Adapter Pattern

	/**
	 *
	 */
	private static final long serialVersionUID = -3232995787054975397L;
	public MainFrame(Mediator med){
		this("No name",med);
	}
	public MainFrame(String str,Mediator med){
		super(str);
		med.register(this);
		addWindowListener(new WindowHandle());
	}

	private class WindowHandle extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}