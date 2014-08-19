package me.softlmis.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MyInetAddress {
	/**
	 * ��ñ�������������IP��ַ
	 * */
	public static String getLocalHost() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			return localHost.getHostName() + "/" + localHost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			MessageBox box = new MessageBox(new Shell());
			box.setMessage("���������ڣ��������磡" + e.toString());
			box.open();
			return null;
		}
	}
}
