package com.cuttingfile;

import javax.swing.JButton;

public class JButtonCollection extends SubCollection{
	private final JButton select,cut,assemble;
	public JButtonCollection(){
		Mediator med=SingleMediator.med();
		select=new SelectButton("Select",med);
		cut=new CutButton("Cut",med);
		assemble=new AssembleButton("Assemble",med);
	}

	public JButton get(String str){
		if(str.toLowerCase()=="select"){return select;}
		else if(str.toLowerCase()=="cut"){return cut;}
		else if(str.toLowerCase()=="assemble"){return assemble;}
		else{throw new IllegalArgumentException("JButtonFactory=>wrong parameter");}
	}
}