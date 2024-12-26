package com.ddc.projects.java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAllocation {
    //static String[] allMemberName = {"ddc1", "ddc2", "ddc3", "ddc4", "ddc5", "ddc6"};
    static String[] allMemberName = {"康立1", "梁加明1", "昌怡玲1", "邓万雄1", "康立", "梁加明", "昌怡玲", "邓万雄", "吴鹏", "周瑞", "冯佳嘉", "梁剑", "王温豪", "徐明", "麻肖肖", "刘陆", "李梦婷", "张云杰", "王红岩", "刘恒", "丁浩", "张品纯", "易雪莲", "刘念", "那仁", "王锦洲", "刘金利", "李松", "陈琳", "宋泰成", "吴瑜琪", "张祥", "阳辉", "南成宇", "张奇光", "叶文龙", "贾欣蕊", "程哲先", "黄智发", "赵琪", "徐康", "谭烁", "余慧云", "倪丹东", "司卓奇", "李瑞凯", "孙宇", "祝江坤", "安鑫", "黄维毅", "章飞", "付瑨", "王梓颐", "陈杰", "李行", "徐振宇", "丁韦娜", "李威钧", "曹华", "李晓希", "巢榛甄", "李柏纬", "王浩", "王炼", "刘明佳"};
    static int memberCountForEachGroup = 10;
    static int groupNumber = 6;

    public static void main(String[] args) {
        //total number should small than (groupNumber + 1) * memberCountForEachGroup
        //62 <= (6 + 1) * 10
        System.out.println(allMemberName.length);

        Map<Integer, List<String>> groupMap = new HashMap<>();
        for (var i = 1; i <= groupNumber; i++) {
            List<String> eachGroupList = new ArrayList<>(memberCountForEachGroup);
            groupMap.put(i, eachGroupList);
        }

        if (groupNumber * memberCountForEachGroup <= allMemberName.length
                && groupNumber * (memberCountForEachGroup + 1) > allMemberName.length) {
            for (var i = 0; i < groupNumber * memberCountForEachGroup; i++) {
                boolean pass = true;
                do {
                    int randomNumber = getRandomNumber() + 1;
                    if (groupMap.get(randomNumber).size() < memberCountForEachGroup) {
                        groupMap.get(randomNumber).add(allMemberName[i]);
                        pass = false;
                    }
                } while (pass);
            }

            for (var i = groupNumber * memberCountForEachGroup; i < allMemberName.length; i++) {
                boolean pass = true;
                do {
                    int randomNumber = getRandomNumber() + 1;
                    if (groupMap.get(randomNumber).size() < memberCountForEachGroup + 1) {
                        groupMap.get(randomNumber).add(allMemberName[i]);
                        pass = false;
                    }
                } while (pass);
            }
        } else {
            System.out.println("Please check groupNumber & memberCountForEachGroup");
        }
        groupMap.forEach((key, value) -> System.out.println("Group" + key + "---" + value.size() + "---" + value));
    }

    static int getRandomNumber() {
        return (int) (Math.random() * 100) % groupNumber;
    }

}
