class Employee {
	
	protected String ename;
	protected double basicSalary;
	protected static int count;
	
	{
		count++;
	}
	
	public Employee() {
		this("NA", 500);
	}
	
	public Employee(String name, double bs) {
		this.ename = name;
		this.basicSalary = bs;
	}
	
	public Employee(Employee e) {
		this.ename = e.ename;
		this.basicSalary = e.basicSalary;
	}
	
	public String getName() {
		return this.ename;
	}
	
	public void setName(String name) {
		this.ename = name;
	}
	
	public double getBaseSal() {
		return this.basicSalary;
	}
	
	public void setBaseSal(double sal) {
		this.basicSalary = sal;
	}
	
	public void printEmployeeDetails() {
		System.out.println("\nName: " + this.ename);
		System.out.println("\nBasic Salary: " + this.basicSalary);
	}
	
	public double getNetIncome() {
		return this.basicSalary;
	}
	
	public static int countEmployees() {
		return count;
	}
}

class SalesManager extends Employee {
	
	protected double salesAmount;
	protected static int salesManaCount;
	
	{
		salesManaCount++;
	}
	
	public SalesManager() {
		this("NA", 0, 0);
	}
	
	public SalesManager(String name, double bs, double sa) {
		super(name, bs);
		this.salesAmount = sa;
	}
	
	public SalesManager(SalesManager s) {
		super(s.ename, s.basicSalary);
		this.salesAmount = s.salesAmount;
	}
	
	public double getSalesAmount() {
		return this.salesAmount;
	}
	
	public void setSalesAmount(double sa) {
		this.salesAmount = sa;
	}
	
	public void printEmployeeDetails() {
		super.printEmployeeDetails();
		System.out.println("\nSales Amount: " + this.salesAmount);
	}
	
	public double getNetIncome() {
		return (super.getNetIncome() + 0.2*(this.salesAmount)); 
	}
	
	public static int countEmployees() {
		return salesManaCount;
	}
}

class Programmer extends Employee {
    
    protected static int progEmpCount;
    protected double bonus;
    
    {
        progEmpCount++;
    }
    
    public Programmer() {
		this("NA", 0, 0);
	}
	
	public Programmer(String name, double bs, double bonus) {
		super(name, bs);
		this.bonus = bonus;
	}
	
	public Programmer(Programmer p) {
		super(p.ename, p.basicSalary);
		this.bonus = p.bonus;
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void printEmployeeDetails() {
		super.printEmployeeDetails();
		System.out.println("\nBonus: " + this.bonus);
	}
	
	public double getNetIncome() {
		return (super.getNetIncome() + 0.3*(this.bonus)); 
	}
	
	public static int countEmployees() {
		return progEmpCount;
	}
    
    
}
public class Java2_1 {
	
	public static void getTotalSalesAmount(Employee[] emparr) {
	    
	    double totalSA = 0;
	    
		for(int i=0; i<emparr.length; i++) {
		    
		    if(emparr[i] instanceof SalesManager) {
		        
		        SalesManager sb = (SalesManager) emparr[i];
		        totalSA += sb.getSalesAmount();
		        
		    }
		}
		
		System.out.println("\nTotal Sales Amount: " + totalSA);
	}
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Tirth", 95000);
		SalesManager s1 = new SalesManager("Rudra", 95000, 8000);
		Programmer p1 = new Programmer("Shreyas", 125000, 50000);
		
		Employee[] emparr = {e1, s1, p1};
		
		e1.printEmployeeDetails();
		System.out.println("\nNet Income: " + e1.getNetIncome());
		
		s1.printEmployeeDetails();
		System.out.println("\nNet Income: " + s1.getNetIncome());
		
		p1.printEmployeeDetails();
		System.out.println("\nNet Income: " + p1.getNetIncome());
		
		System.out.println("\nTotal Employee Accounts: " + Employee.countEmployees());
		System.out.println("\nTotal Sales Manager Accounts: " + SalesManager.countEmployees());
		System.out.println("\nTotal Programmer Accounts: " + Programmer.countEmployees());
		
		getTotalSalesAmount(emparr);
	}
}