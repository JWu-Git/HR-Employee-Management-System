package hw2;

class LNode {
    protected Comparable<Employee> data;
    protected LNode next;
    
    public LNode(Comparable<Employee> o) {
        data=o;
        next=null;
    }
    
    public LNode() {
        data=null;
        next=null;
    }
  
    public Comparable<Employee> getData() {
        return data;
    }
}

 