package com.sap.it.api.securestore

class UserCredential {

    String username
    char[] password

    UserCredential(String username, String password) {
        this.username = username
        this.password = password.toCharArray()
    }
}