import java.util.Scanner;
import java.util.Random;

class GuessNum{
    public static void main(String args[]){
        GuessRand();
    }
    public static void GuessRand(){
        Random ran=new Random();
        int random=ran.nextInt(11);
        Userguess(random);
    }
    public static void Userguess(int rand){
        int trycount=0,score=0;
        int maxlimit=5,flag=0;
        Scanner ob=new Scanner(System.in);
        while(true){
            System.out.println("Enter The Number You Guessed:");
            int userno=ob.nextInt();
            if (userno<0|| userno>10){
                System.out.println("Enter the guess between range of 0-10:");
                userno=ob.nextInt();
            }
            if(rand==userno){
                System.out.println("Congrats you guessed the number:");
                flag=1;
                break;
            }
            else{
                System.out.println("You guess was wrong!:");
                trycount++;
                if(userno<rand){
                    System.out.println("Your guess is smaller than the random number:");
                }
                else{
                    System.out.println("Your guess is Greater than the random number:");
        }
        if(trycount>=maxlimit){
            System.out.println("You Reached Maximum try of 5");
            System.out.println("Your score is:0");
            
             System.out.println();
            System.out.println("Do You want to play again?:");
            System.out.println("Enter 1 to guess again OR to exit Enter 0:");
            int option=ob.nextInt();
            if(option==0){
            break;
        }else{
            GuessRand();
            return;
        }
    }
}
}

if (flag==1){
    if (trycount==0){
        score=100;
    }
    else if(trycount >0 && trycount<=3){
        score=90;
    }
    else if(trycount==4){
        score=80;
    }
    else{
        score=60;
    }
    System.out.println("Your score is:"+score);
}
}
}
