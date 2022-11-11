package com.example.javaproject.dop;

import com.example.javaproject.dataBase.DataBAseHandler;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TextChoiceBox {
    public static String[] typeRoom={
            "Люкc",
            "Полулюкс",
            "Стандартный"
    };
    public static String[] table={
            "Все",
            "Люкc",
            "Полулюкс",
            "Стандартный"
    };
    public static String[] numRoom={
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20"
    };
    public  static String[] day={
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31",
    };
    public  static String[] month={
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
    };
    public  static String[] years={
            "2022",
            "2023",
            "2024",
            "2025",
            "2026",
            "2027",
            "2028",
            "2029",
    };
    public  static String[] hours={
            "00",
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
    };
    public  static String[] minutes={
            "00",
            "30",
    };
    public static ArrayList<String> getFreeNum() throws SQLException {
        final int CountNum=20;
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler db=new DataBAseHandler();
        ResultSet res = db.getNum();

        boolean numBool[]=new boolean[CountNum];
        for(int i=0;i<CountNum;i++){
            numBool[i]=false;
        }
        while(res.next()){
           int index=res.getInt(1);
           numBool[index-1]=true;
        }
        for(int i=0;i<CountNum;i++){
            if(numBool[i]==false){
                numList.add(""+(i+1));
            }
        }
        return numList;
    }
    public static ArrayList<String> getBuseNum() throws SQLException {
        final int CountNum=20;
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler db=new DataBAseHandler();
        ResultSet res = db.getNum();

        boolean numBool[]=new boolean[CountNum];
        for(int i=0;i<CountNum;i++){
            numBool[i]=false;
        }
        while(res.next()){
            int index=res.getInt(1);
            numBool[index-1]=true;
        }
        for(int i=0;i<CountNum;i++){
            if(numBool[i]!=false){
                numList.add(""+(i+1));
            }
        }
        return numList;
    }
    public static ArrayList<String> getSuiteNum() throws SQLException {
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler db=new DataBAseHandler();
        ResultSet res = db.getSuiteNum();
        while(res.next()){
            int index=res.getInt(1);
            numList.add(""+index);
        }
        return numList;
    }
    public static ArrayList<String> getJunSuiteNum() throws SQLException {
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler db=new DataBAseHandler();
        ResultSet res = db.getJunSuiteNum();
        while(res.next()){
            int index=res.getInt(1);
            numList.add(""+index);
        }
        return numList;
    }
    public static ArrayList<String> getStandeNum() throws SQLException {
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler db=new DataBAseHandler();
        ResultSet res = db.getStandNum();
        while(res.next()){
            int index=res.getInt(1);
            numList.add(""+index);
        }
        return numList;
    }
}
