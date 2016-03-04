package fr.jlegall.ProjetHMS.daoMySql;

import fr.jlegall.ProjetHMS.beans.Materiel;
import fr.jlegall.ProjetHMS.beans.TypeM;
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
public class TypeMDAO extends DAO<TypeM> {

    public TypeMDAO() {
        this.connexion = ConnectMySql.getInstance();
    }

    @Override
    public List<TypeM> findAll() {
        List<TypeM> listeType = new ArrayList<>();

        String requete = "SELECT * FROM TypeM";
        Statement stmt;

        try {
            stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(requete);

            while (rs.next()) {
                listeType.add(this.find(rs.getInt("idTypeM")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listeType;
    }

    @Override
    public TypeM find(int id) {
        TypeM typeM = new TypeM();

        String requete = "SELECT * FROM TypeM WHERE idTypeM = ?";
        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                typeM = new TypeM(rs.getInt("idTypeM"), rs.getString("nomTypeM"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return typeM;
    }
    
    public TypeM findByName(String id) {
       TypeM typeM = new TypeM();
        int idt=0;

        String requete = "SELECT * FROM TypeM WHERE nomTypeM = ?";
        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                typeM = new TypeM(rs.getInt("idTypeM"), rs.getString("nomTypeM"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return typeM;
    }


    @Override
    public TypeM create(TypeM typeM) {
        String requete = "INSERT INTO TypeM(nomTypeM) VALUES (?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, typeM.getNomTypeM());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                typeM.setIdTypeM(rs.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeM;
    }

    @Override
    public void delete(TypeM typeM) {

        MaterielDAO matDao = new MaterielDAO();
        List<Materiel> listeMateriel = new ArrayList<>();
        listeMateriel = matDao.findByType(typeM.getNomTypeM());

        for (Materiel mat : listeMateriel) {
            matDao.delete(mat);
        }

        String requete = "DELETE FROM TypeM WHERE idTypeM=?";

        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);
            pstmt.setInt(1, typeM.getIdTypeM());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public TypeM update(TypeM typeM) {

        String requete = "UPDATE TypeM SET nomTypeM=? WHERE idTypeM=?";

        PreparedStatement pstmt;

        try {
            pstmt = this.connexion.prepareStatement(requete);

            pstmt.setString(1, typeM.getNomTypeM());

            pstmt.setInt(2, typeM.getIdTypeM());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.find(typeM.getIdTypeM());
    }

}
