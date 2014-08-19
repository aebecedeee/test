package me.softlmis.runnable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.softlmis.common.Common;
import me.softlmis.main.ChatComposite;
import me.softlmis.main.NewComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * 接收消息
 * */
public class ReceiveMsgSocket implements Runnable {
	private static DatagramSocket ds; // 定义成静态是为了保持在内存中始终 是一份
	private DatagramPacket dp;
	private Composite cpt;
	private String receiveMessage;

	@Override
	public void run() {
		receiveMsg();
	}

	/**
	 * 接收消息
	 * */
	private void receiveMsg() {
		while (true) {
			if (ds == null) {
				try {
					// 静态
					ds = new DatagramSocket(Common.RECEIVE_PORT);
				} catch (SocketException e) {
					throw new RuntimeException(e);
				}
			}
			byte[] buffer = new byte[1024 * 64];
			dp = new DatagramPacket(buffer, buffer.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			try {
				String ip = InetAddress.getLocalHost().getHostAddress();
				String i = dp.getAddress().getHostAddress();
				if (!ip.equals(i))
					// 获取接收到的数据
					receiveMessage = new String(dp.getData(), 0, dp.getLength());
				else
					return;
			} catch (UnknownHostException e) {
				throw new RuntimeException(e);
			}
			/*
			 * SWT会自动创建一个用户界面线程 非用户界面线程不能直接操作用户界面线程 要想在另外一个线程中尝试修改用户界面,应采用一下方法
			 * 。具体请参考http://blog.csdn.net/dl88250/article/details/1669334
			 */
			if (!cpt.isDisposed()) { // 判断
				if (!cpt.getDisplay().isDisposed()) {
					Runnable runnable = new Runnable() {
						public void run() {
							// 让其显示在文本框中
							if (!cpt.isDisposed()) {
								/*
								 * if (cpt instanceof NewComposite) { for (int i
								 * = 0; i < 5; i++) { NewComposite.trayItem
								 * .setImage(SWTResourceManager
								 * .getImage("img_other/01.png")); try {
								 * Thread.sleep(300); } catch
								 * (InterruptedException e) { // TODO
								 * Auto-generated catch block
								 * e.printStackTrace(); } NewComposite.trayItem
								 * .setImage(SWTResourceManager
								 * .getImage("img_other/so32.png")); try {
								 * Thread.sleep(300); } catch
								 * (InterruptedException e) { // TODO
								 * Auto-generated catch block
								 * e.printStackTrace(); } } }
								 */
								if (cpt instanceof ChatComposite) {
									((ChatComposite) cpt).areaReceive
											.append(((ChatComposite) cpt).lblNickname
													.getText()
													+ " "
													+ new SimpleDateFormat(
															"yyyy-MM-dd HH:mm:ss")
															.format(new Date())
													+ "\r\n  ");
									((ChatComposite) cpt).areaReceive
											.append(receiveMessage + "\r\n");
								}
							}

						}
					};
					cpt.getDisplay().syncExec(runnable);// 关键在这一句上（同步调用，等待主界面线程处理完成之后）
				}
			} else
				break;
		}
	}

	/**
	 * 接收发送的消息
	 * */
	public void receiveOtherMsg(Composite cpt) {

		// this.cpt = (ChatComposite) cpt;
		this.cpt = cpt;
		Thread threadReceive = new Thread(this);
		threadReceive.start();
	}

}
