package com.kyw.lolgames;

import java.util.Scanner;

/**
 * @author : kangyw
 * @date : 下午 15:16 2019/11/20
 */
public class LeagueOfLegends {

    public static void main(String[] args) {
        //初始化亚索
        System.out.println("---欢迎来到英雄联盟---");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请选择你的英雄：1.疾风剑豪-亚索，2.探险家-伊泽瑞尔，3.迅捷斥候-提莫，4.德玛西亚皇子-嘉文四世");
            String line = sc.nextLine();
            boolean isRight = "1".equals(line) || "2".equals(line) || "3".equals(line) || "4".equals(line);
            HerosEntity myHero = null;
            if(isRight) {
                myHero = HeroFactory.getHeroInstance(line);
            }else{
                System.out.println("输入的数字不正确，GAMEOVER！！！！！！！");
                break;

            }

            System.out.println("请选择你的对手：1.疾风剑豪-亚索，2.探险家-伊泽瑞尔，3.迅捷斥候-提莫，4.德玛西亚皇子-嘉文四世,5.无极剑圣-易大师，6.雪人骑士-努努,7.诺克萨斯之手-德莱厄斯,8.流浪法师-瑞兹");
            boolean isRight_2 = "1".equals(line) || "2".equals(line) || "3".equals(line) || "4".equals(line) ||
                    "5".equals(line) || "6".equals(line) || "7".equals(line) || "8".equals(line);
            String line2 = sc.nextLine();
            HerosEntity enemyHero = null;
            if(isRight_2) {
                enemyHero = HeroFactory.getHeroInstance(line2);
            }else{
                System.out.println("输入的数字不正确，GAMEOVER！！！！！！！");
                break;
            }

            gameBegin(myHero, enemyHero);
            System.out.println("是否继续：1.继续，2.退出");
            String line3 = sc.nextLine();
            if("2".equals(line3)){
                break;
            }
        }

    }

    /**
     * 对战细节描述
     * @param h1
     * @param h2
     */
    public static void gameBegin(HerosEntity h1,HerosEntity h2){
        System.out.println("初始数值，"+h1.getName()+"HP:"+h1.getHp()+",MP:"+h1.getMp()+",AD:"+h1.getAd());
        System.out.println("初始数值，"+h2.getName()+"HP:"+h2.getHp()+",MP:"+h2.getMp()+",AD:"+h2.getAd());
        System.out.println("对局开始，"+h1.getName()+"先手攻击！");
        while (true) {
            float ad1 = critRateDou(h1.getAd(),h1.getCritRate());
            System.out.println("====" + h1.getName() + ":攻击了" + h2.getName() + ",造成了'" + ad1 + "'点伤害");
            h2.beAttacked(ad1);
            h1.releaseSkills(h2);
            System.out.println("====攻击结束，剩余血量：" + h1.getName() + "为" + h1.getHp() + "," + h2.getName() + "为" + h2.getHp());
            System.out.println("=================================================");

            if(h1.getHp()<0){
                System.out.println(h2.getName()+"击杀了"+h1.getName());
                System.out.println("恕我直言你就是个辣鸡~_~╮︶﹏︶╭！！！！");
                break;
            }else if(h2.getHp()<0){
                System.out.println(h1.getName()+"击杀了"+h2.getName());
                System.out.println("哇，你好棒哦=( °∀° )！！！！");
                break;
            }

            float ad2 = critRateDou(h2.getAd(), h2.getCritRate());
            System.out.println("====敌方攻击," + h2.getName() + ":攻击了" + h1.getName() + ",造成了'" + ad2 + "'点伤害");
            h1.beAttacked(ad2);
            h2.releaseSkills(h1);
            System.out.println("====攻击结束，剩余血量：" + h1.getName() + "为" + h1.getHp() + "," + h2.getName() + "为" + h2.getHp());
            System.out.println("======================================================");

            if(h2.getHp()<0){
                System.out.println(h1.getName()+"击杀了"+h2.getName());
                System.out.println("哇，你好棒哦=( °∀° )！！！！");

                break;
            }else if(h1.getHp()<0){
                System.out.println(h2.getName()+"击杀了"+h1.getName());
                System.out.println("恕我直言你就是个辣鸡~_~╮︶﹏︶╭！！！！");
                break;
            }
        }
    }


    /**
     * 暴击翻倍
     */
    public static float critRateDou(float ad,double rate){
        double a = 100*Math.random();
        if(a>rate){
            return ad;
        }else{
            return ad*2;
        }

    }
}
