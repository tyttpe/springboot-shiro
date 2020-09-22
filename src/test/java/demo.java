import java.util.Scanner;

public class demo {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("please input a number:");
            int num=sc.nextInt();
            System.out.println();
            System.out.println("method1---the factorial of "+num+" is:" +fact(num));
            System.out.println("method2---the factorial of "+num+" is:" +recurrence(num));
        }
    }

    //采用循环连乘法
    public static int fact(int num){
        int temp=1;
        int factorial=1;
        while(num>=temp){
            factorial=factorial*temp;
            temp++;
        }
        return factorial;
    }
    //采用递归法
    public static int recurrence(int num){
        if(num<=1)
            return 1;
        else
            return num*recurrence(num-1);
    }
}
