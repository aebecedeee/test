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
 * 好友面板
 * */
public class FriendsComposite extends Composite {
	private int isClicked = 1; // 是否点击
	public CLabel lblList; // 好友列表
	private CLabel lastLbl; // 判断是否为上次选中的Label
	private Color originalColor; // 记录背景色
	private String host;
	public static int yInterval = 25;

	private static FriendsComposite fc;

	// 实例化
	public static void setInstance(ScrolledComposite sc) {
		fc = new FriendsComposite(sc, SWT.NORMAL);
	}

	// 获得实例
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
	 * 好友面板
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
	 * 初始化好友菜单
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

		// 鼠标点击，切换图片
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
	 * 加载好友列表
	 * */
	public void loadFriendsList(CLabel lbl, String img, String name, int y) {
		// 加载本机到好友面板中
		CLabel lblMe = lbl;
		lblMe.setImage(SWTResourceManager.getImage(img));
		lblMe.setText(name); // 设置好友的主机名和IP地址
		lblMe.setBounds(2, y, 280, 55); // 设置区域
		// 添加监听事件：鼠标按下、获得焦点、移入移出
		mouseDown(lblMe);
		mouseOper(lblMe);
		mouseEnterExit(lblMe);
		mouserDoubleClick(lblMe);

	}

	ChatComposite chatCpt = null;

	/**
	 * 鼠标双击打开聊天窗口
	 * 
	 * @param lbl
	 *            好友列表
	 * */

	private void mouserDoubleClick(final CLabel lbl) {
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				// 判断是否已经打开了相同的窗体，如果存在则不打开
				if (chatCpt != null && !chatCpt.isDisposed()) {
					String s = chatCpt.lblNickname.getText();
					if (lbl.getText() == s) {
						return;
					}
				}
				// 双击打开聊天窗口
				chatCpt = new ChatComposite(new Shell(), SWT.NORMAL);
				chatCpt.setRemoteInfor(lbl.getText());
				chatCpt.showGUI();
			}
		});
	}

	/**
	 * 鼠标按下获得当前背景色和当前的Label
	 * */
	private void mouseDown(final CLabel lbl) {
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				// 注意这里设置的是上次点击的背景色（即还原背景色）
				if (lastLbl != null && lastLbl != lbl)
					lastLbl.setBackground(originalColor);

				lastLbl = lbl; // 把当前点击的Label复制给lastLal
			}
		});
	}

	/**
	 * Label获得焦点时设置背景色。注意这里对Label用的SWT.FOCUSED，而非SWT.FocusIn是因为无效
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
	 * 鼠标移入移出设置背景色
	 * 
	 * @param lbl
	 *            要设置的Label
	 * */
	private void mouseEnterExit(final CLabel lbl) {
		lbl.addMouseTrackListener(new MouseTrackAdapter() {
			// 鼠标移出时
			public void mouseExit(MouseEvent evt) {
				setBgd(lbl, originalColor);
			}

			// 鼠标进入时
			public void mouseEnter(MouseEvent evt) {
				Color c = SWTResourceManager.getColor(252, 240, 192);
				setBgd(lbl, c);
			}
		});
	}

	/**
	 * 设置背景色
	 * */
	private void setBgd(CLabel lbl, Color c) {
		if (lastLbl != lbl)
			lbl.setBackground(c);
	}

	/**
	 * 设置是否隐藏好友列表
	 * */
	private void setHidden(boolean isHidden, CLabel lblList) {
		// 获得点击的分组菜单的父类的所有子类
		Control[] lbl = lblList.getParent().getChildren();
		for (int i = 0; i <= lbl.length - 1; i++) { // 循环遍历子类
			if (lbl[i] != lblList) //
				lbl[i].setVisible(isHidden);
		}
	}

}
