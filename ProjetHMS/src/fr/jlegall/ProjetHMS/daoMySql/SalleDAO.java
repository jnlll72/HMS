package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Materiel;
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
public class SalleDAO extends DAO<Salle> {
   
   public SalleDAO() {
      this.connexion = ConnectMySql.getInstance();
   }

   @Override
   public List<Salle> findAll() {
      List<Salle> listeSalle = new ArrayList<>();

      String requete = "SELECT * FROM Salle";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeSalle.add(this.find(rs.getInt("idSalle")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeSalle;
   }

   @Override
   public Salle find(int id) {
      Salle salle = new Salle();

      String requete = "SELECT * FROM Salle WHERE idSalle = ?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            salle = new Salle(rs.getInt("idSalle"), rs.getString("nomSalle"));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return salle;
   }

   @Override
   public Salle create(Salle salle) {
   String requete = "INSERT INTO Salle(nomSalle) VALUES (?)";
      PreparedStatement pstmt = null;

      try {
         pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

         pstmt.setString(1, salle.getNomSalle());

         pstmt.executeUpdate();

         ResultSet rs = pstmt.getGeneratedKeys();

         while (rs.next()) {
            salle.setNumSalle(rs.getInt(1));
         }

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return salle;   
   }

   @Override
   public void delete(Salle salle) {
      String requete = "DELETE FROM Salle WHERE idSalle=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, salle.getIdSalle());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
   }

   @Override
   public Salle update(Salle salle) {
     
      String requete = "UPDATE Salle SET nomSalle=? WHERE idSalle=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);

         pstmt.setString(1,salle.getNomSalle());
         
         pstmt.setInt(2,salle.getIdSalle());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return this.find(salle.getIdSalle());
   }

}
