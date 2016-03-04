/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thomas Lemaître
 */
public class PanelOrigine extends JPanel {

    private JPanel panelN;
    private JPanel panelS;
    private JLabel labelL;
    private JButton boutonH;
    private JButton boutonM;
    private JButton boutonS;

    public PanelOrigine() {

        this.setBackground(Color.white);

        JLabel labelPhoto = new JLabel();
        labelPhoto.setIcon(new ImageIcon("C:\\Users\\jlegall\\Documents\\NetBeansProjects\\HMS_TEST\\HMSpage2.png"));
        add(labelPhoto);        
    }
}
