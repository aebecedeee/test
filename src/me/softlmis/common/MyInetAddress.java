package me.softlmis.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MyInetAddress {
	/**
	 * 获得本机的主机名和IP地址
	 * */
	public static String getLocalHost() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			return localHost.getHostName() + "/" + localHost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			MessageBox box = new MessageBox(new Shell());
			box.setMessage("主机不存在，请检查网络！" + e.toString());
			box.open();
			return null;
		}
	}
}
