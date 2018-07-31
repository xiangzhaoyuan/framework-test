package com.xzy.spring.label.lookup_method;

public class UserSessionImpl implements UserSession {

    @Override
    public Object getInstance() {
        return this;
    }

}
