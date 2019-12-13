package com.chaochaogu;

/**
 * Object的clone方法默认为浅拷贝（shallow copy）
 *
 * @author chaochao Gu
 * @date 2019/12/13
 */
public class CloneAbout {
    public static void main(String[] args) {
        Person person = new Person();
        person.objects = new Object[]{1, 2, 3};
        try {
            Person clone = (Person) person.clone();
            System.out.println("person == clone :" + (person == clone));
            System.out.println("person.objects == clone.objects :" + (person.objects == clone.objects));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    static class Person implements Cloneable {
        Object[] objects;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
            // 可加上深拷贝
        }
    }
}
