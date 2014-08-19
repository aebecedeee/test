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
 * 该类用于封装鼠标常见操作，如移到窗体、鼠标进入、鼠标离开
 * */
public class MouseOper {
	/**
	 * 判断是否按下
	 * */
	private static boolean isDown;
	/**
	 * 记录上次的坐标值
	 * */
	private static int lastX;
	private static int lastY;

	/**
	 * 鼠标按下。标记鼠标按下，记录当前鼠标的坐标值
	 * */
	public static void thisMouseDown(MouseEvent evt) {
		isDown = true;
		lastX = evt.x;
		lastY = evt.y;
	}

	/**
	 * 移动鼠标，拖动窗体。如果鼠标按下了，获得当前移动的坐标值减去上一次按下的坐标值，即步长；
	 *  获得当前窗口的区域值，然后加上移动的步长，即移动的范围。
	 * @param inst
	 *            要移动的窗体
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
	 * 鼠标抬起。标记鼠标抬起
	 * */
	public static void thisMouseUp(MouseEvent evt) {
		isDown = false;
	}

	/**
	 * 鼠标移入、移除操作 --完工后封装方法，复用
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
	 * 关闭无标题栏的窗体。注意：这里没有直接在窗体中写匿名内部类（如MouseAdapter）
	 * @param lbl 被点击的对象，关闭窗体
	 * */
	public static void mouseDown(final Control ctrl) {
		
		ctrl.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent evt) {
				ctrl.getParent().getShell().close();
			}
		});
	}
}
