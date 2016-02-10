package com.sqllite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dhavalchauhan on 7/25/14.
 */
public class SqlLiteDBAccess {

    public static void main(String args[]){
        Connection c = null;
        String sTempDb = "/Users/dhavalchauhan/work/mm/projects/AntiPiracy/Data/Titles.s3db";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        try {
            Class.forName("org.sqlite.JDBC");

            // which will produce a legitimate Url for SqlLite JDBC :
            // jdbc:sqlite:hello.db
            c = DriverManager.getConnection(sDbUrl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Project;" );
            while ( rs.next() ) {
                int effortId = rs.getInt("EffortId");
                String  name = rs.getString("Name");
                System.out.println(effortId + " || "+ name);
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
}
