package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import AstTreeImplementation.LexicalAnalayzer;
import Metrics.SWMetrics;
import NecessaryDataStructure.CommentDeletion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainController {
	
	@FXML
	private Pane pane;
	
	@FXML
	private AnchorPane pane3;
	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private ListView listView;
	
	@FXML
	private ListView listView1;
	
	@FXML
	private Label lbl;
	

	@FXML
	private Label lbl1;
	

	@FXML
	private Label lbl2;
	
	@FXML
	private Label fun1;
	
	@FXML
	private Label fun2;
	
	@FXML
	private Label fun3;
	
	@FXML
	private Label sta1;
	
	@FXML
	private Label sta2;
	
	@FXML
	private Label sta3;
	
	@FXML
	private Label para1;
	
	@FXML
	private Label para2;
	
	@FXML
	private Label para3;
	
	@FXML
	private Label loc1;
	
	@FXML
	private Label loc2;
	
	@FXML
	private Label loc3;
	
	@FXML
	private Label nonloc1;
	
	@FXML
	private Label nonloc2;
	
	@FXML
	private Label nonloc3;
	
	@FXML
	private Label loop1;
	
	@FXML
	private Label loop2;
	
	@FXML
	private Label loop3;
	
	@FXML
	private Label m1;
	
	@FXML
	private Label m2;
	
	private  java.io.File file;
	private String stringFromFile;
	private String stringFromFileTwo;
	private FileToString object1=new FileToString();
	private FolderToString object2=new FolderToString();
	private String [] stringFromFolder;
	private String [] fileNameOfFolder;
	private static double clonePercentage;
	private String newFileName1;
	private String newFileName2;
    private SWMetrics metricsForFile1;
    private SWMetrics metricsForFile2;
    private static int numOfLocalVariable1 = 0;
	private static int numOfNonLocalVariable1 = 0;
	private static int numOfLoop1 = 0;
	private static int numOfStatement1 = 0;
	private static int numOfFunction1 = 0;
	private static int numOfParameter1 = 0;
	private static int numOfLocalVariable2 = 0;
	private static int numOfNonLocalVariable2 = 0;
	private static int numOfLoop2 = 0;
	private static int numOfStatement2 = 0;
	private static int numOfFunction2 = 0;
	private static int numOfParameter2 = 0;
	
	private Map <String ,String> stringFolder = new HashMap<String,String> () ;
	
	public void fileSelection(ActionEvent event) throws Exception {
		
		String fileName = null;
		
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("C source file", "*.c")
				,new FileChooser.ExtensionFilter("C source file", "*.C")
				,new FileChooser.ExtensionFilter("Header file", "*.h"));
		
		File seletedFile = fc.showOpenDialog(null);
		
		if(seletedFile != null) {
			
			fileName= seletedFile.getAbsolutePath();
			
			file=new  java.io.File(fileName);
			
			  Scanner input = new Scanner(file);
			  
			  while (input.hasNext()) {
				  
				  String str;
				  
				  str=input.nextLine();
				  
				  listView.getItems().add(str);
				  
			  }
			  
			  
		}
		
		else {
			
			System.out.println("file not found ");
			
		}
		
		if(seletedFile != null) {
			CommentDeletion objectForComment=new CommentDeletion();
			
			 newFileName1=objectForComment.DeleteComment(fileName);
			 stringFromFile=object1.stringConverter(newFileName1);
		     metricsForFile1=new SWMetrics(newFileName1);
		
		     numOfFunction1=metricsForFile1.getNumOfFunction();
		     numOfStatement1=metricsForFile1.getNumOfStatement();
		     numOfLoop1 =metricsForFile1.getNumOfLoop();
		     numOfNonLocalVariable1=metricsForFile1.getNumOfNonLocalVariable();
		     numOfLocalVariable1 = metricsForFile1.getNumOfLocalVariable();
		   //  System.out.println(numOfLoop1);
		 //    numOfNonLocalVariable1=metricsForFile1.getNumOfNonLocalVariable();
		}
		
		
	}
	
	public void folderSelection(ActionEvent event) throws FileNotFoundException {
		
		String fileName = null;
		
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("C source file", "*.c")
				,new FileChooser.ExtensionFilter("C source file", "*.C")
				,new FileChooser.ExtensionFilter("Header file", "*.h"));
		
		File seletedFile = fc.showOpenDialog(null);
		
		if(seletedFile != null) {
			
			fileName= seletedFile.getAbsolutePath();
			
			file=new  java.io.File(fileName);
			
			  Scanner input = new Scanner(file);
			  
			  while (input.hasNext()) {
				  
				  String str;
				  
				  str=input.nextLine();
				  
				  listView1.getItems().add(str);
				  
			  }
			  
			  
		}
		
		else {
			
			System.out.println("file not found ");
			
		}
		
		if(seletedFile != null) {
			CommentDeletion objectForComment=new CommentDeletion();
			
			//objectForComment.deleteComment(fileName);
			 newFileName2=objectForComment.DeleteComment(fileName);
			stringFromFileTwo=object1.stringConverter(newFileName2);
			
		    metricsForFile2=new SWMetrics(newFileName2);
		    
		    numOfFunction2 =metricsForFile2.getNumOfFunction();
		    numOfStatement2=metricsForFile2.getNumOfStatement();
		    numOfLoop2=metricsForFile2.getNumOfLoop();
		    numOfNonLocalVariable2=metricsForFile2.getNumOfNonLocalVariable();
		    numOfLocalVariable2 = metricsForFile2.getNumOfLocalVariable();
		 //  System.out.println(numOfLoop2);
		//    numOfNonLocalVariable2=metricsForFile2.getNumOfNonLocalVariable();
		}
		
		
		
	}
	
	public void compare() {
		
			
			int [] array = new int[3];
			
			EditDistance object3=new EditDistance();
			
			array[0]=object3.stringMatching(stringFromFileTwo, stringFromFile, length(stringFromFileTwo),length(stringFromFile));
			array[1]= length(stringFromFileTwo);
			array[2]=length(stringFromFile);
			
			Calculation object4= new Calculation();
		    clonePercentage=object4.calculate(array);
			
			Parent pane2 = null;
			try {
				pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/Result.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			pane.getChildren().setAll(pane2);
		
	}
	
	public void back() {
		
		Parent pane2 = null;
		try {
			pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/Main.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pane3.getChildren().setAll(pane2);
		
		
	}
	public void showResult() {
		
		lbl1.setText("Lexical Similarities");
		lbl.setText( clonePercentage+"%");
		lbl2.setText("Metrics Similarities");
		
		m1.setText("Source Code1");
		m2.setText("Source Code2");
		
		fun1.setText("Number Of Function");
		fun2.setText(String.valueOf(numOfFunction1));
		fun3.setText(String.valueOf(numOfFunction2));
		
		sta1.setText("Number Of  Statement");
		sta2.setText(String.valueOf(numOfStatement1));;
		sta3.setText(String.valueOf(numOfStatement2));;
		
		para1.setText("Number Of  Parameter");
		para2.setText(String.valueOf(10000));
		para3.setText(String.valueOf(10000));
		
		loc1.setText("Number Of  Local Variable");
		loc2.setText(String.valueOf(  numOfLocalVariable1 ));
		loc3.setText(String.valueOf(  numOfLocalVariable2));
		
		nonloc1.setText("Number Of Non-Local Variable");
		nonloc2.setText(String.valueOf( numOfNonLocalVariable1));
		nonloc3.setText(String.valueOf(numOfNonLocalVariable2));
		
		loop1.setText("Number Of Loop");
		loop2.setText(String.valueOf( numOfLoop1));
		loop3.setText(String.valueOf( numOfLoop2));
		
	}
	
private String valueOf(int y) {
		// TODO Auto-generated method stub
		return null;
	}

public int length(String str){
        
        str+='\0';
        int i;
        int len = 0;
        
        for( i=0 ;  ; i++)
        {
            //char ss= str.charAt(i);
            
            if( str.charAt(i) != '\0' ){
               
                len++;
            } 
            
            else {
                
                break;
            }
            
        }
  
        return len;
    }

}
