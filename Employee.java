package hw2;

class Employee implements Comparable<Employee> {
    protected String firstName;
    protected String lastName;
    protected String IDNumber;
    
    public Employee(String fn, String ln, String id) {
        this.firstName=fn;
        this.lastName=ln;
        this.IDNumber=id;
    }
    
    public Employee(String fn, String ln) {
        this.firstName=fn;
        this.lastName=ln;
    }
    
    public void setFirstName(String fn) {
        firstName=fn;
        }
    
    public void setLastName(String ln) {
        lastName=ln;
    }
    
    public void setIDNumber(String id) {
        IDNumber=id;
    }
        
    public String getFirstName() {
        return firstName;
    }
        
    public String getLastName() {
        return lastName;

        }
    
    public String getIDNumber() {
        return IDNumber;

    }
 
    public boolean equals(Employee o) {
        return IDNumber.equals(o.getIDNumber());
         
    }
    
    public String toString() {
        return firstName.toString()+' '+lastName.toString()+' '+IDNumber.toString()+'\n';
    }
 
    public int compareTo(Employee o) {
        if (lastName.compareTo(o.getLastName())==0) {
            return firstName.compareTo((o.getFirstName()));
        }
        else {
            return lastName.compareTo(o.getLastName());
        }
    }

}
