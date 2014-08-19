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
	int count = 1; // 记录列表个数
	private boolean flag = false;

	@Override
	public void run() {
		receiveMsg();
	}

	/**
	 * 接收消息
	 * */
	private void receiveMsg() {
		// 记录主机信息
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
				// 接收数据，会阻塞线程
				ds.receive(dp);

				receiveMessage = new String(dp.getData(), 0, dp.getLength());

				// 如果是本机，就没必要循环发送消息
				/*
				 * if (list.contains(MyInetAddress.getLocalHost())) continue;
				 * //break;
				 */// 查询主机名中是否存在，如果存在则继续循环，如果不存在则添加到列表中
				if (list.contains(receiveMessage))
					//continue;
					break;

				/*
				 * SWT会自动创建一个用户界面线程 非用户界面线程不能直接操作用户界面线程
				 * 要想在另外一个线程中尝试修改用户界面,应采用一下方法
				 * 。具体请参考http://blog.csdn.net/dl88250/article/details/1669334
				 */
				if (!cpt.getDisplay().isDisposed()) {
					Runnable runnable = new Runnable() {
						public void run() {
							FriendsComposite fc = FriendsComposite
									.getInstance();
							//好友下线事，发送下线通知（包含@的符号表示下线了）
							if (receiveMessage.contains("@")) {
								String[] str = receiveMessage.split("@");
								if (str[1].equals("true"))
									for (int i = 0; i < fc.getChildren().length; i++) {
										if (fc.getChildren()[i] instanceof CLabel) {
											CLabel clbl = (CLabel) fc
													.getChildren()[i];
											//判断发送的IP地址是否为列表中的地址，然后移除下线的好友
											if (clbl.getText().equals(str[0])) {
												clbl.dispose(); // fc.getChildren()[0].dispose();
												break;
											}
										}
									}
							} else {
								ScrolledComposite sc = NewComposite.srlComposite;
								CLabel lbl = new CLabel(fc, SWT.NONE);
								// 获得上一次的Label的位置，然后设置这次Label的位置
								fc.loadFriendsList(lbl,
										"img_friends/so_photo.png",
										receiveMessage,
										FriendsComposite.yInterval + y);
								// 设置好友面板的宽度、高度（随列表的高度走）
								fc.setSize(280, FriendsComposite.yInterval + y);
								// 设置滚动窗口的最小可视高度。这两句很重要
								sc.setMinHeight(FriendsComposite.yInterval + y
										+ 55);
							}
						}
					};
					cpt.getDisplay().syncExec(runnable);// 关键在这一句上（同步调用，等待主界面线程处理完成之后）
				}
				if (count++ == 300) // 大于300时，就停止接收好友列表了
					break;
				y += 55;

				list.add(receiveMessage);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 接收发送的消息
	 * */
	public void receiveOtherMsg(NewComposite cpt) {
		this.cpt = cpt;
		Thread threadReceive = new Thread(this);
		threadReceive.start();
	}
}
