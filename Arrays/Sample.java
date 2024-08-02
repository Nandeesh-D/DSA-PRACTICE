package Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] cnt={0};
        isValid("","0011",0,0,cnt);
        System.out.println(cnt[0]);
    }
    public static int countDivisors(int n) {
        double sum=0;
        for(int i=1;i<=n;i++){
            sum+=Math.log(i);
        }
        return (int)Math.exp(sum/n);
    }

    public static void isValid(String p,String up,int z,int o,int cnt[]){
        if(up.isEmpty()){
            if(o>=z*z) cnt[0]+=1;
            return;
        }

        char ch=up.charAt(0);

        isValid(p,up.substring(1),z,o,cnt);
        isValid(p+ch,up.substring(1),z,o,cnt);
    }
}
