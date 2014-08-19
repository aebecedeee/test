package me.softlmis.main;

import me.softlmis.common.Common;
import me.softlmis.common.MouseOper;
import me.softlmis.common.MyInetAddress;
import me.softlmis.runnable.MySendMsgSocket;
import me.softlmis.runnable.ReceiveMsgSocket;
import me.softlmis.runnable.ReceiveSocket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

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
public class NewComposite extends org.eclipse.swt.widgets.Composite {

	{
		// Register as a resource user - SWTResourceManager will
		// handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * ҳǩ
	 * */
	private CTabFolder tabFolder;
	/**
	 * ҳǩ��
	 * */
	private CTabItem tiMult;
	private CTabItem tiWeibo;
	private CTabItem tiSingle;
	/**
	 * Label�ؼ�������CLabel�ؼ���
	 * */
	private Label lblZone;

	public static ScrolledComposite srlComposite;
	private Label lblSoft;
	private CLabel lblAppSet;
	private Label lblRefresh;
	private Label lblQQlive;
	private Label lblXF;
	private Label lblPhone;
	private Label lblMusic;
	private Label lblMrg;
	private Label lblGame;
	private CLabel lblFind;
	private Label lblSafe;
	private Label lblFile;
	private Label lblMsg_1;
	private Label lblTools;
	private Label lblQQ;
	private Label lblSea;
	private Label lblWether;
	private Label labTecent;
	private Label lblVip;
	private Label lblMsg;
	private Label lblWb;
	private Label lblEmail;
	private Text txtSearch;
	private Label lblSkin;
	private Label lblSmall;
	private Label lblClose;
	private Label lblPhoto;
	private CLabel lblTitile;

	// �����б����
	/*
	 * private static FriendsComposite fc;
	 * 
	 * public static FriendsComposite getFc() { return fc; }
	 * 
	 * public static void setFc(FriendsComposite fc) { NewComposite.fc = fc; }
	 */

	private MySendMsgSocket mySend;
	private ReceiveSocket receiveSocket;

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */

	/**
	 * Overriding checkSubclass allows this class to extend
	 * org.eclipse.swt.widgets.Composite
	 */
	protected void checkSubclass() {
	}

	Display display = Display.getDefault();
	// ����û�б������ȱ��Ч��
	Shell shell = new Shell(display, SWT.NO_TRIM | SWT.BORDER_DOT);

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite
	 * inside a new Shell. ������ʾ�ľ�̬����
	 */
	public void showGUI() {
		/* Display display = Display.getDefault(); */
		// ����û�б������ȱ��Ч��
		/* Shell shell = new Shell(display, SWT.NO_TRIM | SWT.BORDER_DOT); */
		this.setParent(shell);
		// �����С
		Point size = this.getSize();
		// ����
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			this.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}

		// ���ô��������ʾ
		// this.setWindowLoacation();
		// -------������ʾ��λ��
		shell.setLocation(shell.getMonitor().getClientArea().width - 300, shell
				.getMonitor().getClientArea().height - 700);

		this.sendMyHost();
		this.setTray();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * ���캯��
	 * */
	public NewComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	 * �����ʼ��
	 * */
	private void initGUI() {
		try {
			this.setSize(280, 600);
			// ���������ı���ɫ
			this.setBackground(SWTResourceManager.getColor(116, 190, 237));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			this.setOrientation(SWT.HORIZONTAL);
			{
				lblQQ = new Label(this, SWT.CENTER);
				FormData lblQQLData = new FormData();
				lblQQLData.left = new FormAttachment(0, 1000, 6);
				lblQQLData.top = new FormAttachment(0, 1000, 572);
				lblQQLData.width = 22;
				lblQQLData.height = 22;
				lblQQ.setLayoutData(lblQQLData);

				WidgetEffect.setBackground(lblQQ);

				lblQQ.setImage(SWTResourceManager.getImage("img_bottom/qq.png"));
			}
			{
				lblSea = new Label(this, SWT.CENTER);
				FormData lblSeaLData = new FormData();
				lblSeaLData.left =  new FormAttachment(0, 1000, 249);
				lblSeaLData.top =  new FormAttachment(0, 1000, 100);
				lblSeaLData.width = 31;
				lblSeaLData.height = 30;
				lblSea.setLayoutData(lblSeaLData);
				lblSea.setBackground(SWTResourceManager.getColor(183, 218, 255));
				lblSea.setImage(SWTResourceManager.getImage("img/search.png"));
				lblSea.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						if (txtSearch.getText() != null) {
							MessageBox box = new MessageBox(new Shell());
							box.open();
						}
					}
				});

			}
			/**
			 * ����ƶ��¼�
			 */
			/*
			 * this.addMouseMoveListener(new MouseMoveListener() { public void
			 * mouseMove(MouseEvent evt) { MouseOper.thisMouseMove(evt, inst); }
			 * });
			 */

