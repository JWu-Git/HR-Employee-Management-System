package hw2;

public class HRList {
    protected Stack LayOffStack;
    protected Queue ReHireQueue;
    protected BST ActiveEmployeeList;
    
    public HRList() {
        LayOffStack=new Stack();
        ReHireQueue=new Queue();
        
    }
    
    public void AddToHRList(Comparable<Employee> e) {

        LayOffStack.Push(e);
        if (ActiveEmployeeList==null) {
            ActiveEmployeeList=new BST(e);
        }
        else{
            ActiveEmployeeList.root=ActiveEmployeeList.insertComparable(e);
        }
    }
    
    public void LayOff( ) {
        Comparable<Employee> e=LayOffStack.Peek();
        ReHireQueue.EnQueue(e);
        ActiveEmployeeList.root=ActiveEmployeeList.deleteComparable(e);
        LayOffStack.Pop();
 
    }
    
    public void Rehire() {
        Comparable <Employee> temp=ReHireQueue.DeQueue();
        ActiveEmployeeList.root=ActiveEmployeeList.insertComparable(temp);
        LayOffStack.Push(temp);
         
    }
    
    public int Count_current_employees() {
        return LayOffStack.Count();
    }
    
 
}
