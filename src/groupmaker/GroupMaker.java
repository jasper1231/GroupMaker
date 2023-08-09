
package groupmaker;

import java.io.File;
import java.io.FileNotFoundException;
import static java.nio.file.AccessMode.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import java.nio.file.attribute.BasicFileAttributes;
/**
 *
 * @author 
 */

public class GroupMaker {

    public static ArrayList<String> list = new ArrayList<String>();
    public static ArrayList<Group> groups=new ArrayList<Group>();
    
    public static void shuffle(){
       ArrayList<String> temp = new ArrayList<String>();
        Random rand=new Random();
        do{
            int i=rand.nextInt(list.size());
            if(temp.contains(list.get(i))){ //check if the get element is already in temp array
                continue;
            }
            else{
                temp.add(list.get(i));
            }
        }while(temp.size()<list.size());
        
        list=temp;
    }
    
    public static String toString(String[] list){
        String out="";
        for(String a:list){
            out+=a+"\n";
        }
        return out;
    }
    
    public static void setGroups(int num){
        for(int i=1; i<=num; i++)
            groups.add(new Group(i));
    }
    
    public static void addMembers(int num){
        for(int i=0; i<list.size(); i++){
            groups.get(i%num).addMember(list.get(i));
        }
    }
    

    
    public static void main(String[] args)  throws FileNotFoundException {
        Scanner scan=new Scanner(System.in);
        
        System.out.print("Enter Number of Groups: ");
       int groupNum=scan.nextInt();
       scan.nextLine();  
       System.out.print("Enter Filename: ");
       String fileName= scan.nextLine();        
        
        
        
        
        
        File file=new File(fileName);
        Scanner fileScan=new Scanner(file);
        while(fileScan.hasNext()){
            list.add(fileScan.nextLine());
        }
        
        shuffle(); //shuffle the deck
        setGroups(groupNum);
        addMembers(groupNum);
        
        System.out.println("\n\n");
        for(Group g:groups){
            System.out.println("Group #"+g.getNum());
            
            ArrayList<String> members=g.getMembers();
            for(String m:members)
                System.out.println(m);
            
            System.out.println("\n");
        }
        
        
    }
    
}
