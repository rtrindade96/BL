package com.example.ranielle.baronlogger.Model;

public class User {

        private String name;
        private String email;
        private String password;
        private String token;

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {

            this.email = email;
        }

        public void setPassword(String password) {

            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {

            return email;
        }

        public String getPassword() {
            return password;
        }
        public void setToken(String token) {

            this.token = token;
        }
}

