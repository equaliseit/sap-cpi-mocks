package com.sap.it.api.mapping

class ValueMappingApi {

    private Map entries = [:]
    private static ValueMappingApi valueMappingApi

    private ValueMappingApi() {
    }

    static ValueMappingApi getInstance() {
        if (!valueMappingApi) {
            valueMappingApi = new ValueMappingApi()
        }
        return valueMappingApi
    }

    void addEntry(String key, String value) {
        entries.put(key, value)
    }

    void addEntry(String sourceAgency, String sourceIdentifier, String sourceValue, String targetAgency, String targetIdentifier, String value) {
        def key = "${sourceAgency}_${sourceIdentifier}_${targetAgency}_${targetIdentifier}_${sourceValue}"
        def mappedKey = key.toString()
        entries.put(mappedKey, value)
    }

    String getMappedValue(String sourceAgency, String sourceIdentifier, String sourceValue, String targetAgency, String targetIdentifier) {
        def key = "${sourceAgency}_${sourceIdentifier}_${targetAgency}_${targetIdentifier}_${sourceValue}"
        def mappedValue = entries.get(key.toString())
        if (!mappedValue) {
            return null
        } else {
            return mappedValue
        }
    }
}