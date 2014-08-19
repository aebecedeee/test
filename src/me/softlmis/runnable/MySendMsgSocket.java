package me.softlmis.runnable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import me.softlmis.common.Common;
import me.softlmis.main.NewComposite;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MySendMsgSocket implements Runnable {
	public DatagramSocket ds; // �������������׽���

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}

	private String remoteIP; // Զ������IP
	private String localIP; // ����IP��ַ
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private int remoteReceivePort;

	public int getRemoteReceivePort() {
		return remoteReceivePort;
	}

	public void setRemoteReceivePort(int remoteReceivePort) {
		this.remoteReceivePort = remoteReceivePort;
	}

	public String getLocalIP() {
		return localIP;
	}

	public void setLocalIP(String localIP) {
		this.localIP = localIP;
	}

	/**
	 * ���ڷ������ݡ���������ʱ�����͵����ݲ�һ���������ģ�����ģʽ
	 * 
	 * @param remoteIP
	 *            Զ��IP
	 * @param remoteReceivePort
	 *            ΪԶ�̽��ն˿�
	 * */
	public MySendMsgSocket(String remoteIP, int remoteReceivePort) {
		this.setRemoteIP(remoteIP);
		this.setRemoteReceivePort(remoteReceivePort);
	}

	public String getRemoteIP() {
		return remoteIP;
	}

	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}

	private long interval;

	/**
	 * �������ݵ��Է����߾�����
	 * */
	public void sendMsg() {
		try {
			if (ds == null)
				ds = new DatagramSocket();
			byte[] buffer = new byte[1024];
			buffer = this.getMsg().getBytes(); // ����Ϣת�����ֽ�����
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(getRemoteIP()),
					getRemoteReceivePort());
			ds.send(dp);
			showMsg(dp);
		} catch (SocketException e) {
			Common.ecptMsg("�����쳣����������ԣ�" + e.toString());
			throw new RuntimeException(e);

		} catch (UnknownHostException e) {
			Common.ecptMsg("������ַ�����ڣ���������ԣ�" + e.toString());
			throw new RuntimeException(e);
		} catch (IOException e) {
			Common.ecptMsg("����ʧ�ܣ�" + e.toString());
			throw new RuntimeException(e);
		}
	}

	/**
	 * ������ʾ���͵����ݣ�������д�÷�������ʵ�����õ���ģ�����ģʽ
	 * */
	public void showMsg(DatagramPacket dp) {

	}

	/**
	 * ����������ѭ�����ͱ������ݰ����������У�ʵ�����߹���
	 * */
	@Override
	public void run() {
		// ��һ�η���ʱ��¼��ǰʱ��
		long lastTime = System.currentTimeMillis();
		while (true) {

			this.sendMsg();
			// ��÷��͵�ʱ��
			this.setInterval((System.currentTimeMillis() - lastTime) / 1000);
			if (this.getInterval() == 10){ // �������Լ�����Ϣ���������У�30��ʱ��ֹͣ����
				/*break;*/
				try {
					Thread.sleep(10000);
					lastTime = System.currentTimeMillis();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * �����̣߳���ʼ��ͣ�ķ����Լ�����Ϣ����������
	 * */
	public void SendMyMsg(String msg) {
		this.setMsg(msg);
		Thread threadSend = new Thread(this);
		threadSend.start();
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}
}
