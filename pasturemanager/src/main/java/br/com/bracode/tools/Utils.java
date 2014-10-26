package br.com.bracode.tools;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class Utils {
	
	public static int getWidthText(String text, Font font) {
		AffineTransform affinetransform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
		int textWidth = (int) (font.getStringBounds(text, frc).getWidth());
		
		return textWidth;
	}
	
	public static int getHeightText(String text, Font font) {
		AffineTransform affinetransform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
		
		int textHeigth = (int) (font.getStringBounds(text, frc).getHeight());
		
		return textHeigth;
	}

}
