package ru.zhao;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
//文本框圆边，透明设置类
public class RoundJTextField extends JTextField{
	 private Shape shape;
	 public RoundJTextField(int size) {
	  super(size);
	  setOpaque(false); // As suggested by @AVD in comment.
	 }
	 protected void paintComponent(Graphics g) {
	   g.setColor(getBackground());
	   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   super.paintComponent(g);
	 }
	 protected void paintBorder(Graphics g) {
	   g.setColor(getForeground());
	   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	 }
	 public boolean contains(int x, int y) {
	   if (shape == null || !shape.getBounds().equals(getBounds())) {
	    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   }
	   return shape.contains(x, y);
	 }
}
