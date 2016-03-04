package fr.jlegall.HMS_TEST.panelSuppr;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;

public class ComboBoxComposantSuppr extends JComboBox implements ItemListener, KeyListener{    
    private PanelSupprComposant panel;

    public ComboBoxComposantSuppr(PanelSupprComposant p) {
        this.panel = p;
        this.addItemListener(this);
    }
    @Override
    public void itemStateChanged(ItemEvent ie) {
        String nomS = null;
        int id = 0;
        if (!ie.getItem().toString().equals(nomS) && ie.getStateChange() == ItemEvent.SELECTED) {
            nomS = ie.getItem().toString();
        }
        if (nomS != null) {
            boolean yes = this.panel.setTextField((String) nomS);
        }
    }    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {    
        String nomS = null;
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            this.panel.setTextField((String) nomS);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
