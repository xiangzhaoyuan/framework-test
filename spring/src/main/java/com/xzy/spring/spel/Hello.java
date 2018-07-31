package com.xzy.spring.spel;

public class Hello {

    private String userDir;
    private String key;

    public String getUserDir() {
        return userDir;
    }

    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Hello{userDir=" + userDir + ", key=" + key + "}";
    }
}
