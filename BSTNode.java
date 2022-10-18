package hw2;

class BSTNode {
    protected Comparable<Employee> data;
    protected BSTNode left;
    protected BSTNode right;
    
    public BSTNode(Comparable<Employee> o) {
        data=o;
        left=null;
        right=null;
    }
    
    public BSTNode() {
        data=null;
        left=null;
        right=null;
    }
  
    public Comparable<Employee> getData() {
        return data;
    }
}

 