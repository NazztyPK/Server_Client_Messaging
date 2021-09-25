import java.util.Scanner;  // Import the Scanner class
import java.io.*;          //Import io wildcard
import java.net.*;         //Import Socket

class NetworkServer
{
   public static void main(String[] args) throws IOException 
   {
      
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
      
      //scam numbers form user
      System.out.println("Please enter Two Numbers");          
      int num1 = scanner.nextInt();   
      int num2 = scanner.nextInt();
      
      //output numbers to client
      output.writeInt(num1);
      output.writeInt(num2);
      
      //get input for operator from client
      char operator = input.readChar(); 
      
      //do calculations
      int result = calculate(num1,num2,operator);
      
      //Print Result of calculation
      System.out.println("Result is " + result);   
   
    }
   
   public static int calculate(int num1, int num2, char sign)
   {
      int result = 0;
      
      switch (sign) {
            case '+':   //addition
                     result = num1 + num2;
                     break;
            case '-':   //subtract
                     result = num1 - num2;
                     break;
            case '/':   //divide
                     result = num1 / num2;
                     break;
            case '*':   //multiply
                     result = num1 * num2;
                     break;
            }//end of switch statement
      return result;
   }
}