import java.io.FileReader;  
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.text.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class duoChecker{
    private String file;
    private String data;
   public duoChecker(String newFile){
        file = newFile;
    }

    public boolean duoCheck(){
    List<Character> q = new CopyOnWriteArrayList<Character>();
    try{
        FileReader myFile = new FileReader(file);
        BufferedReader myReader= new BufferedReader(myFile);
        
       

        

        
        
        while(true){
        data = myReader.readLine();
           

            if (data == null){
                break;
            }
            CharacterIterator itr = new StringCharacterIterator(data);
            
        //reads each line of the file, checks to see if the looked for symbols are in the line, and if they are, adds them to Queue q
             char characters= itr.current();
        //iterate over each line add each occuracne of symbol to collection then use Contains() to make sure matching pair exists :D
            while(itr.current() != CharacterIterator.DONE){
                
                if (characters == '{' || characters == '}' || characters == '(' || characters == ')' || characters == '[' || characters == ']'){
                    q.add(characters);
                    
                    
                    
                }
                characters= itr.next();
                
            }
            
        }
        
            //checks each left symbol of q to see if there is matching right symbol if not returns false, if yes removes both symbols
            for(char symbols: q){
                switch(symbols){
                    case '{':
                        if(!q.contains('}')){
                            
                            return false;
                        } else{
                            q.remove(Character.valueOf('{'));
                            q.remove(Character.valueOf('}'));
                            
                        }
                        break;
                    case '(':
                        if(!q.contains(')')){
                            return false;
                        }else{
                            q.remove(Character.valueOf('('));
                            q.remove(Character.valueOf(')'));
                        }
                        break;
                    case '[':
                        if(!q.contains(']')){
                            return false;
                        }else{
                            q.remove(Character.valueOf('['));
                            q.remove(Character.valueOf(']'));
                        }
                        break;
                    
                        
                    
                }
            }
            
            
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
            return false;
          
        }
    catch(IOException ex){
            System.out.println (ex.toString());
            System.out.println("Could not find file ");
            System.exit(1);
            return false;
        }
        }
    }

