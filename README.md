# Readme: Employee entity

REST API implementing CRUD operations

## Requirements

* SpringBoot
* Java JDK 11+
* Maven
* MySQL server

### Access
http://localhost:9090/callback

### Exercising Rest Controller
* POST	/employees			Create new employee		 http://localhost:9090/employee
* POST	/employees/id		Deletes the employee	 http://localhost:9090/employees/3

### Samples
* POST : {"firstName":"Michael","lastName":"Jordan","dob":"01/10/1970","title":"CEO"}
* DELETE : http://localhost:9090/employees/5
