package me.softlmis.main;

import java.net.UnknownHostException;

import me.softlmis.common.MyInetAddress;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * �������
 * */
public class FriendsComposite extends Composite {
	private int isClicked = 1; // �Ƿ���
	public CLabel lblList; // �����б�
	private CLabel lastLbl; // �ж��Ƿ�Ϊ�ϴ�ѡ�е�Label
	private Color originalColor; // ��¼����ɫ
	private String host;
	public static int yInterval = 25;

	private static FriendsComposite fc;

	// ʵ����
	public static void setInstance(ScrolledComposite sc) {
		fc = new FriendsComposite(sc, SWT.NORMAL);
	}

	// ���ʵ��
	public static FriendsComposite getInstance() {
		return fc;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	private FriendsComposite(Composite parent, int style) {
		super(parent, style);
		iniComposite(parent.getBounds());
	}

	/**
	 * �������
	 * 
	 * @throws UnknownHostException
	 * */
	private void iniComposite(Rectangle rect) {
		this.setSize(280, 500);
		this.setVisible(true);
		originalColor = this.getBackground();

		CLabel lblFriends = new CLabel(this, SWT.NONE);
		iniLabel(lblFriends, "Family  [5/7]");
	}

	/**
	 * ��ʼ�����Ѳ˵�
	 * 
	 * @throws UnknownHostException
	 * */
	private void iniLabel(CLabel lblFriends, String txt) {
		lblList = lblFriends;
		lblFriends.setText(txt);
		lblFriends.setImage(SWTResourceManager
				.getImage("img_friends/list_down.png"));
		lblFriends.setBounds(0, 0, 280, 25);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		lblList.setLayoutData(gridData);

		// ��������л�ͼƬ
		lblList.addMouseListener(new MouseAdapter() {
			// TODO
			public void mouseDown(MouseEvent e) {

				if (isClicked % 2 == 0) {
					setHidden(true, lblList);
					lblList.setImage(SWTResourceManager
							.getImage("img_friends/list_down.png"));
				} else {
					setHidden(false, lblList);
					lblList.setImage(SWTResourceManager
							.getImage("img_friends/list_right.png"));

				}
				isClicked += 1;
			}
		});

		this.setHost(MyInetAddress.getLocalHost());
		if (host != null) {
			CLabel lbl = new CLabel(this, SWT.NONE);
			loadFriendsList(lbl, "img_friends/ico2.png", host, yInterval);
		}
	}

	/**
	 * ���غ����б�
	 * */
	public void loadFriendsList(CLabel lbl, String img, String name, int y) {
		// ���ر��������������
		CLabel lblMe = lbl;
		lblMe.setImage(SWTResourceManager.getImage(img));
		lblMe.setText(name); // ���ú��ѵ���������IP��ַ
		lblMe.setBounds(2, y, 280, 55); // ��������
		// ��Ӽ����¼�����갴�¡���ý��㡢�����Ƴ�
		mouseDown(lblMe);
		mouseOper(lblMe);
		mouseEnterExit(lblMe);
		mouserDoubleClick(lblMe);

	}

	ChatComposite chatCpt = null;

	/**
	 * ���˫�������촰��
	 * 
	 * @param lbl
	 *            �����б�
	 * */

	private void mouserDoubleClick(final CLabel lbl) {
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				// �ж��Ƿ��Ѿ�������ͬ�Ĵ��壬��������򲻴�
				if (chatCpt != null && !chatCpt.isDisposed()) {
					String s = chatCpt.lblNickname.getText();
					if (lbl.getText() == s) {
						return;
					}
				}
				// ˫�������촰��
				chatCpt = new ChatComposite(new Shell(), SWT.NORMAL);
				chatCpt.setRemoteInfor(lbl.getText());
				chatCpt.showGUI();
			}
		});
	}

	/**
	 * ��갴�»�õ�ǰ����ɫ�͵�ǰ��Label
	 * */
	private void mouseDown(final CLabel lbl) {
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				// ע���������õ����ϴε���ı���ɫ������ԭ����ɫ��
				if (lastLbl != null && lastLbl != lbl)
					lastLbl.setBackground(originalColor);

				lastLbl = lbl; // �ѵ�ǰ�����Label���Ƹ�lastLal
			}
		});
	}

	/**
	 * Label��ý���ʱ���ñ���ɫ��ע�������Label�õ�SWT.FOCUSED������SWT.FocusIn����Ϊ��Ч
	 * */
	private void mouseOper(final CLabel lbl) {
		lbl.addListener(SWT.FOCUSED, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (lbl == lastLbl)
					lbl.setBackground(SWTResourceManager
							.getColor(252, 235, 166));
				lastLbl = lbl;
			}
		});

	}

	/**
	 * ��������Ƴ����ñ���ɫ
	 * 
	 * @param lbl
	 *            Ҫ���õ�Label
	 * */
	private void mouseEnterExit(final CLabel lbl) {
		lbl.addMouseTrackListener(new MouseTrackAdapter() {
			// ����Ƴ�ʱ
			public void mouseExit(MouseEvent evt) {
				setBgd(lbl, originalColor);
			}

			// ������ʱ
			public void mouseEnter(MouseEvent evt) {
				Color c = SWTResourceManager.getColor(252, 240, 192);
				setBgd(lbl, c);
			}
		});
	}

	/**
	 * ���ñ���ɫ
	 * */
	private void setBgd(CLabel lbl, Color c) {
		if (lastLbl != lbl)
			lbl.setBackground(c);
	}

	/**
	 * �����Ƿ����غ����б�
	 * */
	private void setHidden(boolean isHidden, CLabel lblList) {
		// ��õ���ķ���˵��ĸ������������
		Control[] lbl = lblList.getParent().getChildren();
		for (int i = 0; i <= lbl.length - 1; i++) { // ѭ����������
			if (lbl[i] != lblList) //
				lbl[i].setVisible(isHidden);
		}
	}

}
