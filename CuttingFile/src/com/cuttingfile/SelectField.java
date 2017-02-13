package com.cuttingfile;

public class SelectField extends TextFieldAdapter{
	/**
	 *
	 */
	private static final long serialVersionUID = 7088985741623384749L;
	public SelectField(Mediator med){this(10,med);}
	public SelectField(int col,Mediator med){super(col,med);}
}