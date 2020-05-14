/**
 * @author xiaoy
 * @date 2020/05/12
 */
package versions.spring;

/*
Spring
1、为什么要用Spring或者说Spring是如何简化Java开发的
1、基于POJO的轻量级和最小侵入性编程；

2、通过依赖注入和面向接口实现松耦合；

3、基于切面和惯例进行声明式编程；

4、通过切面和模板减少样板式代码。
*/
/*
Spring常用注解
@Component

是所有收Spring管理组件的通用形式，@Component注解可以放在类的头上，不推荐使用。

@Controller

对应表现层的Bean，也就是Action

@Service

对应的是业务层Bean

@Repository

对应数据访问层Bean

@Resource和@Autowired

都是做bean的注入时使用

@RequestMapping

是一个用来处理请求地址映射的注解，可用于类或方法上
*/

// Spring 中用到的设计模式
// 工厂模式：在各种BeanFactory以及ApplicationContext创建中用到了
//
// 代理模式：在AOP实现中用到了JDK的动态代理
//
// 策略模式：加载资源文件的方式，使用了不同的方法，比如：ClassPathResource，FileSystemResource，
//
// ServletContextResource，UrlResource
//
// 单例模式：创建Bean的时候
//
// 模板模式：JdbcTemplate
