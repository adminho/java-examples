package com.cuttingfile;

public class CutButton extends ButtonAdapter{
	/**
	 *
	 */
	private static final long serialVersionUID = -3176069379458918598L;

	public CutButton(Mediator med){this("none",med);}
	public CutButton(String str,Mediator med){super(str,med);}

	public void execute(){	med.cut();	}
}