//add or edit employee

var app = angular.module("EmployeeManagement", []);
 
app.controller("EmployeeController", function($scope, $http) {
 
 
    $scope.employees = [];
    $scope.employeeForm = {
        empId: 1,
        empNo: "",
        empName: "",
        empPostion: "",
        empSalary: ""
    };
 
    _refreshEmployeeData();
 
    //add or edit employee
    $scope.submitEmployee = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.employeeForm.empId == -1) {
            method = "POST";
            url = '/employee';
        } else {
            method = "PUT";
            url = '/employee';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employeeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
   //delete employee from database
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.empId
        }).then(_success, _error);
    };
 
    //edit employee data
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.empId = employee.empId;
        $scope.employeeForm.empNo = employee.empNo;
        $scope.employeeForm.empName = employee.empName;
        $scope.employeeForm.empPostion = employee.empPostion;
        $scope.employeeForm.empSalary = employee.empSalary;

    };
 
    
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    //clear input after submisstion
    function _clearFormData() {
        $scope.employeeForm.empId = -1;
        $scope.employeeForm.empNo = "";
        $scope.employeeForm.empName = "";
        $scope.employeeForm.empPostion = "";
        $scope.employeeForm.empSalary = ""
    };
});