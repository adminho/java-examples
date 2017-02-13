package com.cuttingfile;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame jfr;
	private JButton sbtn, cbtn, abtn;
	private JTextField stf, ctf, atf;
	private final CompPool cp = new CompPool();

	public MainWindow() {
		init();
	}

	public void init() {

		jfr = cp.getJFrame("main");

		sbtn = cp.getJButton("select");
		sbtn.setMnemonic('S');

		stf = cp.getJTextField("select");
		stf.setEditable(false);

		cbtn = cp.getJButton("cut");
		cbtn.setMnemonic('C');

		ctf = cp.getJTextField("cut");

		abtn = cp.getJButton("assemble");
		abtn.setMnemonic('A');

		atf = cp.getJTextField("assemble");

		jfr.setLayout(new GridLayout(3, 1));

		// ---Frist JPnel-----///
		JPanel jp = new JPanel();
		jp.add(sbtn);
		jp.add(new JLabel("Open==>"));
		jp.add(stf);
		jfr.add(jp);
		// -----------//

		// ---Secound JPanel -----//
		jp = new JPanel();
		jp.add(cbtn);
		jp.add(new JLabel("Directory==>"));
		jp.add(ctf);
		jfr.add(jp);
		// ----------//

		// ----Third JPanel-----//
		jp = new JPanel();
		jp.add(abtn);
		jp.add(new JLabel("File==>"));
		jp.add(atf);
		jfr.add(jp);

		jfr.setSize(500, 150);
		jfr.setVisible(true);
	}
}