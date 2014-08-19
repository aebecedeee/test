package me.softlmis.common;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Common {
	// 广播IP地址，用于向局域网中散步消息
	public static final String BROADCAST_IP = "255.255.255.255";
	// 接收端口，用来接收消息
	public static int RECEIVE_PORT = 1989;

	/**
	 * 用于弹出错误消息，免得每次都是英文字母不觉得对于中国人来说是折磨吗？
	 * */
	public static void ecptMsg(String msg) {
		MessageBox box = new MessageBox(new Shell());
		box.setMessage(msg);
		box.open();
	}

}
