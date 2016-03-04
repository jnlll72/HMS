package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Caracteristique;
import fr.jlegall.ProjetHMS.beans.Salle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jlegall
 */
public class CaracteristiqueDAO extends DAO<Caracteristique> {
   
   public CaracteristiqueDAO() {
      this.connexion = ConnectMySql.getInstance();
   }

   @Override
   public List<Caracteristique> findAll() {
      List<Caracteristique> listeCarac = new ArrayList<>();

      String requete = "SELECT * FROM Caracteristique";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeCarac.add(this.find(rs.getInt("idCarac")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeCarac;
   }

   @Override
   public Caracteristique find(int id) {
      Caracteristique carac = new Caracteristique();

      String requete = "SELECT * FROM Caracteristique WHERE idCarac = ?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            carac = new Caracteristique(rs.getInt("idCarac"), rs.getString("nomCarac"),rs.getString("valeurCarac"));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return carac;
   }

   @Override
   public Caracteristique create(Caracteristique carac) {
   String requete = "INSERT INTO Caracteristique(nomCarac,valeurCarac) VALUES (?,?)";
      PreparedStatement pstmt = null;

      try {
         pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

         pstmt.setString(1, carac.getNomCarac());
         pstmt.setString(2, carac.getValeurCarac());

         pstmt.executeUpdate();

         ResultSet rs = pstmt.getGeneratedKeys();

         while (rs.next()) {
            carac.setIdCarac(rs.getInt(1));
         }

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return carac;   
   }

   @Override
   public void delete(Caracteristique carac) {
      String requete = "DELETE FROM Caracteristique WHERE idCarac=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, carac.getIdCarac());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
   }

   @Override
   public Caracteristique update(Caracteristique carac) {
    
      String requete = "UPDATE Caracteristique SET nomCarac=?, valeurCarac=? WHERE idCarac=?";

      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);

         pstmt.setString(1,carac.getNomCarac());
         pstmt.setString(2,carac.getValeurCarac());

         pstmt.setInt(3,carac.getIdCarac());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return this.find(carac.getIdCarac());
   }

}
