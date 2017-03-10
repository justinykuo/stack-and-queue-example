import java.awt.EventQueue;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiFX extends Application{
	
	// Show message method to account for program crashing on Mac OS x
	// For some reason my computer crashes when encountering jOption Panes this is my workaround
		private static void showMessage(String message) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, message);
				}
			});
		}
		
	//5 buttons for main GUI + 3 for the dialogue pop ups
	//3 TextField arrays + 1 Text Area
	//2 TF for package + 1 for volunteer + 1 for recipient
	//Labels ''
	//3 Labels for main
	//4 hboxes for main display + 2 for package + 1 for vol + 1 for rec
	
		private final int MAX_SIZE = 5;
		
		Button stackButton = new Button("Stack a new Package");
		Button volunteerButton = new Button("New Volunteer");
		Button recipientButton = new Button("New recipient");
		Button donateButton = new Button("Donate Package");
		Button exitButton = new Button("Exit");
		
		Button volunteerConfirmButton = new Button("Confirm Volunteer Creation");
		Button recipientConfirmButton = new Button("Confirm Recipient Creation");
		Button packageConfirmButton = new Button("Confirm Package Creation");
		
		Label volunteerLabel = new Label("Queue of Volunteers");
		Label recipientLabel = new Label("Queue of recipients");
		Label packageLabel = new Label("Packages in the container");
		
		Label volunteerDialogLabel = new Label("Enter name of volunteer");
		Label recipientDialogLabel = new Label("Enter name of recipient");
		Label packageDialogLabel = new Label("Enter description and weight of package");
		
		TextField volunteerNameText = new TextField();
		TextField recipientNameText = new TextField();
		TextField packageDescription = new TextField();
		TextField packageWeight = new TextField();
		
		TextField[] volunteerText = new TextField[5];
		TextField[] recipientText = new TextField[5];
		TextField[] packageText = new TextField[5];
		
		TextArea resultTextArea = new TextArea();
		
		HBox buttonHBox = new HBox();
		HBox volunteerHBox = new HBox();
		HBox recipientHBox = new HBox();
		HBox packageHBox = new HBox();
		
		VBox volunteerVBox = new VBox();
		VBox recipientVBox = new VBox();
		VBox packageVBox = new VBox();
		VBox volunteerDialogVBox = new VBox();
		VBox recipientDialogVBox = new VBox();
		VBox packageDialogVBox = new VBox();
		VBox layoutVBox = new VBox();
		

		@Override
		public void start(Stage primaryStage) throws Exception {
			
			DonationManager donationManager = new DonationManager();
			VolunteerLine volunteerLine = new VolunteerLine();
			RecipientLine recipientLine = new RecipientLine();
			Container container = new Container();
			
			buttonHBox.setSpacing(10);
			buttonHBox.setAlignment(Pos.TOP_CENTER);
			buttonHBox.setPadding(new Insets(10));
			buttonHBox.getChildren().addAll(stackButton, volunteerButton, recipientButton, donateButton, exitButton);
			
			volunteerLabel.setMinWidth(650);
			volunteerLabel.setStyle("-fx-background-color: lightgray;");
			volunteerLabel.setAlignment(Pos.TOP_LEFT);
			volunteerHBox.setSpacing(10);
			volunteerHBox.setPadding(new Insets(10));
			volunteerHBox.setMaxWidth(600);
			
			for(int i = 0; i < volunteerText.length; i++){
				volunteerText[i] = new TextField();
				volunteerText[i].setEditable(false);
				volunteerHBox.getChildren().add(volunteerText[i]);
			}
			
			volunteerVBox.setAlignment(Pos.TOP_CENTER);
			volunteerVBox.setSpacing(5);
			volunteerVBox.setMaxWidth(650);
			volunteerVBox.setStyle("-fx-border-color: lightgray;");
			volunteerVBox.getChildren().addAll(volunteerLabel, volunteerHBox);
			
			recipientLabel.setMinWidth(650);
			recipientLabel.setStyle("-fx-background-color: lightgray;");
			recipientLabel.setAlignment(Pos.TOP_LEFT);
			recipientHBox.setSpacing(10);
			recipientHBox.setPadding(new Insets(10));
			recipientHBox.setMaxWidth(600);
			
			for(int i = 0; i < recipientText.length; i++){
				recipientText[i] = new TextField();
				recipientText[i].setEditable(false);
				recipientHBox.getChildren().add(recipientText[i]);
			}
			
			recipientVBox.setAlignment(Pos.TOP_CENTER);
			recipientVBox.setStyle("-fx-border-color: lightgray;");
			recipientVBox.setSpacing(5);
			recipientVBox.setMaxWidth(650);
			recipientVBox.getChildren().addAll(recipientLabel, recipientHBox);
			
			
			packageLabel.setStyle("-fx-background-color: lightgray;");
			packageLabel.setMinWidth(175);
			packageLabel.setAlignment(Pos.TOP_CENTER);
			
			packageVBox.setAlignment(Pos.TOP_CENTER);
			packageVBox.setSpacing(5);
			packageVBox.setPadding(new Insets(5));
			packageVBox.getChildren().add(packageLabel);
			packageVBox.setStyle("-fx-border-color: lightgray;");
			
			for(int i = 0; i < packageText.length; i++){
				packageText[i] = new TextField();
				packageText[i].setEditable(false);
				packageText[i].setMaxWidth(150);
				packageVBox.getChildren().add(packageText[i]);
			}
			
			double textAreaHeight = packageVBox.getHeight();
			resultTextArea.setMinHeight(textAreaHeight);
			resultTextArea.setEditable(false);
			
			packageHBox.setSpacing(5);
			packageHBox.setAlignment(Pos.TOP_CENTER);
			packageHBox.setPadding(new Insets(10));
			packageHBox.setMaxWidth(660);
			packageHBox.getChildren().addAll(packageVBox, resultTextArea);
			
			volunteerDialogVBox.setAlignment(Pos.TOP_CENTER);
			volunteerDialogVBox.setPadding(new Insets(10));
			volunteerDialogVBox.setSpacing(5);
			volunteerNameText.setPromptText("Name");
			volunteerDialogVBox.getChildren().addAll(volunteerDialogLabel, volunteerNameText, volunteerConfirmButton);
			
			recipientDialogVBox.setAlignment(Pos.TOP_CENTER);
			recipientDialogVBox.setPadding(new Insets(10));
			recipientDialogVBox.setSpacing(5);
			recipientNameText.setPromptText("Name");
			recipientDialogVBox.getChildren().addAll(recipientDialogLabel, recipientNameText, recipientConfirmButton);
			
			packageDialogVBox.setAlignment(Pos.TOP_CENTER);
			packageDialogVBox.setPadding(new Insets(10));
			packageDialogVBox.setSpacing(5);
			recipientNameText.setPromptText("Description");
			packageWeight.setPromptText("Weight");
			packageDialogVBox.getChildren().addAll(packageDialogLabel, packageDescription, packageWeight, packageConfirmButton);
			
			
			layoutVBox.setSpacing(10);
			layoutVBox.setAlignment(Pos.TOP_CENTER);
			layoutVBox.getChildren().addAll(buttonHBox, volunteerVBox, recipientVBox, packageHBox);
			
			Stage packageStage = new Stage();
			
			//Putting the layout into the grid to display
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_CENTER);	
			grid.getChildren().add(layoutVBox);
			
			stackButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					// Creating the dialog stage for the package creation
					GridPane packageGrid = new GridPane();
					packageGrid.setAlignment(Pos.TOP_CENTER);	
					packageGrid.getChildren().add(packageDialogVBox);
					packageDescription.clear();
					packageWeight.clear();
					
					Scene packageScene = new Scene(packageGrid, 300, 200);
					
					packageStage.setTitle("Package creation");
					packageStage.setScene(packageScene);
					packageStage.show();	
				}
				
			});
			
			volunteerButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					// Creating the dialog stage for the package creation
					GridPane volunteerGrid = new GridPane();
					volunteerGrid.setAlignment(Pos.TOP_CENTER);	
					volunteerGrid.getChildren().add(volunteerDialogVBox);
					volunteerNameText.clear();
					
					Scene packageScene = new Scene(volunteerGrid, 300, 200);
					packageStage.setTitle("Volunteer creation");
					packageStage.setScene(packageScene);
					packageStage.show();	
				}
				
			});
			
			recipientButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					// Creating the dialog stage for the package creation
					GridPane recipientGrid = new GridPane();
					recipientGrid.setAlignment(Pos.TOP_CENTER);	
					recipientGrid.getChildren().add(recipientDialogVBox);
					recipientNameText.clear();
					
					Scene packageScene = new Scene(recipientGrid, 300, 200);
					packageStage.setTitle("Volunteer creation");
					packageStage.setScene(packageScene);
					packageStage.show();	
				}
				
			});
			
			/*
			 * Creates and adds new volunteer + resets the textfields
			 */
			volunteerConfirmButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					String error;
					Volunteer[] volunteerArray = new Volunteer[5];
					
					// Creating the volunteer when the confirm button is hit inside the new scene
						try{
							
							if((volunteerNameText.getText().trim().isEmpty())){
								throw new VolunteerException("No name! Try again.");
							}
							if(volunteerLine.size() == 5){
								throw new VolunteerException("Too many volunteers! List is full");
							}
							Volunteer volunteer = new Volunteer(volunteerNameText.getText());
							donationManager.ManagerQueueVolunteer(volunteer);
							volunteerArray = donationManager.vLineToArr();
							for(int i = 0; i < donationManager.vLine.size(); i++){
								volunteerText[i].setText(volunteerArray[i].toString());
							}
							packageStage.close();
						}catch(VolunteerException e){
							error = e.getMessage();
							volunteerDialogVBox.getChildren().add(new Label(error));
						}
						
					
				}
				
			});
			
			recipientConfirmButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					String error;
					Recipient[] recipientArray = new Recipient[5];
					
					// Creating the volunteer when the confirm button is hit inside the new scene
						try{
							
							if((recipientNameText.getText().trim().isEmpty())){
								throw new RecipientException("No name! Try again.");
							}
							if(recipientLine.size() == 5){
								throw new RecipientException("Too many recipients! List is full");
							}
							Recipient recipient = new Recipient(recipientNameText.getText());
							// managing data
							donationManager.ManagerQueueRecipient(recipient);
							recipientArray = donationManager.rLineToArr();
							for(int i = 0; i < donationManager.rLine.size(); i++){
								recipientText[i].setText(recipientArray[i].toString());
							}
							packageStage.close();
						}catch(RecipientException e){
							error = e.getMessage();
							recipientDialogVBox.getChildren().add(new Label(error));
						}
						
					
				}
				
			});
			
			/*
			 * Creates the package + resets the text field. Throws ContainerException if the text fields are empty
			 * or the weight is more than 20.
			 */
			packageConfirmButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					String error;
					DonationPackage[] packageArray = new DonationPackage[5];
					
					// Creating the volunteer when the confirm button is hit inside the new scene
						try{
							
							if((packageDescription.getText().trim().isEmpty())){
								throw new ContainerException("No description! Try again.");
							}
							if((Double.parseDouble(packageWeight.getText()) > 20.0 || Double.parseDouble(packageWeight.getText()) <= 0.0)){
								throw new ContainerException("Weight incorrect, must be in between 0-20");
							}
							if(container.size() == 5){
								throw new ContainerException("Too many packages! List is full");
							}
							DonationPackage donationPackage = new DonationPackage(packageDescription.getText(), Double.parseDouble(packageWeight.getText()));
							donationManager.ManagerLoadcontainer(donationPackage);
							packageArray = donationManager.contToArr();
							for(int i = 0; i < donationManager.container.size(); i++){
								packageText[i].setText(packageArray[i].toString());
							}
							packageStage.close();
						}catch(ContainerException e){
							error = e.getMessage();
							packageDialogVBox.getChildren().add(new Label(error));
						}
						
					
				}
				
			});
			
			/*
			 * First checks to see whether everything is filled to use in the result text area, then it donates the 
			 * package. Then it resets the text fields.
			 */
			donateButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					
					String volunteerString = "", recipientString = "", packageString = "";
					
					
					//Checking to see if the textfields are filled in to use to display results later
					if(volunteerText[0].getText() != null || !volunteerText[0].getText().isEmpty()){
						volunteerString = volunteerText[0].getText();
					}
					
					if(recipientText[0].getText() != null || !recipientText[0].getText().isEmpty()){
						recipientString = recipientText[0].getText();
					}
					
					if(packageText[0].getText() != null || !packageText[0].getText().isEmpty()){
						packageString = packageText[0].getText();
					}
					
					String stringResult = volunteerString + " donated " + packageString + " to " + recipientString;
					
					// Donating the package
					int result = donationManager.donatePackage();
					
					if(result == 1){
						resultTextArea.setText("No Volunteers!");
					}
					else if(result == 2){
						resultTextArea.setText("No recipients!");
					}
					else if(result == 3){
						resultTextArea.setText("No packages!");
					}
					else{
						
						resultTextArea.setText(stringResult);
						
						// To reset the package textfields after the donation					
						if(!(donationManager.container.isEmpty())){
							DonationPackage[] packageArray = new DonationPackage[5];	
							packageArray = donationManager.contToArr();
							for(int i = 0; i < donationManager.container.size(); i++){
								packageText[i].setText(packageArray[i].toString());
							}
							// Clears what is not part of the container
							for(int i = donationManager.container.size(); i < 5; i++){
								packageText[i].clear();
							}
						}
						// FOr if there is only 1 package left, it resets the GUI manually
						else if(donationManager.container.isEmpty()){
							packageText[0].clear();
						}
						
						// To reset the recipient textfields after donation
						if(!(donationManager.rLine.recipientLineEmpty())){
							Recipient[] recipientArray = new Recipient[5];
							recipientArray = donationManager.rLineToArr();
							for(int i = 0; i < donationManager.rLine.size(); i++){
								recipientText[i].setText(recipientArray[i].toString());
							}
							// Clears what is not part of the line
							for(int i = donationManager.rLine.size(); i < 5; i++){
								recipientText[i].clear();
							}
						}
						// For if there is only 1 recipient left it resets the GUI manually
						else if(donationManager.rLine.recipientLineEmpty()){
							recipientText[0].clear();
						}
						
						if(!(donationManager.vLine.volunteerLineEmpty())){
						// To reset the volunteer textfields after donation
						Volunteer[] volunteerArray = new Volunteer[5];
						volunteerArray = donationManager.vLineToArr();
						for(int i = 0; i < donationManager.vLine.size(); i++){
							volunteerText[i].setText(volunteerArray[i].toString());
						
						}
						}
					}
				}
				
			});
			
			/*
			 * Exits the stage when clicked
			 */
			exitButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					primaryStage.close();
				}
				
			});
			
			
			
			

			Scene scene = new Scene(grid, 700, 550);
			primaryStage.setTitle("Office Depo");
			// Place the scene in the stage
			primaryStage.setScene(scene);
			// Display the stage
			primaryStage.show();
			
		}
		
		public static void main(String[] args) {
			launch(args);

		}

}
