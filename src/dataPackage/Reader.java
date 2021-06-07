package dataPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;




public class Reader {
	
	List<Person> personList = new ArrayList<>();
	
	
	public void loadData(Path p) throws Exception {	
	
		try {
			//open the file
			BufferedReader reader = Files.newBufferedReader(p);
			
			//read the file line by line
			String line = "";
			
			//skip the first line of the file - headers
			reader.readLine();
			
			while( (line = reader.readLine()) != null) {
				//each line has fields separated by commas, split into an array of fields
				String[] fields = line.split(",");
				
				//put some of the fields into variables: check which fields are where atop the CSV file itself
				String	name = fields[0];
				int vanNum = Integer.parseInt(fields[1]);
				
				//create an Aircraft object, and set (some of) its properties
				Person person = new Person();
				person.addName(name);
				person.addVanNum(vanNum);
			
				
				//add the aircraft to our list
				personList.add(person);
				
				System.out.println("Person: " +	name + "vanNum: " + vanNum);
			}
		}
		
		catch ( IOException ioe) {
			//There was a problem reading the file
			throw new Exception(ioe);
		
		}
		
		catch (Exception e) {
			//There was a problem reading the file
			throw new Exception(e);
		
		}

	}
	
	
}



