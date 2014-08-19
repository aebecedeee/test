package me.softlmis.main;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

public class App {

	/**
	 * Æô¶¯³ÌÐò
	 * 
	 * @throws IOException
	 * */
	public static void main(String[] args) throws IOException {
		new NewComposite(new Shell(), SWT.NORMAL).showGUI();
	}

}
