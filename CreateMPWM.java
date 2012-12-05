import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class CreateMPWM {
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
	String fileName = args[0];
        Scanner filescan;//to read the file
        filescan=new Scanner(new File(fileName));//read the whole file
		
	FileWriter fstream = new FileWriter(fileName.subSequence(0,fileName.indexOf(".uniqe.ICext"))+".uniqe.Mpwm");
        BufferedWriter mpwm = new BufferedWriter(fstream);

        String value1, value2, motif, line="";//the readed line as array
		int index, motifIndex;
		ArrayList <ArrayList<String>> matrix = new ArrayList <ArrayList<String>>();
		ArrayList<String> row;
		
		String [] tokens;
		line=filescan.nextLine();
		while (filescan.hasNext())
	        {
	         if(line.charAt(0)=='=')
                {	
	        	
	    	matrix = new ArrayList <ArrayList<String>>();
			line=filescan.nextLine();
			motifIndex=line.indexOf("Motif");
		    motif=line.substring(motifIndex+6, line.indexOf(":"));
			mpwm.write(">motif"+motif+".dmf"+"\n");
			
			while (filescan.hasNext()&&line.charAt(0)!='=')
			{
			  line=filescan.nextLine();//read line by line		  		    
		      if(line.charAt(0)=='L')
		      {
		    	tokens=line.split("\\s+");
		    	row = new ArrayList<String>();
		    	for (int i=1 ;i<5; i++)		    	
		    		row.add(tokens[i]);
		    	matrix.add(row);	
		      }		    
		    }
	    	
	    	for (int j=0; j<4;j++){
    	for (int i=0;i<matrix.size();i++){
    		mpwm.write(matrix.get(i).get(j)+"\t");
    	}
    	mpwm.write("\n");
	      }
          }
          else
          	line=filescan.nextLine();//read line by line
	    	
	    }//while
        mpwm.close();
        
    }
}
