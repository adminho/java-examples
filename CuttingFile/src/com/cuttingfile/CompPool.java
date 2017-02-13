package com.cuttingfile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CompPool{	//Main Collcetion
	private final SubCollection butn,txtf,mainfr;

	public CompPool(){
		butn=new JButtonCollection();
		txtf=new JTextFiledCollection();
		mainfr=new JFrameCollection();
	}

	public SubCollection getJButtons(){
		return butn;
	}

	public SubCollection getJTextFields(){
		return txtf;
	}

	public SubCollection getJFrames(){
		return mainfr;
	}

	public JButton getJButton(String str){
		return ((JButtonCollection)butn).get(str);
	}

	public JTextField getJTextField(String str){
		return ((JTextFiledCollection)txtf).get(str);
	}

	public JFrame getJFrame(String str){
		return ((JFrameCollection)mainfr).get(str);
	}
}