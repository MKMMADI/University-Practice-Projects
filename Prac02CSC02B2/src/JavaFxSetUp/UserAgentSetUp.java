package JavaFxSetUp;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UserAgentSetUp extends BorderPane
{
	
	Label lblhostName = null;
	TextField txtHostName=null;
	
	Label lblPortNumber = null;
	TextField txtPortNumber=null;
	
	Label lblFrom = null;
	TextField txtFrom=null;
	
	Label lblTo = null;
	TextField txtTo=null;
	
	TextArea Messages =null;
	Button Send = null;
	
	
	public UserAgentSetUp() 
	{
		
		OrganizeGui();

	}


	private void OrganizeGui() 
	{
		// TODO Auto-generated method stub
		
		this.lblhostName = new Label("Host Name : ");
		this.txtHostName=new TextField();
		
		this.lblPortNumber=new Label("Port Number : ");
		this.txtPortNumber = new TextField();
		
		this.lblFrom = new Label("From : ");
		this.txtFrom=new TextField();
		
		this.lblTo=new Label("To : ");
		this.txtTo=new TextField();
		
		VBox Vertical = new VBox();

		
		
		
		
		
		
		
		
		
		
	}
	
	

}
