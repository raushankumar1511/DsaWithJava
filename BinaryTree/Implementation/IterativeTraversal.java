package BinaryTree.Implementation;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> preorder= new ArrayList<>();
        if(root == null) return preorder;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return preorder;
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder= new ArrayList<>();
        if(root == null) return inorder;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty())break;

                node  = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }

    //using two stack
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> postorder= new ArrayList<>();
        if(root == null) return postorder;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left!=null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()){
            postorder.add(s2.pop().val);
        }
        return postorder;
    }


    // pre\in\post order traversal in one iteration
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node = node;
            this.num =num;
        }
    }

    public void preInPostTraversal(TreeNode root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null){
            return;
        }
        while (!st.isEmpty()){
            Pair it = st.pop();

            //if it.num is 1 then increment 1 to 2 and push its left to stack
            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }
            //if it.num =2 increment it to 3 and push its right to stak
            else if(it.num == 2){
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            //don't push it back again
            else{
                post.add(it.node.val);
            }
        }
    }
}
