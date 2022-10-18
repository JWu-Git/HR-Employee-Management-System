package hw2;

class Stack {
    protected int top;
    protected Comparable<Employee>[] arr=new Employee[10];
     
    public Stack() {
 
        top=-1;
    }
    
    public void Push(Comparable<Employee> e) {
        top=top+1;
        arr[top]=e;

    }
    
    public void Pop() {
        top=top-1;
    }
    
    public Comparable<Employee> Peek() {
        return arr[top];
    }
    
    public int Count() {
        return top+1;
    }
}
