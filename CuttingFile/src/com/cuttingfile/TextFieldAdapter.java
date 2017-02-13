package com.cuttingfile;

import javax.swing.JTextField;

public abstract class TextFieldAdapter extends JTextField{	//Adapter and Template Pattern
	/**
	 *
	 */
	private static final long serialVersionUID = 2732447368313971769L;
	protected Mediator med;

	public TextFieldAdapter(int col,Mediator med){
		super(col);
		this.med=med;
		med.register(this);
	}
}