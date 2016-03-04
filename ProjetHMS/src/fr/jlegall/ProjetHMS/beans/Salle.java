package fr.jlegall.ProjetHMS.beans;

import java.util.ArrayList;
import java.util.List;


public class Salle {

   private int idSalle;
   private String nomSalle;

   private List<Materiel> listeMateriel;
   
   public Salle() {
      this.idSalle = 0;
      this.nomSalle = "";
      listeMateriel = new ArrayList<>();
   }

   public Salle(int idSalle, String nomSalle) {
      this.idSalle = idSalle;
      this.nomSalle = nomSalle;
      listeMateriel = new ArrayList<>();
   }

   public int getIdSalle() {
      return idSalle;
   }

   public String getNomSalle() {
      return nomSalle;
   }

   public List<Materiel> getListeMateriel() {
      return listeMateriel;
   }

   public void ajouterMateriel(Materiel m){
      this.listeMateriel.add(m);
   }
   
   public void retirerMateriel(Materiel m){
      this.listeMateriel.remove(m);
   }
   
   public void voirListeMateriel(){
      for(Materiel m : this.listeMateriel){
         System.out.println(m);
      }
   }

   public void setNumSalle(int numSalle) {
      this.idSalle = numSalle;
   }

   public void setNomSalle(String nomSalle) {
      this.nomSalle = nomSalle;
   }
   
   

   @Override
   public String toString() {
      return "Salle{" + "idSalle=" + idSalle + ", nomSalle=" + nomSalle + '}';
   }
   
 
}
