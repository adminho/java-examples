package com.cuttingfile;

import java.awt.Component;

public interface Mediator{
	public abstract void register(Component com);
	public abstract void select();
	public abstract	void cut();
	public abstract	void assemble();
}