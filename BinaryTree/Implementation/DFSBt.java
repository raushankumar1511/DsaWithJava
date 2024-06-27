package BinaryTree.Implementation;

public class DFSBt {
     static void inorder(TreeNode treeNode){
         if(treeNode == null){
             return;
         }
         inorder(treeNode.left);
         System.out.print(treeNode.val +" ");
         inorder(treeNode.right);
     }
    static void preorder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.print(treeNode.val +" ");
        preorder(treeNode.left);
        preorder(treeNode.right);
    }
    static void postorder(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        postorder(treeNode.left);
        postorder(treeNode.right);
        System.out.print(treeNode.val +" ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        System.out.print("Inorder Traversal ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal ");
        postorder(root);

    }

}
