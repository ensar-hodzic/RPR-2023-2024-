package ba.unsa.etf.rpr.predavanje02;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input=new Scanner(System.in);
        System.out.println("Unesite neki broj: ");
        int n=input.nextInt();
        System.out.println("Brojevi koji su djeljivi sa svojom sumom cifara: ");
        for(int i=1;i<=n;i++){
            if(sumaCifara(i)) System.out.printf(i+",");
        }
    }

    public static Boolean sumaCifara(int n){
        int temp=n,sum=0;
        while(temp!=0){
            sum=sum+(temp%10);
            temp=temp/10;
        }
        if(n%sum==0) return true;
        return false;
    }
}
