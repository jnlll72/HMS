package fr.jlegall.ProjetHMS.beans;

public class Caracteristique {

   private int idCarac;
   private String nomCarac;
   private TypeM typeM;
   private String valeurCarac;

   public Caracteristique() {
      this.idCarac = 0;
      this.nomCarac = "";
      this.valeurCarac = "";
   }

   public Caracteristique(int idCarac, String nomCarac, String valeurCarac) {
      this.idCarac = idCarac;
      this.nomCarac = nomCarac;
   }

   public int getIdCarac() {
      return idCarac;
   }

    public void setIdCarac(int idCarac) {
        this.idCarac = idCarac;
    }

    public void setNomCarac(String nomCarac) {
        this.nomCarac = nomCarac;
    }
 
   public String getNomCarac() {
      return nomCarac;
   }

   public TypeM getTypeM() {
      return typeM;
   }

   public void setTypeM(TypeM typeM) {
      this.typeM = typeM;
   }

    public String getValeurCarac() {
        return valeurCarac;
    }

    public void setValeurCarac(String valeurCarac) {
        this.valeurCarac = valeurCarac;
    }

}
