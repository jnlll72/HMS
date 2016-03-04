package fr.jlegall.ProjetHMS.daoMySql;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
   
   protected Connection connexion = ConnectMySql.getInstance();

   public abstract List<T> findAll();

   public abstract T find(int id);

   public abstract T create(T obj);

   public abstract void delete(T obj);

   public abstract T update(T obj);
}
