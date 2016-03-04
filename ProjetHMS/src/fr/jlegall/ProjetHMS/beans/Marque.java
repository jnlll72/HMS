package fr.jlegall.ProjetHMS.beans;

public class Marque {

   private int idMarque;
   private String nomMarque;

   public Marque() {
      this.idMarque = 0;
      this.nomMarque = "";
   }

   public Marque(int idMarque, String nomMarque) {
      this.idMarque = idMarque;
      this.nomMarque = nomMarque;
   }

   public int getIdMarque() {
      return idMarque;
   }

   public String getNomMarque() {
      return nomMarque;
   }

   public void setIdMarque(int numMarque) {
      this.idMarque = numMarque;
   }

   public void setNomMarque(String nomMarque) {
      this.nomMarque = nomMarque;
   }

   @Override
   public String toString() {
      return "Marque{" + "IdMarque=" + idMarque + ", nomMarque=" + nomMarque + '}';
   }

}
