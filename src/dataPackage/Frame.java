package dataPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener{
		
		static Path getPath;
	
		private static final long serialVersionUID = 1L;
		JButton button = new JButton("Select File");
		
		public Frame(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
			button.addActionListener(this);
			this.add(button);
			this.pack();
			this.setVisible(true);
			}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == button ) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		
				getPath = file.toPath();
				
				
				}
			}
		}
		
		public static Path getPath() {
			System.out.print(getPath);
			return getPath;
		}
		
	}

