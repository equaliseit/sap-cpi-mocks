package com.sap.it.api.securestore

import com.sap.it.api.securestore.exception.SecureStoreException

class SecureStoreService {

    private static SecureStoreService secureStoreService
    private Map<String, UserCredential> userCredentials = [:]

    static SecureStoreService getInstance() {
        if (!secureStoreService) {
            secureStoreService = new SecureStoreService()
        }
        return secureStoreService
    }

    void addCredential(String alias, UserCredential userCredential) {
        userCredentials.put(alias, userCredential)
    }

    UserCredential getUserCredential(String alias) throws SecureStoreException {
        return userCredentials.get(alias)
    }
}