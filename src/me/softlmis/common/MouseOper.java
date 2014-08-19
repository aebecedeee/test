package me.softlmis.common;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.cloudgarden.resource.SWTResourceManager;

/**
 * �������ڷ�װ��곣�����������Ƶ����塢�����롢����뿪
 * */
public class MouseOper {
	/**
	 * �ж��Ƿ���
	 * */
	private static boolean isDown;
	/**
	 * ��¼�ϴε�����ֵ
	 * */
	private static int lastX;
	private static int lastY;

	/**
	 * ��갴�¡������갴�£���¼��ǰ��������ֵ
	 * */
	public static void thisMouseDown(MouseEvent evt) {
		isDown = true;
		lastX = evt.x;
		lastY = evt.y;
	}

	/**
	 * �ƶ���꣬�϶����塣�����갴���ˣ���õ�ǰ�ƶ�������ֵ��ȥ��һ�ΰ��µ�����ֵ����������
	 *  ��õ�ǰ���ڵ�����ֵ��Ȼ������ƶ��Ĳ��������ƶ��ķ�Χ��
	 * @param inst
	 *            Ҫ�ƶ��Ĵ���
	 * */
	public static void thisMouseMove(final Composite inst) {
		inst.addMouseMoveListener(new MouseMoveListener() {
			@Override
			public void mouseMove(MouseEvent evt) {
				if (isDown) {
					int offsetX = evt.x - lastX;
					int offsetY = evt.y - lastY;

					Rectangle bounds = inst.getShell().getBounds();
					bounds.x += offsetX;
					bounds.y += offsetY;
					inst.getShell().setBounds(bounds);
				}
			}
		});
	}

	/**
	 * ���̧�𡣱�����̧��
	 * */
	public static void thisMouseUp(MouseEvent evt) {
		isDown = false;
	}

	/**
	 * ������롢�Ƴ����� --�깤���װ����������
	 * */
	public static void mouseOper(final Control c, final String imgExit,
			final String imgEnter) {
		c.addMouseTrackListener(new MouseTrackAdapter() {
			public void mouseExit(MouseEvent evt) {
				((Label) c).setImage(SWTResourceManager.getImage(imgExit));
			}

			public void mouseEnter(MouseEvent evt) {
				((Label) c).setImage(SWTResourceManager.getImage(imgEnter));
			}
		});
	}

	/**
	 * �ر��ޱ������Ĵ��塣ע�⣺����û��ֱ���ڴ�����д�����ڲ��ࣨ��MouseAdapter��
	 * @param lbl ������Ķ��󣬹رմ���
	 * */
	public static void mouseDown(final Control ctrl) {
		
		ctrl.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent evt) {
				ctrl.getParent().getShell().close();
			}
		});
	}
}
