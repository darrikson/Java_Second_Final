// Name : Rick Williams
// Course: CIT 230
// Date: 10th November 2020
package rwilliams_cit230_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class RWilliams_CIT230_Final extends Application {
    //
    // Pieces - imageviews for the player pieces
    //     
          
    static Image redPiece = new Image("images/pieceRed.png");
    static Image bluePiece = new Image("images/pieceBlue.png");
    static ImageView red1st = new ImageView(redPiece);
    static ImageView red2nd = new ImageView(redPiece);
    static ImageView red3rd = new ImageView(redPiece);
    static ImageView red4th = new ImageView(redPiece);
    static ImageView red5th = new ImageView(redPiece);
    static ImageView red6th = new ImageView(redPiece);
    static ImageView red7th = new ImageView(redPiece);
    static ImageView red8th = new ImageView(redPiece);
        
    static ImageView blue1st = new ImageView(bluePiece);
    static ImageView blue2nd = new ImageView(bluePiece);
    static ImageView blue3rd = new ImageView(bluePiece);
    static ImageView blue4th = new ImageView(bluePiece);
    static ImageView blue5th = new ImageView(bluePiece);
    static ImageView blue6th = new ImageView(bluePiece);
    static ImageView blue7th = new ImageView(bluePiece);
    static ImageView blue8th = new ImageView(bluePiece);
        
    
    static BorderPane rootPane = new BorderPane();
    
    
    //
    // Title Pane - needs title label, turn label, and turn counter label
    // 
        
    static VBox titlePane = new VBox();        
    static Label lblTitle = new Label("Forward Chance");
    static HBox titleHlder = new HBox(lblTitle);     
    static Label lblTurn = new Label("This Turn: Red");                        
    static int Turn = 1;
    static Label lblTurnCounter =  new Label("Turn:  " + Turn); 
    static HBox btmLblHlder = new HBox();       
    static HBox turnHlder = new HBox(lblTurn);    
    static HBox counterHlder = new HBox(lblTurnCounter);
    
    //
    // Menu Pane - needs menu label, and buttons for menu controls
    //
    
    static VBox menuPane = new VBox();              
    static Label lblMenu = new Label("Menu");        
    static Button btnNew = new Button("Start New Game");       
    static Button btnLoad = new Button("Load Saved Game");        
    static Button btnSave = new Button("Save Game");        
    static Button btnRed = new Button("Red Resigns");        
    static Button btnBlue = new Button("Blue Resigns");        
    static ToggleButton btnMoves = new ToggleButton("Show All Moves");        
    static Button btnExit = new Button("Exit");
        
    //
    // Move Pane - needs label for move history, vertical textbox for display of history
    //
    
    static VBox movePane = new VBox();        
    static Label lblMoveHistory = new Label("Move History");              
    static TextArea taMoveHistory = new TextArea();        
    static ScrollPane taMoveListHolder = new ScrollPane(taMoveHistory);
        
    //
    // Bin Pane - holds bins for lost pieces, lost to R, lost to B, lost to FF
    //
    
    static HBox binPane =  new HBox();        
    static VBox paneLostBlue = new VBox();        
    static VBox paneLostFF = new VBox();
    static VBox paneLostRed = new VBox();
    static Label lblLostBlue = new Label("Lost Blue Pieces");        
    static Label lblLostFF = new Label("Lost to Friendly Fire");        
    static Label lblLostRed = new Label("Lost Red Pieces");        
    static FlowPane binLostBlue = new FlowPane();          
    static FlowPane binLostFF = new FlowPane();        
    static FlowPane binLostRed = new FlowPane();
    
    //
    // Play Pane - holds gridPane for play space, and individual stack panes
    // Unfortunately you can't automate naming assignments    
    
    static GridPane playPane = new GridPane();        
    static Image panelWhite = new Image("images/boardWhite.jpg");
    static Image panelBrown = new Image("images/boardBrown.jpg");
    static StackPane indicator = new StackPane();        
    static StackPane APane = new StackPane();
    static ImageView Apanel = new ImageView(panelWhite);
    // So I learned you can't re-use ImageViews, which makes this suck even more        
    static ImageView AImage = new ImageView("images/letterA.png");       
    static StackPane BPane  = new StackPane();
    static ImageView Bpanel = new ImageView(panelBrown);       
    static ImageView BImage = new ImageView("images/letterB.png");       
    static StackPane CPane  = new StackPane();
    static ImageView Cpanel = new ImageView(panelWhite);        
    static ImageView CImage = new ImageView("images/letterC.png");      
    static StackPane DPane  = new StackPane();
    static ImageView Dpanel = new ImageView(panelBrown);        
    static ImageView DImage = new ImageView("images/letterD.png");       
    static StackPane EPane  = new StackPane();
    static ImageView Epanel = new ImageView(panelWhite);        
    static ImageView EImage = new ImageView("images/letterE.png");     
    static StackPane FPane  = new StackPane();
    static ImageView Fpanel = new ImageView(panelBrown);        
    static ImageView FImage = new ImageView("images/letterF.png");        
    static StackPane GPane  = new StackPane();
    static ImageView Gpanel = new ImageView(panelWhite);        
    static ImageView GImage = new ImageView("images/letterG.png");        
    static StackPane HPane  = new StackPane();
    static ImageView Hpanel = new ImageView(panelBrown);        
    static ImageView HImage = new ImageView("images/letterH.png");        
    static StackPane ColHeader1Pane  = new StackPane();
    static ImageView Col1panel = new ImageView(panelWhite);        
    static ImageView Num1Image = new ImageView("images/number1.png");        
    static StackPane ColHeader2Pane  = new StackPane();
    static ImageView Col2panel = new ImageView(panelBrown);        
    static ImageView Num2Image = new ImageView("images/number2.png");        
    static StackPane ColHeader3Pane  = new StackPane();
    static ImageView Col3panel = new ImageView(panelWhite);        
    static ImageView Num3Image = new ImageView("images/number3.png");        
    static StackPane ColHeader4Pane  = new StackPane();
    static ImageView Col4panel = new ImageView(panelBrown);        
    static ImageView Num4Image = new ImageView("images/number4.png");        
    static StackPane ColHeader5Pane  = new StackPane();
    static ImageView Col5panel = new ImageView(panelWhite);        
    static ImageView Num5Image = new ImageView("images/number5.png");        
    static StackPane ColHeader6Pane  = new StackPane();
    static ImageView Col6panel = new ImageView(panelBrown);        
    static ImageView Num6Image = new ImageView("images/number6.png");        
    static StackPane ColHeader7Pane  = new StackPane();
    static ImageView Col7panel = new ImageView(panelWhite);        
    static ImageView Num7Image = new ImageView("images/number7.png");                
    static StackPane ColHeader8Pane  = new StackPane();
    static ImageView Col8panel = new ImageView(panelBrown);        
    static ImageView Num8Image = new ImageView("images/number8.png");        
    static StackPane A1Pane  = new StackPane();
    static Label lblA1 = new Label("11");
    static ImageView A1panel = new ImageView(panelBrown);   
    static StackPane A2Pane  = new StackPane();
    static Label lblA2 = new Label("12");
    static ImageView A2panel = new ImageView(panelWhite);        
    static StackPane A3Pane  = new StackPane();
    static Label lblA3 = new Label("13");
    static ImageView A3panel = new ImageView(panelBrown);        
    static StackPane A4Pane  = new StackPane();
    static Label lblA4 = new Label("14");
    static ImageView A4panel = new ImageView(panelWhite);       
    static StackPane A5Pane  = new StackPane();
    static Label lblA5 = new Label("15");
    static ImageView A5panel = new ImageView(panelBrown);        
    static StackPane A6Pane  = new StackPane();
    static Label lblA6 = new Label("16");
    static ImageView A6panel = new ImageView(panelWhite);       
    static StackPane A7Pane  = new StackPane();
    static Label lblA7 = new Label("17");
    static ImageView A7panel = new ImageView(panelBrown);        
    static StackPane A8Pane  = new StackPane();
    static Label lblA8 = new Label("18");
    static ImageView A8panel = new ImageView(panelWhite);        
    static StackPane B1Pane  = new StackPane();
    static Label lblB1 = new Label("21");
    static ImageView B1panel = new ImageView(panelWhite);        
    static StackPane B2Pane  = new StackPane();
    static Label lblB2 = new Label("22");
    static ImageView B2panel = new ImageView(panelBrown);        
    static StackPane B3Pane  = new StackPane();
    static Label lblB3 = new Label("23");
    static ImageView B3panel = new ImageView(panelWhite);        
    static StackPane B4Pane  = new StackPane();
    static Label lblB4 = new Label("24");
    static ImageView B4panel = new ImageView(panelBrown);        
    static StackPane B5Pane  = new StackPane();
    static Label lblB5 = new Label("25");
    static ImageView B5panel = new ImageView(panelWhite);        
    static StackPane B6Pane  = new StackPane();
    static Label lblB6 = new Label("26");
    static ImageView B6panel = new ImageView(panelBrown);        
    static StackPane B7Pane  = new StackPane();
    static Label lblB7 = new Label("27");
    static ImageView B7panel = new ImageView(panelWhite);        
    static StackPane B8Pane  = new StackPane();
    static Label lblB8 = new Label("28");
    static ImageView B8panel = new ImageView(panelBrown);      
    static StackPane C1Pane  = new StackPane();
    static Label lblC1 = new Label("31");
    static ImageView C1panel = new ImageView(panelBrown);        
    static StackPane C2Pane  = new StackPane();
    static Label lblC2 = new Label("32");
    static ImageView C2panel = new ImageView(panelWhite);        
    static StackPane C3Pane  = new StackPane();
    static Label lblC3 = new Label("33");
    static ImageView C3panel = new ImageView(panelBrown);        
    static StackPane C4Pane  = new StackPane();
    static Label lblC4 = new Label("34");
    static ImageView C4panel = new ImageView(panelWhite);        
    static StackPane C5Pane  = new StackPane();
    static Label lblC5 = new Label("35");
    static ImageView C5panel = new ImageView(panelBrown);        
    static StackPane C6Pane  = new StackPane();
    static Label lblC6 = new Label("36");
    static ImageView C6panel = new ImageView(panelWhite);        
    static StackPane C7Pane  = new StackPane();
    static Label lblC7 = new Label("37");
    static ImageView C7panel = new ImageView(panelBrown);        
    static StackPane C8Pane  = new StackPane();
    static Label lblC8 = new Label("38");
    static ImageView C8panel = new ImageView(panelWhite);        
    static StackPane D1Pane  = new StackPane();
    static Label lblD1 = new Label("41");
    static ImageView D1panel = new ImageView(panelWhite);        
    static StackPane D2Pane  = new StackPane();
    static Label lblD2 = new Label("42");
    static ImageView D2panel = new ImageView(panelBrown);       
    static StackPane D3Pane  = new StackPane();
    static Label lblD3 = new Label("43");
    static ImageView D3panel = new ImageView(panelWhite);        
    static StackPane D4Pane  = new StackPane();
    static Label lblD4 = new Label("44");
    static ImageView D4panel = new ImageView(panelBrown);        
    static StackPane D5Pane  = new StackPane();
    static Label lblD5 = new Label("45");
    static ImageView D5panel = new ImageView(panelWhite);        
    static StackPane D6Pane  = new StackPane();
    static Label lblD6 = new Label("46");
    static ImageView D6panel = new ImageView(panelBrown);        
    static StackPane D7Pane  = new StackPane();
    static Label lblD7 = new Label("47");
    static ImageView D7panel = new ImageView(panelWhite);        
    static StackPane D8Pane  = new StackPane();
    static Label lblD8 = new Label("48");
    static ImageView D8panel = new ImageView(panelBrown);        
    static StackPane E1Pane  = new StackPane();
    static Label lblE1 = new Label("51");
    static ImageView E1panel = new ImageView(panelBrown);        
    static StackPane E2Pane  = new StackPane();
    static Label lblE2 = new Label("52");
    static ImageView E2panel = new ImageView(panelWhite);        
    static StackPane E3Pane  = new StackPane();
    static Label lblE3 = new Label("53");
    static ImageView E3panel = new ImageView(panelBrown);        
    static StackPane E4Pane  = new StackPane();
    static Label lblE4 = new Label("54");
    static ImageView E4panel = new ImageView(panelWhite);        
    static StackPane E5Pane  = new StackPane();
    static Label lblE5 = new Label("55");
    static ImageView E5panel = new ImageView(panelBrown);        
    static StackPane E6Pane  = new StackPane();
    static Label lblE6 = new Label("56");
    static ImageView E6panel = new ImageView(panelWhite);        
    static StackPane E7Pane  = new StackPane();
    static Label lblE7 = new Label("57");
    static ImageView E7panel = new ImageView(panelBrown);        
    static StackPane E8Pane  = new StackPane();
    static Label lblE8 = new Label("58");
    static ImageView E8panel = new ImageView(panelWhite);        
    static StackPane F1Pane  = new StackPane();
    static Label lblF1 = new Label("61");
    static ImageView F1panel = new ImageView(panelWhite);        
    static StackPane F2Pane  = new StackPane();
    static Label lblF2 = new Label("62");
    static ImageView F2panel = new ImageView(panelBrown);        
    static StackPane F3Pane  = new StackPane();
    static Label lblF3 = new Label("63");
    static ImageView F3panel = new ImageView(panelWhite);        
    static StackPane F4Pane  = new StackPane();
    static Label lblF4 = new Label("64");
    static ImageView F4panel = new ImageView(panelBrown);        
    static StackPane F5Pane  = new StackPane();
    static Label lblF5 = new Label("65");
    static ImageView F5panel = new ImageView(panelWhite);        
    static StackPane F6Pane  = new StackPane();
    static Label lblF6 = new Label("66");
    static ImageView F6panel = new ImageView(panelBrown);        
    static StackPane F7Pane  = new StackPane();
    static Label lblF7 = new Label("67");
    static ImageView F7panel = new ImageView(panelWhite);        
    static StackPane F8Pane  = new StackPane();
    static Label lblF8 = new Label("68");
    static ImageView F8panel = new ImageView(panelBrown);        
    static StackPane G1Pane  = new StackPane();
    static Label lblG1 = new Label("71");
    static ImageView G1panel = new ImageView(panelBrown);        
    static StackPane G2Pane  = new StackPane();
    static Label lblG2 = new Label("72");
    static ImageView G2panel = new ImageView(panelWhite);        
    static StackPane G3Pane  = new StackPane();
    static Label lblG3 = new Label("73");
    static ImageView G3panel = new ImageView(panelBrown);        
    static StackPane G4Pane  = new StackPane();
    static Label lblG4 = new Label("74");
    static ImageView G4panel = new ImageView(panelWhite);        
    static StackPane G5Pane  = new StackPane();
    static Label lblG5 = new Label("75");
    static ImageView G5panel = new ImageView(panelBrown);        
    static StackPane G6Pane  = new StackPane();
    static Label lblG6 = new Label("76");
    static ImageView G6panel = new ImageView(panelWhite);        
    static StackPane G7Pane  = new StackPane();
    static Label lblG7 = new Label("77");
    static ImageView G7panel = new ImageView(panelBrown);        
    static StackPane G8Pane  = new StackPane();
    static Label lblG8 = new Label("78");
    static ImageView G8panel = new ImageView(panelWhite);       
    static StackPane H1Pane  = new StackPane();
    static Label lblH1 = new Label("81");
    static ImageView H1panel = new ImageView(panelWhite);        
    static StackPane H2Pane  = new StackPane();
    static Label lblH2 = new Label("82");
    static ImageView H2panel = new ImageView(panelBrown);        
    static StackPane H3Pane  = new StackPane();
    static Label lblH3 = new Label("83");
    static ImageView H3panel = new ImageView(panelWhite);        
    static StackPane H4Pane  = new StackPane();
    static Label lblH4 = new Label("84");
    static ImageView H4panel = new ImageView(panelBrown);        
    static StackPane H5Pane  = new StackPane();
    static Label lblH5 = new Label("85");
    static ImageView H5panel = new ImageView(panelWhite);        
    static StackPane H6Pane  = new StackPane();
    static Label lblH6 = new Label("86");
    static ImageView H6panel = new ImageView(panelBrown);        
    static StackPane H7Pane  = new StackPane();
    static Label lblH7 = new Label("87");
    static ImageView H7panel = new ImageView(panelWhite);        
    static StackPane H8Pane  = new StackPane();
    static Label lblH8 = new Label("88");
    static ImageView H8panel = new ImageView(panelBrown);       
    // Yup, that sucked
    
    //
    /* Other Requirements - each team needs an ArrayList of pieces, lost pieces
    are stored in a stack, FF is stored in a LinkedList, moves are stored in a
    queue, will need a shadow board for doing math for move/attack checking */
    //
    
    static ArrayList<Piece> RedTeam = new ArrayList<>();
    static ArrayList<Piece> BlueTeam = new ArrayList<>();
    static Stack<Piece> lostBlue = new Stack<>();
    static Stack<Piece> lostRed = new Stack<>();
    static LinkedList<Piece> lostFF = new LinkedList<>();
    static Queue<String> moveHistory = new LinkedList<>();
    static Queue<String> writerMoveHistory = new LinkedList<>();
    static BoardPanel[] ShadowBoard = new BoardPanel[89];
    static BoardPanel LostBlue = new BoardPanel(1);
    static BoardPanel LostRed = new BoardPanel(2);
    static BoardPanel LostFF = new BoardPanel(3);    
    static String Rules = "Rules:\nClick on a piece to move it \nand advance across the board.\nWhen it is a players turn\nand there is an opposing piece\non a connecting panel, the\nplayer may choose to capture the piece\nor move on.\nOnly one piece may occupy a space \nat a time.\nWhen a piece advances all\nthe way across the board\nit will be dropped randomly\nback in the starting column\nit will remove whatever piece\nit lands on, including\nit's own team.\nWin Conditions:\nThe player who can capture all\nthe opposing team's pieces\nwill win.\nIf neither player has won\nafter 200 turns then\nthe player with more\nremaining pieces is the winner\nIn the event of a tie\nthe player who lost more\npieces to friendly fire loses\nIf this is a tie, then\nthe player who moved first\nloses.";
    
    static BluePiece blue1 = new BluePiece(blue1st);
    static BluePiece blue2 = new BluePiece(blue2nd);
    static BluePiece blue3 = new BluePiece(blue3rd);
    static BluePiece blue4 = new BluePiece(blue4th);
    static BluePiece blue5 = new BluePiece(blue5th);
    static BluePiece blue6 = new BluePiece(blue6th);
    static BluePiece blue7 = new BluePiece(blue7th);
    static BluePiece blue8 = new BluePiece(blue8th);
    
    static RedPiece red1 = new RedPiece(red1st);
    static RedPiece red2 = new RedPiece(red2nd);
    static RedPiece red3 = new RedPiece(red3rd);
    static RedPiece red4 = new RedPiece(red4th);
    static RedPiece red5 = new RedPiece(red5th);
    static RedPiece red6 = new RedPiece(red6th);
    static RedPiece red7 = new RedPiece(red7th);
    static RedPiece red8 = new RedPiece(red8th);
    
    static int moveFirst = 0;
    static int hasMove = 0;    
    
    //
    // File system 
    //
    static File pieces = new File("pieces.txt");
    static File moves = new File("moves.txt");
    static File info = new File("info.txt");
    
    @Override
    public void start(Stage primaryStage) {
                      
        //
        // Title Pane - options on titlePane items
        //
                        
        lblTitle.setFont(Font.font("Helvetica", 64));        
        titleHlder.setAlignment(Pos.CENTER);               
        lblTurn.setFont(Font.font("Times New Roman", 48));            
        lblTurnCounter.setFont(Font.font("Times New Roman", 48));         
        btmLblHlder.setAlignment(Pos.CENTER);
        btmLblHlder.setSpacing(276);        
        turnHlder.setAlignment(Pos.TOP_LEFT);        
        counterHlder.setAlignment(Pos.TOP_RIGHT);
        btmLblHlder.getChildren().addAll(turnHlder, counterHlder);        
        titlePane.getChildren().addAll(titleHlder, btmLblHlder);
        
        //
        // Menu Pane - options for menuPane items
        //       
               
        menuPane.setPrefSize(276, 666);
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setPadding(new Insets(10));
        menuPane.setSpacing(10);        
        lblMenu.setFont(Font.font("Times New Roman", 36));        
        btnNew.setFont(Font.font("Times New Roman", 24));        
        btnLoad.setFont(Font.font("Times New Roman", 24));        
        btnSave.setFont(Font.font("Times New Roman", 24));        
        btnRed.setFont(Font.font("Times New Roman", 24));        
        btnBlue.setFont(Font.font("Times New Roman", 24));        
        btnMoves.setFont(Font.font("Times New Roman", 24));        
        btnExit.setFont(Font.font("Times New Roman", 24));
        menuPane.getChildren().addAll(lblMenu, btnNew, btnLoad, btnSave, btnRed, 
                btnBlue, btnMoves, btnExit);
        
        //
        // Move Pane - options for movePane items
        //
                
        movePane.setPadding(new Insets(10));
        movePane.setSpacing(50);
        movePane.setPrefSize(276,666);
        movePane.setAlignment(Pos.CENTER);        
        lblMoveHistory.setFont(Font.font("Times New Roman",FontWeight.BOLD, 24));                
        taMoveHistory.setEditable(false);
        taMoveHistory.setPrefRowCount(36);             
        movePane.getChildren().addAll(lblMoveHistory, taMoveListHolder);
        
        //
        // Bin Pane - options on binPane items
        //
                
        binPane.setAlignment(Pos.TOP_CENTER);
        binPane.setPadding(new Insets(20));
        binPane.setSpacing(50);     
        paneLostBlue.setAlignment(Pos.CENTER);
        paneLostBlue.setSpacing(10);        
        paneLostFF.setAlignment(Pos.CENTER);
        paneLostFF.setSpacing(10);       
        paneLostRed.setAlignment(Pos.CENTER);
        paneLostRed.setSpacing(10);        
        lblLostBlue.setFont(Font.font("Times New Roman", 24));        
        lblLostFF.setFont(Font.font("Times New Roman", 24));        
        lblLostRed.setFont(Font.font("Times New Roman", 24));        
        binLostBlue.setAlignment(Pos.TOP_CENTER);
        binLostBlue.setMinSize(270, 145);
        binLostBlue.setMaxSize(270, 145);
        binLostBlue.setStyle("-fx-border-color: black; -fx-stroke: black; "
                + "-fx-background-color: white");                
        binLostFF.setAlignment(Pos.TOP_CENTER);
        binLostFF.setMinSize(270, 145);
        binLostFF.setMaxSize(270, 145);
        binLostFF.setStyle("-fx-border-color: black; -fx-stroke: black; "
                + "-fx-background-color: white");        
        binLostRed.setAlignment(Pos.TOP_CENTER);
        binLostRed.setMinSize(270, 145);
        binLostRed.setMaxSize(270, 145);
        binLostRed.setStyle("-fx-border-color: black; -fx-stroke: black; "
                + "-fx-background-color: white");
        
        paneLostRed.getChildren().addAll(lblLostRed, binLostRed);
        paneLostFF.getChildren().addAll(lblLostFF, binLostFF);
        paneLostBlue.getChildren().addAll(lblLostBlue, binLostBlue);
        binPane.getChildren().addAll(paneLostBlue, paneLostFF, paneLostRed);
        
        //
        // Play Pane - options on playPane items
        // 
        
        playPane.setAlignment(Pos.CENTER);
        playPane.getColumnConstraints().add(new ColumnConstraints(74));
        playPane.getRowConstraints().add(new RowConstraints(74));            
        indicator.setMinSize(74, 74);
        indicator.setMaxSize(74, 74);        
        APane.getChildren().add(Apanel);      
        APane.getChildren().add(AImage);        
        BPane.getChildren().add(Bpanel);        
        BPane.getChildren().add(BImage);        
        CPane.getChildren().add(Cpanel);        
        CPane.getChildren().add(CImage);        
        DPane.getChildren().add(Dpanel);        
        DPane.getChildren().add(DImage);        
        EPane.getChildren().add(Epanel);        
        EPane.getChildren().add(EImage);        
        FPane.getChildren().add(Fpanel);        
        FPane.getChildren().add(FImage);        
        GPane.getChildren().add(Gpanel);        
        GPane.getChildren().add(GImage);        
        HPane.getChildren().add(Hpanel);        
        HPane.getChildren().add(HImage);        
        ColHeader1Pane.getChildren().add(Col1panel);        
        ColHeader1Pane.getChildren().add(Num1Image);        
        ColHeader2Pane.getChildren().add(Col2panel);        
        ColHeader2Pane.getChildren().add(Num2Image);        
        ColHeader3Pane.getChildren().add(Col3panel);        
        ColHeader3Pane.getChildren().add(Num3Image);        
        ColHeader4Pane.getChildren().add(Col4panel);        
        ColHeader4Pane.getChildren().add(Num4Image);        
        ColHeader5Pane.getChildren().add(Col5panel);        
        ColHeader5Pane.getChildren().add(Num5Image);        
        ColHeader6Pane.getChildren().add(Col6panel);        
        ColHeader6Pane.getChildren().add(Num6Image);        
        ColHeader7Pane.getChildren().add(Col7panel);        
        ColHeader7Pane.getChildren().add(Num7Image);       
        ColHeader8Pane.getChildren().add(Col8panel);        
        ColHeader8Pane.getChildren().add(Num8Image);
        A1Pane.getChildren().addAll(lblA1, A1panel);        
        A2Pane.getChildren().addAll(lblA2, A2panel);        
        A3Pane.getChildren().addAll(lblA3, A3panel);        
        A4Pane.getChildren().addAll(lblA4, A4panel);        
        A5Pane.getChildren().addAll(lblA5, A5panel);        
        A6Pane.getChildren().addAll(lblA6, A6panel);        
        A7Pane.getChildren().addAll(lblA7, A7panel);       
        A8Pane.getChildren().addAll(lblA8, A8panel);        
        B1Pane.getChildren().addAll(lblB1, B1panel);        
        B2Pane.getChildren().addAll(lblB2, B2panel);        
        B3Pane.getChildren().addAll(lblB3, B3panel);        
        B4Pane.getChildren().addAll(lblB4, B4panel);       
        B5Pane.getChildren().addAll(lblB5, B5panel);        
        B6Pane.getChildren().addAll(lblB6, B6panel);        
        B7Pane.getChildren().addAll(lblB7, B7panel);        
        B8Pane.getChildren().addAll(lblB8, B8panel);        
        C1Pane.getChildren().addAll(lblC1, C1panel);        
        C2Pane.getChildren().addAll(lblC2, C2panel);        
        C3Pane.getChildren().addAll(lblC3, C3panel);        
        C4Pane.getChildren().addAll(lblC4, C4panel);        
        C5Pane.getChildren().addAll(lblC5, C5panel);        
        C6Pane.getChildren().addAll(lblC6, C6panel);        
        C7Pane.getChildren().addAll(lblC7, C7panel);        
        C8Pane.getChildren().addAll(lblC8, C8panel);        
        D1Pane.getChildren().addAll(lblD1, D1panel);        
        D2Pane.getChildren().addAll(lblD2, D2panel);        
        D3Pane.getChildren().addAll(lblD3, D3panel);        
        D4Pane.getChildren().addAll(lblD4, D4panel);        
        D5Pane.getChildren().addAll(lblD5, D5panel);        
        D6Pane.getChildren().addAll(lblD6, D6panel);        
        D7Pane.getChildren().addAll(lblD7, D7panel);        
        D8Pane.getChildren().addAll(lblD8, D8panel);        
        E1Pane.getChildren().addAll(lblE1, E1panel);        
        E2Pane.getChildren().addAll(lblE2, E2panel);        
        E3Pane.getChildren().addAll(lblE3, E3panel);        
        E4Pane.getChildren().addAll(lblE4, E4panel);        
        E5Pane.getChildren().addAll(lblE5, E5panel);        
        E6Pane.getChildren().addAll(lblE6, E6panel);        
        E7Pane.getChildren().addAll(lblE7, E7panel);        
        E8Pane.getChildren().addAll(lblE8, E8panel);        
        F1Pane.getChildren().addAll(lblF1, F1panel);        
        F2Pane.getChildren().addAll(lblF2, F2panel);        
        F3Pane.getChildren().addAll(lblF3, F3panel);        
        F4Pane.getChildren().addAll(lblF4, F4panel);        
        F5Pane.getChildren().addAll(lblF5, F5panel);        
        F6Pane.getChildren().addAll(lblF6, F6panel);        
        F7Pane.getChildren().addAll(lblF7, F7panel);        
        F8Pane.getChildren().addAll(lblF8, F8panel);        
        G1Pane.getChildren().addAll(lblG1, G1panel);        
        G2Pane.getChildren().addAll(lblG2, G2panel);        
        G3Pane.getChildren().addAll(lblG3, G3panel);        
        G4Pane.getChildren().addAll(lblG4, G4panel);        
        G5Pane.getChildren().addAll(lblG5, G5panel);        
        G6Pane.getChildren().addAll(lblG6, G6panel);        
        G7Pane.getChildren().addAll(lblG7, G7panel);        
        G8Pane.getChildren().addAll(lblG8, G8panel);        
        H1Pane.getChildren().addAll(lblH1, H1panel);        
        H2Pane.getChildren().addAll(lblH2, H2panel);        
        H3Pane.getChildren().addAll(lblH3, H3panel);        
        H4Pane.getChildren().addAll(lblH4, H4panel);        
        H5Pane.getChildren().addAll(lblH5, H5panel);        
        H6Pane.getChildren().addAll(lblH6, H6panel);        
        H7Pane.getChildren().addAll(lblH7, H7panel);        
        H8Pane.getChildren().addAll(lblH8, H8panel);
        
        playPane.addColumn(0, indicator, APane, BPane, CPane, DPane, EPane, 
                FPane, GPane, HPane);
        playPane.addColumn(1, ColHeader1Pane, A1Pane, B1Pane, C1Pane, D1Pane, 
                E1Pane, F1Pane, G1Pane, H1Pane);
        playPane.addColumn(2, ColHeader2Pane, A2Pane, B2Pane, C2Pane, D2Pane, 
                E2Pane, F2Pane, G2Pane, H2Pane);
        playPane.addColumn(3, ColHeader3Pane, A3Pane, B3Pane, C3Pane, D3Pane, 
                E3Pane, F3Pane, G3Pane, H3Pane);
        playPane.addColumn(4, ColHeader4Pane, A4Pane, B4Pane, C4Pane, D4Pane, 
                E4Pane, F4Pane, G4Pane, H4Pane);
        playPane.addColumn(5, ColHeader5Pane, A5Pane, B5Pane, C5Pane, D5Pane, 
                E5Pane, F5Pane, G5Pane, H5Pane);
        playPane.addColumn(6, ColHeader6Pane, A6Pane, B6Pane, C6Pane, D6Pane, 
                E6Pane, F6Pane, G6Pane, H6Pane);
        playPane.addColumn(7, ColHeader7Pane, A7Pane, B7Pane, C7Pane, D7Pane, 
                E7Pane, F7Pane, G7Pane, H7Pane);
        playPane.addColumn(8, ColHeader8Pane, A8Pane, B8Pane, C8Pane, D8Pane, 
                E8Pane, F8Pane, G8Pane, H8Pane);
        // At least you only have to do it once!       
        
        //
        // rootPane - options and assignments for rootPane and items
        //
        
        rootPane.setTop(titlePane);
        rootPane.setLeft(menuPane);
        rootPane.setRight(movePane);
        rootPane.setBottom(binPane);
        rootPane.setCenter(playPane);
        
        Scene frame = new Scene(rootPane);        
        primaryStage.setScene(frame);
        primaryStage.show();
        
        initializeBoard();
        //From here, we need to set actions for the buttons
        playGame();
    }
    
    public static void main(String[] args) {
        launch(args);        
    }
    
    public static void playGame(){
        //
        // New Game Button
        //
        btnNew.setOnAction( e -> resetBoard());
        //
        // Save Game Button
        //
        btnSave.setOnAction( e ->{
            try{
                PrintWriter pw = new PrintWriter(pieces);
                for(Piece piece : RedTeam){
                    pw.println(piece);
                }
                for(Piece piece : BlueTeam){
                    pw.println(piece);
                }
                pw.close();
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            try{
                PrintWriter pw = new PrintWriter(moves);
                while(!moveHistory.isEmpty()){
                    String play = moveHistory.poll();
                    pw.print(play);
                    writerMoveHistory.offer(play);
                };
                while(!writerMoveHistory.isEmpty()){
                    moveHistory.offer(writerMoveHistory.poll());
                }
                pw.close();
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            try{
                PrintWriter pw = new PrintWriter(info);
                pw.println(moveFirst);
                pw.println(hasMove); 
                pw.println(Turn);
                pw.close();
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Game Saved Successfully");
        });
        //
        // Load Game Button
        //
        btnLoad.setOnAction( e ->{
            if(info.exists() && moves.exists() && pieces.exists()){
            // So we should reset the board first in preparation for the load
            resetBoard();
            // then turn off the board members for all positions
            for(Piece piece : RedTeam){
                setPanelMembers(piece);
            }
            for(Piece piece : BlueTeam){
                setPanelMembers(piece);
            }
            // then load in the pieces values and change them, red team loads first
            int[] pieceValues = new int[32];
            try{
                Scanner scan = new Scanner(pieces);
                for(int x = 0; x < pieceValues.length; x++){
                    pieceValues[x] = scan.nextInt();
                }
                scan.close();
                int index = 0;
                for(Piece piece : RedTeam){
                    piece.Position = pieceValues[index];
                    index++;
                    piece.Active = pieceValues[index];
                    index++;
                }
                index = 16;
                for(Piece piece : BlueTeam){
                    piece.Position = pieceValues[index];
                    index++;
                    piece.Active = pieceValues[index];
                    index++;
                }
                // then re-toggle the board members for the new positions - bins!
                for(Piece piece : RedTeam){
                    if(piece.Active > 0){
                        setPanelMembers(piece);
                    }else if(piece.Position == 2){
                        lostRed.add(piece);
                    }else if(piece.Position == 3){
                        lostFF.addLast(piece);
                    }
                }
                for(Piece piece : BlueTeam){
                    if(piece.Active > 0){
                        setPanelMembers(piece);
                    }else if(piece.Position == 1){
                        lostBlue.add(piece);
                    }else if(piece.Position == 3){
                        lostFF.addLast(piece);
                    }
                }
                // redisplay the pieces
                for(Piece piece : RedTeam){
                    setDisplay(piece, positionTranslator(piece));
                }
                for(Piece piece : BlueTeam){
                    setDisplay(piece, positionTranslator(piece));
                }
                // read the move history directly into the move history queue
                try{
                    scan = new Scanner(moves);
                    while(scan.hasNext()){
                        moveHistory.offer(scan.next()+"\n");
                    }
                    scan.close();
                    // load in and set the info, hasMove -1 then increment the turn
                    int[] infos = new int[3];
                    try{
                        scan = new Scanner(info);                                   
                        infos[0] = scan.nextInt();
                        infos[1] = scan.nextInt();
                        infos[2] = scan.nextInt();
                        scan.close();
                    }catch(FileNotFoundException ex){
                        JOptionPane.showMessageDialog(null, "Saved Game Not Found");
                    }
                    moveFirst = infos[0];
                    hasMove = infos[1];
                    hasMove--;
                    Turn = infos[2];
                    Turn--;
                    turn(true);
                }catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Saved Game Not Found");
                }
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Saved Game Not Found");
            }                      
            }else{
                JOptionPane.showMessageDialog(null, "Saved Game Not Found");
            }
        });
        //
        // Red Resigns Button
        //
        btnRed.setOnAction( e ->{
            JOptionPane.showMessageDialog(null, "Red Resigns\nBlue Wins!");
            resetBoard();
        });
        //
        // Blue Resigns Button
        //
        btnBlue.setOnAction( e ->{
            JOptionPane.showMessageDialog(null, "Blue Resigns\nRed Wins!");
            resetBoard();
        });
        //
        // Show Moves Button
        //
        btnMoves.setOnAction( e -> {
            if(btnMoves.isSelected()){
                taMoveHistory.clear();
                writeMoveHistory();
            }
            else{
                taMoveHistory.clear();
                taMoveHistory.appendText(Rules);
            }
        });
        //
        // Exit Button
        //
        btnExit.setOnAction( e -> Platform.exit());
                
        A1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        A8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        B8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        C8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        D8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        E8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        F8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        G8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H1Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H2Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H3Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H4Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H5Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H6Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H7Pane.setOnMouseClicked( e -> turn(panelClicked(e)));
        H8Pane.setOnMouseClicked( e -> turn(panelClicked(e)));        
    }
    
    // writes the move history queue into the move history display while
    // dumping into a temp queue. Temp queue is then written back to the original
    // queue
    public static void writeMoveHistory(){
        if(!moveHistory.isEmpty()){
            do{
                String play = moveHistory.poll();
                taMoveHistory.appendText(play);
                writerMoveHistory.offer(play);
            }while(!moveHistory.isEmpty());
            do{
                moveHistory.offer(writerMoveHistory.poll());
            }while(!writerMoveHistory.isEmpty());
        }
    }
    
    // checks for winning conditions
    public static boolean checkWin(){
        /* win conditions
        base case: turns are less than 200
            b1: all blue pieces go inactive, red wins
            b2: all red pieces go inactive, blue wins
        over 200:
            o1: color with more active pieces wins
            o2: same number of active pieces
            same#: 
                same1: side that lost less to FF wins
                same2: lostFF is same for both teams
                sameLoss:
                    team that matches hasMove loses                               
        */
        if(Turn < 201){
            int blueActive = 0;
            for(Piece piece : BlueTeam){
                blueActive += piece.Active;
            }
            if(blueActive == 0){
                return true;
            }
            int redActive = 0;
            for(Piece piece : RedTeam){
                redActive += piece.Active;
            }
            if(redActive == 0){
                return true;
            }
        }else if(Turn > 200){
            int blueActive = 0;
            for(Piece piece : BlueTeam){
                blueActive += piece.Active;
            }
            int redActive = 0;
            for(Piece piece : RedTeam){
                redActive += piece.Active;
            }
            if(blueActive > redActive){
                return true;
            }
            else if(redActive > blueActive){
                return true;
            }else if(blueActive == redActive){
                int blueFF = 0;
                for(Piece piece : BlueTeam){
                    if(piece.Position == 3){
                        blueFF++;
                    }
                }
                int redFF = 0;
                for(Piece piece : RedTeam){
                    if(piece.Position == 3){
                        redFF++;
                    }
                }
                if(blueFF > redFF){
                    return true;
                }else if(redFF > blueFF){
                    return true;
                }else if(blueFF == redFF){
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }
    
    // increments turn and changes labels and indicator when a valid move is made
    // checks win conditions at the completion of each turn and announces winner
    // if any conditions have been fulfilled
    public static void turn(boolean goodMove){
        if(goodMove){
            Turn++;
            hasMove++;
            changeTurn(hasMove);             
        }if(checkWin()){
            JOptionPane.showMessageDialog(null, determineWin() + " Wins!");
            resetBoard();
        }
    }
    
    // checks conditions and returns string containing name of winner
    public static String determineWin(){
        String winner = "";
        if(Turn > 200){
            int blueActive = 0;
            for(Piece piece : BlueTeam){
                blueActive += piece.Active;
            }
            int redActive = 0;
            for(Piece piece : RedTeam){
                redActive += piece.Active;
            }
            if(blueActive > redActive){
                winner = "Blue";
            }
            else if(redActive > blueActive){
                winner = "Red";
            }else if(blueActive == redActive){
                int blueFF = 0;
                for(Piece piece : BlueTeam){
                    if(piece.Position == 3){
                        blueFF++;
                    }
                }
                int redFF = 0;
                for(Piece piece : RedTeam){
                    if(piece.Position == 3){
                        redFF++;
                    }
                }
                if(blueFF > redFF){
                    winner = "Red";
                }else if(redFF > blueFF){
                    winner = "Blue";
                }else if(blueFF == redFF){
                    if(moveFirst%2 == 0){
                        winner = "Red";
                    }else{
                        winner = "Blue";
                    }
                }
            }
        }else{
            int blueActive = 0;
            for(Piece piece : BlueTeam){
                blueActive += piece.Active;
            }
            if(blueActive == 0){
                winner = "Red";
            }
            int redActive = 0;
            for(Piece piece : RedTeam){
                redActive += piece.Active;
            }
            if(redActive == 0){
                winner = "Blue";
            }          
        }
        return winner;
    }
    
    public static boolean panelClicked(MouseEvent e){
        /*Okay so if a board panel is clicked
        check the panel for piece ->
            yes ->
                check if piece matches turn
                    yes -> 
                        bind piece and panel
                        check attack possible
                            yes -> use attack method
                            no -> 
                                check if next board is occupied
                                yes - >
                                    nothing
                                no ->
                                    use move method
                                    check if new panel is end of board
                                        yes -> dumboDrop
                                        no -> nothing
                    no -> nothing
            no -> nothing */
        // Figure out how to write stuff into the move history!
        boolean goodMove = false;      
        BoardPanel panel = ShadowBoard[panelFindPosition(e)];
        if(hasPiece(panel)){
            if(matchTurn(panel)){
                Piece boundPiece = bindPiece(determineColor(panel), panel.posValue);
                if(attackPossible(panel, boundPiece)){
                    goodMove = attack(panel, boundPiece);                                            
                }else{
                    BoardPanel nextPanel = checkPanel(boundPiece.Position + boundPiece.Direction());
                    boolean next =
                            hasPiece(nextPanel);
                    if(!next){
                        move(boundPiece);
                        if(checkEnd(boundPiece)){
                            dumboDrop(boundPiece);
                        }
                        goodMove = true;
                    }                                           
                }
            }
        }  
        return goodMove;    
    }
    
    // takes piece that has reached the end and drops it back on the home row
    // on a randomly selected tile, if the tile is occupied
    // the occupying piece is removed. If the occupying piece is the same
    // team, it goes to the friendly fire bin
    public static void dumboDrop(Piece piece){
        Random rand = new Random();
        int row = rand.nextInt(8) + 1;
        String xy = String.valueOf(row) + String.valueOf(piece.homeColumn);
        int coord = Integer.parseInt(xy);
        // check new panel for occupation
        BoardPanel nextPanel = checkPanel(coord);
        boolean next = hasPiece(nextPanel);
        if(next){
            // check panel for match
            if(nextPanel.pieceValue == piece.Color){
                Piece lostPiece = bindPiece(determineColor(nextPanel), coord);
                setPanelMembers(lostPiece);
                lostPiece.Position = 3;
                lostPiece.Active = 0;
                lostFF.addLast(lostPiece);
                setDisplay(lostPiece, positionTranslator(lostPiece));
                setPanelMembers(piece);
                int start = piece.Position;
                piece.Position = coord;
                setPanelMembers(piece);
                setDisplay(piece, positionTranslator(piece));
                String play = positionTranslator(start) + "-" +
                        positionTranslator(piece.Position) + "-X\n";
                moveHistory.offer(play);
                if(btnMoves.isSelected()){
                    taMoveHistory.appendText(play);
                }
            }else{
                BoardPanel cPanel = checkPanel(piece.Position);
                attackFlow(cPanel, piece, nextPanel);
            }
        }else{
            setPanelMembers(piece);
            int start = piece.Position;
            piece.Position = coord;
            setPanelMembers(piece);
            setDisplay(piece, positionTranslator(piece));
            String play = positionTranslator(start) + "-" +
                        positionTranslator(piece.Position) + "\n";
            moveHistory.offer(play);
            if(btnMoves.isSelected()){
                taMoveHistory.appendText(play);
            }
        }
    }
    
    // checks if currently occupied space is an end of the board
    public static boolean checkEnd(Piece piece){
        String xy = String.valueOf(piece.Position);
        xy = xy.substring(1, 2);
        int column = Integer.parseInt(xy);
        if( column == 1 || column == 8){
            return true;
        }else{
            return false;
        }
    }
    
    // advances piece to next position
    public static void move(Piece piece){
        setPanelMembers(piece);
        int start = piece.Position;
        piece.Position = piece.Position + piece.Direction;
        setPanelMembers(piece);
        setDisplay(piece, positionTranslator(piece));
        String play = positionTranslator(start) + "-" +
                        positionTranslator(piece.Position) + "\n";
        moveHistory.offer(play);
        if(btnMoves.isSelected()){
            taMoveHistory.appendText(play);
        }
    }
    
    // asks for area to attack, determines if attack possible, if so, attacks
    // if not, checks if space in front is occupied and attackable
    // will auto attack if both true, auto move if unoccupied
    // else do nothiing
    public static boolean attack(BoardPanel panel, Piece piece){
        /* ask if want to attack        
            yes ->
                ask for space to attack
                check if space is within move constraints
                    yes ->
                        check if space is occupied
                            yes ->
                                check if space is attackable
                                    yes ->
                                        turn off occupying piece board members
                                        reassign occupying piece to appropriate bin
                                        update display
                                        turn off current piece board members
                                        reassign piece to attacked board
                                        turn on board members
                                        update display
                                        return true;
                                    no ->
                                        return false
                            no ->
                                return false
                    no ->
                        return false
            no ->
                check if space ahead is occupied
                yes ->
                    check if attackable
                        yes ->
                            attack
                        no ->
                            return false;
                no ->
                    move
                    return true;
                */
        boolean goodMove = false;
        int result = JOptionPane.showConfirmDialog(null, 
                "Do you want to declare an attack?", "Attack", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        switch(result){
            case 0:
                String attackSpace = 
                JOptionPane.showInputDialog(null, "Enter Name of Space to Attack",
                        "Attack", JOptionPane.PLAIN_MESSAGE);
                if(attackSpace == null){
                    break;
                }
                attackSpace = attackSpace.toUpperCase();                
                int coord = transInput(attackSpace);
                if(coord != 0){
                    BoardPanel attackPanel = checkPanel(coord);
                    if(checkBounds(piece, attackPanel)){
                        boolean next =  hasPiece(attackPanel);
                        if(next){
                            if(attackPanel.pieceValue != piece.Color){
                                attackFlow(panel, piece, attackPanel);
                                if(checkEnd(piece)){
                                    dumboDrop(piece);
                                }     
                            }                                                   
                            goodMove = true;
                            break;
                        }else{
                            break;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Move");
                        break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Move");
                    break;
                }
            case 1:
                BoardPanel nextPanel = checkPanel(piece.Position + piece.Direction());
                boolean next =
                hasPiece(nextPanel);
                if(next){
                    if(nextPanel.pieceValue != piece.Color){
                        attackFlow(panel, piece, nextPanel);
                        if(checkEnd(piece)){
                            dumboDrop(piece);
                        }
                        goodMove = true;
                        break;
                    }else{
                        break;
                    }
                }else{
                    move(piece);
                    if(checkEnd(piece)){
                        dumboDrop(piece);
                    }
                    goodMove = true;
                }
                break;
            default:
                break;
        }             
        return goodMove;
    }
    
    // receives the current panel, piece, and attack panel, runs all operations
    public static void attackFlow(BoardPanel cPanel, Piece piece, BoardPanel aPanel){
        Piece enemyPiece = bindPiece(determineColor(aPanel), aPanel.posValue);
        // turn off occupying piece board members
        setPanelMembers(enemyPiece);
        // reassign occupying piece to appropriate bin
        enemyPiece.Position = piece.Color;
        // add lost piece to appropriate stack
        if(piece.Color == 1){
            lostRed.add(piece);
        }else{
            lostBlue.add(piece);
        }
        //disable active
        enemyPiece.Active = 0;
        // update display
        setDisplay(enemyPiece, positionTranslator(enemyPiece));
        // turn off current piece board members
        setPanelMembers(piece);
        // reassign piece to attacked board
        piece.Position = aPanel.posValue;
        // turn on board members
        setPanelMembers(piece);
        // update display
        setDisplay(piece, positionTranslator(piece));
        String play = positionTranslator(cPanel.posValue) + "-" + 
                positionTranslator(aPanel.posValue) + "-O\n" ;
        moveHistory.offer(play);  
        if(btnMoves.isSelected()){
            taMoveHistory.appendText(play);
        }
    }
    
    // takes in row/column coordinate and returns the corresponding BoardPanel
    // in the ShadowBaord array
    public static BoardPanel checkPanel(int coord){
        return ShadowBoard[coord];
    }
    
    // receives the attacking piece and panel to be attacked, and checks 
    // their distance to determine if the panel is within movement bounds
    public static boolean checkBounds(Piece piece, BoardPanel panel){
        if(piece.Position < 20){
            BoardPanel[] poller = new BoardPanel[3];
            poller[0] = ShadowBoard[(piece.Position + piece.Direction())];
            poller[1] = ShadowBoard[(piece.Position + 10)];
            poller[2] = ShadowBoard[(piece.Position + 10 + piece.Direction())];            
            boolean withinBounds = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.posValue == panel.posValue)){
                    withinBounds = true;
                }
            }
            return withinBounds;
        }else if(piece.Position > 80){
            BoardPanel[] poller = new BoardPanel[3];
            poller[0] = ShadowBoard[(piece.Position + piece.Direction())];
            poller[1] = ShadowBoard[(piece.Position - 10)];
            poller[2] = ShadowBoard[(piece.Position - 10 + piece.Direction())];            
            boolean withinBounds = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.posValue == panel.posValue)){
                    withinBounds = true;
                }
            }
            return withinBounds;
        }else{
            BoardPanel[] poller = new BoardPanel[5];
            poller[0] = ShadowBoard[(piece.Position + piece.Direction())];
            poller[1] = ShadowBoard[(piece.Position + 10)];
            poller[2] = ShadowBoard[(piece.Position + 10 + piece.Direction())];
            poller[3] = ShadowBoard[(piece.Position - 10)];
            poller[4] = ShadowBoard[(piece.Position - 10 + piece.Direction())];            
            boolean withinBounds = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.posValue == panel.posValue)){
                    withinBounds = true;
                }
            }
            return withinBounds;
        }
    }
    
    // takes the board panel and searches surrounding panels for pieces of 
    // opposite value returns true if an attack is possible
    public static boolean attackPossible(BoardPanel panel, Piece piece){
        /* three cases possible, top of board, bottom of board, and middle of
        board top and bottom will use the same size matrix but different math
        while any piece in the middle of the board will use the same operation
        */
        /* so an edge panel will poll above/below, in the direction of the piece
        movement relative to itself, and in the direction of the piece movement
        above/below
        */
        if(panel.posValue < 20){
            BoardPanel[] poller = new BoardPanel[3];
            poller[0] = ShadowBoard[(panel.posValue + piece.Direction())];
            poller[1] = ShadowBoard[(panel.posValue + 10)];
            poller[2] = ShadowBoard[(panel.posValue + 10 + piece.Direction())];            
            boolean attackable = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.pieceValue != piece.Color && panelPiece.pieceValue != 0)){
                    attackable = true;
                }
            }
            return attackable;
        }else if(panel.posValue > 80){
            BoardPanel[] poller = new BoardPanel[3];
            poller[0] = ShadowBoard[(panel.posValue + piece.Direction())];
            poller[1] = ShadowBoard[(panel.posValue - 10)];
            poller[2] = ShadowBoard[(panel.posValue - 10 + piece.Direction())];
            boolean attackable = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.pieceValue != piece.Color && panelPiece.pieceValue != 0)){
                    attackable = true;
                }
            }
            return attackable;
        }else{
            BoardPanel[] poller = new BoardPanel[5];
            poller[0] = ShadowBoard[(panel.posValue + piece.Direction())];
            poller[1] = ShadowBoard[(panel.posValue + 10)];
            poller[2] = ShadowBoard[(panel.posValue + 10 + piece.Direction())];
            poller[3] = ShadowBoard[(panel.posValue - 10)];
            poller[4] = ShadowBoard[(panel.posValue - 10 + piece.Direction())];
            boolean attackable = false;
            for(BoardPanel panelPiece : poller){
                if((panelPiece.pieceValue != piece.Color && panelPiece.pieceValue != 0)){
                    attackable = true;
                }
            }
            return attackable;
        }
    }
    
    // searches the team list for the piece whose position matches the panel
    // and returns the piece
    public static Piece bindPiece(ArrayList<Piece> team, int pos){
        if(team == RedTeam){
            RedPiece match = new RedPiece(new ImageView(redPiece));
            for(int x = 0; x < RedTeam.size(); x++){
                RedPiece temp = new RedPiece(new ImageView(redPiece));
                temp = (RedPiece) RedTeam.get(x);
                if( temp.Position == pos){
                    match = temp;
                }
            }
            return match;
        }else{
            BluePiece match = new BluePiece(new ImageView(bluePiece));
            for(int x = 0; x < BlueTeam.size(); x++){
                BluePiece temp = new BluePiece(new ImageView(bluePiece));
                temp = (BluePiece) BlueTeam.get(x);
                if( temp.Position == pos){
                    match = temp;
                }
            }
            return match;
        }
    }
    
    // takes the shadowboard panel and determines which team the occupying piece
    // belongs to based off the pieceValue
    public static ArrayList<Piece> determineColor(BoardPanel panel){
        if(panel.pieceValue == 1){
            return RedTeam;
        }else{
            return BlueTeam;
        }
    }
    
    // reads the stackpane label and returns the corresponding shadow board value
    public static int panelFindPosition(MouseEvent e){ 
        StackPane pane = (StackPane) e.getSource();
        ObservableList<Node> kids = pane.getChildren();
        Label temp = (Label) kids.get(0);
        int position = Integer.parseInt(temp.getText());
        return position;
    }
    
    // reads and returns the boardpiece hasPiece value
    public static boolean hasPiece(BoardPanel piece){
        return piece.piecePresent;
    }
    
    // reads the boardpiece pieceValue and determines if it matches the current hasMove
    public static boolean matchTurn(BoardPanel piece){
        if((hasMove%2 == 0 && piece.pieceValue%2 ==0)){
            return true;
        }else if((hasMove%2 != 0 && piece.pieceValue%2 != 0)){
            return true;
        }else{
            return false;
        }
    }
    
    //sets up initial board and display at beginning of game
    public static void initializeBoard(){
        for(int x = 1; x < 9; x++){
            for(int y = 1; y < 9; y++){
               String position = String.valueOf(x) + String.valueOf(y);
               int pos = Integer.parseInt(position);
               BoardPanel piece = new BoardPanel(pos);
               ShadowBoard[pos] = piece;               
            }
        }
        
        ShadowBoard[1] = LostBlue;
        ShadowBoard[2] = LostRed;
        ShadowBoard[3] = LostFF;
                
        RedTeam.add(red1);
        RedTeam.add(red2);
        RedTeam.add(red3);
        RedTeam.add(red4);
        RedTeam.add(red5);
        RedTeam.add(red6);
        RedTeam.add(red7);
        RedTeam.add(red8);
                
        BlueTeam.add(blue1);
        BlueTeam.add(blue2);
        BlueTeam.add(blue3);
        BlueTeam.add(blue4);
        BlueTeam.add(blue5);
        BlueTeam.add(blue6);
        BlueTeam.add(blue7);
        BlueTeam.add(blue8);
        
        red1.Position = 12;
        red2.Position = 22;
        red3.Position = 32;
        red4.Position = 42;
        red5.Position = 52;
        red6.Position = 62;
        red7.Position = 72;
        red8.Position = 82;
        
        blue1.Position = 17;
        blue2.Position = 27;
        blue3.Position = 37;
        blue4.Position = 47;
        blue5.Position = 57;
        blue6.Position = 67;
        blue7.Position = 77;
        blue8.Position = 87;
        
        for(Piece piece : RedTeam){
            setPanelMembers(piece);
        }
        for(Piece piece : BlueTeam){
            setPanelMembers(piece);
        }       
                
        resetBoard();        
    }
    
    public static void resetBoard(){               
        // toggles board members and returns a piece to it's original possition
        // if it is not currently in the original position
        if(red1.Position != 12){
            setPanelMembers(red1);
            red1.Position = 12;
            setPanelMembers(red1);
        }
        if(red2.Position != 22){
            setPanelMembers(red2);
            red2.Position = 22;
            setPanelMembers(red2);
        }        
        if(red3.Position != 32){
            setPanelMembers(red3);
            red3.Position = 32;
            setPanelMembers(red3);
        }
        if(red4.Position != 42){
            setPanelMembers(red4);
            red4.Position = 42;
            setPanelMembers(red4);
        }
        if(red5.Position != 52){
            setPanelMembers(red5);
            red5.Position = 52;
            setPanelMembers(red5);
        }
        if(red6.Position != 62){
            setPanelMembers(red6);
            red6.Position = 62;
            setPanelMembers(red6);
        }
        if(red7.Position != 72){
            setPanelMembers(red7);
            red7.Position = 72;
            setPanelMembers(red7);
        }
        if(red8.Position != 82){
            setPanelMembers(red8);
            red8.Position = 82;
            setPanelMembers(red8);
        }
        
        if(blue1.Position != 17){
            setPanelMembers(blue1);
            blue1.Position = 17;
            setPanelMembers(blue1);
        }        
        if(blue2.Position != 27){
            setPanelMembers(blue2);
            blue2.Position = 27;
            setPanelMembers(blue2);
        }
        if(blue3.Position != 37){
            setPanelMembers(blue3);
            blue3.Position = 37;
            setPanelMembers(blue3);
        }
        if(blue4.Position != 47){
            setPanelMembers(blue4);
            blue4.Position = 47;
            setPanelMembers(blue4);
        }
        if(blue5.Position != 57){
            setPanelMembers(blue5);
            blue5.Position = 57;
            setPanelMembers(blue5);
        }
        if(blue6.Position != 67){
            setPanelMembers(blue6);
            blue6.Position = 67;
            setPanelMembers(blue6);
        }
        if(blue7.Position != 77){
            setPanelMembers(blue7);
            blue7.Position = 77;
            setPanelMembers(blue7);
        }
        if(blue8.Position != 87){
            setPanelMembers(blue8);
            blue8.Position = 87;
            setPanelMembers(blue8);
        }
        
        // redisplays pieces back at their original positions
        for(Piece piece : RedTeam){
            setDisplay(piece, positionTranslator(piece));
            piece.Active = 1;
        }
        for(Piece piece : BlueTeam){
            setDisplay(piece, positionTranslator(piece));
            piece.Active = 1;
        }
        
        // empties out all lists if necessary
        if(!lostBlue.empty()){
            do{
                lostBlue.pop();
            }while(!lostBlue.empty());
        }
        if(!lostRed.empty()){
            do{
                lostRed.pop();           
            }while(!lostRed.empty());
        }
        if(!lostFF.isEmpty()){
            lostFF.clear();
        }
        if(!moveHistory.isEmpty()){
            moveHistory.clear();
        }
        
        //resets counters and indicators
        moveFirst = moveFirst();
        hasMove = moveFirst;
        lblTurn.setText("This Turn: " + colorTrans(hasMove));
        indicator(hasMove);
        Turn = 1;
        lblTurnCounter.setText("Turn: " + Turn);
        btnMoves.setSelected(false);
        taMoveHistory.setText(Rules);
    }
    
    // toggles members on current position 
    public static void setPanelMembers(Piece piece){
        // if piece is already present on board, turn off members in prep to move
        if(ShadowBoard[piece.Position].pieceValue == piece.Color){
            ShadowBoard[piece.Position].pieceValue = 0;
            ShadowBoard[piece.Position].piecePresent = false;
        }
        // if piece is not present, change members to make it present
        else{
            ShadowBoard[piece.Position].pieceValue = piece.Color;
            ShadowBoard[piece.Position].piecePresent = true;
        }
    }
    
    // adds piece image to panel, used with initiliatize, load, move, attack, and reset
    public static void setDisplay(Piece piece, Pane panel){
        try{
        panel.getChildren().add(piece.Display);
        }catch(IllegalArgumentException e){};
    }
    
    // used to switch indicator and label turn in one
    public static void changeTurn(int moveFirst){
        lblTurn.setText("This Turn: " + colorTrans(moveFirst));
        indicator(moveFirst);
        lblTurnCounter.setText("Turn : " + Turn);
    }
    
    //used to manipulate lblTurn
    public static String colorTrans(int moveFirst){
        if(moveFirst%2 == 0){
            return "Blue";
        }else{
            return "Red";
        }
    }
    
    //used to switch indicator panel
    public static void indicator(int moveFirst){
        if(moveFirst%2 == 0){
            indicator.setStyle("-fx-background-color: #00A8F3");
        }else{
            indicator.setStyle("-fx-background-color: #88001B");
        }
    }
    
    //randomly determines who goes first
    public static int moveFirst(){
        Random rand = new Random();
        int moveFirst = rand.nextInt(2) + 1;
        return moveFirst;
    }
    
    // a gigantic pain in the ass switch, 
    // that translates the shadow board matrix values into panes
    // for the purpose of adding the piece imageView to the appropriate pane
    public static Pane positionTranslator(Piece piece){
        Pane position = binLostFF;
        switch(piece.Position){
            case 1:
                position = binLostBlue;
                break;
            case 2:
                position = binLostRed;
                break;
            case 3:
                position = binLostFF;
                break;
            case 11:
                position = A1Pane;
                break;
            case 12:
                position = A2Pane;
                break;
            case 13:
                position = A3Pane;
                break;
            case 14:
                position = A4Pane;
                break;
            case 15:
                position = A5Pane;
                break;
            case 16:
                position = A6Pane;
                break;
            case 17:
                position = A7Pane;
                break;
            case 18:
                position = A8Pane;
                break;
            case 21:
                position = B1Pane;
                break;
            case 22:
                position = B2Pane;
                break;
            case 23:
                position = B3Pane;
                break;
            case 24:
                position = B4Pane;
                break;
            case 25:
                position = B5Pane;
                break;
            case 26:
                position = B6Pane;
                break;
            case 27:
                position = B7Pane;
                break;
            case 28:
                position = B8Pane;
                break;
            case 31:
                position =  C1Pane;
                break;
            case 32:
                position =  C2Pane;
                break;
            case 33:
                position =  C3Pane;
                break;
            case 34:
                position =  C4Pane;
                break;
            case 35:
                position =  C5Pane;
                break;
            case 36:
                position =  C6Pane;
                break;
            case 37:
                position =  C7Pane;
                break;
            case 38:
                position =  C8Pane;
                break;
            case 41:
                position =  D1Pane;
                break;
            case 42:
                position =  D2Pane;
                break;
            case 43:
                position =  D3Pane;
                break;
            case 44:
                position =  D4Pane;
                break;
            case 45:
                position =  D5Pane;
                break;
            case 46:
                position =  D6Pane;
                break;
            case 47:
                position =  D7Pane;
                break;
            case 48:
                position =  D8Pane;
                break;
            case 51:
                position =  E1Pane;
                break;
            case 52:
                position =  E2Pane;
                break;
            case 53:
                position =  E3Pane;
                break;
            case 54:
                position =  E4Pane;
                break;                
            case 55:
                position =  E5Pane;
                break;
            case 56:
                position =  E6Pane;
                break;
            case 57:
                position =  E7Pane;
                break;
            case 58:
                position =  E8Pane;
                break;
            case 61:
                position =  F1Pane;
                break;
            case 62:
                position =  F2Pane;
                break;
            case 63:
                position =  F3Pane;
                break;
            case 64:
                position =  F4Pane;
                break;                
            case 65:
                position =  F5Pane;
                break;
            case 66:
                position =  F6Pane;
                break;
            case 67:
                position =  F7Pane;
                break;
            case 68:
                position =  F8Pane;
                break;
            case 71:
                position =  G1Pane;
                break;
            case 72:
                position =  G2Pane;
                break;
            case 73:
                position =  G3Pane;
                break;
            case 74:
                position =  G4Pane;
                break;
            case 75:
                position =  G5Pane;
                break;
            case 76:
                position =  G6Pane;
                break;
            case 77:
                position =  G7Pane;
                break;
            case 78:
                position =  G8Pane;
                break;
            case 81:
                position =  H1Pane;
                break;
            case 82:
                position =  H2Pane;
                break;                
            case 83:
                position =  H3Pane;
                break;
            case 84:
                position =  H4Pane;
                break;
            case 85:
                position =  H5Pane;
                break;
            case 86:
                position =  H6Pane;
                break;
            case 87:
                position =  H7Pane;
                break;
            case 88:
                position =  H8Pane;
                break;
        }
        return position;
    }       
    
    // another pain in the ass switch, this time for user input
    // takes user input in Alpha/Row Number/Column and translates to equivalent
    // Number/Number Row/Column on shadow board. Includes check for valid
    // input and bounds of the shadow board array
    public static int transInput(String input){
        char firstC = input.charAt(0);
        int firstInt = 0;
        String secondC = input.substring(1, 2);
        int secondInt = 0;
        try{
            secondInt = Integer.parseInt(secondC);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Illegal Move");
        }
        if(secondInt < 1 || secondInt > 8){
            return firstInt;
        }
        switch(firstC){
            case 'A':
                firstInt = 1;
                break;
            case 'B':
                firstInt = 2;
                break;
            case 'C':
                firstInt = 3;
                break;
            case 'D':
                firstInt = 4;
                break;
            case 'E':
                firstInt = 5;
                break;
            case 'F':
                firstInt = 6;
                break;
            case 'G':
                firstInt = 7;
                break;
            case 'H':
                firstInt = 8;
                break;
            default: 
                break;
        }
        String result = "";
        if(firstInt == 0){
            return firstInt;
        }else{
            result = String.valueOf(firstInt) + String.valueOf(secondInt);
            int resultInt = Integer.parseInt(result);
            return resultInt;
        }
    }
    
    // one last pain in the ass switch. This one is used to translate moves
    // on the shadow board into the Alpha/Row for the move history
    public static String positionTranslator(int pos){
        String panel = String.valueOf(pos);
        int parseRow = Integer.parseInt(panel.substring(0, 1));
        String col = panel.substring(1);
        String row = "";
        switch(parseRow){
            case 1:
                row = "A";
                break;
            case 2:
                row = "B";
                break;
            case 3:
                row = "C";
                break;
            case 4:
                row = "D";
                break;
            case 5:
                row = "E";
                break;
            case 6:
                row = "F";
                break;
            case 7:
                row = "G";
                break;
            case 8:
                row ="H";
                break;
        }
        return panel = row + col;
    }
}
