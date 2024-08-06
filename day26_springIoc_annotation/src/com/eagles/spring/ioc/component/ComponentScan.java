package com.eagles.spring.ioc.component;

import com.eagles.spring.ioc.annotation.*;
import com.eagles.spring.ioc.factory.BeanFactory;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComponentScan {

    private static final List<String> classList = new ArrayList<>();

    public static void componentScan(String basePackage){
        String path = ClassLoader.getSystemResource("").getPath() + basePackage.replace(".","/");

        File file = new File(path);

        isFile(file);

        Map<String, Object> map = BeanFactory.getMap();

        for (String className : classList) {
            try {
                Class aClass = Class.forName(className);

                // 通过反射获取类上的注解
                Repository repository = (Repository)aClass.getAnnotation(Repository.class);
                Component component = (Component)aClass.getAnnotation(Component.class);
                Service service = (Service)aClass.getAnnotation(Service.class);
                Controller controller = (Controller)aClass.getAnnotation(Controller.class);

                Object instance = null;
                if (controller != null || repository != null || service != null || component != null){
                    // 通过反射创建实例
                    instance = aClass.newInstance();
                }

                if(controller != null){

                    map.put(!controller.value().equals("") ? controller.value() : Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase()+aClass.getSimpleName().substring(1),instance);

                }

                if(repository != null){

                    map.put(!repository.value().equals("") ? repository.value() : Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase()+aClass.getSimpleName().substring(1),instance);

                }
                if(component != null){

                    map.put(!component.value().equals("") ? component.value() : Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase()+aClass.getSimpleName().substring(1),instance);

                }
                if(service != null){

                    map.put(!service.value().equals("") ? service.value() : Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase()+aClass.getSimpleName().substring(1),instance);

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        for (String className : classList) {
            try {
                Class aClass = Class.forName(className);

                // 通过反射获取类上的注解
                Repository repository = (Repository)aClass.getAnnotation(Repository.class);
                Component component = (Component)aClass.getAnnotation(Component.class);
                Service service = (Service)aClass.getAnnotation(Service.class);
                Controller controller = (Controller)aClass.getAnnotation(Controller.class);

                if (controller != null || repository != null || service != null || component != null){

                    Field[] declaredFields = aClass.getDeclaredFields();

                    for (Field declaredField : declaredFields) {

                        Autowired autowired = declaredField.getAnnotation(Autowired.class);

                        if(autowired != null){

                            String value = null;
                            String beanId;

                            if (component != null){
                                value = component.value();
                            }
                            if (controller != null){
                                value = controller.value();
                            }
                            if (service != null){
                                value = service.value();
                            }
                            if (repository != null){
                                value = repository.value();
                            }

                            if (value != null && !value.equals("")){
                                beanId = value;
                            }else {
                                String simpleName = aClass.getSimpleName();
                                beanId = simpleName.split("")[0].toLowerCase()+simpleName.substring(1);
                            }

                            declaredField.setAccessible(true);

                            BeanFactory.getMap().forEach((k,v)->{
                                Class[] interfaces = v.getClass().getInterfaces();

                                for (Class anInterface : interfaces) {

                                    if (declaredField.getType() == anInterface){

                                        try {
                                            /*
                                                set参数:
                                                    1. 该属性对应类的实例
                                                    2. 需要注入的值
                                             */
                                            declaredField.set(BeanFactory.getBean(beanId),v);
                                        } catch (IllegalAccessException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void isFile(File file){

        File[] files = file.listFiles(pathname -> {
            if (pathname.isDirectory()) {

                isFile(pathname);

            }
            return pathname.getName().endsWith(".class");
        });

        for (File fileName : files) {
            String className = fileName.getPath().replace(".class", "").replace("\\", ".");
            classList.add(className.substring(className.indexOf("com")));

        }

    }
}
