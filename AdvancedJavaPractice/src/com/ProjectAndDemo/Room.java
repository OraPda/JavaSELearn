package com.ProjectAndDemo;




import java.util.*;

public class Room {
//    1.准备54张牌，给房间使用，定义一个集合容器装54张牌
    private List<Park> parkList = new ArrayList<>();
    private static int index =0;  //庄家索引

//    2.放54张牌进去
    {
//    3.准备点数
        String[] colors = {"♥","♠","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
//        4.组合点数和花色成为牌对象
        for (String number : numbers) {
            for (String color : colors) {
//                5.创建牌对象
                Park park = new Park(number,color);
//                加入集合中
                parkList.add(park);
            }
        }
        Collections.addAll(parkList,new Park("大王","🃏"),new Park("小王","🃏"));
//        System.out.println("洗牌前"+parkList);
    }
    public void start() {
//        7.洗牌,随机打乱顺序
        Collections.shuffle(parkList);
//        System.out.println(parkList);
//        8.发牌  定义三个玩家： 玩家1，玩家2，玩家3
        Map<String ,List<Park>>  players = new HashMap<>();
        List<Park> lhc = new ArrayList<>();
        players.put("令狐冲",lhc);
        List<Park> lhq = new ArrayList<>();
        players.put("令狐齐",lhq);
        List<Park> lhx = new ArrayList<>();
        players.put("令狐小",lhx);
        for (int i = 0; i < parkList.size()-3; i++) {
            Park park = parkList.get(i);
            if (i % 3 == 0) {
                lhc.add(park);
            } else if (i % 3 == 1) {
                lhq.add(park);
            } else {
                lhx.add(park);
            }
        }
//        9.对每个人手中的牌排序.从小到大排序顺序为，3，4，5，6，7，8，9，10，J，Q,K,A，2，小王，大王
        
        // 定义玩家列表，保持顺序
        List<String> playerNames = new ArrayList<>(players.keySet());
        
        // 对每个玩家的手牌进行排序
        for (Map.Entry<String, List<Park>> entry : players.entrySet()) {
            List<Park> parkList = entry.getValue();
            sortCards(parkList);
        }
        
        // 打印每个人的手牌
        for (Map.Entry<String, List<Park>> entry : players.entrySet()) {
            System.out.println(entry.getKey() + "的手牌：");
            for (Park park : entry.getValue()) {
                System.out.print(park + " ");
            }
            System.out.println();
        }
        
        // 打印剩余的3张牌
        List<Park> lastThreeCards = parkList.subList(parkList.size() - 3, parkList.size());
        System.out.println("剩余的3张牌：" + lastThreeCards);

//         正式开始游戏。
        System.out.println("=============开始游戏===============");
//        1.抢地主
//        假设庄家一开始是第0号位，并且，本局游戏内谁赢了下一局中谁是庄家，循环一次，从庄家开始叫分。一分二分三分，抢到地主的玩家是本局游戏的庄家。
//        上一名玩家在抢地主时，假如叫1分，下一名玩家就不可再叫1分，必须叫0分或者2分或3分。如果无人叫3分，那么本剧中叫分最高的玩家成为地主。
        
        // 从庄家开始叫分
        String[] playerArray = playerNames.toArray(new String[0]);
        Map<String, Integer> bids = new HashMap<>();
        int maxBid = 0;
        String landlord = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("庄家是：" + playerArray[index]);
        
        // 抢地主循环，最多3轮
        for (int round = 0; round < 3; round++) {
            for (int i = 0; i < playerArray.length; i++) {
                // 计算当前玩家的索引（从庄家开始）
                int currentPlayerIndex = (index + i) % playerArray.length;
                String currentPlayer = playerArray[currentPlayerIndex];
                
                // 如果已经有玩家叫3分，直接结束
                if (maxBid == 3) {
                    break;
                }
                
                // 如果玩家已经叫过0分（不抢），跳过
                if (bids.containsKey(currentPlayer) && bids.get(currentPlayer) == 0) {
                    continue;
                }
                
                System.out.println(currentPlayer + "请开始叫分（0=不抢，1=1分，2=2分，3=3分）：");
                int bid = scanner.nextInt();
                
                // 验证叫分合法性
                while (bid < 0 || bid > 3 || (bid > 0 && bid <= maxBid)) {
                    if (bid > 0 && bid <= maxBid) {
                        System.out.println("叫分必须高于当前最高分 " + maxBid + " 分，请重新输入：");
                    } else {
                        System.out.println("叫分无效，请输入0-3之间的数字：");
                    }
                    bid = scanner.nextInt();
                }
                
                bids.put(currentPlayer, bid);
                
                if (bid > maxBid) {
                    maxBid = bid;
                    landlord = currentPlayer;
                    System.out.println(currentPlayer + "叫了 " + bid + " 分，当前最高分！");
                } else if (bid == 0) {
                    System.out.println(currentPlayer + "不抢地主");
                }
            }
            
            // 如果所有人都不抢地主，结束
            if (maxBid == 0) {
                System.out.println("无人抢地主，重新发牌！");
                return;
            }
            
            // 如果已经有玩家叫3分，直接结束
            if (maxBid == 3) {
                break;
            }
        }
        
        // 确定地主
        if (landlord != null) {
            System.out.println("\n=============地主确定===============");
            System.out.println(landlord + " 成为地主！");
            System.out.println("地主获得剩余的3张牌：" + lastThreeCards);
            
            // 地主获得剩余的3张牌
            List<Park> landlordCards = players.get(landlord);
            landlordCards.addAll(lastThreeCards);
            
            // 地主重新排序手牌
            sortCards(landlordCards);
            
            // 打印地主最终的手牌
            System.out.println("\n地主 " + landlord + " 的最终手牌：");
            for (Park park : landlordCards) {
                System.out.print(park + " ");
            }
            System.out.println();
            
            // 打印其他玩家的手牌
            for (Map.Entry<String, List<Park>> entry : players.entrySet()) {
                if (!entry.getKey().equals(landlord)) {
                    System.out.println("\n" + entry.getKey() + " 的手牌：");
                    for (Park park : entry.getValue()) {
                        System.out.print(park + " ");
                    }
                    System.out.println();
                }
            }
            
            // 开始出牌阶段
            System.out.println("\n=============开始出牌===============");
            System.out.println("地主 " + landlord + " 先出牌！");
            // 这里可以继续实现出牌逻辑
        } else {
            System.out.println("无人抢地主，游戏结束！");
        }
    }
    
    /**
     * 对手牌进行排序
     * 排序规则：3,4,5,6,7,8,9,10,J,Q,K,A,2,小王,大王
     * 花色顺序：黑桃>红桃>梅花>方块
     * @param cards 需要排序的手牌列表
     */
    private void sortCards(List<Park> cards) {
        // 创建牌点数的排序权重映射
        Map<String, Integer> cardWeightMap = new HashMap<>();
        String[] order = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "小王", "大王"};
        for (int i = 0; i < order.length; i++) {
            cardWeightMap.put(order[i], i);
        }
        
        cards.sort(new Comparator<Park>() {
            @Override
            public int compare(Park o1, Park o2) {
                // 首先比较牌的点数权重
                int weight1 = cardWeightMap.getOrDefault(o1.getSize(), 0);
                int weight2 = cardWeightMap.getOrDefault(o2.getSize(), 0);
                
                // 如果点数权重不同，则按点数排序
                if (weight1 != weight2) {
                    return Integer.compare(weight1, weight2);
                }
                
                // 如果都是大小王，比较大小
                if ((o1.getSize().equals("大王") || o1.getSize().equals("小王")) && 
                    (o2.getSize().equals("大王") || o2.getSize().equals("小王"))) {
                    // 大王比小王大
                    if (o1.getSize().equals("大王") && o2.getSize().equals("小王")) {
                        return 1;
                    } else if (o1.getSize().equals("小王") && o2.getSize().equals("大王")) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

                // 如果点数相同，则按花色排序（黑桃>红桃>梅花>方块）
                Map<String, Integer> colorOrder = new HashMap<>();
                colorOrder.put("♠", 4);
                colorOrder.put("♥", 3);
                colorOrder.put("♣", 2);
                colorOrder.put("♦", 1);
                
                int colorWeight1 = colorOrder.getOrDefault(o1.getColor(), 0);
                int colorWeight2 = colorOrder.getOrDefault(o2.getColor(), 0);
                
                return Integer.compare(colorWeight2, colorWeight1); // 花色从大到小
            }
        });
    }
}
