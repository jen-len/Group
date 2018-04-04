package sample;
import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application {
     Fridge fridge = new Fridge();
     int x = 0;
     static String userName = "";
     static String fridgeStuff = "";
     static String jdbcUrl = "jdbc:sqlite:src/dbProject.db";
     String grey = ("-fx-font: 14 arial; -fx-background-radius: 8,7,6; -fx-base: #dddddd;");

     ArrayList<String> stuff = new ArrayList<String>();
     ArrayList<String> recipes = new ArrayList<String>();
     Scene Opening, Other;


// @Override
// This is the Login page for the database and uses the userName as the primary key
     public void start(Stage primaryStage) throws Exception {
         //connection to Database
         primaryStage.setTitle("Kitchen Helper");
         //text + text styling
         Text wlcmLbl = new Text("Welcome to KitchenHelper ");
         wlcmLbl.setFont(Font.font("Georgia", FontWeight.BOLD, 28));
         wlcmLbl.setTextAlignment(TextAlignment.CENTER);
         BorderPane bp = new BorderPane();
         bp.setPadding(new Insets(10, 20, 20, 20));

         Label nameLbl = new Label("Enter a Username:");
         TextField userTxt = new TextField();

         VBox logBox = new VBox();

         logBox.setPadding(new Insets(5, 5, 5, 5));

         Button enterBtn = new Button("Enter Your Username");
         //this button registers a new user
         Button registerBtn = new Button("Register Your Username");

         Text error = new Text();
         error.setFill(Color.RED);

         enterBtn.setOnAction(new EventHandler<ActionEvent>() {

             public void handle(ActionEvent e) {
                 if ((userTxt.getText()) != null && !userTxt.getText().isEmpty()) {
                     userName = (userTxt.getText());
                     System.out.println(userName);
                     if (CheckLogin()) {
                         MainMenu(primaryStage);
                         }
                            System.out.println(fridgeStuff);
                    } else {
                        error.setText("Error! You need to Register Your Username!");

                     }

                 }

         }
         );


         registerBtn.setOnAction(new EventHandler<ActionEvent>() {

              public void handle(ActionEvent e) {
                  if ((userTxt.getText()) != null && !userTxt.getText().isEmpty()) {
                      System.out.println(userName);
                      if (!InsertUserData()) {
                          MainMenu(primaryStage);
                      }
                      System.out.println(fridgeStuff);
                  } else {
                      if (userTxt.getText().isEmpty()){
                        error.setText("Error! You need to enter a username!");
                        }
                  }
              }
         }
         );

         logBox.getChildren().addAll(wlcmLbl, bp, nameLbl, error, userTxt, enterBtn, registerBtn);

         Opening = new Scene(logBox, 500, 500);

         primaryStage.setScene(Opening);
         primaryStage.show();

     }
     /*Check Login method
        -returns a boolean namecode
            - false = name hasn't been found
            - true = name has been found and loads user's previous fridge into fridgeStuff
    */
     public boolean CheckLogin() {
         Boolean nameCode = false;
         try {
             Connection con = DriverManager.getConnection(jdbcUrl);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Fridge FROM Users WHERE " +
                     " User='" + userName + "'");
             if (rs.next()) {
                 nameCode = true;
                 fridgeStuff = rs.getString("Fridge");
                 System.out.println("DB OK");
             } else
                 nameCode = false;
             stmt.close();
             con.close();
         } catch (SQLException sqlE) {
             System.out.println("SQL Exception " + sqlE.toString());
         }
         return nameCode;
     }

     /*InsertUserData
        -returns a boolean
        -returns false if name is found and puts fridge in fridgeStuff
        - returns true if name isn't found and inserts data into the database
     */
     public boolean InsertUserData()    {
            Boolean nameCode = true;
            try {
                Connection con = DriverManager.getConnection(jdbcUrl);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE " +
                        " User='" + userName + "'");
                if (rs.next()) {
                    //hes found and therefore false
                    nameCode = false;
                    fridgeStuff = rs.getString("Fridge");
                    System.out.println("DB OK");
                }
                else {
                    nameCode = true;
                    stmt.executeUpdate("INSERT INTO Users (User,Fridge) " +
                                "VALUES('" + userName + "', '" + fridgeStuff + "')");
                    }
                stmt.close();
                con.close();

            } catch (SQLException sqlE) {
                System.out.println("SQL Exception " + sqlE.toString());
            }
            return nameCode;
    }


    public void MainMenu(Stage primaryStage) {
         Label label1 = new Label("Hey " + userName +" Welcome to KitchenHelper!");
         Label label2 = new Label("What do we have to work with today?");

         Text Food = new Text("You currently have: " + fridgeStuff + " in your fridge");
         label1.setPadding(new Insets(5, 5, 5, 35));
         VBox layout1 = new VBox(25);
         primaryStage.setTitle("Kitchen Helper");
         Scene MainMenu = new Scene(layout1, 400, 500);

         // first 5 is top, second is left, third is bottom, last the 15 is from the right
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Button btnDairy = new Button("Dairy");
         Button btnMeat = new Button("Meat");
         Button btnFruit = new Button("Fruit");
         Button btnVeg = new Button("Vegetables");
         Button btnGrain = new Button("Grains");
         Button btnDone = new Button("Done");
         
         btnDairy.setOnAction(e -> DairyMenu(primaryStage));
         btnMeat.setOnAction(e -> MeatMenu(primaryStage));
         btnFruit.setOnAction(e -> FruitMenu(primaryStage));
         btnVeg.setOnAction(e -> VeggieMenu(primaryStage));
         btnGrain.setOnAction(e -> GrainMenu(primaryStage));
         btnDone.setOnAction(e ->
             {
                 try {
                     conclusion(primaryStage);
                 } catch (Exception e1) {
                     e1.printStackTrace();
                 }
             }
         );

         layout1.getChildren().addAll(label1, Food, label2, btnDairy, btnMeat, btnFruit, btnVeg, btnGrain, btnDone);

         primaryStage.setScene(MainMenu);
         primaryStage.show();

     }


     public void DairyMenu(Stage primaryStage) {
         primaryStage.setTitle("Dairy");
         VBox layout1 = new VBox(20);
         Label lblDairy = new Label("What dairy do you have in your fridge?");
         Scene Dairy = new Scene(layout1, 400, 400);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Button btnAdd = new Button("Add");
         Button btnBack = new Button("Back");

         CheckBox[] boxes = new CheckBox[5];

         CheckBox c1 = new CheckBox("milk");
         CheckBox c2 = new CheckBox("eggs");
         CheckBox c3 = new CheckBox("mayonnaise");
         CheckBox c4 = new CheckBox("butter");
         CheckBox c5 = new CheckBox("cheese");

         boxes[0] = c1;
         boxes[1] = c2;
         boxes[2] = c3;
         boxes[3] = c4;
         boxes[4] = c5;

         btnAdd.setOnAction(e ->
         {
             try {
                 addFood(boxes, 4);

                 SelectionMade(primaryStage);

             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         }
         );

         layout1.getChildren().addAll(lblDairy, c1, c2, c3, c4, c5, btnAdd, btnBack);
         primaryStage.setScene(Dairy);
         primaryStage.show();

         btnBack.setOnAction(e ->
         {
             try {
                 MainMenu(primaryStage);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });
     }


     public void MeatMenu(Stage primaryStage) {
         primaryStage.setTitle("Meat");
         VBox layout1 = new VBox(20);
         Label lblMeat = new Label("What meat do you have in your fridge?");
         Scene Meat = new Scene(layout1, 400, 400);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Button btnAdd = new Button("Add");
         Button btnBack = new Button("Back");

         CheckBox[] boxes = new CheckBox[5];

         CheckBox c1 = new CheckBox("chicken");
         CheckBox c2 = new CheckBox("tuna");
         CheckBox c3 = new CheckBox("ground beef");
         CheckBox c4 = new CheckBox("pork");
         CheckBox c5 = new CheckBox("ham");

         boxes[0] = c1;
         boxes[1] = c2;
         boxes[2] = c3;
         boxes[3] = c4;
         boxes[4] = c5;

         btnAdd.setOnAction(e ->
         {
             try {
                 addFood(boxes, 4);
                 SelectionMade(primaryStage);

             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         }
         );

         layout1.getChildren().addAll(lblMeat, c1, c2, c3, c4, c5, btnAdd, btnBack);
         primaryStage.setScene(Meat);
         primaryStage.show();

         btnBack.setOnAction(e ->
         {
             try {
                 MainMenu(primaryStage);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });
     }


     public void FruitMenu(Stage primaryStage) {
         primaryStage.setTitle("Fruit");
         VBox layout1 = new VBox(20);
         Label fLabel = new Label("What fruit do you have in your fridge?");
         Scene Fruit = new Scene(layout1, 400, 400);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Button btnAdd = new Button("Add");
         Button btnBack = new Button("Back");

         CheckBox[] boxes = new CheckBox[5];

         CheckBox c1 = new CheckBox("apples");
         CheckBox c2 = new CheckBox("bananas");
         CheckBox c3 = new CheckBox("strawberries");
         CheckBox c4 = new CheckBox("pineapple");
         CheckBox c5 = new CheckBox("blueberries");

         boxes[0] = c1;
         boxes[1] = c2;
         boxes[2] = c3;
         boxes[3] = c4;
         boxes[4] = c5;

         btnAdd.setOnAction(e ->
         {
             try {
                 addFood(boxes, 4);

                 SelectionMade(primaryStage);

             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });

         layout1.getChildren().addAll(fLabel, c1, c2, c3, c4, c5, btnAdd, btnBack);
         primaryStage.setScene(Fruit);
         primaryStage.show();

         btnBack.setOnAction(e ->
         {
             try {
                 MainMenu(primaryStage);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });
     }


     public void VeggieMenu(Stage primaryStage) {
         primaryStage.setTitle("Vegetables");
         VBox layout1 = new VBox(20);
         Label vLabel = new Label("What vegetables do you have in your fridge?");
         Scene Veggie = new Scene(layout1, 400, 400);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Button btnAdd = new Button("Add");
         Button btnBack = new Button("Back");

         CheckBox[] boxes = new CheckBox[5];

         CheckBox c1 = new CheckBox("carrots");
         CheckBox c2 = new CheckBox("celery");
         CheckBox c3 = new CheckBox("peppers");
         CheckBox c4 = new CheckBox("tomatoes");
         CheckBox c5 = new CheckBox("potatoes");

         boxes[0] = c1;
         boxes[1] = c2;
         boxes[2] = c3;
         boxes[3] = c4;
         boxes[4] = c5;


         btnAdd.setOnAction(e ->
         {
             try {
                 addFood(boxes, 4);

                 SelectionMade(primaryStage);

             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         }
         );


         layout1.getChildren().addAll(vLabel, c1, c2, c3, c4, c5, btnAdd, btnBack);
         primaryStage.setScene(Veggie);
         primaryStage.show();

         btnBack.setOnAction(e ->
         {
             try {
                 MainMenu(primaryStage);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });
     }

     public void GrainMenu(Stage primaryStage) {

         primaryStage.setTitle("Grains");
         VBox layout1 = new VBox(20);
         Label vLabel = new Label("What grains do you have in your fridge?");
         Scene Veggie = new Scene(layout1, 400, 400);
         layout1.setPadding(new Insets(5, 5, 5, 15));


         Button btnAdd = new Button("Add");
         Button btnBack = new Button("Back");


         CheckBox[] boxes = new CheckBox[3];

         CheckBox c1 = new CheckBox("bread");
         CheckBox c2 = new CheckBox("rice");
         CheckBox c3 = new CheckBox("pasta");

         boxes[0] = c1;
         boxes[1] = c2;
         boxes[2] = c3;

         btnAdd.setOnAction(e ->
         {
             try {
                 addFood(boxes, 2);

                 SelectionMade(primaryStage);

             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });

         layout1.getChildren().addAll(vLabel, c1, c2, c3, btnAdd, btnBack);
         primaryStage.setScene(Veggie);
         primaryStage.show();

         btnBack.setOnAction(e ->
         {
             try {
                 MainMenu(primaryStage);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         });
     }

     public void addFood(CheckBox[] boxes, int x) {
         for (int i = 0; i <= x; i++) {
             if (boxes[i].isSelected()) {
                 fridge.setFood(boxes[i].getText());
                 stuff.add(fridge.getFood());
             }
         }
     }

     public void SelectionMade(Stage primaryStage) {
         primaryStage.setTitle("Limbo");
         VBox layout1 = new VBox(20);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         Label sLabel = new Label("Ok adding " + fridge.getFood() + " you have " + fridge.getCounter() + " things so far");

         Scene Selection = new Scene(layout1, 400, 400);

         Button btnBack = new Button("Continue");
         btnBack.setOnAction(e ->
                 {
                     try {
                         MainMenu(primaryStage);
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
         );

         Button btnDone = new Button("Done");
         btnDone.setOnAction(e ->
                 {
                     try {
                         conclusion(primaryStage);
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
         );


         layout1.getChildren().addAll(sLabel, btnBack, btnDone);
         primaryStage.setScene(Selection);
         primaryStage.show();
     }


     public void conclusion(Stage primaryStage) {
         primaryStage.setTitle("conclusion");
         VBox layout1 = new VBox(20);
         layout1.setPadding(new Insets(5, 5, 5, 15));

         TextArea txtDone = new TextArea();
         txtDone.setEditable(false);

         Button btnDairy = new Button("but wait... There's more");
         btnDairy.setOnAction(e ->
                 {
                     try {
//                         stuff.clear();
                         fridge.setCounter(0);
                         MainMenu(primaryStage);
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
         );
         Button exitBtn = new Button("Exit");
         exitBtn.setOnAction(e ->
                 {
                     try {
                         cancel();
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
         );

         //
         StringBuilder newFood = new StringBuilder();
         for (String s : stuff){

                     newFood.append(s);
                     newFood.append(", ");

         }


   System.out.println(newFood);
    fridgeStuff = fridgeStuff + newFood;
        System.out.println(fridgeStuff);

         Button saveBtn = new Button("Save Fridge");
         Button deleteBtn = new Button("Delete User Data");
         Button deletefBtn = new Button("Delete User Fridge");


         deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
             if (userName != null && !userName.isEmpty()) {
                   System.out.println(userName);
                   System.out.println(fridgeStuff);
                   DeleteData();
             }
            }
            });

         saveBtn.setOnAction(new EventHandler<ActionEvent>() {

             public void handle(ActionEvent e) {
                 if (userName != null && !userName.isEmpty()) {
                     SaveData();
                     }

                 }
            }
         );
         //delete button
         deletefBtn.setOnAction(new EventHandler<ActionEvent>() {
               public void handle(ActionEvent e) {
                   if (userName != null && !userName.isEmpty()) {
                       DeleteFridge();
                   }
               }
           }
         );

         txtDone.setText("You have " + stuff + "\nWith that you can make: " +
                 fridge.normText(fridge.findRecipe(stuff)));

         Scene Selection = new Scene(layout1, 400, 400);

         layout1.getChildren().addAll(txtDone, btnDairy, saveBtn, deleteBtn, deletefBtn, exitBtn);
         primaryStage.setScene(Selection);
         primaryStage.show();
     }

     //SaveData: connects to the database and saves the stuff to the fridge

    public void SaveData()    {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Users SET User = '" + userName + "', Fridge = '"
                        + fridgeStuff + "'WHERE User = '" + userName + "'");

            stmt.close();
            con.close();


    } catch (SQLException sqlE) {
            System.out.println("SQL Exception " + sqlE.toString());
        }
    }

    public void DeleteFridge()    {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Users SET Fridge = '"  +
                  "' WHERE User = '" + userName + "'");

            stmt.close();
            con.close();
            System.out.println("DB OK");


        } catch (SQLException sqlE) {
            System.out.println("SQL Exception " + sqlE.toString());
        }
    }

    public void DeleteData()    {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Users WHERE User = '" + userName + "'");

            stmt.close();
            con.close();
            System.out.println("DB OK");

        } catch (SQLException sqlE) {
            System.out.println("SQL Exception " + sqlE.toString());
        }
    }

     // thing to bail out, mostly a formatting thing I will remove it prior to submitting it
     public static void cancel() {
         System.exit(0);
     }


 }