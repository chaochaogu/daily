package com.chaochaogu.daily;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaochao Gu
 * @date 2019/12/4
 */
public class ListAbout {
    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("1", "2", "3", "4");

        // wrong, cause ConcurrentModificationException
        list.forEach((e) -> {
            if (e.contains("2")) {
                list.remove(e);
            }
        });
        for (String s : list) {
            if (s.contains("2")) {
                list.remove(s);
            }
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.contains("2")) {
                list.remove(next);
            }
        }

        // right
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("2")) {
                list.remove(i);
                i--;
            }
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("2")) {
                // Iterator.remove()方法会在删除当前迭代对象同时维护索引的一致
                it.remove();
            }
        }
        list.removeIf((e) -> e.contains("2"));
        // list去重
        list.stream().distinct().collect(Collectors.toList());
        list.forEach(System.out::println);

        // list取前多少个
        List<Integer> list1 = Lists.newArrayList();
        for (int i = 0; i < 15; i++) {
            list1.add(i);
        }
        System.out.println(Iterables.limit(list1, 20));
        // 转换成list
        list1 = Lists.newArrayList(Iterables.limit(list1, 10));
        // list分页
        Iterable<List<Integer>> partition = Iterables.partition(list1, 3);
    }
}
