package com.xing.common.util;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        System.out.println(list);
        System.out.println(JsonUtils.toJson(list));
    }
}
