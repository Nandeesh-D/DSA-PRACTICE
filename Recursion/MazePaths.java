package Recursion;

public class MazePaths {
    public static void main(String[] args) {
        System.out.println(pathsCount(3,3));
        printPaths1("",3,3);
    }

    //1 based index
    static int pathsCount(int r,int c){
        if(r==1 || c==1) return 1;

        int left=pathsCount(r-1,c);
        int right=pathsCount(r,c-1);

        return left+right;
    }

    //print paths
    static void printPaths(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1) printPaths(p+"D",r-1,c);
        if(c>1) printPaths(p+"R",r,c-1);
    }

    //including diagonal paths
    static void printPaths1(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1 && c>1) printPaths1(p+"D",r-1,c-1);
        if(r>1) printPaths1(p+"B",r-1,c);
        if(c>1) printPaths1(p+"R",r,c-1);
    }
}
