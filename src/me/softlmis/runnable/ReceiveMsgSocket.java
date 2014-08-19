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
 * ������Ϣ
 * */
public class ReceiveMsgSocket implements Runnable {
	private static DatagramSocket ds; // ����ɾ�̬��Ϊ�˱������ڴ���ʼ�� ��һ��
	private DatagramPacket dp;
	private Composite cpt;
	private String receiveMessage;

	@Override
	public void run() {
		receiveMsg();
	}

	/**
	 * ������Ϣ
	 * */
	private void receiveMsg() {
		while (true) {
			if (ds == null) {
				try {
					// ��̬
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
					// ��ȡ���յ�������
					receiveMessage = new String(dp.getData(), 0, dp.getLength());
				else
					return;
			} catch (UnknownHostException e) {
				throw new RuntimeException(e);
			}
			/*
			 * SWT���Զ�����һ���û������߳� ���û������̲߳���ֱ�Ӳ����û������߳� Ҫ��������һ���߳��г����޸��û�����,Ӧ����һ�·���
			 * ��������ο�http://blog.csdn.net/dl88250/article/details/1669334
			 */
			if (!cpt.isDisposed()) { // �ж�
				if (!cpt.getDisplay().isDisposed()) {
					Runnable runnable = new Runnable() {
						public void run() {
							// ������ʾ���ı�����
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
					cpt.getDisplay().syncExec(runnable);// �ؼ�����һ���ϣ�ͬ�����ã��ȴ��������̴߳������֮��
				}
			} else
				break;
		}
	}

	/**
	 * ���շ��͵���Ϣ
	 * */
	public void receiveOtherMsg(Composite cpt) {

		// this.cpt = (ChatComposite) cpt;
		this.cpt = cpt;
		Thread threadReceive = new Thread(this);
		threadReceive.start();
	}

}
