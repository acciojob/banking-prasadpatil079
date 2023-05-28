package com.driver;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.min;

@Getter
@Setter
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
            this.name=name;
            this.balance=balance;
            this.minBalance=minBalance;
    }

    public String generateAccountNumber(int n, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum < 0||sum > n*9){
            throw new AccountNumberCannotBeGeneratedException("Account Number cannot be Generated");
        }
        int remaining =sum;
        String acNo="";
        for(int i=0;i<n;i++){
            int dig= min(9,remaining);
            acNo+=dig;
            remaining-=dig;
        }

        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
      if ((this.balance-amount)<this.minBalance||this.balance<amount){
          throw new Exception("Insufficient Balance");
      }else{
          this.balance=this.balance-amount;
      }

    }

}