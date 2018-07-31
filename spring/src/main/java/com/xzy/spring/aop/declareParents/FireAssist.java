package com.xzy.spring.aop.declareParents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FireAssist {

    @DeclareParents(value = "com.xzy.spring.aop.declareParents.Fireable+", defaultImpl = CommonParentImpl.class)
    private CommonParent commonParent;

    @Before("bean(fighterPlane) && this(commonParent)")
    public void beforeAttack(CommonParent commonParent) {
        commonParent.doSomething();
    }

}
