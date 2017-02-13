package com.cuttingfile;

import javax.swing.JTextField;

public class JTextFiledCollection extends SubCollection{
	private final JTextField select,cut,asm;

	public JTextFiledCollection(){
		Mediator med=SingleMediator.med();
		select=new SelectField(20,med);
		cut=new CutField(20,med);
		asm=new AssemField(20,med);
	}

	public JTextField get(String str){
		if(str.toLowerCase()=="select"){return select;}
		else if(str.toLowerCase()=="cut"){return cut;}
		else if(str.toLowerCase()=="assemble"){return asm;}
		else{throw new IllegalArgumentException("JTextFiledFactory=>wrong parameter");}
	}
}