package me.softlmis.runnable;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.softlmis.main.ChatComposite;

/**
 * ��������
 * */
public class SendMsgSocket extends MySendMsgSocket {
	private DatagramSocket ds;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}

	public SendMsgSocket(int remoteReceivePort, String remoteIP) {
		super(remoteIP, remoteReceivePort);
	}

	/**
	 * ��д���෽��
	 * */
	@Override
	public void showMsg(DatagramPacket dp) {
		// TODO Auto-generated method stub
		/*ChatComposite.areaReceive.append(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date())
				+ " send to Remote("
				+ dp.getAddress() + " " + dp.getPort() + ") :\n" + getMsg());*/
	}

}
