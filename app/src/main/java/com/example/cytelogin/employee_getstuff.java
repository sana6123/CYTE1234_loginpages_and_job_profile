package com.example.cytelogin;

public class employee_getstuff {


        public employee_getstuff(int id, String Name, String Phone, String Email,String Password,String Postal_code ) {
            this.id = id;
            this.title = Name;
            this.title = Phone;
            this.title = Email;
            this.title = Password;
            this.title = Postal_code;
        }

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        private String title;
        private String industry;
        private String city;




    }

