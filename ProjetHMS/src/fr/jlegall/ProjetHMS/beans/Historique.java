
package fr.jlegall.ProjetHMS.beans;

import java.util.Date;

public class Historique {
   
   private int idHistorique;
   private Date dateMaj;
   private String description;
   
   private Materiel materiel;
   
   public Historique(){
      this.idHistorique=0;
      this.dateMaj=null;
      this.description="";
      this.materiel=null;
   }

   public Historique(int idHistorique, Date dateMaj, String description, Materiel materiel) {
      this.idHistorique = idHistorique;
      this.dateMaj = dateMaj;
      this.description = description;
      this.materiel = materiel;
   }

   public int getIdHistorique() {
      return idHistorique;
   }

   public Date getDateMaj() {
      return dateMaj;
   }

   public String getDescription() {
      return description;
   }

   public Materiel getMateriel() {
      return materiel;
   }

   public void setIdHistorique(int idHistorique) {
      this.idHistorique = idHistorique;
   }

   public void setDateMaj(Date dateMaj) {
      this.dateMaj = dateMaj;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setMateriel(Materiel materiel) {
      this.materiel = materiel;
   }

   
   
}
