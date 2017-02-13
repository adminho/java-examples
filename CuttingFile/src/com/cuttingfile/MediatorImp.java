package com.cuttingfile;

import java.awt.Component;
import java.awt.FileDialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MediatorImp implements Mediator{	//Mediator pattern

	protected JFrame mfr=new MainFrame("default",this);		//default
	protected JButton sbtn=new SelectButton("default",this);	//default
	protected JButton cbtn=new CutButton("default",this);		//default
	protected JButton abtn=new AssembleButton("default",this);	//default
	protected JTextField sf=new SelectField(this);			//default
	protected JTextField cf=new CutField(this);				//default
	protected JTextField af=new AssemField(this);			//default
	protected CuttingFile cutf;
	public void register(Component com)
	{
		if(com instanceof MainFrame){	mfr=(MainFrame)com;	}
		else if(com instanceof SelectButton){	sbtn=(SelectButton)com;		}
		else if(com instanceof CutButton){	cbtn=(CutButton)com;		}
		else if(com instanceof AssembleButton){	abtn=(AssembleButton)com;	}
		else if(com instanceof SelectField){	sf=(SelectField)com;		}
		else if(com instanceof CutField){	cf=(CutField)com;		}
		else if(com instanceof AssemField){	af=(AssemField)com;		}
	}

	public void select(){
		FileDialog fdlg=new FileDialog(mfr);
		fdlg.setVisible(true);
		String str1=fdlg.getDirectory();
		if(str1==null){return;}
		String str2=fdlg.getFile();
		if(str2==null){return;}
		String str3=str1+str2;
		sf.setText(str3);
		cutf=CuttingFileBuilder.create(str3,4);
	}
	public void cut(){
		if(cutf==null){return;}
		mfr.setVisible(false);
		String dir=cf.getText();
		cutf.setDir(dir);
		cutf.cut();
		mfr.setVisible(true);
	}
	public void assemble(){
		if(cutf==null){return;}
		cutf.setAsmDir(af.getText());
		cutf.assemble();
	}
}