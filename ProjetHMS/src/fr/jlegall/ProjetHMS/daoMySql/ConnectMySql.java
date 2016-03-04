package fr.jlegall.ProjetHMS.daoMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySql {

   private final String DriverPath = "com.mysql.jdbc.Driver";
   private final String chaineConnexion = "jdbc:mysql://10.4.0.87:3306";
   private final String nomBase = "HMS_TEST2";
   private final String nomUser = "julien";
   private final String mdp = "julien";
   
   private Connection connection;
   //private static Connection connection = null;
   private static ConnectMySql instance = null;
   
   private ConnectMySql(){
      this.connexion();
      instance = this;
   }
   
   public void connexion() {
      try {
         Class.forName(DriverPath);
         connection = DriverManager.getConnection(chaineConnexion + "/" + nomBase, nomUser, mdp);
      } catch (ClassNotFoundException ex) {
         System.err.println(ex.getMessage());
      } catch (SQLException ex) {
         System.err.println(ex.getMessage());
      }
   }
   
   public static Connection getInstance(){
      if(instance == null){
         new ConnectMySql();
      }
      return instance.connection;
   }

   public void déconnexion() {

   }

}