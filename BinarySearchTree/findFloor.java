package BinarySearchTree;

public class findFloor {
    public static int floor(TreeNode root, int x) {
        // Code here
        int floor=-1;
        while(root!=null){
            if(root.val==x){
                floor=root.val;
                return floor;
            }

            if(x>root.val){
                floor=root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
