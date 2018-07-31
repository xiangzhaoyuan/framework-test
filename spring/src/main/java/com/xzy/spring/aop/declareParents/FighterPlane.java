package com.xzy.spring.aop.declareParents;

import org.springframework.stereotype.Component;

@Component
public class FighterPlane implements Fireable {

    @Override
    public void attack() {
        System.out.println("战斗机开火！造成200点伤害！");
    }

}
