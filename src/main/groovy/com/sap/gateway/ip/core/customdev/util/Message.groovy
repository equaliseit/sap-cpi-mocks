package com.sap.gateway.ip.core.customdev.util

import org.apache.camel.Exchange
import org.apache.camel.TypeConversionException
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.support.DefaultExchange

class Message {

    Exchange exchange
    Object body
    Map<String, Object> headers
    Map<String, Object> properties

    Message() {
        this.exchange = new DefaultExchange(new DefaultCamelContext())
        this.headers = [:]
        this.properties = [:]
    }

    public <K> K getBody(Class<K> klass) throws TypeConversionException {
        return this.exchange.getIn().getBody(klass) ?: null
    }

    void setBody(Object body) {
        // Set exchange body in case automatic Type Conversion is required
        this.exchange.getIn().setBody(body)
        this.body = this.exchange.getIn().getBody()
    }

    public <K> K getHeader(String name, Class<K> klass) throws TypeConversionException {
        if (!this.exchange.getIn().getHeader(name)) {
            return null
        } else {
            return this.exchange.getIn().getHeader(name, klass) ?: null
        }
    }

    void setHeader(String name, Object value) {
        this.exchange.getIn().setHeader(name, value)
        this.headers.put(name, exchange.getIn().getHeader(name))
    }

    void setProperty(String name, Object value) {
        this.properties.put(name, value)
    }

    Object getProperty(String name) {
        return this.properties.get(name)
    }
}