/**
 * fileIn.java
 *
 *
 * pm
 * @version 1.00 2009/9/16
 */ 

import java.util.Scanner;

import java.io.*;
import java.util.*;

public class fileIn {
	String fname;

    public fileIn() {
    	System.out.println("Constructor");
    	getFileName();
    	readFileContents();
    }
    
    public void readFileContents()
    {
    	boolean looping;
    	DataInputStream in;
    	String line;
    	int j, len;
    	char ch;
    	
    	/* Read input from file and process. */
        try {
            in = new DataInputStream(new FileInputStream(fname));
            
            looping = true;
            while(looping) {
                /* Get a line of input from the file. */
                if (null == (line = in.readLine())) {
                    looping = false;
                    /* Close and free up system resource. */
                    in.close();
                }
                else {
                	System.out.println("line = "+line);
                	j = 0;
                	len = line.length();
                	for(j=0;j<len;j++){
                		System.out.println("line["+j+"] = "+line.charAt(j));
                	}
                }
            } /* End while. */
                	
        } /* End try. */
        
        catch(IOException e) {
            System.out.println("Error " + e);
        } /* End catch. */
    }
    
    public void getFileName()
    {
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Enter file name please.");
    	fname = in.nextLine();
    	System.out.println("You entered "+fname);
    }
    
    public static void main(String[] args)
	{
		
		System.out.println("Hello TV land!");
		
		fileIn f = new fileIn();
		
		System.out.println("Bye-bye!");
	}
}
