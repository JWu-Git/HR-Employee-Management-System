package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInput {
    public UserInput(Employee[] idlist) {

        Scanner scanner = new Scanner(System.in);
        HRList hrlist=new HRList();
        String userInput = null;
        
        File inputFile = new File("C:\\Users\\jwu22\\eclipse-workspace\\COPY\\src\\hw2\\active.txt");
        Scanner in = null;
        try {
            in = new Scanner(inputFile);
            System.out.println("Loading all active employees into HRList.");
            while (in.hasNextLine())
            {
              String line = in.nextLine();
              String[] splitted = line.split("\\s+");
              if (splitted.length<3) {
                  System.out.println("Invalid input for this line." +line+ "Continuing to next line.");
                  continue;
              }
              else {
                  Employee temp=new Employee(splitted[0],splitted[1],splitted[2]);
                  hrlist.AddToHRList(temp);
                  idlist[Integer.parseInt(temp.getIDNumber())%100]=temp;
              }
            }
            System.out.println("Finished loading file into HR List.");
            in.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
         

        while (true) {
            System.out.println("Number of current active employees:"+hrlist.Count_current_employees());
            System.out.println("Enter 0 to add employee, 1 to layoff employee, 2 to rehire employee, and "
                    + "3 to display current active employees, and 4 to search by name, and 5 to search by ID. Enter 6 to exit.");
            userInput = scanner.nextLine();
            
            if (userInput.equals("0")) { //add employee
                System.out.println("Please enter first name, last name, and id number, seperated by space.");
                userInput = scanner.nextLine();
                String[] splitted = userInput.split("\\s+");
                if (splitted.length<3) {
                    System.out.println("Too few inputs.");
                    continue;
                }
                else {
                    boolean noException=true;
                    Employee temp=new Employee(splitted[0],splitted[1],splitted[2]);
                    hrlist.AddToHRList(temp);
                    try {
                        idlist[Integer.parseInt(temp.getIDNumber())%100]=temp;
                        System.out.println(222); 
                    }
                    catch (NumberFormatException e) {
                        noException=false;
                        System.out.println("ID must be numbers only");
                    }
                    if (noException==true){
                        System.out.println("Employee added to HR list/system.");
                    }
                }
            }
            else if (userInput.equals("1")) { //layoff
                if (hrlist.ActiveEmployeeList.isEmpty()) {
                    System.out.println("Cannot layoff. No workers.");
                }
                else {
                    hrlist.LayOff();
                }
            }
                
 
            else if (userInput.equals("2")) {  //rehire
                if (hrlist.ReHireQueue.isEmpty()) {
                    System.out.println("No person in queue for rehire.");
                    continue;
                }
                else {
                    hrlist.Rehire();
                    System.out.println("Rehired from queue.");
                }  
            }
                 
            else if (userInput.equals("3")) { //display
                System.out.println(hrlist.ActiveEmployeeList.toString());;
            }
            
            else if (userInput.equals("4")) { //search by name
                System.out.println("Please enter first name and last name seperated by space.");
                String nameString = scanner.nextLine();
                String[] splitted = nameString.split("\\s+");
                if (splitted.length!=2) {
                    System.out.println("Too few or too many inputs.");
                    continue;
                }
                else {
                    Employee temp=new Employee(splitted[0],splitted[1]);
                    if (hrlist.ActiveEmployeeList.search(temp)) {
                        System.out.println("User found in active employees");
                    }
                    else {
                        System.out.println("User not found.");
                    }
                }
            }
            else if (userInput.equals("5")) { //search by ID
                System.out.println("Please enter id number.");
                String stringNumber = scanner.nextLine();
                int id;
                try {
                    id=Integer.parseInt(stringNumber);
                }
                catch (NumberFormatException e){
                    System.out.println("ID must be numbers only.");
                    continue;
                }
                System.out.println(id);
                if (idlist[id%100]==null) {
                    System.out.println("User not found in active employees.");
                }
                else {
                    System.out.println("User found in active employees");
                }
            }
            else if (userInput.equals("6")) { //quit
                
                break;
            }
            else { 
                System.out.println("Input invalid.");
                continue;
            }
        }
        scanner.close();
        
        try {
            String text = hrlist.ActiveEmployeeList.toString();
            PrintWriter out = new PrintWriter("./active.txt");
            out.print(text);
            out.close();
            System.out.println("Wrote active employee list to active.txt");
        }
        catch (Exception e) {
            System.out.println("Could not write active employee list to file.");
        }
        
        try {
            String text = hrlist.ReHireQueue.toString();
            PrintWriter out = new PrintWriter("./rehire.txt");
            out.print(text);
            out.close();
            System.out.println("Wrote rehire queue to rehire.txt");
        }
        catch (Exception e) {
            System.out.println("Could not write rehire queue to rehire.txt.");
        }
        System.out.println("Program terminated.");
    }  
}