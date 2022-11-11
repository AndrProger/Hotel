package com.example.javaproject.dataBase;

import com.example.javaproject.dop.TextChoiceBox;
import com.example.javaproject.room.Room;

import java.sql.*;

import static com.example.javaproject.dataBase.ConstDB.*;

public class DataBAseHandler extends ConfigsDB{
    Connection dbConnection;
    public DataBAseHandler(){

        try {
            getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("dbConnection dont create in construct");
            e.printStackTrace();
        }
    }
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        System.out.println("connectionString= " + connectionString);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return null;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }

        if (dbConnection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return dbConnection;

    }
    private ResultSet getResultSet(String sql)throws SQLException {
        ResultSet resultSet = null;
        Statement statement=dbConnection.createStatement();
        resultSet=statement.executeQuery(sql);
        return resultSet;
    }
    public ResultSet getNum(){
        String select="SELECT "+ ROOMS_TABLE_NUM+
                " FROM " + ROOMS_TABLE;
        try {
            System.out.println("getNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontGetNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getJunSuiteNum() {
        String select = "SELECT " + ROOMS_TABLE_NUM +
                " FROM " + ROOMS_TABLE +
                " WHERE " + ROOMS_TABLE_TYPE + " = 'Полулюкс'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getSuiteNum() {
        String select = "SELECT " + ROOMS_TABLE_NUM +
                " FROM " + ROOMS_TABLE +
                " WHERE " + ROOMS_TABLE_TYPE + " = 'Люкc'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getStandNum() {
        String select = "SELECT " + ROOMS_TABLE_NUM +
                " FROM " + ROOMS_TABLE +
                " WHERE " + ROOMS_TABLE_TYPE + " = 'Стандартный'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getAll() {
        String select = "SELECT " +
                ROOMS_TABLE_TYPE+","+
                ROOMS_TABLE_NUM+","+
                ROOMS_TABLE_PEOPLE+","+
                ROOMS_TABLE_PRICE+","+
                ROOMS_TABLE_MIN_TERN+","+
                ROOMS_TABLE_MAX_TERN+","+
                ROOMS_TABLE_STATUC+","+
                ROOMS_TABLE_ENTRY+","+
                ROOMS_TABLE_EXIT+
                " FROM " + ROOMS_TABLE;
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getStand() {
        String select = "SELECT " +
                ROOMS_TABLE_TYPE+","+
                ROOMS_TABLE_NUM+","+
                ROOMS_TABLE_PEOPLE+","+
                ROOMS_TABLE_PRICE+","+
                ROOMS_TABLE_MIN_TERN+","+
                ROOMS_TABLE_MAX_TERN+","+
                ROOMS_TABLE_STATUC+","+
                ROOMS_TABLE_ENTRY+","+
                ROOMS_TABLE_EXIT+
                " FROM " + ROOMS_TABLE+
                " WHERE "+ ROOMS_TABLE_TYPE+"="+"'Стандартный'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getSuite() {
        String select = "SELECT " +
                ROOMS_TABLE_TYPE+","+
                ROOMS_TABLE_NUM+","+
                ROOMS_TABLE_PEOPLE+","+
                ROOMS_TABLE_PRICE+","+
                ROOMS_TABLE_MIN_TERN+","+
                ROOMS_TABLE_MAX_TERN+","+
                ROOMS_TABLE_STATUC+","+
                ROOMS_TABLE_ENTRY+","+
                ROOMS_TABLE_EXIT+
                " FROM " + ROOMS_TABLE+
                " WHERE "+ ROOMS_TABLE_TYPE+"="+"'Люкc'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getJunSuite() {
        String select = "SELECT " +
                ROOMS_TABLE_TYPE+","+
                ROOMS_TABLE_NUM+","+
                ROOMS_TABLE_PEOPLE+","+
                ROOMS_TABLE_PRICE+","+
                ROOMS_TABLE_MIN_TERN+","+
                ROOMS_TABLE_MAX_TERN+","+
                ROOMS_TABLE_STATUC+","+
                ROOMS_TABLE_ENTRY+","+
                ROOMS_TABLE_EXIT+
                " FROM " + ROOMS_TABLE+
                " WHERE "+ ROOMS_TABLE_TYPE+"="+"'Полулюкс'";
        try {
            System.out.println("getSuiteNum)!!!");
            return getResultSet(select);
        } catch (SQLException e) {
            System.out.println("dontgetSuiteNum)!!!");
            e.printStackTrace();
            return null;
        }
    }

    public int getMaxPeople(int num) {
        String select = "SELECT " + ROOMS_TABLE_MAX_PEOPLE +
                " FROM " + ROOMS_TABLE +
                " WHERE " + ROOMS_TABLE_NUM + " = "+num;
        try {
            System.out.println("getMaxPeople)!!!");
            ResultSet resultSet = getResultSet(select);
            int numRec=0;
            while(resultSet.next()){
                numRec=resultSet.getInt(1);
            }
            return numRec;
        } catch (SQLException e) {
            System.out.println("dont getMaxPeople)!!!");
            e.printStackTrace();
            return 0;
        }
    }
    public void setDB(Room room){
        String insert="INSERT INTO "+ ROOMS_TABLE+"("+
                ROOMS_TABLE_TYPE+","+
                ROOMS_TABLE_NUM+","+
                ROOMS_TABLE_MAX_PEOPLE+","+
                ROOMS_TABLE_PEOPLE+","+
                ROOMS_TABLE_PRICE+","+
                ROOMS_TABLE_MIN_TERN+","+
                ROOMS_TABLE_MAX_TERN+","+
                ROOMS_TABLE_STATUC+","+
                ROOMS_TABLE_ENTRY+","+
                ROOMS_TABLE_EXIT+")"+
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setString(1, room.getType());
            prSt.setInt(   2,  room.getNum());
            prSt.setInt(   3,  room.getMaxPeople());
            prSt.setInt(   4,  room .getCountPeople());
            prSt.setDouble(5, room.getPrice());
            prSt.setDouble(6, room.getMin_tern());
            prSt.setDouble(7, room.getMax_tern());
            prSt.setString(8, room.getStatus());
            prSt.setString(9, room.getEntry());
            prSt.setString(10, room.getExit());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }
    public void deleteStr(String num){
        String delete="DELETE FROM "+ROOMS_TABLE+" WHERE "+ROOMS_TABLE_NUM + " = "+num;
        try {
            PreparedStatement prSt=dbConnection.prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("dontDelete");
        }
    }
    public  void updateDb(String num,String People, String status, String entry,String exit){
        String update="UPDATE "+ROOMS_TABLE+" SET "+
                ROOMS_TABLE_STATUC+"="+"'"+status+"',"+
                ROOMS_TABLE_ENTRY+"="+"'"+entry+"',"+
                ROOMS_TABLE_EXIT+"="+"'"+exit+"',"+
                ROOMS_TABLE_PEOPLE+"="+People+
                " WHERE "+ROOMS_TABLE_NUM+"="+num;
        try {
            PreparedStatement prSt=dbConnection.prepareStatement(update);
            prSt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("dont update");
        }
    }
}
