package dataPackage;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.DataFormatException;

import javax.swing.filechooser.*;
class Application extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
// Jlabel to show the files user selects
 static JLabel l;

 // a default constructor
 Application()
 {
 }
 
 Path p = null ;

 public static void main(String args[])
 {
     // frame to contains GUI elements
     JFrame f = new JFrame("file chooser");

     // set the size of the frame
     f.setSize(400, 400);

     // set the frame's visibility
     f.setVisible(true);

     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     // button to open save dialog
     JButton button1 = new JButton("Make Report");

     // button to open open dialog
     JButton button2 = new JButton("Open");

     // make an object of the class filechooser
     Application f1 = new Application();

     // add action listener to the button to capture user
     // response on buttons
     button1.addActionListener(f1);
     button2.addActionListener(f1);
     

     // make a panel to add the buttons and labels
     JPanel p = new JPanel();
    
     p.setLayout(new BorderLayout(100,100));

     // add buttons to the frame
     button1.setPreferredSize(new Dimension(70, 70));
     button2.setPreferredSize(new Dimension(70, 70));
    
     p.add(button2,BorderLayout.NORTH);
     p.add(button1,BorderLayout.SOUTH);;

     // set the label to its initial value
     l = new JLabel("no file selected");
    

     // add panel to the frame
     p.add(l,BorderLayout.CENTER);
     f.add(p);

     f.setVisible(true);
 }
 public void actionPerformed(ActionEvent evt)
 {
     // if the user presses the save button show the save dialog
     String com = evt.getActionCommand();
    

     if (com.equals("Open")) {
    	 
         // create an object of JFileChooser class
         JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

         // resctrict the user to select files of all types
         j.setAcceptAllFileFilterUsed(false);

         // set a title for the dialog
         j.setDialogTitle("Select a .csv file");

         // only allow files of .txt extension
         FileNameExtensionFilter restrict = new FileNameExtensionFilter("CSV files", "csv");
         j.addChoosableFileFilter(restrict);

         // invoke the showsOpenDialog function to show the save dialog
         int r = j.showOpenDialog(null);

         // if the user selects a file
         if (r == JFileChooser.APPROVE_OPTION) {
             // set the label to the path of the selected file
             l.setText(j.getSelectedFile().getAbsolutePath());
             p = Paths.get(j.getSelectedFile().getAbsolutePath());
             
         }
         // if the user cancelled the operation
         else
             l.setText("the user cancelled the operation");
     }
     
     if(com.equals("Make Report")) {
    
    	 System.out.print(p);
    	 Reader r = new Reader();
    	 try {
			r.loadData(p);
		}		catch (Exception dle) {
			System.err.println("Error loading data");
			dle.printStackTrace();
		}
    	 
     }
     
 }
}