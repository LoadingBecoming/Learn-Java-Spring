package practiseAnnotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class fileFortune implements FortuneService {

	private String fileName = "E:\\practiseSpring\\spring-demo-annotations\\src\\practiseAnnotations\\fortune-data.txt";
	private List<String> theFortune;
	
	// Create a number random generator
	private Random myRandom = new Random();

	public fileFortune() {
		File theFile = new File(fileName);

		System.out.println("Reading fortunes form file: " + theFile);
		System.out.println("File exits: " + theFile.exists());
		
		//initialize array list
		theFortune = new ArrayList<String>(); 
		
		// Read fortune from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))){
			
			String tempLine;
			
			while ((tempLine = br.readLine()) != null)
				theFortune.add(tempLine);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		//pick a random string from the array
		int index = myRandom.nextInt(theFortune.size());
		
		String TempFortune = theFortune.get(index);
		
		return TempFortune;
	}

}
