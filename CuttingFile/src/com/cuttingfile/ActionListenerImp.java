package com.cuttingfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionListenerImp implements ActionListener{

	public void actionPerformed(ActionEvent e){

		Object src=e.getSource();

		if( !(src instanceof JButton)){
		throw new IllegalArgumentException("ActionEvent not instanceof JButton");}

		if(src instanceof Command){
			((Command)src).execute();	//Command Pattern
		}
		else{throw new IllegalArgumentException("ActionEvent not instanceof Command");}
	}
}