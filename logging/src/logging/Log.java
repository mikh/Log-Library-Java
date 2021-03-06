package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	int logging_level;
	BufferedWriter logger;
	
	public Log(int logging_level, String file_location){
		this.logging_level = logging_level;
		
		try{
			FileWriter fstream = new FileWriter(file_location, false);
			logger = new BufferedWriter(fstream);
		} catch(IOException e){
			System.out.println("Error. Cannot open logger file. " + e.getMessage());
			System.exit(-1);
		}
	}
	
	public void write(int level, String message){
		if(level <= logging_level){
			try{
				if(level == 1){
					logger.write("[ERROR] " + message);
					System.out.print("[ERROR] " + message);
				}
				else{
					logger.write(message);
					System.out.print(message);
				}
			} catch(IOException e){
				System.out.println("Error. Cannot log message: " + message + " " + e.getMessage());
				System.exit(-1);
			}
		}
	}
	
	public void close(){
		try {
			logger.close();
		} catch (IOException e) {
			System.out.println("Error. Cannot close logger file. " + e.getMessage());
			System.exit(-1);
		}
	}

}
