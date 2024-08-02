package BinarySearchTree;



public class findCeil {
    public int findCeil(TreeNode root,int key){
        int ceil=-1;
        while(root!=null){
            if(root.val==key){
                ceil=root.val;
                return ceil;
            }

            if(key<root.val){
                ceil=root.val;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ceil;
    }



}
