package com.study.work2;

import com.study.work2.annotation.Controller;
import com.study.work2.annotation.Repository;
import com.study.work2.annotation.Service;
import com.study.work2.annotation.Autowired;
import com.study.work2.factory.BeanFactory;
import com.study.work2.servlet.MyServlet;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Component {

    private static final List<String> classNameList = new ArrayList<>();

    public static void getComponent(String path){

        path = path.replace(".", "/");

        path = ClassLoader.getSystemResource("").getPath() + path;

        File file = new File(path);

        addFile(file);

        for (String className : classNameList) {
            try {
                Class aClass = Class.forName(className);
                Controller controller = (Controller) aClass.getAnnotation(Controller.class);
                Repository repository = (Repository) aClass.getAnnotation(Repository.class);
                Service service = (Service) aClass.getAnnotation(Service.class);

                Object instance = null;
                if (controller != null || repository != null || service != null){
                    instance = aClass.newInstance();
                }

                if(controller != null && !controller.value().equals("")){
                    BeanFactory.getMap().put(controller.value(),instance);
                }else if(repository != null && !repository.value().equals("")){
                    BeanFactory.getMap().put(repository.value(),instance);
                }else if(service != null && !service.value().equals("")){
                    BeanFactory.getMap().put(service.value(),instance);
                } else if (controller != null || repository != null || service != null) {
                    BeanFactory.getMap().put(Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase() + aClass.getSimpleName().substring(1),instance);
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        for (String className : classNameList) {
            try {
                Class aClass = Class.forName(className);

                Controller controller = (Controller) aClass.getAnnotation(Controller.class);
                Repository repository = (Repository) aClass.getAnnotation(Repository.class);
                Service service = (Service) aClass.getAnnotation(Service.class);

                Field[] fields = aClass.getDeclaredFields();

                for (Field field : fields) {

                    field.setAccessible(true);
                    Autowired annotation = field.getAnnotation(Autowired.class);

                    if(annotation != null){
                        Map<String, Object> map = BeanFactory.getMap();

                        Set<Map.Entry<String, Object>> entries = map.entrySet();

                        for (Map.Entry<String, Object> entry : entries) {

                            Class[] interfaces = entry.getValue().getClass().getInterfaces();

                            for (Class anInterface : interfaces) {
                                if(anInterface == field.getType()){
                                    if(controller != null && !controller.value().equals("")){
                                        field.set(BeanFactory.getBean(controller.value()),entry.getValue());
                                    }else if(repository != null && !repository.value().equals("")){
                                        field.set(BeanFactory.getBean(repository.value()),entry.getValue());
                                    }else if(service != null && !service.value().equals("")){
                                        field.set(BeanFactory.getBean(service.value()),entry.getValue());
                                    } else if (controller != null || repository != null || service != null) {
                                        field.set(BeanFactory.getBean(Character.toString(aClass.getSimpleName().charAt(0)).toLowerCase() + aClass.getSimpleName().substring(1)),entry.getValue());
                                    }
                                }
                            }

                        }
                    }

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void addFile(File file){

        File[] files = file.listFiles(new FileFilter() {

            /*
            * 获取以.class结尾的文件
            * */
            @Override
            public boolean accept(File pathname) {

                if(pathname.isDirectory()){
                    addFile(pathname);
                }

                return pathname.getName().endsWith(".class");
            }
        });

        for (File fileName : files) {

            String path = fileName.getPath();

            path =  path.replace("\\",".");

            path =  path.replace(".class","");

            String SysPath = ClassLoader.getSystemResource("").getPath().replace("/",".").substring(1);

            String className = path.replace(SysPath,"");

            classNameList.add(className);

        }

    }

}
