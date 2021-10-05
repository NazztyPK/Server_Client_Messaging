import java.util.Scanner;  // Import the Scanner class
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
      
      
      try {
      File myObj = new File("shadow.txt");
      Scanner myReader = new Scanner(myObj);
      /*while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }*/
      myReader.close();
      } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
      
      int choice = 0;
      //Turn server off
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
            if(!loginStatus)  //login false
            {
               //Send Output to client - 1
               output.writeUTF("Enter the Username and password"); //send to client - 1
               
               //Receive Output from client - 2
               String userAndPass = input.readUTF();
                          
               //split string and put it into array
               String[] userPassArray = userAndPass.split(" ");
            }   
            else
               
            
            break;
         case 2: //choice = 2;
            System.out.println("connected 2");
            break;
         case 3: //choice = 3;
            System.out.println("connected 3");
            break;
       }
      }while (choice != 4);
      /*** End of Main Menu program ***/
   
    }
}