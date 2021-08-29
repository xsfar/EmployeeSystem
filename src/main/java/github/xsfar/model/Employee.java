/**
 * setters and getters for employees information
 */
package github.xsfar.model;
 
public class Employee {
 
    private Long empId;
    private String empNo;
    private String empName;
    private String empPosition;
    private String empSalary;

    public Employee() {
 
    }
 
    public Employee(EmployeeForm empForm) {
        this.empId = empForm.getEmpId();
        this.empNo = empForm.getEmpNo();
        this.empName = empForm.getEmpName();
        this.empPosition = empForm.getEmpPosition();
        this.empSalary = empForm.getEmpSalary();

    }
 
    public Employee(Long empId, String empNo, String empName, String position, String salary) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        this.empPosition = empPosition;
        this.empSalary = empSalary;

    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public String getEmpPosition() {
        return empPosition;
    }
 
    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }
    
    public String getEmpSalary() {
        return empSalary;
    }
 
    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }
 
 
}