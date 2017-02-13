package com.cuttingfile;

public class AssembleButton extends ButtonAdapter{
	/**
	 *
	 */
	private static final long serialVersionUID = 1286769973066530912L;

	public AssembleButton(Mediator med){this("none",med);}
	public AssembleButton(String str,Mediator med){	super(str,med);}


	public void execute(){	med.assemble();	}
}