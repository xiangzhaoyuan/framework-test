package com.xzy.spring.label.lookup_method;

public abstract class ServiceBean {

    private UserSession userSession;

    public Object perform() {
        this.userSession = setUserSession();
        return this.userSession.getInstance();
    }

    //抽象方法，由lookup-method注入具体bean，当然也可以不声明为抽象方法（并不是强制要求），最终Lookup会覆盖原方法里的实现内容。
    abstract UserSession setUserSession();

}
