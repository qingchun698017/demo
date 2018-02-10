package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wqc on 2017/3/2.
 */
public class LeanReflection {

    public void testReflection() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Method[] methods = MyObject.class.getMethods();
        Class myObjectClass = MyObject.class;
        String className = myObjectClass.getName();
        String classSimpleName = myObjectClass.getSimpleName();
        Class superClass = myObjectClass.getSuperclass();
        Package myObjectClasspackage = myObjectClass.getPackage();
        int midefiers = myObjectClass.getModifiers();//修饰词
        Class[] interfaces = myObjectClass.getInterfaces();


        Annotation[] annotations = myObjectClass.getAnnotations();//注解

        //构造器的参数
        Constructor[] constructors = myObjectClass.getConstructors();
        Constructor constructor = myObjectClass.getConstructor(new Class[]{String.class});
        Class[] parameterTypes = constructors[0].getParameterTypes();
        MyObject myObject = (MyObject)constructor.newInstance("leanClass");

        //成员变量
        Field[] fields = myObjectClass.getFields();
        Field field = myObjectClass.getField("name");
        String filedName = field.getName();
        Object fileType = field.getType();

        field.set(myObject,"leanField");
        Object fieldValue = field.get(myObject);



    }

}
