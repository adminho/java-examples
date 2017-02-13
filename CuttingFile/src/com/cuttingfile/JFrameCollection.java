package com.cuttingfile;

import javax.swing.JFrame;

public class JFrameCollection extends SubCollection{
	private final JFrame main;

	public JFrameCollection(){
		Mediator med=SingleMediator.med();
		main=new MainFrame("Main Frame",med);
	}

	public JFrame get(String str){
		if(str.toLowerCase()=="main"){return main;}
		else{throw new IllegalArgumentException("JTextFiledFactory=>wrong parameter");}
	}
}