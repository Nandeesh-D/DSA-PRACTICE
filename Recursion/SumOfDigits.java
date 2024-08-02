package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int a=4312;
        SumOfDigits s=new SumOfDigits();
        System.out.println(s.digitsSum(a));
        s.reverse(143);
        System.out.println(s.rev);
    }

    public int digitsSum(int num){
        if(num<=0) return 0;
        return num%10+digitsSum(num/10);
    }

    int rev=0;
    public void reverse(int num){
        if(num==0) return;

        int r=num%10;
        rev=rev*10+r;
        reverse(num/10);
    }

}
