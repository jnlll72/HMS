package fr.jlegall.HMS_TEST;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class MenuBar extends JMenuBar {

   private FenetrePrincipale fenetre;

   public MenuBar(FenetrePrincipale fenetre) {
      this.fenetre = fenetre;
      this.setBorderPainted(true);
      this.setMargin(new Insets(0, 0, 0, 0));
      this.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
      Color jaune = (new Color(253, 181, 21));
      Color vert = new Color(87, 191, 147);
      Color bleu = new Color(72, 185, 199);
      Color rouge = new Color(238, 49, 36);

      Menu ajouter = new Menu("AJOUTER", jaune);

      ajouter.add(new MenuItem("Ajouter matériel", this.fenetre));
      ajouter.add(new MenuItem("Ajouter salle", this.fenetre));
      ajouter.add(new MenuItem("Ajouter marque", this.fenetre));
      ajouter.add(new MenuItem("Ajouter composant", this.fenetre));
      ajouter.add(new MenuItem("Ajouter type (materiel)", this.fenetre));

      Menu modifier = new Menu("MODIFIER", vert);
      modifier.add(new MenuItem("Modifier matériel", this.fenetre));
      modifier.add(new MenuItem("Modifier salle", this.fenetre));
      modifier.add(new MenuItem("Modifier marque", this.fenetre));
      modifier.add(new MenuItem("Modifier composant", this.fenetre));
      modifier.add(new MenuItem("Modifier type (materiel)", this.fenetre));

      Menu supprimer = new Menu("SUPPRIMER", bleu);
      supprimer.add(new MenuItem("Supprimer matériel", this.fenetre));
      supprimer.add(new MenuItem("Supprimer salle", this.fenetre));
      supprimer.add(new MenuItem("Supprimer marque", this.fenetre));
      supprimer.add(new MenuItem("Supprimer composant", this.fenetre));
      supprimer.add(new MenuItem("Supprimer type (materiel)", this.fenetre));


      Menu consulter = new Menu("CONSULTER", rouge);
      consulter.add(new MenuItem("Consulter matériel", this.fenetre));
      consulter.add(new MenuItem("Consulter salle", this.fenetre));
      consulter.add(new MenuItem("Consulter marque", this.fenetre));
      consulter.add(new MenuItem("Consulter composant", this.fenetre));
      consulter.add(new MenuItem("Consulter type (materiel)", this.fenetre));
      consulter.add(new MenuItem("Consulter historique", this.fenetre));

//        Menu v1 = new Menu("                ", null);
//        Menu v2 = new Menu("               ", Color.white);
//        Menu v3 = new Menu("                  ", Color.white);
      this.add(ajouter);
      //this.add(v1);
      this.add(modifier);
      //this.add(v2);
      this.add(supprimer);
      //this.add(v3);
      this.add(consulter);
      //this.add(v4);

   }

}
