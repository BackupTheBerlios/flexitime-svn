package fr.umlv.ir3.GL.test.edt.MouseMotion;

/*
 * BlankArea.java is used by:
 *    MouseEventDemo.java.
 *    MouseMotionEventDemo.java
 *    MouseWheelEventDemo.java
 */

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;

public class BlankArea extends JLabel {
    Dimension minSize = new Dimension(100, 100);

    public BlankArea(Color color) {
        //setBackground(color);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getMinimumSize() {
        return minSize;
    }

    public Dimension getPreferredSize() {
        return minSize;
    }
}
