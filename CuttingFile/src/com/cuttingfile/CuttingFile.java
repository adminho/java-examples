package com.cuttingfile;

import java.io.File;
import java.util.Iterator;

public interface CuttingFile {

	public abstract void setResultNum(int resultNum);

	public abstract void setFile(String file);

	public abstract void setDir(String dir);

	public abstract void setAsmDir(String asmDir);

	public abstract Iterator<File> getFiles();

	public abstract boolean cut();

	public boolean assemble();
}