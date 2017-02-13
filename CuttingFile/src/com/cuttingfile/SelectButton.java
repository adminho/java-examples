package com.cuttingfile;

public class SelectButton extends ButtonAdapter{
	/**
	 *
	 */
	private static final long serialVersionUID = 1903975879762584751L;

	public SelectButton(Mediator med){this("none",med);}
	public SelectButton(String str,Mediator med){super(str,med);}

	public void execute(){	med.select();	}
}