			MouseOper.thisMouseMove(this);

			/**
			 * ��갴�¡�̧���¼�
			 * */
			this.addMouseListener(new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					MouseOper.thisMouseUp(evt);
				}

				public void mouseDown(MouseEvent evt) {
					MouseOper.thisMouseDown(evt);
				}
			});
			/***** ���涼��һ�¿ؼ���Label��TabFolder�Ļ������� ******/
			{
				lblEmail = new Label(this, SWT.CENTER);
				// ��񲼾֣���ʵ�����Լ�д�������Զ����ɵġ�������Ҫϸ΢�ĵ�����
				FormData lblEmailLData = new FormData();
				lblEmailLData.left = new FormAttachment(0, 1000, 130);
				lblEmailLData.top = new FormAttachment(0, 1000, 74);
				lblEmailLData.width = 22;
				lblEmailLData.height = 20;
				lblEmail.setLayoutData(lblEmailLData);
				lblEmail.setImage(SWTResourceManager.getImage("img/email.png"));

				WidgetEffect.setBackground(lblEmail);

				MouseOper.mouseOper(lblEmail, "img/email.png",
						"img_move/email_1.png");

			}

			{
				lblZone = new Label(this, SWT.CENTER);
				lblZone.setImage(SWTResourceManager.getImage("img/zone.png"));
				FormData lblZoneLData = new FormData();
				lblZoneLData.left = new FormAttachment(0, 1000, 80);
				lblZoneLData.top = new FormAttachment(0, 1000, 74);
				lblZoneLData.width = 22;
				lblZoneLData.height = 20;
				lblZone.setLayoutData(lblZoneLData);

				WidgetEffect.setBackground(lblZone);

				MouseOper.mouseOper(lblZone, "img/zone.png",
						"img_move/zone_1.png");

			}
			{
				// ��CTabFolderû��TabFolder����Ϊǰ�߹���ǿ��Щ
				tabFolder = new CTabFolder(this, SWT.V_SCROLL);
				FormData tabFolderLData = new FormData();
				tabFolderLData.left = new FormAttachment(0, 1000, 0);
				tabFolderLData.top = new FormAttachment(0, 1000, 130);
				tabFolderLData.width = 276;
				tabFolderLData.height = 372;
				tabFolderLData.bottom = new FormAttachment(1000, 1000, -57);
				tabFolderLData.right = new FormAttachment(1000, 1000, 0);
				tabFolder.setLayoutData(tabFolderLData);
				tabFolder.setMinimumCharacters(2);
				tabFolder.setTabHeight(32);
				// ���õ�һ��ǰ��ɫ�ͱ���ɫ
				tabFolder.setSelectionForeground(SWTResourceManager.getColor(
						255, 255, 255));
				tabFolder.setSelectionBackground(SWTResourceManager.getColor(
						116, 190, 237));
				// ���TabItem
				{
					tiSingle = new CTabItem(tabFolder, SWT.NONE);
					tiSingle.setText(" ��ϵ��   ");
					tiSingle.setToolTipText("��ϵ��");
					tiSingle.setImage(SWTResourceManager
							.getImage("img/single.png"));
					{
						srlComposite = new ScrolledComposite(tabFolder,
								SWT.V_SCROLL);
						tiSingle.setControl(srlComposite);
						FriendsComposite.setInstance(srlComposite);
						FriendsComposite fc = FriendsComposite.getInstance();
						// ����������壬���ù��������ڿ���
						srlComposite.setContent(fc);
						// fc.setBounds(41, 0, 259, 375);
						srlComposite.setExpandVertical(true);
						srlComposite.setAlwaysShowScrollBars(false);
						srlComposite
								.addMouseWheelListener(new MouseWheelListener() {
									public void mouseScrolled(MouseEvent evt) {

										if (evt.button == 2) {
											srlComposite.getVerticalBar()
													.setSelection(10);
										}

									}
								});
					}
				}
				{
					tiMult = new CTabItem(tabFolder, SWT.NONE);
					tiMult.setText(" Ⱥ/������   ");
					tiMult.setToolTipText("Ⱥ/������");
					tiMult.setImage(SWTResourceManager.getImage("img/mult.png"));
				}
				{
					tiWeibo = new CTabItem(tabFolder, SWT.NONE);
					tiWeibo.setText("  ΢��    ");
					tiWeibo.setToolTipText("΢��");
					tiWeibo.setImage(SWTResourceManager.getImage("img/wb.png"));
				}
			}
			// ���������Ͻǵ�Ƥ������С������󻯰�ť
			{
				lblSkin = new Label(this, SWT.CENTER);
				FormData lblSkinLData = new FormData();
				lblSkinLData.left = new FormAttachment(0, 1000, 202);
				lblSkinLData.top = new FormAttachment(0, 1000, 0);
				lblSkinLData.width = 25;
				lblSkinLData.height = 20;
				lblSkin.setLayoutData(lblSkinLData);
				lblSkin.setImage(SWTResourceManager
						.getImage("img/icon_skin.png"));

				MouseOper.mouseOper(lblSkin, "img/icon_skin.png",
						"img/icon_skin_1.png");
			}
			{
				lblSmall = new Label(this, SWT.CENTER);
				FormData lblSmallLData = new FormData();
				lblSmallLData.left = new FormAttachment(0, 1000, 225);
				lblSmallLData.top = new FormAttachment(0, 1000, 0);
				lblSmallLData.width = 25;
				lblSmallLData.height = 20;
				lblSmall.setLayoutData(lblSmallLData);
				lblSmall.setImage(SWTResourceManager
						.getImage("img/icon_small.png"));
				lblSmall.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						shell.setVisible(false);
						setTray();
					}
				});

				MouseOper.mouseOper(lblSmall, "img/icon_small.png",
						"img/icon_small_1.png");
			}
			// �����ı��򣬲������ı�ֵ�������ı�û����QQ������ֱ���У���ʱû�ҵ��������ã�
			{
				final String searchTip = "  ��������ϵ�ˡ������顢Ⱥ����ҵ";
				txtSearch = new Text(this, SWT.SINGLE);
				FormData txtSerchLData = new FormData();
				txtSerchLData.top = new FormAttachment(0, 1000, 100);
				txtSerchLData.width = 250;
				txtSerchLData.height = 30;
				txtSearch.setLayoutData(txtSerchLData);
				txtSearch.setText(searchTip);
				txtSearch.setBackground(SWTResourceManager.getColor(183, 218,
						255));
				txtSearch.setTextLimit(100);
				txtSearch.setForeground(SWTResourceManager.getColor(100, 100,
						100));
				// ���ı����ý���ʱ��ȫѡ�ı�����
				txtSearch.addListener(SWT.FOCUSED, new Listener() {
					@Override
					public void handleEvent(Event event) {
						txtSearch.selectAll();
						// txtSearch.setText("");
					}
				});
			}
			{
				lblClose = new Label(this, SWT.CENTER);
				FormData lblCloseLData = new FormData();
				lblCloseLData.left = new FormAttachment(0, 1000, 250);
				lblCloseLData.top = new FormAttachment(0, 1000, 0);
				lblCloseLData.width = 30;
				lblCloseLData.height = 20;
				lblClose.setLayoutData(lblCloseLData);
				lblClose.setImage(SWTResourceManager
						.getImage("img/icon_close.png"));

				MouseOper.mouseOper(lblClose, "img/icon_close.png",
						"img/icon_close1.png");
				// �رմ���
				lblClose.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						/*MessageBox box = new MessageBox(shell, SWT.YES | SWT.NO
								| SWT.ICON_QUESTION);
						box.setMessage("�Ƿ����ص���������");
						int result = box.open();
						if (result == SWT.YES) {
							// shell.setMinimized(true);
							shell.setVisible(false);
							setTray();
						} else {
							tray.dispose(); // �ͷ�������Դ
							System.exit(0);
						}*/
						shell.setVisible(false);
						setTray();
					}
				});
			}
			// ���ø���ͷ��
			{
				lblPhoto = new Label(this, SWT.CENTER);
				FormData lblPhotoLData = new FormData();
				lblPhotoLData.left = new FormAttachment(0, 1000, 8);
				lblPhotoLData.top = new FormAttachment(0, 1000, 31);
				lblPhotoLData.width = 60;
				lblPhotoLData.height = 60;
				lblPhoto.setLayoutData(lblPhotoLData);
				lblPhoto.setImage(SWTResourceManager.getImage("img/me60.png"));
				lblPhoto.setCursor(SWTResourceManager
						.getCursor(SWT.CURSOR_HAND));
			}
			// ����
			{
				lblTitile = new CLabel(this, SWT.NONE);
				FormData lblTitileLData = new FormData();
				lblTitileLData.left = new FormAttachment(0, 1000, 8);
				lblTitileLData.top = new FormAttachment(0, 1000, 2);
				lblTitileLData.width = 60;
				lblTitileLData.height = 20;
				lblTitile.setLayoutData(lblTitileLData);
				lblTitile.setText("So");
				lblTitile.setFont(SWTResourceManager.getFont("΢���ź�", 11, 1,
						false, false));
				lblTitile.setBackground(SWTResourceManager.getColor(116, 190,
						237));
				lblTitile.setImage(SWTResourceManager.getImage("img/so_circle96.png"));
			}
			{
				lblWb = new Label(this, SWT.CENTER);
				lblWb.setImage(SWTResourceManager.getImage("img/wblogicon.png"));
				FormData label1LData = new FormData();
				label1LData.left = new FormAttachment(0, 1000, 105);
				label1LData.top = new FormAttachment(0, 1000, 74);
				label1LData.width = 22;
				label1LData.height = 20;
				lblWb.setLayoutData(label1LData);

				WidgetEffect.setBackground(lblWb);

				MouseOper.mouseOper(lblWb, "img/wblogicon.png",
						"img_move/wb_1.png");
			}
			{
				lblMsg = new Label(this, SWT.CENTER);
				lblMsg.setImage(SWTResourceManager.getImage("img/msg.png"));
				FormData label3LData = new FormData();
				label3LData.left = new FormAttachment(0, 1000, 252);
				label3LData.top = new FormAttachment(0, 1000, 74);
				label3LData.width = 22;
				label3LData.height = 20;
				lblMsg.setLayoutData(label3LData);

				WidgetEffect.setBackground(lblMsg);

				MouseOper
						.mouseOper(lblMsg, "img/msg.png", "img_move/msg_1.png");
			}
			{
				lblVip = new Label(this, SWT.CENTER);
				lblVip.setImage(SWTResourceManager.getImage("img/vip.png"));
				FormData label1LData1 = new FormData();
				label1LData1.left = new FormAttachment(0, 1000, 155);
				label1LData1.top = new FormAttachment(0, 1000, 74);
				label1LData1.width = 22;
				label1LData1.height = 20;
				lblVip.setLayoutData(label1LData1);

				WidgetEffect.setBackground(lblVip);

				MouseOper
						.mouseOper(lblVip, "img/vip.png", "img_move/vip_1.png");
			}
			{
				labTecent = new Label(this, SWT.CENTER);
				labTecent
						.setImage(SWTResourceManager.getImage("img/ten_1.png"));
				FormData label1LData2 = new FormData();
				label1LData2.left = new FormAttachment(0, 1000, 180);
				label1LData2.top = new FormAttachment(0, 1000, 74);
				label1LData2.width = 22;
				label1LData2.height = 20;
				labTecent.setLayoutData(label1LData2);

				WidgetEffect.setBackground(labTecent);
				labTecent.addMouseTrackListener(new MouseTrackAdapter() {
				});

				MouseOper.mouseOper(labTecent, "img/ten_1.png",
						"img_move/ten_1.png");
			}
			{
				lblWether = new Label(this, SWT.CENTER);
				lblWether
						.setImage(SWTResourceManager.getImage("img/sunny.png"));
				FormData label1LData3 = new FormData();
				label1LData3.left = new FormAttachment(0, 1000, 225);
				label1LData3.top = new FormAttachment(0, 1000, 24);
				label1LData3.width = 45;
				label1LData3.height = 45;
				lblWether.setLayoutData(label1LData3);
				lblWether.setBackground(SWTResourceManager.getColor(116, 190,
						237));
				lblWether.setCursor(SWTResourceManager
						.getCursor(SWT.CURSOR_HAND));
			}
			/********** ������QQ�ײ��� **********/
			{
				lblTools = new Label(this, SWT.CENTER);
				lblTools.setImage(SWTResourceManager
						.getImage("img_bottom/tools.png"));
				FormData label1LData4 = new FormData();
				label1LData4.left = new FormAttachment(0, 1000, 36);
				label1LData4.top = new FormAttachment(0, 1000, 572);
				label1LData4.width = 22;
				label1LData4.height = 22;
				lblTools.setLayoutData(label1LData4);

				WidgetEffect.setBackground(lblTools);
			}
			{
				lblMsg_1 = new Label(this, SWT.CENTER);
				lblMsg_1.setImage(SWTResourceManager
						.getImage("img_bottom/message.png"));
				FormData label2LData = new FormData();
				label2LData.left = new FormAttachment(0, 1000, 66);
				label2LData.top = new FormAttachment(0, 1000, 572);
				label2LData.width = 22;
				label2LData.height = 22;
				lblMsg_1.setLayoutData(label2LData);

				WidgetEffect.setBackground(lblMsg_1);
			}
			{
				lblFile = new Label(this, SWT.CENTER);
				lblFile.setImage(SWTResourceManager
						.getImage("img_bottom/file.png"));
				FormData label3LData1 = new FormData();
				label3LData1.left = new FormAttachment(0, 1000, 96);
				label3LData1.top = new FormAttachment(0, 1000, 572);
				label3LData1.width = 22;
				label3LData1.height = 22;
				lblFile.setLayoutData(label3LData1);

				WidgetEffect.setBackground(lblFile);
			}
			{
				lblSafe = new Label(this, SWT.CENTER);
				lblSafe.setImage(SWTResourceManager
						.getImage("img_bottom/qqsafe.png"));
				FormData label1LData5 = new FormData();
				label1LData5.left = new FormAttachment(0, 1000, 126);
				label1LData5.top = new FormAttachment(0, 1000, 572);
				label1LData5.width = 22;
				label1LData5.height = 22;
				lblSafe.setLayoutData(label1LData5);

				WidgetEffect.setBackground(lblSafe);
			}
			{
				lblFind = new CLabel(this, SWT.NONE | SWT.SHADOW_NONE);
				lblFind.setText("����");
				lblFind.setImage(SWTResourceManager
						.getImage("img_bottom/find.png"));
				FormData label2LData1 = new FormData();
				label2LData1.left = new FormAttachment(0, 1000, 153);
				label2LData1.top = new FormAttachment(0, 1000, 572);
				label2LData1.width = 55;
				label2LData1.height = 22;
				lblFind.setLayoutData(label2LData1);

				lblFind.setBackground(SWTResourceManager
						.getColor(116, 190, 237));
			}
			{
				lblGame = new Label(this, SWT.CENTER);
				lblGame.setImage(SWTResourceManager
						.getImage("img_bottom/qqgame.png"));
				FormData label2LData2 = new FormData();
				label2LData2.left = new FormAttachment(0, 1000, 6);
				label2LData2.top = new FormAttachment(0, 1000, 544);
				label2LData2.width = 22;
				label2LData2.height = 22;
				lblGame.setLayoutData(label2LData2);

				WidgetEffect.setBackground(lblGame);
			}
			{
				lblMrg = new Label(this, SWT.CENTER);
				lblMrg.setImage(SWTResourceManager
						.getImage("img_bottom/qqmrg.png"));
				FormData label3LData2 = new FormData();
				label3LData2.left = new FormAttachment(0, 1000, 36);
				label3LData2.top = new FormAttachment(0, 1000, 544);
				label3LData2.width = 22;
				label3LData2.height = 22;
				lblMrg.setLayoutData(label3LData2);

				WidgetEffect.setBackground(lblMrg);
			}
			{
				lblMusic = new Label(this, SWT.CENTER);
				lblMusic.setImage(SWTResourceManager
						.getImage("img_bottom/qqmusic.png"));
				FormData label4LData = new FormData();
				label4LData.left = new FormAttachment(0, 1000, 66);
				label4LData.top = new FormAttachment(0, 1000, 544);
				label4LData.width = 22;
				label4LData.height = 22;
				lblMusic.setLayoutData(label4LData);

				WidgetEffect.setBackground(lblMusic);
			}
			{
				lblPhone = new Label(this, SWT.CENTER);
				lblPhone.setImage(SWTResourceManager
						.getImage("img_bottom/phone_1.png"));
				FormData label5LData = new FormData();
				label5LData.left = new FormAttachment(0, 1000, 96);
				label5LData.top = new FormAttachment(0, 1000, 544);
				label5LData.width = 22;
				label5LData.height = 22;
				lblPhone.setLayoutData(label5LData);

				WidgetEffect.setBackground(lblPhone);
			}
			{
				lblXF = new Label(this, SWT.CENTER);
				lblXF.setImage(SWTResourceManager
						.getImage("img_bottom/qqdownload.png"));
				FormData label6LData = new FormData();
				label6LData.left = new FormAttachment(0, 1000, 126);
				label6LData.top = new FormAttachment(0, 1000, 544);
				label6LData.width = 22;
				label6LData.height = 22;
				lblXF.setLayoutData(label6LData);

				WidgetEffect.setBackground(lblXF);
			}
			{
				lblQQlive = new Label(this, SWT.CENTER);
				lblQQlive.setImage(SWTResourceManager
						.getImage("img_bottom/qqlive.png"));
				FormData cLabel1LData = new FormData();
				cLabel1LData.left = new FormAttachment(0, 1000, 156);
				cLabel1LData.top = new FormAttachment(0, 1000, 544);
				cLabel1LData.width = 22;
				cLabel1LData.height = 22;
				lblQQlive.setLayoutData(cLabel1LData);

				WidgetEffect.setBackground(lblQQlive);
			}
			{
				lblRefresh = new Label(this, SWT.CENTER);
				lblRefresh.setImage(SWTResourceManager
						.getImage("img_bottom/refresh.png"));
				lblRefresh.setToolTipText("ˢ���б�");
				FormData label7LData = new FormData();
				label7LData.left = new FormAttachment(0, 1000, 253);
				label7LData.top = new FormAttachment(0, 1000, 544);
				label7LData.width = 22;
				label7LData.height = 22;
				lblRefresh.setLayoutData(label7LData);
				lblRefresh.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						mySend.setMsg(MyInetAddress.getLocalHost());
						mySend.sendMsg();
					}
				});

				WidgetEffect.setBackground(lblRefresh);
			}
			{
				lblAppSet = new CLabel(this, SWT.SHADOW_NONE);
				lblAppSet.setBackground(SWTResourceManager.getColor(116, 190,
						237));
				lblAppSet.setText("Ӧ�ñ�");
				lblAppSet.setImage(SWTResourceManager
						.getImage("img_bottom/app_1.png"));
				FormData cLabel1LData1 = new FormData();
				cLabel1LData1.left = new FormAttachment(0, 1000, 213);
				cLabel1LData1.top = new FormAttachment(0, 1000, 572);
				cLabel1LData1.width = 72;
				cLabel1LData1.height = 20;
				lblAppSet.setLayoutData(cLabel1LData1);
			}
			{
				lblSoft = new Label(this, SWT.CENTER);
				lblSoft.setImage(SWTResourceManager
						.getImage("img_bottom/qqsoft.png"));
				FormData label1LData6 = new FormData();
				label1LData6.left = new FormAttachment(0, 1000, 186);
				label1LData6.top = new FormAttachment(0, 1000, 544);
				label1LData6.width = 22;
				label1LData6.height = 22;
				lblSoft.setLayoutData(label1LData6);

				WidgetEffect.setBackground(lblSoft);
			}

			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ô������
	 * */
	private void setWindowLoacation() {
		// ���ô��������ʾ��ע����this.getParent
		// �����Ļ������Ȼ������Ļ�Ĵ�С
		Rectangle bounds = this.getParent().getMonitor().getClientArea();
		int width = bounds.width;
		int height = bounds.height;
		// ��ô���Shell�Ĵ�С
		int x = this.getParent().getSize().x;
		int y = this.getParent().getSize().y;
		// ������ھ���ʱ�������Ͻǵ�����ֵ��Ȼ�����
		Point p = new Point((width - x) / 2, (height - y) / 2);
		this.getParent().setLocation(p);
	}

	/**
	 * ���ͱ�����IP���˿���Ϣ��������IPΪ255.255.255.255�����ھ�����������ʾ�����û���
	 * */
	private void sendMyHost() {
		mySend = new MySendMsgSocket(Common.BROADCAST_IP, 2812);
		mySend.SendMyMsg(MyInetAddress.getLocalHost());
		receiveSocket = new ReceiveSocket();
		receiveSocket.receiveOtherMsg(this);
		new ReceiveMsgSocket().receiveOtherMsg(this);
	}

	// ����������
	Tray tray = shell.getDisplay().getSystemTray();
	public static TrayItem trayItem;

	private void setTray() {
		if (tray != null) {
			if (trayItem == null) {
				trayItem = new TrayItem(tray, SWT.NONE);
				trayItem.setToolTipText("So����������");
				trayItem.setImage(SWTResourceManager
						.getImage("img_other/so32.png"));

				final Menu trayMenu = new Menu(shell, SWT.POP_UP);
				MenuItem showMenuItem = new MenuItem(trayMenu, SWT.PUSH);
				showMenuItem.setText("�������");
				showMenuItem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent event) {
						if (!shell.getVisible()) {
							shell.setVisible(true);
							// shell.setMaximized(true);
							shell.setActive();// �����
						}
					}
				});

				MenuItem exitMenuItem = new MenuItem(trayMenu, SWT.PUSH);
				exitMenuItem.setText("�˳�");
				// �˳�����
				exitMenuItem.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						mySend.SendMyMsg(MyInetAddress.getLocalHost() + "@true");
						tray.dispose();// �ͷ�������Դ
						System.exit(0);
					}
				});

				// ����Ҽ������˵�
				trayItem.addMenuDetectListener(new MenuDetectListener() {
					public void menuDetected(MenuDetectEvent e) {
						trayMenu.setVisible(true);
					}
				});
				//������ʾ������
				trayItem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						shell.setVisible(true);
						shell.setActive();// �����
					}
				});
				
			}
		}
	}

}
