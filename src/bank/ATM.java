package bank;

import java.io.IOException;
import java.sql.*;

public class ATM extends Usr {
    public ATM() throws IOException, SQLException {
        SetAtm(Email);
    }

    public ATM(int AccNumber, int AccPin)throws IOException, SQLException {
        this.AccNumber = AccNumber;
        this.AccPin = AccPin;
    }
    
    int AccNumber, AccPin;

    public final void SetAtm(String Email) throws SQLException {
        ResultSet result = GetData(Email);
        while (result.next()) {
            this.AccNumber = result.getInt("AccNum");
            this.AccPin = result.getInt("AccPin");
        }

    }
    

    public boolean AtmLogin(int Account, int Accpin) {
        if (Account == AccNumber && Accpin == AccPin) {
           
           return true;
        }
        else{
        return false;
        }
        
    }
    public void TransferMoneyATM(int AccNumber) throws SQLException, ClassNotFoundException{
        System.out.print("Dear  Customer, Enter the value this you wanna to Transfar : ");
        int value = input.nextInt();
      float Balance = getBalance(AccNumber);
        while (value > Balance) {
            System.out.println("Dear Customer , Please Enter A money You have you are poor : \"" + Balance + "\".");
            value = input.nextInt();
        }

        System.out.println("Enter the Account  of receiver : ");
        int acco_of_recei = input.nextInt();
        if (!EmailExist(acco_of_recei).equals("Not Found")) {
            float SenderBalance = Balance - value;
            UpdateBal(AccNumber, SenderBalance);
            float ReseverBalance = getBalance(acco_of_recei) + value;
            UpdateBal(acco_of_recei, ReseverBalance);
        } else {
            System.out.println(EmailExist(acco_of_recei));
        }  
    
    }
    public void AccInfo() throws SQLException{
        ResultSet result=GetData(AccNumber);
        String Name="",email="";
        int AccountNumber=AccNumber;
        float Balance1=0;
       if (!EmailExist(AccNumber).equals("Not Found")){
        while (result.next()){
            Name=result.getString("FirstName")+" "+result.getString("lastName");
            email=result.getString("email");
            AccountNumber=result.getInt("AccNum");
            Balance1=result.getFloat("Balance");
        }
        
        System.err.println(" Welcome "+Name+"\n Your Account Number is : "+AccountNumber+"\n You Email is : "+
                email+"\n Your Balance is : "+Balance1); 
       }
      
    }
   
    
    }
