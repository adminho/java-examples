package com.cuttingfile;

import java.awt.event.ActionListener;

public abstract class SingleActionHandle{	//Singleton pattern
	static private ActionListener hdl=new ActionListenerImp();
	static public ActionListener handle(){return hdl;}
}