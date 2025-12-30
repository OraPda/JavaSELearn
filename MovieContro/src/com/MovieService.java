package com;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {

//    4. 准备一个集合容器，存储电影信息
    private static List<MoviePojo> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
/*
        3.准备操作界面：GUI/cmd命令行
        JFrame jf = new JFrame("电影管理系统");
        jf.setLayout(null);
        jf.setSize(500, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
*/
        while (true) {
            System.out.println("欢迎来到电影管理系统");
            System.out.println("1. 添加电影");
            System.out.println("2. 删除电影");
            System.out.println("3. 查询电影");
            System.out.println("4. 封杀某个明星");
            System.out.println("5. 显示所有电影");
            System.out.println("6. 退出");
            System.out.println("请输入您的选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
//                    上架(独立功能独立成方法)
                    addMovie();
                    break;
                case 2:
//                    下架
                    deleteMovie();
                    break;
                case 3:
//                    查询
                    queryMovie();
                    break;
                case 4:
//                    封杀
                    killStar();
                    break;
                case 5:
//                    展示所有电影
                    showAllMovie();
                    break;
                case 6:
                    System.out.println("感谢使用");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    /*
    * 删除电影
     */
    private void deleteMovie() {
        System.out.println("============下架电影===========");
        System.out.println("请输入电影名称：");
        String movieName = sc.next();
        for (int i = 0; i < list.size(); i++) {
            MoviePojo movie = list.get(i);
            if (movie.getMovieName().equals(movieName)) {
                list.remove(movie);
                System.out.println("下架成功");
                return;
            }
        }
    }

    /*
    * 展示所有电影
     */
    private void showAllMovie() {
        System.out.println("============所有电影===========");
        for (MoviePojo movie : list) {
            System.out.println(movie.getMovieName() + "" + movie.getMovieRating() + ""  + movie.getActors());
        }
    }
    /*
    * 封杀明星
     */
    private void killStar() {
        System.out.println("============封杀明星===========");
        System.out.println("请输入明星名称：");
        String starName = sc.next();
        for (int i = 0; i < list.size(); i++) {
            MoviePojo movie = list.get(i);
            if (movie.getActors().contains(starName)) {
                movie.setMovieRating("未知");
                list.remove(movie);
                i--;
            }
        }
    }



    /*
    * 根据电影名称查询电影
     */
    private void queryMovie() {
        System.out.println("============查询电影===========");
        System.out.println("请输入电影名称：");
        String movieName = sc.next();
//        根据电影名称查询电影对象返回，展示这个对象数据
        MoviePojo movie = queryMovieByName(movieName);
        if (movie != null) {
            System.out.println(movie.getMovieName() + "" + movie.getMovieRating() + "" + movie.getScore() + "" + movie.getActors());
        }
        else {
            System.out.println("没有此电影");
        }
    }

    /*
    * 查询电影对象并返回对象方法
     */
    private MoviePojo queryMovieByName(String movieName) {
        for (MoviePojo movie : list) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    /*
    * 上架电影
     */
    private void addMovie() {
        System.out.println("============上架电影===========");
//        分析：每点击一次上架电影，其实就是新增一部电影。每部电影是一个电影对象封装数据的
//        1. 创建电影对象
        MoviePojo movie = new MoviePojo();
//        2.给电影对象注入数据
        System.out.println("请输入电影名称：");
        movie.setMovieName(sc.next());
        System.out.println("请输入主演：");
        movie.setActors(sc.next());
        System.out.println("请输入电影评分：");
        movie.setMovieRating(sc.next());
        System.out.println("请输入电影价格：");
        movie.setPrice(sc.nextDouble());
//        3. 将电影对象添加到集合中
        list.add(movie);
        System.out.println(list);
        System.out.println("上架成功");
    }
}

