package me.softlmis.main;

import org.eclipse.swt.widgets.Label;

import com.cloudgarden.resource.SWTResourceManager;

public class WidgetEffect {
	/**
	 * ÉèÖÃLabelµÄ±³¾°É«
	 * */
	public static void setBackground(Label lbl) {
		lbl.setBackground(SWTResourceManager.getColor(116, 190, 237));
	}
}
