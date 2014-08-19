package me.softlmis.runnable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.LinkedList;

import me.softlmis.common.MyInetAddress;
import me.softlmis.main.FriendsComposite;
import me.softlmis.main.NewComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;

public class ReceiveSocket implements Runnable {
	private DatagramSocket ds;
	private DatagramPacket dp;
	private NewComposite cpt;

	private String receiveMessage;
	int y = 55;
	int count = 1; // ��¼�б����
	private boolean flag = false;

	@Override
	public void run() {
		receiveMsg();
	}

	/**
	 * ������Ϣ
	 * */
	private void receiveMsg() {
		// ��¼������Ϣ
		LinkedList<String> list = new LinkedList<String>();
		list.add(MyInetAddress.getLocalHost());
		while (true) {
			if (ds == null) {
				try {
					ds = new DatagramSocket(2812);
				} catch (SocketException e) {
					throw new RuntimeException(e);
				}
			}
			byte[] buffer = new byte[1024];
			dp = new DatagramPacket(buffer, buffer.length);
			try {
				// �������ݣ��������߳�
				ds.receive(dp);

				receiveMessage = new String(dp.getData(), 0, dp.getLength());

				// ����Ǳ�������û��Ҫѭ��������Ϣ
				/*
				 * if (list.contains(MyInetAddress.getLocalHost())) continue;
				 * //break;
				 */// ��ѯ���������Ƿ���ڣ�������������ѭ�����������������ӵ��б���
				if (list.contains(receiveMessage))
					//continue;
					break;

				/*
				 * SWT���Զ�����һ���û������߳� ���û������̲߳���ֱ�Ӳ����û������߳�
				 * Ҫ��������һ���߳��г����޸��û�����,Ӧ����һ�·���
				 * ��������ο�http://blog.csdn.net/dl88250/article/details/1669334
				 */
				if (!cpt.getDisplay().isDisposed()) {
					Runnable runnable = new Runnable() {
						public void run() {
							FriendsComposite fc = FriendsComposite
									.getInstance();
							//���������£���������֪ͨ������@�ķ��ű�ʾ�����ˣ�
							if (receiveMessage.contains("@")) {
								String[] str = receiveMessage.split("@");
								if (str[1].equals("true"))
									for (int i = 0; i < fc.getChildren().length; i++) {
										if (fc.getChildren()[i] instanceof CLabel) {
											CLabel clbl = (CLabel) fc
													.getChildren()[i];
											//�жϷ��͵�IP��ַ�Ƿ�Ϊ�б��еĵ�ַ��Ȼ���Ƴ����ߵĺ���
											if (clbl.getText().equals(str[0])) {
												clbl.dispose(); // fc.getChildren()[0].dispose();
												break;
											}
										}
									}
							} else {
								ScrolledComposite sc = NewComposite.srlComposite;
								CLabel lbl = new CLabel(fc, SWT.NONE);
								// �����һ�ε�Label��λ�ã�Ȼ���������Label��λ��
								fc.loadFriendsList(lbl,
										"img_friends/so_photo.png",
										receiveMessage,
										FriendsComposite.yInterval + y);
								// ���ú������Ŀ�ȡ��߶ȣ����б�ĸ߶��ߣ�
								fc.setSize(280, FriendsComposite.yInterval + y);
								// ���ù������ڵ���С���Ӹ߶ȡ����������Ҫ
								sc.setMinHeight(FriendsComposite.yInterval + y
										+ 55);
							}
						}
					};
					cpt.getDisplay().syncExec(runnable);// �ؼ�����һ���ϣ�ͬ�����ã��ȴ��������̴߳������֮��
				}
				if (count++ == 300) // ����300ʱ����ֹͣ���պ����б���
					break;
				y += 55;

				list.add(receiveMessage);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * ���շ��͵���Ϣ
	 * */
	public void receiveOtherMsg(NewComposite cpt) {
		this.cpt = cpt;
		Thread threadReceive = new Thread(this);
		threadReceive.start();
	}
}
