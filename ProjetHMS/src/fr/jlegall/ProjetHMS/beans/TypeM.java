package fr.jlegall.ProjetHMS.beans;

import java.util.ArrayList;
import java.util.List;

public class TypeM {

   private int idTypeM;
   private String nomTypeM;
   
   private List<Composant> listeComposant;

   public TypeM() {
      this.idTypeM = 0;
      this.nomTypeM = "";
   }

   public TypeM(int idTypeM, String nomTypeM) {
      this.idTypeM = idTypeM;
      this.nomTypeM = nomTypeM;
      this.listeComposant = new ArrayList<>();
   }

   public int getIdTypeM() {
      return idTypeM;
   }

   public String getNomTypeM() {
      return nomTypeM;
   }

   public void setIdTypeM(int numTypeM) {
      this.idTypeM = numTypeM;
   }

   public void setNomTypeM(String nomTypeM) {
      this.nomTypeM = nomTypeM;
   }
   
   public void ajouterComposant(Composant c){
      this.listeComposant.add(c);
   }
   
   public void retirerComposant(Composant c){
      this.listeComposant.remove(c);
   }
   
   public void voirListeComposant(){
      for(Composant c : this.listeComposant){
         System.out.println(c);
      }
   }

   @Override
   public String toString() {
      return "TypeM{" + "numTypeM=" + idTypeM + ", nomTypeM=" +
              nomTypeM + ", listeComposant=" + listeComposant + '}';
   }
   

}
