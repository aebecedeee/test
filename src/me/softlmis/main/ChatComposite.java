package me.softlmis.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.softlmis.common.Common;
import me.softlmis.common.MouseOper;
import me.softlmis.common.MyInetAddress;
import me.softlmis.runnable.MySendMsgSocket;
import me.softlmis.runnable.ReceiveMsgSocket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ChatComposite extends Composite {

	{
		// Register as a resource user - SWTResourceManager will
		// handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Button btnSend;
	private Button btnClose;
	public Text areaSend;
	public  Text areaReceive;

	private Label lblClose;
	private Label lblSmall;

	private Label lblSheShow;
	private Label lblMyShow;
	private CLabel clblRecord;
	private Label lblCut;
	private Label lblFace;
	private Label lblFont;
	public Label lblNickname;
	private Label lblApp;
	private Label lblTalk;
	private Label lblVoice;
	private Label lblVideo;
	private Label lblPhoto;
	private String remoteInfor;

	/**
	 * 获得远程主机信息
	 * */
	public String getRemoteInfor() {
		return remoteInfor;
	}

	/**
	 * 用来设置远程主机的信息
	 * */
	public void setRemoteInfor(String remoteInfor) {
		this.remoteInfor = remoteInfor;
	}

	/**
	 * 显示聊天窗体
	 * */
	public void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, SWT.NO_TRIM | SWT.BORDER_DOT);
		// 设置父类
		this.setParent(shell);

		Point size = this.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			this.pack();
			this.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}

		// 设置窗体居中显示
		Rectangle bounds = display.getPrimaryMonitor().getBounds();
		Rectangle rect = shell.getBounds();
		int x = (bounds.width - rect.width) / 2;
		int y = (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);
		// -------
		// 标题显示远程主机信息
		lblNickname.setText(this.getRemoteInfor());
		areaSend.setFocus(); // 发送框获得焦点

		new ReceiveMsgSocket().receiveOtherMsg(this);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public ChatComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		this.initGUI();
	}

	private void initGUI() {
		try {
			// 窗体大小
			this.setSize(565, 535);
			// 窗体颜色
			this.setBackground(SWTResourceManager.getColor(116, 190, 237));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				lblSheShow = new Label(this, SWT.NONE);
				FormData lblSheShowLData = new FormData();
				lblSheShowLData.left = new FormAttachment(0, 1000, 421);
				lblSheShowLData.top = new FormAttachment(0, 1000, 96);
				lblSheShowLData.width = 140;
				lblSheShowLData.height = 227;
				lblSheShow.setLayoutData(lblSheShowLData);
				lblSheShow.setImage(SWTResourceManager.getImage("img_show/img_SheShow.png"));
				lblSheShow.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));
			}
			{
				lblMyShow = new Label(this, SWT.NONE);
				FormData lblMyShowLData = new FormData();
				lblMyShowLData.left = new FormAttachment(0, 1000, 421);
				lblMyShowLData.top = new FormAttachment(0, 1000, 390);
				lblMyShowLData.width = 140;
				lblMyShowLData.height = 140;
				lblMyShow.setLayoutData(lblMyShowLData);
				lblMyShow.setImage(SWTResourceManager.getImage("img_show/img_MyShow.png"));
				lblMyShow.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));
			}
			{
				clblRecord = new CLabel(this, SWT.NONE);
				clblRecord.setText("消息记录");
				FormData clblRecordLData = new FormData();
				clblRecordLData.left = new FormAttachment(0, 1000, 336);
				clblRecordLData.top = new FormAttachment(0, 1000, 382);
				clblRecordLData.width = 80;
				clblRecordLData.height = 25;
				clblRecord.setLayoutData(clblRecordLData);
				clblRecord.setImage(SWTResourceManager.getImage("img_tool/tool_record.png"));

				clblRecord.setBackground(SWTResourceManager.getColor(116, 190, 237));
			}
			{
				lblCut = new Label(this, SWT.NONE);
				FormData lblCutLData = new FormData();
				lblCutLData.left = new FormAttachment(0, 1000, 74);
				lblCutLData.top = new FormAttachment(0, 1000, 384);
				lblCutLData.width = 20;
				lblCutLData.height = 20;
				lblCut.setLayoutData(lblCutLData);
				lblCut.setImage(SWTResourceManager.getImage("img_tool/tool_cut.png"));

				WidgetEffect.setBackground(lblCut);
			}
			{
				lblFace = new Label(this, SWT.NONE);
				FormData lblFaceLData = new FormData();
				lblFaceLData.left = new FormAttachment(0, 1000, 42);
				lblFaceLData.top = new FormAttachment(0, 1000, 384);
				lblFaceLData.width = 20;
				lblFaceLData.height = 20;
				lblFace.setLayoutData(lblFaceLData);
				lblFace.setImage(SWTResourceManager.getImage("img_tool/tool_face.png"));

				WidgetEffect.setBackground(lblFace);
			}
			{
				lblFont = new Label(this, SWT.NONE);
				FormData lblFontLData = new FormData();
				lblFontLData.left = new FormAttachment(0, 1000, 10);
				lblFontLData.top = new FormAttachment(0, 1000, 384);
				lblFontLData.width = 20;
				lblFontLData.height = 20;
				lblFont.setLayoutData(lblFontLData);
				lblFont.setImage(SWTResourceManager.getImage("img_tool/tool_font.png"));

				WidgetEffect.setBackground(lblFont);
			}
			{
				lblNickname = new Label(this, SWT.NONE);
				FormData lblNicknameLData = new FormData();
				lblNicknameLData.left =  new FormAttachment(0, 1000, 60);
				lblNicknameLData.top =  new FormAttachment(0, 1000, 7);
				lblNicknameLData.width = 352;
				lblNicknameLData.height = 20;
				lblNickname.setLayoutData(lblNicknameLData);
				lblNickname.setFont(SWTResourceManager.getFont("微软雅黑", 12, 0, false, false));
				lblNickname.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));

				WidgetEffect.setBackground(lblNickname);
			}
			{
				lblApp = new Label(this, SWT.CENTER);
				FormData lblAppLData = new FormData();
				lblAppLData.left = new FormAttachment(0, 1000, 139);
				lblAppLData.top = new FormAttachment(0, 1000, 58);
				lblAppLData.width = 26;
				lblAppLData.height = 26;
				lblApp.setLayoutData(lblAppLData);
				lblApp.setImage(SWTResourceManager.getImage("img_tool/tool_app.png"));

				WidgetEffect.setBackground(lblApp);
			}
			{
				lblTalk = new Label(this, SWT.CENTER);
				FormData lblTalkLData = new FormData();
				lblTalkLData.left = new FormAttachment(0, 1000, 96);
				lblTalkLData.top = new FormAttachment(0, 1000, 58);
				lblTalkLData.width = 26;
				lblTalkLData.height = 26;
				lblTalk.setLayoutData(lblTalkLData);
				lblTalk.setImage(SWTResourceManager.getImage("img_tool/tool_talk.png"));

				WidgetEffect.setBackground(lblTalk);
			}
			{
				lblVoice = new Label(this, SWT.CENTER);
				FormData lblVoiceLData = new FormData();
				lblVoiceLData.left = new FormAttachment(0, 1000, 53);
				lblVoiceLData.top = new FormAttachment(0, 1000, 58);
				lblVoiceLData.width = 26;
				lblVoiceLData.height = 26;
				lblVoice.setLayoutData(lblVoiceLData);
				lblVoice.setImage(SWTResourceManager.getImage("img_tool/tool_voice.png"));

				WidgetEffect.setBackground(lblVoice);
			}
			{
				FormData lblVideoLData = new FormData();
				lblVideoLData.left = new FormAttachment(0, 1000, 10);
				lblVideoLData.top = new FormAttachment(0, 1000, 58);
				lblVideoLData.width = 26;
				lblVideoLData.height = 26;
				lblVideo = new Label(this, SWT.CENTER);
				lblVideo.setLayoutData(lblVideoLData);
				lblVideo.setImage(SWTResourceManager.getImage("img_tool/tool_video.png"));

				WidgetEffect.setBackground(lblVideo);
			}
			{
				lblPhoto = new Label(this, SWT.NONE);
				FormData lblPhotoLData = new FormData();
				lblPhotoLData.left = new FormAttachment(0, 1000, 7);
				lblPhotoLData.top = new FormAttachment(0, 1000, 7);
				lblPhotoLData.width = 42;
				lblPhotoLData.height = 42;
				lblPhoto.setLayoutData(lblPhotoLData);
				lblPhoto.setImage(SWTResourceManager.getImage("img/me60.png"));
				lblPhoto.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));
			}
			// 鼠标抬起、按下
			this.addMouseListener(new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					MouseOper.thisMouseUp(evt);
				}

				public void mouseDown(MouseEvent evt) {
					MouseOper.thisMouseDown(evt);
				}
			});
			// 鼠标移动
			MouseOper.thisMouseMove(this);

			{
				btnSend = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData btnSendLData = new FormData();
				btnSendLData.left = new FormAttachment(0, 1000, 342);
				btnSendLData.top = new FormAttachment(0, 1000, 508);
				btnSendLData.width = 70;
				btnSendLData.height = 22;
				btnSend.setLayoutData(btnSendLData);
				btnSend.setText("发送(S)");
				btnSend.setBackground(SWTResourceManager.getColor(116, 190, 237));
				btnSend.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						sendMsg();
					}
				});
			}
			{
				btnClose = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData btnCloseLData = new FormData();
				btnCloseLData.left = new FormAttachment(0, 1000, 266);
				btnCloseLData.top = new FormAttachment(0, 1000, 508);
				btnCloseLData.width = 70;
				btnCloseLData.height = 22;
				btnClose.setLayoutData(btnCloseLData);
				btnClose.setText("关闭(C)");
				btnClose.setBackground(SWTResourceManager.getColor(116, 190, 237));
				MouseOper.mouseDown(btnClose);
			}
			{
				FormData areaSendLData = new FormData();
				areaSendLData.left = new FormAttachment(0, 1000, 2);
				areaSendLData.top = new FormAttachment(0, 1000, 408);
				areaSendLData.width = 393;
				areaSendLData.height = 95;
				areaSend = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
				areaSend.setLayoutData(areaSendLData);
				areaSend.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						// 回车+Ctrl键
						if ((e.stateMask & SWT.CTRL) != 0 && (e.keyCode == 13)) {
							e.doit = false; // 取消其他任何操作，即只响应Ctrl键和回车键
							sendMsg();
						}
						/*
						 * if (e.keyCode == 13){ e.doit = false; sendMsg(); }
						 */
					}
				});
			}
			{
				FormData areaReceiveLData = new FormData();
				areaReceiveLData.left = new FormAttachment(0, 1000, 2);
				areaReceiveLData.top = new FormAttachment(0, 1000, 90);
				areaReceiveLData.width = 393;
				areaReceiveLData.height = 290;
				areaReceive = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
				areaReceive.setLayoutData(areaReceiveLData);
				areaReceive.setEditable(false);
			}
			{
				lblSmall = new Label(this, SWT.NONE);
				lblSmall.setText("label1");
				FormData lblSmallLData = new FormData();
				lblSmallLData.left = new FormAttachment(0, 1000, 513);
				lblSmallLData.top = new FormAttachment(0, 1000, 0);
				lblSmallLData.width = 25;
				lblSmallLData.height = 20;
				lblSmall.setLayoutData(lblSmallLData);
				lblSmall.setImage(SWTResourceManager.getImage("img/icon_small.png"));
				MouseOper.mouseOper(lblSmall, "img/icon_small.png", "img/icon_small_1.png");
			}
			{
				lblClose = new Label(this, SWT.NONE);
				FormData lblCloseLData = new FormData();
				lblCloseLData.left = new FormAttachment(0, 1000, 538);
				lblCloseLData.top = new FormAttachment(0, 1000, 0);
				lblCloseLData.width = 30;
				lblCloseLData.height = 20;
				lblClose.setLayoutData(lblCloseLData);
				lblClose.setImage(SWTResourceManager.getImage("img/icon_close.png"));
				/*
				 * lblClose.addMouseListener(new MouseAdapter() { public void
				 * mouseDown(MouseEvent evt) { //TODO 为啥匿名内部类访问全局变量是null？
				 * shell.close(); } });
				 */

				MouseOper.mouseDown(lblClose);

				MouseOper.mouseOper(lblClose, "img/icon_close.png", "img/icon_close1.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendMsg() {
		if (areaSend.getText() == null || areaSend.getText().trim().length() == 0) {
			areaSend.setText("在不？");
			areaSend.setSelection(areaSend.getText().length());
		} else {
			MySendMsgSocket mySend = new MySendMsgSocket(remoteInfor.split("/")[1], Common.RECEIVE_PORT);
			mySend.setMsg(areaSend.getText());
			mySend.sendMsg();
			areaReceive.append("我自己   "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\r\n  ");
			areaReceive.append(areaSend.getText() + "\r\n");
		}
	}

}
