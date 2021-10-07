import java.util.*;  // Import the Scanner class
import java.io.*;          //Import io wildcard
import java.net.*;         //Import Socket

class NetworkServer
{
   public static void main(String[] args) throws IOException 
   {
      //connect server to client
      int PortNumber = 9959;      
      Scanner scan = new Scanner(System.in);      
      DataInputStream input;      
      DataOutputStream output;      
      Scanner scanner = new Scanner(System.in);  
      ServerSocket listener = new ServerSocket(PortNumber);      
      Socket socket = listener.accept();      
      System.out.println("connected server!");      
      
      output = new DataOutputStream(socket.getOutputStream());      
      input = new DataInputStream(socket.getInputStream());
      
      //
      ArrayList<String> textFromShadow = new ArrayList<String>(); // Create an ArrayList with user From "shadow.txt"
      ArrayList<String> passFromFile = new ArrayList<String>(); // Create an ArrayList with passwords From "shadow.txt"
      
      try {
      File myObj = new File("shadow.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        textFromShadow.add(myReader.next());
      }
      myReader.close();
      } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
      
      int choice = 0;
      
      //check Log in status 
      boolean loginStatus = false;
      

      
      /************************
      *** Main Menu Program ***
      *************************/
      do
      {
      //get input for operator from client
      choice = input.readInt(); 
      
      //Switch statement for all the
      switch (choice) {
         case 1: //choice = 1;
            //System.out.println("connected 1");
            output.writeBoolean(loginStatus); //give login status to client            
            boolean usernameTest = false;
            boolean passwordTest = false;
            
            if(!loginStatus)  //login false
            {
               //Send Output to client - 1
               output.writeUTF("Enter the Username and password"); //send to client - 1
               
               //Receive Output from client - 2
               String userAndPass = input.readUTF();
                          
               //split string and put it into array
               String[] userPassArrayClient = userAndPass.split(" ");
               
               //check if username and password work
               for (int i = 0; i<textFromShadow.size()-1; i++) 
               {
                  if(textFromShadow.get(i).equals(userPassArrayClient[0]))
                     usernameTest = true;
                  
                  if(textFromShadow.get(i+1).equals(userPassArrayClient))
                     passwordTest = true;
                  
                  //Username and password work - Login Succesful
                  if(usernameTest & passwordTest)
                  {
                     loginStatus = true;
                     
                     //Send Output to client - 3
                     output.writeUTF("You're Logged In"); //send to client - 3
                  }
                  
                  //username wrong after going through whole arraylist
                  else if(!usernameTest && i == textFromShadow.size()-1)
                  {
                     //Send Output to client - 3
                     output.writeUTF("The Username is Wrong!!"); //send to client - 3
                  }
                  
                  //username is right, but password is wrong
                  else if(usernameTest && !passwordTest)
                  {
                     //Send Output to client - 3
                     output.writeUTF("The Password is Wrong!!"); //send to client - 3
                  }

               }
               
            }// end of if for log in status
            else //if (loginStatus) //login true
            {
               output.writeUTF("Already Logged in"); //send to client - 1
            }
            
            break;
         case 2: //choice = 2;
            System.out.println("connected 2");
            break;
         case 3: //choice = 3;
            System.out.println("connected 3");
            break;
       }//end of switch
      }while (choice != 4);
      /*** End of Main Menu program ***/
   
    }
}