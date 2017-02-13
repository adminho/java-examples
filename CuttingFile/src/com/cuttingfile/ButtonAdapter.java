package com.cuttingfile;

import javax.swing.JButton;

public abstract class ButtonAdapter extends JButton implements Command
{
	//Adapter ,Command and Template Pattern

	/**
	 *
	 */
	private static final long serialVersionUID = -2252886847796879931L;
	protected Mediator med;

	public ButtonAdapter(String str,Mediator med){
		super(str);
		this.med=med;
		med.register(this);
		addActionListener(SingleActionHandle.handle());
		}

	public void execute(){}
}