package com.eagles.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XmlTest {

    /**
     * 1、创建流对象，通过流对象解析xml文件(dom4j提供的流对象),返回一个文本对象document
     * 2、通过文本对象获取根标签 students
     * 3、获取跟标签中的自标签
     * 4、遍历所有的子标签，取出数据
     * @param args
     */
    public static void main(String[] args) throws Exception {

        //创建流对象
        SAXReader saxReader = new SAXReader();

        //获取xml的文本对象 该文本对象可以管理xml中所有的标签
        Document document = saxReader.read("src/xml/students.xml");

        //获取根标签
        Element rootElement = document.getRootElement();
        //获取所有子标签
        List<Element> elements = rootElement.elements();

        //遍历子标签
        for (Element element : elements) {
//            Element nameElement = element.element("name");
//            Element ageElement = element.element("age");
//            Element addressElement = element.element("address");
            String name = element.elementText("name");
            String age = element.elementText("age");
            String address = element.elementText("address");
            System.out.println(name);
            System.out.println(age);
            System.out.println(address);
            System.out.println("--------------------------------------------");

        }


    }

}
