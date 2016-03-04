/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jlegall.HMS_TEST.panelModif;

import fr.jlegall.ProjetHMS.beans.TypeM;
import fr.jlegall.ProjetHMS.daoMySql.TypeMDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Thomas Lemaître
 */
public class ButtonTypeMModif extends JButton implements ActionListener{
   private PanelModifTypeM panel;
   
   public ButtonTypeMModif(String str, PanelModifTypeM panel){
      this.setText(str);
      this.panel = panel;
      this.setPreferredSize(new Dimension(150, 25));
      this.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      TypeM typeTemp = new TypeM(Integer.parseInt(this.panel.getIdT()),this.panel.getTextNom());
      TypeMDAO sd = new TypeMDAO();
      
      sd.update(typeTemp);
      this.panel.getFen().refreshFrame();
   }
}