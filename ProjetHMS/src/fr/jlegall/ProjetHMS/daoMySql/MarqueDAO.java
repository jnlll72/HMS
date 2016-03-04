package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Marque;
import fr.jlegall.ProjetHMS.beans.Materiel;
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
public class MarqueDAO extends DAO<Marque> {

    public MarqueDAO() {
        this.connexion = ConnectMySql.getInstance();
    }

    @Override
    public List<Marque> findAll() {
        List<Marque> listeMarque = new ArrayList<>();

        String requete = "SELECT * FROM Marque";
        Statement stmt;

        try {
            stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(requete);

            while (rs.next()) {
                listeMarque.add(this.find(rs.getInt("idMarque")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listeMarque;
    }

    @Override
    public Marque find(int id) {
        Marque marque = new Marque();

        String requete = "SELECT * FROM Marque WHERE idMarque = ?";
        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                marque = new Marque(rs.getInt("idMarque"), rs.getString("nomMarque"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return marque;
    }

    @Override
    public Marque create(Marque marque) {
        String requete = "INSERT INTO Marque(nomMarque) VALUES (?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, marque.getNomMarque());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                marque.setIdMarque(rs.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return marque;
    }

    @Override
    public void delete(Marque marque) {

        MaterielDAO matDao = new MaterielDAO();
        List<Materiel> listeMateriel = new ArrayList<>();
        listeMateriel = matDao.findByMarque(marque.getIdMarque());

        for (Materiel mat : listeMateriel) {
            matDao.delete(mat);
        }

        String requete = "DELETE FROM Marque WHERE idMarque=?";

        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);
            pstmt.setInt(1, marque.getIdMarque());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Marque update(Marque marque) {

        String requete = "UPDATE Marque SET nomMarque=? WHERE idMarque=?";

        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);

            pstmt.setString(1, marque.getNomMarque());

            pstmt.setInt(2, marque.getIdMarque());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.find(marque.getIdMarque());
    }

}
