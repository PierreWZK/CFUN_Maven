package com.CFUN.sqlite;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

//table gestionnaire avec nom, prenom et password
//table equipement avec nom, type et quantité

public class Database {

    public static void main(String[] args) throws Exception {
        getPassword(); // Voir les MDP
        getEquipementNom();
        getEquipementType();
        getEquipementQte();
    }
    
    public static String[] password = new String[999];
    public static String[] getPassword() throws SQLException {
        String jdbcUrl = "jdbc:sqlite:cfun.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);

        String req = "select * from gestionnaire";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(req);

        int n=0;
        while(result.next()) {
        	password[n] = result.getString("password");
//        	System.out.println(password[n]);
        	n++;
        }
        return (String[]) password;
    }
    
	public static String[] equipementNom = new String[999];
    public static String[] equipementType = new String[999];
    public static String[] equipementQte = new String[999];
    public static String[] getEquipementNom() throws SQLException {
    	String jdbcUrl = "jdbc:sqlite:cfun.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);
    	
        String req = "select * from equipement";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(req);
        
        int n=0;
        while(result.next()) {
        	equipementNom[n] = result.getString("nom");
//        	System.out.println(equipementNom[n]);
        	n++;
        }
        
		return equipementNom;
    }
    
    public static String[] getEquipementType() throws SQLException {
    	String jdbcUrl = "jdbc:sqlite:cfun.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);
    	
        String req = "select * from equipement";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(req);
        
        int n=0;
        while(result.next()) {
        	if (result.getString("type").contains("F")) {
        		equipementType[n] = "Fitness";
        	} else {
        		equipementType[n] = "Musculation";
        	}
//        	System.out.println(equipementType[n]);
        	n++;
        }
        
		return equipementType;
    }
    
    public static String[] getEquipementQte() throws SQLException {
    	String jdbcUrl = "jdbc:sqlite:cfun.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);
    	
        String req = "select * from equipement";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(req);
        
        int n=0;
        while(result.next()) {
        	equipementQte[n] = result.getString("quantite");   
//        	System.out.println(equipementQte[n]);
        	n++;
        }
        
		return equipementQte;
    }
    
}