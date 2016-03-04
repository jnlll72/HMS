package fr.jlegall.ProjetHMS.beans;

public class Materiel {

   private String numSerie;
   private String nomMateriel;
   private boolean etat;
   private Marque marque;
   private TypeM type;
   private Salle salle;

   public Materiel() {
      this.numSerie = "";
      this.nomMateriel = "";
      this.etat = true;
      
      this.marque = null;
      this.type = null;
      this.salle = null;
   }

   public Materiel(String numSerie, String nomMateriel, boolean etat, Marque marque, TypeM typeM, Salle salle) {
      this.numSerie = numSerie;
      this.nomMateriel = nomMateriel;
      this.etat = etat;
      
      this.marque = marque;
      this.type = typeM;
      this.salle = salle;
      
   }

   public void setIdMateriel(String numSerie) {
      this.numSerie = numSerie;
   }

   public String getNumSerieMateriel() {
      return numSerie;
   }

   public Marque getMarque() {
      return marque;
   }

   public TypeM getType() {
      return type;
   }

   public boolean isEtat() {
      return etat;
   }

   public void setEtat(boolean etat) {
      this.etat = etat;
   }

   public Salle getSalle() {
      return salle;
   }

   public void setSalle(Salle salle) {
      this.salle = salle;
   }
   

   public String getNomMateriel() {
      return nomMateriel;
   }


   public void setMarque(Marque marque) {
      this.marque = marque;
   }

   public void setType(TypeM type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "Materiel{" + "numSerie=" + numSerie + ", nomMateriel=" + nomMateriel + ", etat=" + etat + ", marque=" + marque + ", type=" + type + ", salle=" + salle + '}';
   }


   

}
