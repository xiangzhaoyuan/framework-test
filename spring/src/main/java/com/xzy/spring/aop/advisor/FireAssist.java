package com.xzy.spring.aop.advisor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FireAssist {

    //记录开火时间
    public void actionLog() throws Throwable {
        System.out.println("开火时间：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    }

    //报告已完成开火
    public void reportComplete() throws Throwable {
        System.out.println("报告长官：打完收工！");
    }

}
