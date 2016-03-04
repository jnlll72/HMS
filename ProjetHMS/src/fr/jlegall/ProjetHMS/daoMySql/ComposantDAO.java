package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Caracteristique;
import fr.jlegall.ProjetHMS.beans.Composant;

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
public class ComposantDAO extends DAO<Composant> {

   public ComposantDAO() {
      this.connexion = ConnectMySql.getInstance();
   }

   @Override
   public List<Composant> findAll() {
      List<Composant> listeComposant = new ArrayList<>();

      String requete = "SELECT * FROM Composant";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeComposant.add(this.find(rs.getInt("idComposant")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeComposant;
   }

   @Override
   public Composant find(int id) {
      Composant composant = new Composant();

      String requete = "SELECT * FROM Composant WHERE idComposant =?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            composant = new Composant(rs.getInt("idComposant"), rs.getString("nomComposant"));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return composant;
   }

   @Override
   public Composant create(Composant composant) {
      String requete = "INSERT INTO Composant(nomComposant) VALUES (?)";
      PreparedStatement pstmt = null;

      try {
         pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

         pstmt.setString(1, composant.getNomComposant());

         pstmt.executeUpdate();

         ResultSet rs = pstmt.getGeneratedKeys();

         while (rs.next()) {
            composant.setIdComposant(rs.getInt(1));
         }

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return composant;
   }

   @Override
   public void delete(Composant composant) {

      String requete = "DELETE FROM Composant WHERE idComposant=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, composant.getIdComposant());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
   }

   @Override
   public Composant update(Composant composant) {

      String requete = "UPDATE Composant SET nomComposant=? WHERE idComposant=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);

         pstmt.setString(1, composant.getNomComposant());

         pstmt.setInt(2, composant.getIdComposant());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return this.find(composant.getIdComposant());
   }
   
    public List<Caracteristique> findAllCarac(int id) {
      List<Caracteristique> listeCarac = new ArrayList<>();
      CaracteristiqueDAO cd = new CaracteristiqueDAO();

      String requete = "SELECT * FROM Posseder WHERE idComposant = ?";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            listeCarac.add(cd.find(rs.getInt("idCarac")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeCarac;
   }

}
