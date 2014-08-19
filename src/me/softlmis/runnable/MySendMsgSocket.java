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
	public DatagramSocket ds; // 本机接收数据套接字

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}

	private String remoteIP; // 远程主机IP
	private String localIP; // 本机IP地址
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
	 * 用于发送数据。发送数据时，发送的数据不一样，因此用模板设计模式
	 * 
	 * @param remoteIP
	 *            远程IP
	 * @param remoteReceivePort
	 *            为远程接收端口
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
	 * 发送数据到对发或者局域网
	 * */
	public void sendMsg() {
		try {
			if (ds == null)
				ds = new DatagramSocket();
			byte[] buffer = new byte[1024];
			buffer = this.getMsg().getBytes(); // 把信息转化成字节数组
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(getRemoteIP()),
					getRemoteReceivePort());
			ds.send(dp);
			showMsg(dp);
		} catch (SocketException e) {
			Common.ecptMsg("网络异常，请检查后再试！" + e.toString());
			throw new RuntimeException(e);

		} catch (UnknownHostException e) {
			Common.ecptMsg("主机地址不存在，请检查后再试！" + e.toString());
			throw new RuntimeException(e);
		} catch (IOException e) {
			Common.ecptMsg("发送失败！" + e.toString());
			throw new RuntimeException(e);
		}
	}

	/**
	 * 用于显示发送的数据，子类重写该方法。其实这里用到了模板设计模式
	 * */
	public void showMsg(DatagramPacket dp) {

	}

	/**
	 * 程序启动后，循环发送本机数据包到局域网中，实现在线功能
	 * */
	@Override
	public void run() {
		// 第一次发送时记录当前时间
		long lastTime = System.currentTimeMillis();
		while (true) {

			this.sendMsg();
			// 获得发送的时间
			this.setInterval((System.currentTimeMillis() - lastTime) / 1000);
			if (this.getInterval() == 10){ // 当发送自己的信息到局域网中，30秒时就停止发送
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
	 * 启动线程，开始不停的发送自己的信息到局域网中
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
