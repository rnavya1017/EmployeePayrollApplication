package com.bridgelabz.EmployeePayrollApplication.responsedto;


public class ExternalUserResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private ExternalAddressDTO address;
    private ExternalCompanyDTO company;

    public ExternalUserResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ExternalAddressDTO getAddress() {
        return address;
    }

    public void setAddress(ExternalAddressDTO address) {
        this.address = address;
    }

    public ExternalCompanyDTO getCompany() {
        return company;
    }

    public void setCompany(ExternalCompanyDTO company) {
        this.company = company;
    }
}
