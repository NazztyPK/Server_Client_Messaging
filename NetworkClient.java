import java.io.*;    //Import io wildcard
import java.net.*;   //Import Socket
import java.util.Scanner; 
class NetworkClient
{
   public static void main(String[] args) throws IOException
   {
      int PortNumber = 9959;      
      DataInputStream input;      
      DataOutputStream output;  
      Socket MyClient = new Socket("127.0.0.1", PortNumber);      
      Scanner scanner = new Scanner(System.in);  
      
      System.out.println("connected client!");      
      
      output = new DataOutputStream(MyClient.getOutputStream());      
      input = new DataInputStream(MyClient.getInputStream());      
      
      //intialize int for Menu input
      int choice = 0;
      
      do
      {
      //Print menu for client
      System.out.println("What would you like to do?");
      System.out.println("1. Login");
      System.out.println("2. Logout");    
      System.out.println("3. Send Message");
      System.out.println("4. Turn Off Server");
      
      String choiceString = scanner.nextLine();      
      choice = Integer.parseInt(choiceString);
      
      //output operator to server
      output.writeInt(choice);
      
      //switch statement for different choices
      switch (choice) {
         case 1: //choice = 1;
            boolean loginStatus = input.readBoolean(); //boolean from server about loginstatus
            if(!loginStatus)
            {
               //Read input form server - 1
               String userAndPass = input.readUTF();  //receive input from server - 1
               System.out.println(userAndPass);       //print input from server - 1  
               
               //Output to server - 2
               userAndPass = scanner.nextLine();   //get input from user
               output.writeUTF(userAndPass);       //send input to Server - 2
               
               //Read input form server - 3
               String serverInput = input.readUTF();  //receive input from server - 3
               System.out.println(serverInput);       //print input from server - 3
            }
                     
            break;
         case 2: //choice = 2;
            
            break;
         case 3: //choice = 3;
            
            break;
       }
      }while(choice != 4);
      
      
      if(choice == 4)
         System.out.println("Server is Off"); 
      
      //get input for numbers from server
      //int num1 = input.readInt(); 
      
      
      //do calculations
       
      //Print Result of calculation

      
   }
}