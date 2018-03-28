package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{
	Fridge fridge = new Fridge();
	ArrayList<String> stuff = new ArrayList<String>();
	Scene Opening;
		
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Label label1 = new Label("MEOW");
		Label label2 = new Label("What do we have to work with today? ");
		
		VBox layout1 = new VBox(25);
		// first 5 is top, second is left, third is bottom, last the 15 is from the right
		layout1.setPadding(new Insets(5,5,5,15));
		Button button1 = new Button("Dairy");
		Button button2 = new Button("Meat");
		Button button3 = new Button("Fruit");
		Button button4 = new Button("Veggie");
		Button button5 = new Button("that is all I've got");
		primaryStage.setTitle("Graham is a person");
		
		button1.setOnAction(e -> DairyMenu(primaryStage));
		button2.setOnAction(e -> MeatMenu(primaryStage));
		button3.setOnAction(e -> FruitMenu(primaryStage));	
		button4.setOnAction(e -> VeggieMenu(primaryStage));
		button5.setOnAction(e -> conclusion(primaryStage));
		layout1.getChildren().addAll(label1, label2, button1, button2, button3, button4, button5);

		Opening = new Scene(layout1, 400, 400);

		primaryStage.setScene(Opening);
		primaryStage.show();
		
	}
	public void DairyMenu(Stage primaryStage)
	{
		primaryStage.setTitle("Dairy Stuff ");
		VBox layout1 = new VBox(20);
		Label dLabel = new Label("What Dairy do you have in your fridge?");
		Scene Dairy = new Scene(layout1, 400, 400);
		layout1.setPadding(new Insets(5,5,5,15));

		
		Button button1 = new Button("milk");
		
		button1.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("milk");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		Button button2 = new Button("eggs");
		button2.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("eggs");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button3 = new Button("mayonnaise");
		button3.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("mayonnaise");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button4 = new Button("nevermind");
		
		button4.setOnAction(e->
		{
			try 
			{
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		layout1.getChildren().addAll(dLabel, button1, button2, button3, button4);
		primaryStage.setScene(Dairy);
		primaryStage.show();

	}	
	public void MeatMenu(Stage primaryStage)
	{
		primaryStage.setTitle("Meat Stuff ");
		VBox layout1 = new VBox(20);
		Label mLabel = new Label("What Meats do you have in your fridge?");
		Scene Meat= new Scene(layout1, 400, 400);
		layout1.setPadding(new Insets(5,5,5,15));

		
		Button button1 = new Button("chicken");
		button1.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("chicken");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		Button button2 = new Button("tuna");
		button2.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("tuna");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);		
		
		
		Button button3 = new Button("ground beef");
		button3.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("ground beef");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button4 = new Button("nevermind");
		
		button4.setOnAction(e->
		{
			try 
			{
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		layout1.getChildren().addAll(mLabel, button1, button2, button3, button4);
		primaryStage.setScene(Meat);
		primaryStage.show();

	}
	public void FruitMenu(Stage primaryStage)
	{
		primaryStage.setTitle("Fruit Stuff ");
		VBox layout1 = new VBox(20);
		Label fLabel = new Label("What Fruit do you have in your fridge?");
		Scene Fruit= new Scene(layout1, 400, 400);
		layout1.setPadding(new Insets(5,5,5,15));

		
		Button button1 = new Button("apples");
		button1.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("apples");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button2 = new Button("bananas");
		button2.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("bananas");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button3 = new Button("tomatoes");
		button3.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("tomatoes");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button4 = new Button("nevermind");
		
		button4.setOnAction(e->
		{
			try 
			{
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		layout1.getChildren().addAll(fLabel, button1, button2, button3, button4);
		primaryStage.setScene(Fruit);
		primaryStage.show();

	}
	public void VeggieMenu(Stage primaryStage)
	{
		primaryStage.setTitle("Veggie Stuff ");
		VBox layout1 = new VBox(20);
		Label vLabel = new Label("What Vegetables do you have in your fridge?");
		Scene Veggie= new Scene(layout1, 400, 400);
		layout1.setPadding(new Insets(5,5,5,15));

		
		Button button1 = new Button("carrots");
		button1.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("carrots");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button2 = new Button("celery");
		button2.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("celery");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button3 = new Button("onions");
		button3.setOnAction(e -> 
		{
			try 
			{
				fridge.setWhat("onions");
				stuff.add(fridge.getWhat());
				SelectionMade(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		Button button4 = new Button("nevermind");
		
		button4.setOnAction(e->
		{
			try 
			{
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		
		layout1.getChildren().addAll(vLabel, button1, button2, button3, button4);
		primaryStage.setScene(Veggie);
		primaryStage.show();

	}
	public void SelectionMade(Stage primaryStage)
	{
		primaryStage.setTitle("Error 404 joke title not found");
		VBox layout1 = new VBox(20);
		layout1.setPadding(new Insets(5,5,5,15));

		Label sLabel = new Label("Ok adding " + fridge.getWhat() +" you have " + fridge.getCounter() + " things so far");
		Label sLabel2 = new Label("Do you have anything else back there?");

		Scene Selection= new Scene(layout1, 400, 400);
		
		Button button1 = new Button("YES");
		button1.setOnAction(e -> 
		{
			try 
			{
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		
		Button button2 = new Button("no");
		button2.setOnAction(e -> 
		{
			try 
			{
				conclusion(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		

		layout1.getChildren().addAll(sLabel, sLabel2, button1, button2);
		primaryStage.setScene(Selection);
		primaryStage.show();
	}
	public void conclusion(Stage primaryStage)
	{
		primaryStage.setTitle("conclusion");
		VBox layout1 = new VBox(20);
		layout1.setPadding(new Insets(5,5,5,5));
		
		TextArea text = new TextArea();
		
		
		Button button1 = new Button("but wait... There's more");
		button1.setOnAction(e -> 
		{
			try 
			{
				stuff.clear();
				fridge.setCounter(0);
				start(primaryStage);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);
		Button button2 = new Button("all done");
		button2.setOnAction(e -> 
		{
			try 
			{
				cancel();
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		);

		text.setText("You have " + stuff + "\nwith that you can make: " +
		fridge.normText(fridge.findRecipe(stuff)));

		Scene Selection= new Scene(layout1, 400, 400);
		
		layout1.getChildren().addAll(text, button1, button2);
		primaryStage.setScene(Selection);
		primaryStage.show();
	}
	public static void cancel()
	{
		System.exit(0);
	}	
	public static void main(String[] args) 
	{
		launch(args);	
	}
}