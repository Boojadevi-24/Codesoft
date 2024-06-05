import java.io.*;
import java.util.*;
//TASK 2 ATM INTERFACE
class Bank{
    private int balance;
    public Bank(int amt){
        balance=amt;
    }
    public void checkbalance(){
        System.out.println("your balance is:"+balance);
    }
    public void deposit(int amt){
        balance+=amt;
    }
    public void withdraw(int amt){
        if (balance>0){
            if(amt<=balance){
                balance-=amt;
            }
            else{
                System.out.println("Insufficient Balance!");
            }
        }
    }
}
class atm{
    private Bank ac;
    int amount,choice;
    public atm(Bank account) {
        ac = account;
    }
    Scanner ob=new Scanner(System.in);
    public void userinput(){
    while(true){
        System.out.println("1 ->Display balance:");
        System.out.println("2 ->Deposit amount:");
        System.out.println("3 ->Withdraw money:"); 
        System.out.println("4 ->Exit");
        System.out.println("Enter your choice:");
        choice=ob.nextInt();
        switch(choice){
            case 1:
            ac.checkbalance();
            break;
            case 2:
            System.out.println("Enter amount you want to deposit:");
            amount=ob.nextInt();
            if (amount>0){
                ac.deposit(amount);
            }
            else{
                System.out.println("Enter valid amount:");
            }
            break;
            case 3:
            System.out.println("Enter withdraw amount:");
            amount=ob.nextInt();
            ac.withdraw(amount);
            break;
            case 4:
            System.out.println("Exited!");
            return;
        }
    }
}

}
class atminterface{
    public static void main(String args[]){
        Bank b=new Bank(10000);
        atm a=new atm(b);
        a.userinput();
    }
}