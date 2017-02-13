package com.cuttingfile;

public class CutField extends TextFieldAdapter{
	/**
	 *
	 */
	private static final long serialVersionUID = 5146511539366816836L;
	public CutField(Mediator med){this(10,med);}
	public CutField(int col,Mediator med){super(col,med);}
}