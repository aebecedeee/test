package me.softlmis.common;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Common {
	// �㲥IP��ַ���������������ɢ����Ϣ
	public static final String BROADCAST_IP = "255.255.255.255";
	// ���ն˿ڣ�����������Ϣ
	public static int RECEIVE_PORT = 1989;

	/**
	 * ���ڵ���������Ϣ�����ÿ�ζ���Ӣ����ĸ�����ö����й�����˵����ĥ��
	 * */
	public static void ecptMsg(String msg) {
		MessageBox box = new MessageBox(new Shell());
		box.setMessage(msg);
		box.open();
	}

}
