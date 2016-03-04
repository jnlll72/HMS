package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.beans.Historique;
import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.beans.Salle;
import fr.jlegall.ProjetHMS.beans.TypeM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MaterielDAO extends DAO<Materiel> {

   public MaterielDAO() {
      this.connexion = ConnectMySql.getInstance();
   }

   @Override
   public List<Materiel> findAll() {
      List<Materiel> listeMateriel = new ArrayList<>();

      String requete = "SELECT * FROM Materiel";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeMateriel.add(this.find(rs.getString("numMateriel")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeMateriel;
   }

   public Materiel find(String id) {
      Materiel materiel = new Materiel();

      String requete = "SELECT * FROM Materiel WHERE numMateriel = ?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            boolean etat;
            if (rs.getInt("etatMateriel") == 1) {
               etat = true;
            } else {
               etat = false;
            }
            MarqueDAO m = new MarqueDAO();
            TypeMDAO t = new TypeMDAO();
            SalleDAO s = new SalleDAO();

            materiel = new Materiel(rs.getString("numMateriel"), rs.getString("nomMateriel"), etat, m.find(rs.getInt("idMarque")), t.find(rs.getInt("idTypeM")), s.find(rs.getInt("idSalle")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return materiel;
   }

   public String findNumSerie(String id) {
      String num = "";

      String requete = "SELECT numMateriel FROM Materiel WHERE nomMateriel = ?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            num = rs.getString("numMateriel");
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return num;
   }

   @Override
   public Materiel create(Materiel materiel) {
      String requete = "INSERT INTO Materiel(numMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (?,?,?,?,?,?)";
      PreparedStatement pstmt = null;

      try {
         pstmt = this.connexion.prepareStatement(requete);

         pstmt.setString(1, materiel.getNumSerieMateriel());
         pstmt.setString(2, materiel.getNomMateriel());
         pstmt.setInt(3, (materiel.isEtat() == true) ? 1 : 0);
         pstmt.setInt(4, materiel.getMarque().getIdMarque());
         pstmt.setInt(5, materiel.getType().getIdTypeM());
         pstmt.setInt(6, materiel.getSalle().getIdSalle());
         pstmt.executeUpdate();

         HistoriqueDAO histoDAO = new HistoriqueDAO();
         Date dateDay = new Date();

         Historique histo = new Historique(0, dateDay, "Ajout du materiel n° " + materiel.getNumSerieMateriel(), materiel);

         histo = histoDAO.create(histo);

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return materiel;
   }

   @Override
   public void delete(Materiel materiel) {

      this.deleteAllContenir(materiel.getNumSerieMateriel());
      this.deleteHistorique(materiel.getNumSerieMateriel());

      String requete = "DELETE FROM Materiel WHERE numMateriel=?";

      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, materiel.getNumSerieMateriel());
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
   }

   @Override
   public Materiel update(Materiel materiel) {

      String requete = "UPDATE Materiel SET nomMateriel=?, etatMateriel=?, idMarque=?, idTypeM=?, idSalle=? WHERE numMateriel=?";

      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         int etat = (materiel.isEtat()) ? 1 : 0;

         pstmt.setString(1, materiel.getNomMateriel());
         pstmt.setInt(2, etat);
         pstmt.setInt(3, materiel.getMarque().getIdMarque());
         pstmt.setInt(4, materiel.getType().getIdTypeM());
         pstmt.setInt(5, materiel.getSalle().getIdSalle());
         pstmt.setString(6, materiel.getNumSerieMateriel());

         pstmt.executeUpdate();

         HistoriqueDAO histoDAO = new HistoriqueDAO();
         Date dateDay = new Date();

         Historique histo = new Historique(0, dateDay, "Modification du materiel n° " + materiel.getNumSerieMateriel(), materiel);

         histo = histoDAO.create(histo);

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return this.find(materiel.getNumSerieMateriel());
   }

   public List<Materiel> findByMarque(int id) {
      List<Materiel> listeMateriel = new ArrayList<>();

      String requete = "SELECT * FROM Materiel WHERE idMarque =?";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            listeMateriel.add(this.find(rs.getInt("numMateriel")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeMateriel;
   }

   public List<TypeM> findAllType() {

      List<TypeM> listeTypeM = new ArrayList<>();

      TypeMDAO ty = new TypeMDAO();
      
      String requete = "SELECT DISTINCT idTypeM FROM Materiel";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeTypeM.add(ty.find(rs.getInt("idTypeM")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeTypeM;
   }

   public List<Materiel> findByType(String id) {
      List<Materiel> listeMateriel = new ArrayList<>();

      TypeMDAO t = new TypeMDAO();
      TypeM idt = t.findByName(id);

      String requete = "SELECT * FROM Materiel WHERE idTypeM =?";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, idt.getIdTypeM());

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            listeMateriel.add(this.find(rs.getString("numMateriel")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeMateriel;
   }

   public List<Composant> findAllComposant(String id) {
      List<Composant> listeComposant = new ArrayList<>();
      ComposantDAO cd = new ComposantDAO();

      String requete = "SELECT * FROM Contenir WHERE numMateriel = ?";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            //System.out.println(rs.getInt("idComposant"));
            listeComposant.add(cd.find(rs.getInt("idComposant")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeComposant;
   }

   public void deleteAllContenir(String id) {
      String requete = "DELETE FROM Contenir WHERE numMateriel = ?";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
   }

   public void deleteHistorique(String id) {
      String requete = "DELETE FROM Historique WHERE numMateriel = ?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);
         pstmt.executeUpdate();

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
   }

   @Override
   public Materiel find(int id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
