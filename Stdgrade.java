import java.io.*;
import java.util.*;

class grade{
    String calculategrade(double g){
        int grade=(int)(g/10);
        switch (grade){
            case 10:
            return "S";
            case 9:
            return "A";
            case 8:
            return "B";
            case 7:
            return "C";
            case 6:
            return "D";
            case 5:
            return "E";
            default:
            return "FAIL";
        }

    }

}
 class Stdgrade{
    public static void main(String args[]){
        int i,num,total=0,mark;
        System.out.println("Enter the number of subjects:");
        Scanner ob=new Scanner(System.in);
        num=ob.nextInt();
        System.out.println("Enter the marks for "+num+" Subjects:");
        for(i=0;i<num;i++){
            mark=ob.nextInt();
            total+=mark;
        }
        double average=(double)total/num;
        System.out.println("Your total mark is:"+total);
        System.out.println("Your average is:"+average+"%");
        grade gd=new grade();
        String grade=gd.calculategrade(average);
        System.out.println("Your grade is:"+grade);

    }
 }
