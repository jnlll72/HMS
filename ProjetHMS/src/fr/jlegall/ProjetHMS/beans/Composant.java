package fr.jlegall.ProjetHMS.beans;

import java.util.ArrayList;
import java.util.List;

public class Composant {

   private int idComposant;
   private String nomComposant;
   
   private List<Caracteristique> listeCarac;

   public Composant() {
      this.idComposant = 0;
      this.nomComposant = "";
      
      this.listeCarac = new ArrayList<>();
   }

   public Composant(int idComposant, String nomComposant) {
      this.idComposant = idComposant;
      this.nomComposant = nomComposant;
      
      this.listeCarac = new ArrayList<>();
   }

   public int getIdComposant() {
      return idComposant;
   }

   public String getNomComposant() {
      return nomComposant;
   }

   public void setIdComposant(int idComposant) {
      this.idComposant = idComposant;
   }

   public void setNomComposant(String nomComposant) {
      this.nomComposant = nomComposant;
   }
   
   public List<Caracteristique> getListeCarac() {
      return listeCarac;
   }

   public void ajouterCarac(Caracteristique c){
      this.listeCarac.add(c);
   }
   
   public void retirerCarac(Caracteristique m){
      this.listeCarac.remove(m);
   }
   
   public void voirListeCarac(){
      for(Caracteristique c : this.listeCarac){
         System.out.println(c);
      }
   }

   @Override
   public String toString() {
      return "Composant{" + "idComposant=" + idComposant + ", nomComposant=" + nomComposant + '}';
   }
   
}
