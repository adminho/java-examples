package com.cuttingfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CuttingFileImp implements CuttingFile {
	private final List<File> listfile = new ArrayList<File>();
	private String file = "";
	private int resultNum = 2; // set defalt
	private String dir = "cutted"; // set defalt
	private String asmDir = "asm"; // set defalt

	CuttingFileImp() {
		this("", 2, "cutted");
	}

	CuttingFileImp(String file) {
		this(file, 2, "cutted");
	}

	CuttingFileImp(String file, int resultNum) {
		this(file, resultNum, "cutted");
	}

	CuttingFileImp(String file, int resultNum, String dir) {
		super();
		setFile(file);
		setResultNum(resultNum);
		setDir(dir);
	}

	public void setFile(String file) {
		if (file == "" || file == null) {
			throw new IllegalArgumentException("==>wrong file name");
		}
		this.file = file;
	}

	public void setResultNum(int resultNum) {
		if (resultNum < 1 || resultNum > 10) {
			throw new IllegalArgumentException("==>wrong cutting number");
		}
		this.resultNum = resultNum;
	}

	public void setDir(String dir) {
		if (dir == "" || dir == null) {
			throw new IllegalArgumentException("==>wrong directory");
		}
		this.dir = dir;
	}

	public void setAsmDir(String asmDir) {
		if (asmDir == "" || asmDir == null) {
			throw new IllegalArgumentException("==>wrong directory");
		}
		this.asmDir = asmDir;
	}

	public Iterator<File> getFiles() {
		return listfile.iterator();
	}

	public boolean cut() {
		try {

			File sourceFile = new File(file);
			if (!sourceFile.exists()) {
				throw new IllegalArgumentException("==>no a exist file");
			} // have a exist file
			if (sourceFile.length() < 10240) {
				throw new IllegalArgumentException("==>short file");
			}

			List<BufferedOutputStream> out = new ArrayList<BufferedOutputStream>();
			File myDir = new File(dir);
			myDir.mkdir();
			for (int i = 0; i < resultNum; i++) {
				File f = new File(myDir, sourceFile.getName() + (i + 1)
						+ ".MyOp");
				listfile.add(i, f);
				out.add(i, new BufferedOutputStream(new FileOutputStream(f)));
			}

			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(sourceFile));
			byte b[] = new byte[1024];
			int c;
			for (int i = 0; i < resultNum; i++) {
				if ((c = bis.read(b)) == -1) {
					break;
				} // read binary data
				out.get(i).write(b, 0, c); // write binary data

				i = i == resultNum - 1 ? -1 : i;
			}

			for (int i = 0; i < resultNum; i++) {
				out.get(i).flush();
				out.get(i).close();
			}

			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean assemble() {
		if (dir == "" || file == null) {
			throw new IllegalArgumentException("assemble ==>wrong argument");
		}

		try {
			List<BufferedInputStream> in = new ArrayList<BufferedInputStream>();
			for (int i = 0; i < resultNum; i++) {
				in.add(i, new BufferedInputStream(new FileInputStream(listfile
						.get(i))));
			}

			File myDir = new File(asmDir);
			myDir.mkdir();
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(new File(myDir, new File(file)
							.getName())));

			byte b[] = new byte[1024];
			int c;
			for (int i = 0; i < resultNum; i++) {
				if ((c = in.get(i).read(b)) == -1) {
					break;
				} // read binary data
				bos.write(b, 0, c); // write binary data

				i = i == resultNum - 1 ? -1 : i;
			}

			for (int i = 0; i < resultNum; i++) {
				in.get(i).close();
			}

			bos.flush();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}