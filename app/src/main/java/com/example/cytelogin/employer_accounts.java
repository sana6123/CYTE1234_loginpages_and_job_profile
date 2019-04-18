package com.example.cytelogin;

public class employer_accounts {
    public employer_accounts(String companyname, String email_empr, String phone_empr, String password_empr, String postal_code_empr) {


        this.id_1 = -1;
        this.companyname = companyname;
        this.email_empr = email_empr;
        this.phone_empr = phone_empr;
        this.password_empr = password_empr;
        this.postal_code_empr = postal_code_empr;
    }

    private int id_1;
    private String companyname;
    private String email_empr;
    private String phone_empr;
    private String password_empr;
    private String postal_code_empr;



    public int getid_1() {
        return id_1;
    }

    public void setid_1(int id_1) {
        this.id_1 = id_1;
    }

    public  String getcompanyname() {
        return companyname;
    }

    public void setName(String name) {
        this.companyname = companyname;
    }
//phone number
    public String getemail_empr() {
        return email_empr;
    }

    public void setemail_empr(String phone) {
        this.email_empr = email_empr;
    }

    public String getphone_empr() {
        return phone_empr;
    }
    public void setphone_empr (String phone_empr) {
        this.phone_empr = phone_empr; }

    public String password_empr() {
        return password_empr;
    }

    public void setpassword_empr(String password) {
        this.password_empr = password_empr;
    }

    public String getpostal_code_empr() { return postal_code_empr; }
    public void setpostal_code_empr (String postal_code_empr) { this.postal_code_empr = postal_code_empr; }


    public String postal_code_empr() {
        return null;
    }
}
