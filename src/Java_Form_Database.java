import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;


public class Java_Form_Database extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception, IOException {

        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        TextField Name = new TextField();
        Label label_name = new Label("Write product's name:");

        TextField Mark = new TextField();
        Label label_mark = new Label("Write product's mark:");
        TextField Category = new TextField();
        Label label_category = new Label("Write product's category:");
        TextField Price = new TextField();
        Label label_price = new Label("Write product's price:");

        gridpane.add(label_name,0,0);
        gridpane.add(Name,1,0);
        gridpane.add(label_mark,0,1);
        gridpane.add(Mark,1,1);
        gridpane.add(label_category,0,2);
        gridpane.add(Category,1,2);
        gridpane.add(label_price,0,3);
        gridpane.add(Price,1,3);

        Button button_add = new Button("Add data");
        gridpane.add(button_add,0,4);

        Scene scene = new Scene(gridpane,500,200);

        button_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFromTextField_Name = Name.getText();
                String textFromTextField_Mark = Mark.getText();
                String textFromTextField_Category = Category.getText();
                String textFromTextField_Price = Price.getText();

                File file = new File("src/Data.csv");

                try{
                    FileOutputStream fileOutputStream = new FileOutputStream(file,true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                   if (file.length() == 0) {
                       bufferedWriter.write("sep=,");
                       bufferedWriter.newLine();
                       bufferedWriter.write("Product's name" + "," + "Product's mark" + "," + "Product's category" + "," +
                               "Product's price");
                       bufferedWriter.newLine();
                   }
                    bufferedWriter.write(textFromTextField_Name +","+ textFromTextField_Mark +","+ textFromTextField_Category +","+textFromTextField_Price);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException ex){
                    System.out.println("Mistake IO");
                }
                Name.clear();
                Mark.clear();
                Category.clear();
                Price.clear();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Form for updating Database");

         primaryStage.show();
    }
}
