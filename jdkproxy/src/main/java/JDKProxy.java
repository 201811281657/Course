import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class<?> [] interfaces = {UserDao.class};
        List<UserDao> userDaoList = new ArrayList<UserDao>();
        for(UserDao userDao: userDaoList ){
            int addresult = userDao.add(1, 5);
            System.out.println(addresult);
        }
        UserDaoImpl userDaoimpl = new UserDaoImpl();
        //返回代理对象,需要强转成UserDao 这句话类似UserDao userDao = new UserDaoImpl(); 接口等于实现类的代理对象 类加载器
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoimpl));
        userDao.update("1");
//        int result = userDaoimpl.add(2, 3);
//        System.out.println(result);
        
    }
}

//创建代理对象
class UserDaoProxy implements InvocationHandler{
    //使用有参构造器将目标对象传进来,
//    public UserDaoProxy(UserDaoImpl userDao);
    //来个通用的Object目标对象
    private Object object;
    public UserDaoProxy(Object object){
        this.object = object;
    };

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行...."+"执行的方法名:"+method.getName()+":传递的参数:"+ Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(object, args);
        //方法之后
        System.out.println("方法之后执行.."+object);
        return res;
    }
    //增强逻辑

}
