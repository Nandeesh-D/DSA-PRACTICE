package Searching;

import java.util.ArrayList;

public class BookAllocation {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n) return -1;  //no of students > no of books available
        int low=0;
        int high=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<low) low=arr.get(i);
            high+=arr.get(i);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int students=findStudents(arr,mid);
            if(students>m) low=mid+1;
            else high=mid-1;
        }

        //finally low will point to the correct answer
        return low;

    }

    public static int findStudents(ArrayList<Integer> arr,int m){
        int students=1;
        int pagesCount=0;
        for(int i=0;i<arr.size();i++){
            if(pagesCount+arr.get(i)<=m){
                pagesCount+=arr.get(i);
            }else{
                students+=1;
                pagesCount=arr.get(i);
            }
        }
        return students;
    }
}
