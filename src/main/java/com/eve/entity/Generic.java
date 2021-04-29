package com.eve.entity;

import lombok.Data;

/**
 * @Author hanneys
 * @Date 2021/1/19 10:03
 * @Version 1.0
 */
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
@Data
public class Generic<T> {

    // key这个成员变量的类型为T,T的类型由外部指定
    private T key;

}
