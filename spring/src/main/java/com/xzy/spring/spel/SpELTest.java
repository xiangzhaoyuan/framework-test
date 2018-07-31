package com.xzy.spring.spel;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.*;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.*;

public class SpELTest {

    @Test
    public void test() {
        String expressionStr = "1+2";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expressionStr);
        Integer val = expression.getValue(Integer.class);
        System.out.println(expressionStr + "的结果是：" + val);
    }

    //算术运算
    @Test
    public void test01() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("(1+2)*5 + 8-6/2").getValue().equals(20));//加减乘除
        Assert.assertTrue(parser.parseExpression("8%3").getValue().equals(2));//求余
        Assert.assertTrue(parser.parseExpression("2.0e3").getValue().equals(2000.0));//指数
        Assert.assertTrue(parser.parseExpression("2^3").getValue().equals(8));//指数
    }

    //逻辑运算
    @Test
    public void test02() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("true and true").getValue(Boolean.class));//与
        Assert.assertTrue(parser.parseExpression("true or false").getValue(Boolean.class));//与
        Assert.assertTrue(parser.parseExpression("!false").getValue(Boolean.class));//非
    }

    //比较运算
    @Test
    public void test03() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("5>3").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("5<=8").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("5==5").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("5!=6").getValue(Boolean.class));
    }

    //字符串
    @Test
    public void test04() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("'abc'").getValue().equals("abc"));
        //当我们的字符串中包含单引号时，那么对应的单引号需要使用一个单引号进行转义，即连续两个单引号。
        Assert.assertTrue(parser.parseExpression("'''abc'").getValue().equals("'abc"));
    }

    //访问方法
    @Test
    public void test05() {
        ExpressionParser parser = new SpelExpressionParser();
        //直接访问String的length()方法。
        Assert.assertTrue(parser.parseExpression("'abc'.length()").getValue().equals(3));
    }

    //使用EvaluationContext
    @Test
    public void test06() {
        Object user = new Object() {
            public String getName() {
                return "abc";
            }
        };
        EvaluationContext context = new StandardEvaluationContext(user);
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("name").getValue(context, String.class).equals("abc"));
        Assert.assertTrue(parser.parseExpression("getName()").getValue(context, String.class).equals("abc"));
    }

    //使用rootObject
    @Test
    public void test07() {
        Object user = new Object() {
            public String getName() {
                return "abc";
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("name").getValue(user, String.class).equals("abc"));
        Assert.assertTrue(parser.parseExpression("getName()").getValue(user, String.class).equals("abc"));
    }

    //List元素的访问
    @Test
    public void test08_1() {
        Object user = new Object() {
            public List<String> getInterests() {
                return Arrays.asList("BasketBall", "FootBall");
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("interests[0]").getValue(user, String.class).equals("BasketBall"));
        Assert.assertTrue(parser.parseExpression("interests[1]").getValue(user, String.class).equals("FootBall"));
    }

    //Array元素的访问
    @Test
    public void test08_2() {
        Object user = new Object() {
            public String[] getInterests() {
                return new String[]{"BasketBall", "FootBall"};
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("interests[0]").getValue(user, String.class).equals("BasketBall"));
        Assert.assertTrue(parser.parseExpression("interests[1]").getValue(user, String.class).equals("FootBall"));
    }

    //Map元素的访问
    @Test
    public void test08_3() {
        Object user = new Object() {
            public Map<String, String> getInterests() {
                Map<String, String> interests = new HashMap<>();
                interests.put("key1", "BasketBall");
                interests.put("key2", "FootBall");
                return interests;
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("interests['key1']").getValue(user, String.class).equals("BasketBall"));
        Assert.assertTrue(parser.parseExpression("interests['key2']").getValue(user, String.class).equals("FootBall"));
    }

    //构造List
    @Test
    public void test09() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> intList = (List<Integer>) parser.parseExpression("{1,2,3,4,5,6}").getValue();
        int index = 0;
        for (Integer i : intList) {
            Assert.assertTrue(i == ++index);
        }
    }

    @Test
    public void test09_1() {
        ExpressionParser parser = new SpelExpressionParser();
        List<List<Integer>> list = (List<List<Integer>>) parser.parseExpression("{{1,2},{3,4,5},{6,7,8,9}}").getValue();
        int index = 0;
        for (List<Integer> intList : list) {
            for (Integer i : intList) {
                Assert.assertTrue(i == ++index);
            }
        }
    }

    //构造Map
    @Test
    public void test10() {
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, Long> map = (Map<String, Long>) parser.parseExpression("{'key1':1L,'key2':2L}").getValue();
        Assert.assertTrue(map.get("key1").equals(1L));
        Assert.assertTrue(map.get("key2").equals(2L));
    }

    @Test
    public void test10_1() {
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, Long> map = (Map<String, Long>) parser.parseExpression("{:}").getValue();
        Assert.assertTrue(map.isEmpty());
    }

    //构造数组
    @Test
    public void test11() {
        ExpressionParser parser = new SpelExpressionParser();
        int[] nums = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue();
        Assert.assertTrue(nums.length == 3);
    }

    //多维数组也是支持的，但是多维数组只支持定义一个空的数组，对于需要初始化指定数组元素的定义暂时在SpEl中是不支持的。
    @Test
    public void test11_1() {
        ExpressionParser parser = new SpelExpressionParser();
        int[][] nums = (int[][]) parser.parseExpression("new int[2][3]").getValue();//正确
        int[][] nums2 = (int[][]) parser.parseExpression("new int[2][3]{{1,2,3},{4,5,6}}").getValue();//错误
    }

    //集合选择
    @Test
    public void test12_1() {
        Object user = new Object() {
            public List<String> getInterests() {
                List<String> interests = new ArrayList<>();
                interests.add("BasketBall");
                interests.add("FootBall");
                interests.add("Movie");
                return interests;
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        List<String> interests = (List<String>) parser.parseExpression("interests.?[endsWith('Ball')]").getValue(user);
        Assert.assertTrue(interests.size() == 2);
        Assert.assertTrue(interests.get(0).equals("BasketBall"));
        Assert.assertTrue(interests.get(1).equals("FootBall"));
    }

    @Test
    public void test12_2() {
        Object user = new Object() {
            public Map<String, String> getInterests() {
                Map<String, String> interests = new HashMap<>();
                interests.put("key1", "BasketBall");
                interests.put("key2", "FootBall");
                interests.put("key3", "Movie");
                return interests;
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, String> interests = (Map<String, String>) parser.parseExpression("interests.?[value.endsWith('Ball')]").getValue(user);
        Assert.assertTrue(interests.size() == 2);
        Assert.assertTrue(interests.get("key1").equals("BasketBall"));
        Assert.assertTrue(interests.get("key2").equals("FootBall"));
    }

    //集合投影
    @Test
    public void test13_1() {
        Object user = new Object() {
            public List<String> getInterests() {
                List<String> interests = new ArrayList<>();
                interests.add("BasketBall");
                interests.add("FootBall");
                interests.add("Movie");
                return interests;
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        List<Boolean> interests = (List<Boolean>) parser.parseExpression("interests.![endsWith('Ball')]").getValue(user);
        Assert.assertTrue(interests.size() == 3);
        Assert.assertTrue(interests.get(0).equals(true));
        Assert.assertTrue(interests.get(1).equals(true));
        Assert.assertTrue(interests.get(2).equals(false));
    }

    @Test
    public void test13_2() {
        Object user = new Object() {
            public Map<String, String> getInterests() {
                Map<String, String> interests = new HashMap<>();
                interests.put("key1", "BasketBall");
                interests.put("key2", "FootBall");
                interests.put("key3", "Movie");
                return interests;
            }
        };
        ExpressionParser parser = new SpelExpressionParser();
        List<String> interests = (List<String>) parser.parseExpression("interests.![value]").getValue(user);
        Assert.assertTrue(interests.size() == 3);
        for (String interest : interests) {
            Assert.assertTrue(interest.equals("BasketBall") || interest.equals("FootBall") || interest.equals("Movie"));
        }
    }

    //设置变量
    @Test
    public void test14() {
        Object user = new Object() {
            public String getName() {
                return "abc";
            }
        };
        EvaluationContext context = new StandardEvaluationContext();
        //1、设置变量
        context.setVariable("user", user);
        ExpressionParser parser = new SpelExpressionParser();
        //2、表达式中以#varName的形式使用变量
        Expression expression = parser.parseExpression("#user.name");
        //3、在获取表达式对应的值时传入包含对应变量定义的EvaluationContext
        String userName = expression.getValue(context, String.class);
        //表达式中使用变量，并在获取值时传递包含对应变量定义的EvaluationContext
        Assert.assertTrue(userName.equals("abc"));
    }

    //#root在表达式中永远都指向对应EvaluationContext的rootObject对象
    @Test
    public void test14_1() {
        Object user = new Object() {
            public String getName() {
                return "abc";
            }
        };
        EvaluationContext context = new StandardEvaluationContext(user);
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("#root.name").getValue(context).equals("abc"));
    }

    //#this永远指向当前对象，其通常用于集合类型，表示集合中的一个元素
    @Test
    public void test14_2() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> intList = (List<Integer>) parser.parseExpression("{1,2,3,4,5,6}").getValue();
        EvaluationContext context = new StandardEvaluationContext(intList);
        //从List中选出为奇数的元素作为一个List进行返回，1、3、5。
        List<Integer> oddList = (List<Integer>) parser.parseExpression("#root.?[#this%2==1]").getValue(context);
        for (Integer odd : oddList) {
            Assert.assertTrue(odd % 2 == 1);
        }
    }

    static class MathUtils {
        public static int plusTen(int i) {
            return i + 10;
        }
    }

    //注册方法
    @Test
    public void test15() throws NoSuchMethodException, SecurityException {
        ExpressionParser parser = new SpelExpressionParser();
        //1、获取需要设置的java.lang.reflect.Method，需是static类型
        Method plusTen = MathUtils.class.getDeclaredMethod("plusTen", int.class);
        StandardEvaluationContext context = new StandardEvaluationContext();
        //2、注册方法到StandardEvaluationContext，第一个参数对应表达式中需要使用的方法名
        context.registerFunction("plusTen", plusTen);
        //3、表达式中使用注册的方法
        Expression expression = parser.parseExpression("#plusTen(10)");
        //4、传递包含对应方法注册的StandardEvaluationContext给Expression以获取对应的值
        int result = expression.getValue(context, int.class);
        Assert.assertTrue(result == 20);
    }

    //new对象
    @Test
    public void test16() {
        ExpressionParser parser = new SpelExpressionParser();
        String currentTime = (String) parser.parseExpression("new java.util.Date().toLocaleString()").getValue();
        System.out.println(currentTime);
    }

    //赋值
    @Test
    public void test17_1() {
        ExpressionParser parser = new SpelExpressionParser();
        Date d = new java.util.Date();
        //设日期为1号
        parser.parseExpression("date").setValue(d, 1);
        int date = (Integer) parser.parseExpression("date").getValue(d);
        Assert.assertTrue(date == 1);
    }

    //List赋值
    @Test
    public void test17_2() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = new ArrayList<>(1);
        list.add(0);//添加一个元素0
        EvaluationContext context = new StandardEvaluationContext();
        //添加变量以方便表达式访问
        context.setVariable("list", list);
        //设置第一个元素的值为1
        parser.parseExpression("#list[0]").setValue(context, 1);
        int first = (Integer) parser.parseExpression("#list[0]").getValue(context);
        Assert.assertTrue(first == 1);
    }

    //Map赋值
    @Test
    public void test17_3() {
        ExpressionParser parser = new SpelExpressionParser();
        Map<String, Integer> map = new HashMap<>();
        EvaluationContext context = new StandardEvaluationContext();
        //添加变量以方便表达式访问
        context.setVariable("map", map);
        //设置第一个元素的值为1
        parser.parseExpression("#map['key1']").setValue(context, 1);
        int first = (Integer) parser.parseExpression("#map['key1']").getValue(context);
        Assert.assertTrue(first == 1);
    }

    //访问静态方法或属性
    @Test
    public void test18() {
        ExpressionParser parser = new SpelExpressionParser();
        //进行访问的时候需要使用“T(type)”的形式来表示对应的静态类，其中type表示对应类的全限定名，即包括对应的包名
        Assert.assertTrue(parser.parseExpression("T(java.util.Calendar).DATE").getValue(int.class) == 5);
    }

    //使用字符代替符号
    @Test
    public void test19() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("1 lt 2").getValue(boolean.class));//1<2
        Assert.assertTrue(parser.parseExpression("1 le 2").getValue(boolean.class));//1<=2
        Assert.assertTrue(parser.parseExpression("2 gt 1").getValue(boolean.class));//2>1
        Assert.assertTrue(parser.parseExpression("2 ge 1").getValue(boolean.class));//2>=1
        Assert.assertTrue(parser.parseExpression("1 ne 2").getValue(boolean.class));//1!=2
        Assert.assertTrue(parser.parseExpression("not false").getValue(boolean.class));//!false
    }

    //使用正则表达式
    @Test
    public void test20() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("123 matches '\\d{3}'").getValue(Boolean.class));//正则匹配三位数字
    }

    //使用instanceof
    @Test
    public void test21() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("'123' instanceof T(String)").getValue(Boolean.class));//检测字符串是否是String的实例。
    }

    //三目运算
    @Test
    public void test22() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("1>2 ? 1 : 2").getValue(int.class) == 2);//1跟2之间的较大者为2
        Assert.assertTrue(parser.parseExpression("1<2 ? 2 : 1").getValue(int.class) == 2);//1跟2之间的较大者为2
    }

    //表达式模板
    @Test
    public void test23() {
        //the year is 2014
        String expressionStr = "the year is #{T(java.util.Calendar).getInstance().get(T(java.util.Calendar).YEAR)}";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expressionStr, new TemplateParserContext());
        Assert.assertTrue(expression.getValue().equals("the year is 2014"));
    }

    //设置默认值
    @Test
    public void test24() {
        ExpressionParser parser = new SpelExpressionParser();
        Assert.assertTrue(parser.parseExpression("#abc?:123").getValue().equals(123));//变量abc不存在
        Assert.assertTrue(parser.parseExpression("1?:123").getValue().equals(1));//数字1不为null
    }

    //安全导航
    @Test
    public void test25() {
        ExpressionParser parser = new SpelExpressionParser();
        /**
         * 经常会使用类似于“a.b.c”这样的用法，表示a的b属性的c属性，但如果a为null或者a的b属性为null时都会出现空指针。
         * 为了避免此种情况发生，我们可以在SpEl表达式中使用安全导航，这样当a为null或a的b属性为null时将直接返回null，而不抛出空指针异常。
         * SpEl表达式中安全导航的语法是将点“.”替换为“?.”，即不使用“a.b.c”，而是使用“a?.b?.c”。
         */
        Assert.assertNull(parser.parseExpression("null?.abc").getValue());
        Assert.assertNull(parser.parseExpression("T(System)?.getProperty('abc')?.length()").getValue());
    }

    //获取bean对象
    @Test
    public void test26() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        /**
         * 如果要在SpEL表达式中访问bean对象，我们需要通过StandardEvaluationContext来设置对应的BeanResolver，
         * 同时我们需要在SpEL表达式中以“@beanName”的方式来访问对应的bean对象。
         */
        context.setBeanResolver(new MyBeanResolver());
        //访问bean名称为hello的bean对象的getKey()方法。
        Object obj = parser.parseExpression("@hello.key").getValue(context);
        System.out.println(obj);
    }

    /**
     * BeanResolver是一个接口，其只定义了一个方法resolve，用以通过beanName解析为对应的bean对象并返回
     */
    private static class MyBeanResolver implements BeanResolver {

        private static ApplicationContext appContext = new ClassPathXmlApplicationContext("spel/application-context.xml");

        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            return appContext.getBean(beanName);
        }

    }

    @Test
    public void test27() {
        User user = new User();
        /**
         * 在构建SpelExpressionParser时我们可以给其传递一个SpelParserConfiguration对象以对SpelExpressionParser进行配置。
         * 其可以用于指定在遇到List或Array为null时是否自动new一个对应的实例，对应SpelParserConfiguration的第一个构造参数；
         * 也可以指定在List或Array中对应索引超出了当前索引的最大值时是否自动进行扩充，对应SpelParserConfiguration的第二个构造参数。
         */
        SpelParserConfiguration parserConfig = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(parserConfig);
        //第一次为null
        Assert.assertNull(parser.parseExpression("interests").getValue(user));
        //自动new一个List的实例，对应ArrayList,并自动new String()添加6次。
        Assert.assertTrue(parser.parseExpression("interests[5]").getValue(user).equals(""));
        //size为6
        Assert.assertTrue(parser.parseExpression("interests.size()").getValue(user).equals(6));
    }

    class User {
        public List<String> interests;
    }


}
