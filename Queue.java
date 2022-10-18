package hw2;
 

class Queue {
    protected LNode first;
    protected LNode last;
    
    public Queue() {
        first=new LNode();
        last=first;
    }
    
    public boolean isEmpty() {
        if (first.next==(null)) return true;
        else return false;
    }

    public void EnQueue (Comparable<Employee> x) {
        last.next=new LNode(x);
        last=last.next;
    }
    
    public Comparable<Employee> DeQueue() {
        Comparable<Employee> temp= first.next.getData();
        first=first.next;
 
        return temp;
    }
    
    public String toString(){
        LNode leader=first.next;
        LNode follower=first;
        String s="";
        while (leader!=(null)) {
            s+=leader.data.toString();
            leader=leader.next;
            follower=follower.next;
        }
        return s;
    }
}
