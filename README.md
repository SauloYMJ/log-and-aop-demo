# log-and-aop-demo
#### 切入点表达式的格式： 
                   访问修饰符        返回值类型（必填）      包和类        方法（必填）  方法参数           异常
    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)  throws-pattern?) 

#### 通配符的使用:
  *：匹配所有字符  
  ***
  ..：一般用于匹配多个包，多个参数  
  ***
  +：表示类及其子类  
  ***
  运算符有：&&、||、!  

除了返回类型模式（_上面代码片断中的ret-type-pattern_），名字模式和参数模式以外， 所有的部分都是可选的。返回类型模式决定了方法的返回类型必须依次匹配一个连接点。  
    使用的最频繁的返回类型模式是(*)，它代表了匹配任意的返回类型。 一个全限定的类型名将只会匹配返回给定类型的方法。名字模式匹配的是方法名。可以使用*通配符作为所有或者部分命名模式。 
    参数模式稍微有点复杂：()匹配了一个不接受任何参数的方法， 而(..)匹配了一个接受任意数量参数的方法（_零或者更多_）。 
    模式(*)匹配了一个接受一个任何类型的参数的方法。 模式(*,String)匹配了一个接受两个参数的方法，第一个可以是任意类型， 第二个则必须是String类型。
    更多的信息请参阅[AspectJ编程指南](http://www.eclipse.org/aspectj/doc/released/progguide/index.html)中 语言语义的部分。

#### 通用切入点表达式的例子
###### 任意公共方法的执行：
    execution（public * *（..））
###### 任何一个名字以“set”开始的方法的执行：
    execution（* set*（..））
###### AccountService接口定义的任意方法的执行：
    execution（* com.xyz.service.AccountService.*（..））
###### 在service包中定义的任意方法的执行：
    execution（* com.xyz.service.*.*（..））
###### 在service包或其子包中定义的任意方法的执行：
    execution（* com.xyz.service..*.*（..））
###### 在service包中的任意连接点（在Spring AOP中只是方法执行）：
    within（com.xyz.service.*）
###### 在service包或其子包中的任意连接点（在Spring AOP中只是方法执行）：
    within（com.xyz.service..*）
###### 实现了AccountService接口的代理对象的任意连接点 （在Spring AOP中只是方法执行）：
    this（com.xyz.service.AccountService）
###### 实现AccountService接口的目标对象的任意连接点 （在Spring AOP中只是方法执行）：
    target（com.xyz.service.AccountService）
