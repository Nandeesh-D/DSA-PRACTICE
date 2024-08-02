package Searching;

public class FindFloorAndCeil {

    public static void main(String[] args) {

        int[] arr={3, 4, 7, 8, 8, 10};
        System.out.println(floor(arr,5));
        System.out.println(ceil(arr,5));

    }

    static int floor(int[] arr,int x){

            int s=0;
            int e=arr.length-1;

            while(s<=e){
                int mid=s+(e-s)/2;
                if(arr[mid]==x) return mid;
                else if(arr[mid]<x) s=mid+1;
                else e=mid-1;
            }
            return e;
    }


    static int ceil(int[] arr,int x){

        int s=0;
        int e=arr.length-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x) s=mid+1;
            else e=mid-1;
        }
        return s;
    }
}
