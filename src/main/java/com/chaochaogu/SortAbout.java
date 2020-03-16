package com.chaochaogu;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @author chaochao Gu
 * @date 2020/3/16
 */
public class SortAbout {
    static class Item {
        int id;
        String name;

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Item> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            if (i < 5) {
                item.id = i;
            }
            item.name = i + "name";
            list.add(item);
        }
        list.sort(Comparator.comparing(item -> item.id));
        System.out.println(list);
        List<Integer> list1 = Lists.newArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = Lists.newArrayList();
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list1.addAll(list2);
        System.out.println(list1);
    }
}
