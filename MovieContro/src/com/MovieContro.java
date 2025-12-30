package com;

public class MovieContro {
    public static void main(String[] args) {
//        1.创建电影对象，定义电影类
//        2.创建一个电影操作对象，专门负责对象电影数据进行业务处理（上架，下假，封杀，查询）
        MovieService movieService = new MovieService();
        movieService.start();

    }
}
