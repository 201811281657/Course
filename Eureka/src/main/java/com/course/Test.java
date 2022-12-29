package com.course;

import java.util.ArrayList;
import java.util.List;

public class Test<T>{
//    private Integer age;
//    private Boolean sex;
//    private T t;

//    public T getT() {
//        return t;
//    }
//
//    public void setT(T t) {
//        this.t = t;
//    }


    public <T> T getListFirst(List<T> data){
        if(data == null||data.size()==0){
            return null;
        }
        return data.get(0);
    }

    public static void main(String[] args) {
        Test<String> ts = new Test<>();
//        Test<Integer> it = new Test<>();
        List<String> ls = new ArrayList<String>();
        ls.add("aaa");
        ls.add("bbb");
        String str = ts.getListFirst(ls);
        System.out.println(str);
        List<Integer> nums = new ArrayList<>();
        nums.add(111);
        nums.add(222);
        Integer num = ts.getListFirst(nums);//报错,引文定义的List<Integer>不是String类型
        System.out.println(num);


    }


}