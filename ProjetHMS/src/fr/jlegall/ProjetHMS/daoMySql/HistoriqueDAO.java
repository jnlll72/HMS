package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Composant;
import fr.jlegall.ProjetHMS.beans.Historique;
import fr.jlegall.ProjetHMS.beans.Materiel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriqueDAO extends DAO<Historique> {
   
   public HistoriqueDAO() {
      this.connexion = ConnectMySql.getInstance();
   }
   
   @Override
   public List<Historique> findAll() {
      List<Historique> listeHisto = new ArrayList<>();

      String requete = "SELECT * FROM Historique ORDER BY dateMaj DESC";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            listeHisto.add(this.find(rs.getInt("idHistorique")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeHisto;
   }

   @Override
   public Historique find(int id) {
       Historique histo = new Historique();
       MaterielDAO m = new MaterielDAO();

      String requete = "SELECT * FROM Historique WHERE idHistorique =?";
      PreparedStatement pstmt;

      try {
         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setInt(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            histo = new Historique(rs.getInt("idHistorique"),rs.getDate("dateMaj"),rs.getString("description"),m.find(rs.getString("numMateriel")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }

      return histo;
   }

   @Override
   public Historique create(Historique histo) {
      
      java.util.Date dt = new java.util.Date();

      java.text.SimpleDateFormat sdf = 
       new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      String currentTime = sdf.format(dt);

      String requete = "INSERT INTO Historique(dateMaj,description,numMateriel) VALUES (?,?,?)";
      PreparedStatement pstmt = null;

      try {
         pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
               
         pstmt.setString(1, currentTime);
         pstmt.setString(2, histo.getDescription());
         pstmt.setString(3,histo.getMateriel().getNumSerieMateriel());

         pstmt.executeUpdate();

         ResultSet rs = pstmt.getGeneratedKeys();

         while (rs.next()) {
            histo.setIdHistorique(rs.getInt(1));
         }

      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      return histo;
   }
   
   public List<Materiel> findAllMateriel() {
      MaterielDAO matDAO = new MaterielDAO();
      List<Materiel> listeTousMateriel = matDAO.findAll();
      List<Materiel> listeMateriel = new ArrayList<>();

      String requete = "SELECT DISTINCT numMateriel FROM Historique ORDER BY dateMaj DESC";
      Statement stmt;

      try {
         stmt = this.connexion.createStatement();
         ResultSet rs = stmt.executeQuery(requete);

         while (rs.next()) {
            for(Materiel m : listeTousMateriel){
               if(m.getNumSerieMateriel().equals(rs.getString("numMateriel"))){
                  listeMateriel.add(m);
               }
            }
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeMateriel;
   }
   
   public List<Historique> findByMateriel(String id) {
      List<Historique> listeHisto = new ArrayList<>();

      String requete = "SELECT * FROM Historique WHERE numMateriel =? ORDER BY dateMaj DESC";
      PreparedStatement pstmt;

      try {

         pstmt = this.connexion.prepareStatement(requete);
         pstmt.setString(1, id);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            listeHisto.add(this.find(rs.getInt("idHistorique")));
         }

      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
      return listeHisto;
   }

   @Override
   public void delete(Historique obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Historique update(Historique obj) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
