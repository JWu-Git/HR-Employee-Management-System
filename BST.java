package hw2;

class BST {
    protected BSTNode root;
    
    public BST(Comparable<Employee> x) {
        root=new BSTNode(x);
    }
    
    public boolean isEmpty() {
        if (root==null) return true;
        else return false;
    }
    
    public BSTNode insertComparable (Comparable<Employee> x) {
        return BST.insertComparable(root, x);
    }
    
    private static BSTNode insertComparable (BSTNode treeRoot, Comparable<Employee> x) {
        if (treeRoot==null) return new BSTNode(x);
        else if (treeRoot.getData().compareTo((Employee) x)<0) {
            treeRoot.right=BST.insertComparable(treeRoot.right, x);
        }
        else {
            treeRoot.left=BST.insertComparable(treeRoot.left, x);
        }
        return treeRoot;

    }
    
    private static BSTNode insertNodeDirectly (BSTNode treeRoot, BSTNode treeRootToBeInserted) {
        if (treeRoot==null) return treeRootToBeInserted;
        else if (treeRoot.getData().compareTo((Employee) treeRootToBeInserted.getData())<0) {
            treeRoot.right=BST.insertNodeDirectly(treeRoot.right, treeRootToBeInserted);
        }
        else {
            treeRoot.left=BST.insertNodeDirectly(treeRoot.left, treeRootToBeInserted);
        }
        return treeRoot;

    }
    
    public BSTNode deleteComparable(Comparable<Employee> x) {
        return BST.deleteComparable(root, x);
    }
    
    private static BSTNode deleteComparable(BSTNode treeRoot,Comparable<Employee> x) {
             if (treeRoot==null) {
                return treeRoot;
            }
            else if (treeRoot.data.equals(x)) {
                return BST.insertNodeDirectly(treeRoot.left, treeRoot.right);
            }
            else if (treeRoot.data.compareTo((Employee) x)<0) {
                treeRoot.right=BST.deleteComparable(treeRoot.right, x);
            }
            else {
                treeRoot.left=BST.deleteComparable(treeRoot.left, x);
            }
            return treeRoot;
    }
    
    public boolean search(Comparable<Employee> x) {
        BSTNode currentNode=root;
        boolean found=false;
        while (true) {
             if (currentNode==null) {
                break;
            }
            else if (currentNode.data.compareTo((Employee) x)==0) {
                found=true;
                break;
            }
            else if (currentNode.data.compareTo((Employee) x)<0) {
                currentNode=currentNode.right;
            }
            else {
                currentNode=currentNode.left;
            }
        }
        return found;
        
    }
   
    public String toString() {
        return toString(root);
    }
    
    private static String toString(BSTNode treeRoot){
        String return_data="";
        if (treeRoot.left!=null) return_data += BST.toString(treeRoot.left);
        return_data += treeRoot.getData().toString();
        if (treeRoot.right!=null) return_data+=BST.toString(treeRoot.right);
        return return_data;
         
    }
}
