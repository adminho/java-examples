package com.cuttingfile;

public abstract class SingleMediator{	//Singleton Pattern
	static private Mediator md=new MediatorImp();
	static public Mediator med(){return md;}
}