public class TreeNode {

	public String token = null;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode() {
	
	}


	public int height(){
		if(this.token != null){
			return 1;
			
		}else{
			return 1 + Math.max(left.height(), right.height());
		}
	}


	public int n_leaves(){
		if(this.token != null){
			return 1;
			
		}else{
			return left.n_leaves() + right.n_leaves();
		}
	}

}