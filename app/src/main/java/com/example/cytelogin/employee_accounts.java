package com.example.cytelogin;

public class employee_accounts {
    public employee_accounts(String name, String phone, String email, String password, String postal_code) {
        this.idd = -1;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.name = password;
        this.postal_code = postal_code;
    }

    private int idd;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String postal_code;



    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public void setEmail (String email) { this.email = email; }

    public String getPassword() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostal_code() { return postal_code; }
    public void setPostal_code (String postal_code) { this.postal_code = postal_code; }




}
