class DeleteNodeAndReturnForest {
    private boolean helper(TreeNode root, Set<Integer> set,List<TreeNode> ans){
        if(root == null)return false;

        boolean left = helper(root.left,set ,ans);
         if(left) root.left = null;
        boolean right = helper(root.right, set,ans);
         if(right) root.right = null;

        if(set.contains(root.val) ){
            if(root.left != null){
            ans.add(root.left);
            root.left = null;
            }
            if(root.right != null){
            ans.add(root.right);
            root.right = null;
            }
            return true;
        }
        return false;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
      Set<Integer> set= new HashSet<>();
       List<TreeNode> ans = new ArrayList<>();
      for(int num : to_delete){
        set.add(num);
      }
      if(!helper(root,set,ans)){
        ans.add(root);
      }
      return ans;
    }
}
