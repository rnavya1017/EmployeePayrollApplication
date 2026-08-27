package com.bridgelabz.EmployeePayrollApplication.responsedto;


public class ExternalCompanyDTO {

    private String department;
    private String name;
    private String title;

    public ExternalCompanyDTO() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}