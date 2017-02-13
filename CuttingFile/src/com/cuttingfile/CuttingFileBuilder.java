package com.cuttingfile;

//package com.test;

public abstract class CuttingFileBuilder{		//Builder Pattern

	static public CuttingFile create(String file,int resultNum){
		return new CuttingFileImp(file,resultNum);
	}

	static public CuttingFile create(String file){
		return create(file,2);
	}
}