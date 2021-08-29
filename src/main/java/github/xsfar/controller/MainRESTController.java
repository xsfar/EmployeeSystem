/**
 *  add, update and delete employees from the system 
 */
package github.xsfar.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import github.xsfar.dao.EmployeeDAO;
import github.xsfar.model.Employee;
import github.xsfar.model.EmployeeForm;
  
@RestController 
public class MainRESTController {
  
    @Autowired
    private EmployeeDAO employeeDAO;
  
  
    /**
     * retrieve all employees and return them
     * 
     * @return list of employees
     */
    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }
  

    /**
     * lookup employee based on ID
     * 
     * @param empId employee ID 
     * @return a specific employees information based on a given ID
     */
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeDAO.getEmployee(empId);
    }
  
    /**
     * add new employees to system
     * 
     * @param empForm form to create a new employees 
     * @return 
     */
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
  
        return employeeDAO.addEmployee(empForm);
    }
  

    /**
     * edit a employees information
     * 
     * @param empForm form to update employee 
     * @return
     */
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());
  
        return employeeDAO.updateEmployee(empForm);
    }
  
    /**
     * remove employee form system based on ID
     * 
     * @param empId delete employee based on ID
     */
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empId") Long empId) {
  
        System.out.println("(Service Side) Deleting employee with Id: " + empId);
  
        employeeDAO.deleteEmployee(empId);
    }
  
}