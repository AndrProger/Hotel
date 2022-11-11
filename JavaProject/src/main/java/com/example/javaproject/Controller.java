package com.example.javaproject;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.javaproject.dataBase.DataBAseHandler;
import com.example.javaproject.dop.CSS;
import com.example.javaproject.room.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import static com.example.javaproject.dop.TextChoiceBox.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> HourseForComVisitorChs;

    @FXML
    private AnchorPane VisitorAPane;

    @FXML
    private TableColumn<PropertyRoom, Integer> VisitorTColumn;

    @FXML
    private AnchorPane addRoomAPane;

    @FXML
    private AnchorPane infoAPane;
    @FXML
    private Button addRoomBTN;

    @FXML
    private RadioButton busyRadBTN;

    @FXML
    private ChoiceBox<String> choiseTypeCHS;

    @FXML
    private Button closeBTN;

    @FXML
    private ChoiceBox<String> dayForComVisitorChs;

    @FXML
    private ChoiceBox<String> dayForOutVisitorChs;

    @FXML
    private Button deleteRoomBTN;

    @FXML
    private Button forRoomBTN;

    @FXML
    private RadioButton freeRadBTN;

    @FXML
    private ImageView hotelImage;

    @FXML
    private Text hotelTxt1;

    @FXML
    private ChoiceBox<String> hourseForOutVisitorChs;

    @FXML
    private TableView<PropertyRoom> infoTable;

    @FXML
    private Button infoBTN;

    @FXML
    private TableColumn<PropertyRoom, Double> maxTColumn;

    @FXML
    private TextField maxTimeAddRoomTxt;

    @FXML
    private TextField maxVisitorAddRoomTxt;

    @FXML
    private ChoiceBox<String> minForComVisitorChs;

    @FXML
    private ChoiceBox<String> minForOutVisitorChs;

    @FXML
    private TableColumn<PropertyRoom, Double> minTColumn;

    @FXML
    private TextField minTimeAddRoomTxt;

    @FXML
    private ChoiceBox<String> monthForComVisitorChs;

    @FXML
    private ChoiceBox<String> monthForOutVisitorChs;

    @FXML
    private ChoiceBox<String> numberDeleteRoomCH;

    @FXML
    private ChoiceBox<String> numberPeopleAddVisitorChs;

    @FXML
    private ChoiceBox<String> numberRoomAddRoomChs;

    @FXML
    private ChoiceBox<String> numberRoomAddVisitorChs;

    @FXML
    private ChoiceBox<String> numberRoomRemoveVisitorChs1;

    @FXML
    private TableColumn<PropertyRoom, Integer> numberRoomTColumn;

    @FXML
    private Button removeVisitorBTN;

    @FXML
    private TextField salaryAddRoomTxt;

    @FXML
    private TableColumn<PropertyRoom, Double> salaryTColumn;

    @FXML
    private TableColumn<PropertyRoom, String> statusTColumn;

    @FXML
    private Text textForapTXT;

    @FXML
    private TableColumn<PropertyRoom, String> timeEntryTColumn;

    @FXML
    private TableColumn<PropertyRoom, String> timeOutTColumn;

    @FXML
    private ChoiceBox<String> typeAddRoomChs;

    @FXML
    private ChoiceBox<String> typeAddVisitorCh;

    @FXML
    private TableColumn<PropertyRoom, String> typeTColumn;

    @FXML
    private Button uVisitorBTN;

    @FXML
    private Button uVisitorBTN1;

    @FXML
    private ChoiceBox<String> yearForComVisitorChs;

    @FXML
    private ChoiceBox<String> yearForOutVisitorChs;
    private Room room;

    @FXML
    void ClickAddBTN(MouseEvent event) {
        boolean checkDB=true;
        String type = typeAddRoomChs.getValue();
        int maxPeople=0;
        try {
            maxPeople = Integer.parseInt(maxVisitorAddRoomTxt.getText());
        }catch (Exception e){
            checkDB=false;
        }
        int numRoom=Integer.parseInt(numberRoomAddRoomChs.getValue());
        double price=0;
        try {
            price = Double.parseDouble(salaryAddRoomTxt.getText());
        }catch (Exception e){
            checkDB=false;
        }

        double minTerm=0;
        try {
            minTerm = Double.parseDouble(minTimeAddRoomTxt.getText());
        }catch (Exception e){
            checkDB=false;
        }

        double maxTerm=0;
        try {
            maxTerm = Double.parseDouble(maxTimeAddRoomTxt.getText());
        }catch (Exception e){
            checkDB=false;
        }

        if(checkDB==true) {
            Room room=null;
            if(type.equals("Люкc")){
                room=new Suite(numRoom,maxPeople,0,price,minTerm,maxTerm,"free","none","none");

            }
            if(type.equals("Полулюкс")){
                room=new JunSuite(numRoom,maxPeople,0,price,minTerm,maxTerm,"free","none","none");

            }
            if(type.equals("Стандартный")){
                room=new Standard(numRoom,maxPeople,0,price,minTerm,maxTerm,"free","none","none");

            }
            DataBAseHandler dbaHandler=new DataBAseHandler();
            dbaHandler.setDB(room);
            initChB();
        }
    }

    @FXML
    void ClickDeleteBTN(MouseEvent event) {
        String num = numberDeleteRoomCH.getValue();
        DataBAseHandler dbaHandler=new DataBAseHandler();
        dbaHandler.deleteStr(num);
        initChB();
    }
    @FXML
    void uVisitorBTN1Clck(MouseEvent event) {
        String num=numberRoomAddVisitorChs.getValue();
        String status="buse";
        String people=numberPeopleAddVisitorChs.getValue();
        String entry=HourseForComVisitorChs.getValue()+":"
                +minForComVisitorChs.getValue()+" "
                +dayForComVisitorChs.getValue()+"."
                +monthForComVisitorChs.getValue()+"."
                +yearForComVisitorChs.getValue();
        String exit=hourseForOutVisitorChs.getValue()+":"
                +minForOutVisitorChs.getValue()+" "
                +dayForOutVisitorChs.getValue()+"."
                +monthForOutVisitorChs.getValue()+"."
                +yearForOutVisitorChs.getValue();

        DataBAseHandler dbaHandler=new DataBAseHandler();
        dbaHandler.updateDb(num,people,status,entry,exit);
    }

    @FXML
    void EnteredAddBTN(MouseEvent event) {
    }

    @FXML
    void EnteredDeleteBTN(MouseEvent event) {

    }

    @FXML
    void ExitedAddBTN(MouseEvent event) {

    }

    @FXML
    void ExitedDeleteBTN(MouseEvent event) {

    }

    @FXML
    void closeBTNClicked(MouseEvent event) {

    }

    @FXML
    void closeBTNEnter(MouseEvent event) {
        CSS.enterButtonEnterChange(closeBTN);
    }

    @FXML
    void closeBTNExit(MouseEvent event) {
        CSS.exitButtonEnterChange(closeBTN);
    }

    @FXML
    void forRoomBTNClick(MouseEvent event) {
        textForapTXT.setText("Управление комнатами");
        addRoomAPane.setVisible(true);
        infoAPane.setVisible(false);
        VisitorAPane.setVisible(false);
    }

    @FXML
    void forRoomBTNEnter(MouseEvent event) {
        CSS.ButtonEnterChange(forRoomBTN);
    }

    @FXML
    void forRoomBTNExit(MouseEvent event) {
        CSS.ButtonExitedChange(forRoomBTN);
    }

    @FXML
    void infoBTNClicked(MouseEvent event) {
        textForapTXT.setText("Информация об отеле");
        addRoomAPane.setVisible(false);
        infoAPane.setVisible(true);
        VisitorAPane.setVisible(false);
        choiseTypeCHS();
    }

    @FXML
    void infoBTNEnter(MouseEvent event) {
        CSS.ButtonEnterChange(infoBTN);
    }

    @FXML
    void infoBTNExit(MouseEvent event) {
        CSS.ButtonExitedChange(infoBTN);
    }

    @FXML
    void uVisitorBTNClicked(MouseEvent event) {
        textForapTXT.setText("Управление посетителями");
        addRoomAPane.setVisible(false);
        infoAPane.setVisible(false);
        VisitorAPane.setVisible(true);
    }

    @FXML
    void uVisitorBTNEnter(MouseEvent event) {
        CSS.ButtonEnterChange(uVisitorBTN);
    }

    @FXML
    void uVisitorBTNExit(MouseEvent event) {
        CSS.ButtonExitedChange(uVisitorBTN);
    }

    @FXML
    void initialize() {
        {
            typeAddRoomChs.getItems().addAll(typeRoom);
            typeAddRoomChs.setValue("Стандартный");



            choiseTypeCHS.getItems().addAll(table);
            choiseTypeCHS.setValue("Все");

            typeAddVisitorCh.getItems().addAll(typeRoom);
            typeAddVisitorCh.setValue("-Выберите тип комнаты-");

            HourseForComVisitorChs.getItems().addAll(hours);
            HourseForComVisitorChs.setValue("00");

            minForComVisitorChs.getItems().addAll(minutes);
            minForComVisitorChs.setValue("00");

            hourseForOutVisitorChs.getItems().addAll(hours);
            hourseForOutVisitorChs.setValue("00");

            minForOutVisitorChs.getItems().addAll(minutes);
            minForOutVisitorChs.setValue("00");

            dayForComVisitorChs.getItems().addAll(day);
            dayForComVisitorChs.setValue("01");

            monthForComVisitorChs.getItems().addAll(month);
            monthForComVisitorChs.setValue("01");

            yearForComVisitorChs.getItems().addAll(years);
            yearForComVisitorChs.setValue("2022");

            dayForOutVisitorChs.getItems().addAll(day);
            dayForOutVisitorChs.setValue("01");

            monthForOutVisitorChs.getItems().addAll(month);
            monthForOutVisitorChs.setValue("01");

            yearForOutVisitorChs.getItems().addAll(years);
            yearForOutVisitorChs.setValue("2022");

            numberRoomAddVisitorChs.setValue("-Выберите тип комнаты-");
            numberPeopleAddVisitorChs.setValue("-Выберите комнату-");
            typeAddVisitorCh.setOnAction(this::typeAddVisitorChAction);
            numberRoomAddVisitorChs.setOnAction(this::numberRoomAddVisitorChsAction);
            initChB();

            typeTColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
            numberRoomTColumn.setCellValueFactory(new PropertyValueFactory<>("Num"));
            VisitorTColumn.setCellValueFactory(new PropertyValueFactory<>("CountPeople"));
            salaryTColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
            minTColumn.setCellValueFactory(new PropertyValueFactory<>("Min_tern"));
            maxTColumn.setCellValueFactory(new PropertyValueFactory<>("Max_tern"));
            statusTColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
            timeEntryTColumn.setCellValueFactory(new PropertyValueFactory<>("Entry"));
            timeOutTColumn.setCellValueFactory(new PropertyValueFactory<>("Exit"));
            choiseTypeCHS.setOnAction(this::choiseTypeCHSAction);

            choiseTypeCHS();
        }
    }

    void initChB(){
        try {
            numberRoomAddRoomChs.getItems().clear();
            numberRoomAddRoomChs.getItems().addAll(getFreeNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        numberRoomAddRoomChs.setValue("-Не выбрано-");
        try {
            numberDeleteRoomCH.getItems().clear();
            numberDeleteRoomCH.getItems().addAll(getBuseNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        numberDeleteRoomCH.setValue("-Не выбрано-");
    }
    private void typeAddVisitorChAction(ActionEvent event){
        numberRoomAddVisitorChs.getItems().clear();
        String value =typeAddVisitorCh.getValue();
        if(value.equals("Стандартный")){
            try {
                numberRoomAddVisitorChs.getItems().addAll(getStandeNum());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(value.equals("Люкc")){
            try {
                numberRoomAddVisitorChs.getItems().addAll(getSuiteNum());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(value.equals("Полулюкс")){
            try {
                numberRoomAddVisitorChs.getItems().addAll(getJunSuiteNum());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void numberRoomAddVisitorChsAction(ActionEvent event){
        numberPeopleAddVisitorChs.getItems().clear();
        ArrayList<String> numList = new ArrayList<String>();
        DataBAseHandler dbaHandler=new DataBAseHandler();
        int num=Integer.parseInt(numberRoomAddVisitorChs.getValue());
        int max=dbaHandler.getMaxPeople(num);
        for (int i=1;i<=max;i++){
            numList.add(""+i);
        }
        numberPeopleAddVisitorChs.getItems().addAll(numList);

    }
    private void choiseTypeCHSAction(ActionEvent event) {
        choiseTypeCHS();
    }
    private void choiseTypeCHS(){
        String value=choiseTypeCHS.getValue();
        DataBAseHandler dbaHandler=new DataBAseHandler();
        ArrayList<PropertyRoom> arrayList=new ArrayList<PropertyRoom>();

        ResultSet resultSet;
        if(value.equals("Все")){
            resultSet= dbaHandler.getAll();
            if(resultSet==null)
                return;

            while(true){
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PropertyRoom room= null;
                try {
                    room = new PropertyRoom(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4),
                            resultSet.getDouble(5),
                            resultSet.getDouble(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                arrayList.add(room);
            }

        }
        if(value.equals("Люкc")){
            resultSet= dbaHandler.getSuite();
            if(resultSet==null)
                return;

            while(true){
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PropertyRoom room= null;
                try {
                    room = new PropertyRoom(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4),
                            resultSet.getDouble(5),
                            resultSet.getDouble(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                arrayList.add(room);
            }
        }
        if(value.equals("Полулюкс")){
            resultSet= dbaHandler.getJunSuite();
            if(resultSet==null)
                return;

            while(true){
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PropertyRoom room= null;
                try {
                    room = new PropertyRoom(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4),
                            resultSet.getDouble(5),
                            resultSet.getDouble(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                arrayList.add(room);
            }
        }
        if(value.equals("Стандартный")){
            resultSet= dbaHandler.getStand();
            if(resultSet==null)
                return;

            while(true){
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PropertyRoom room= null;
                try {
                    room = new PropertyRoom(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4),
                            resultSet.getDouble(5),
                            resultSet.getDouble(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                arrayList.add(room);
            }
        }
        ObservableList<PropertyRoom> observableList= FXCollections.observableList(arrayList);
        infoTable.setItems(observableList);
    }
}
