package org.westos.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero {

    public static void main(String[] args) throws IOException {
        System.out.println("武将中武力前三的hero对象:");
        Stream<Heroes> heroesStream = getHeroesStream();
        Stream<Heroes> power = heroesStream.sorted((a, b) -> -((a.getPower()) - (b.getPower())));
        power.limit(3).forEach(h->{
            System.out.println(h);
        });
        System.out.println("--------------------------------------------------------------------------");
        Stream<Heroes> heroesStream1 = getHeroesStream();
        Map<String, List<Heroes>> location = heroesStream1.collect(Collectors.groupingBy(h -> h.getLoc()));
        System.out.println("按出生地分组:");
        for(Map.Entry<String, List<Heroes>> key:location.entrySet()){
            List<Heroes> value = key.getValue();
            for(Heroes h:value){
                System.out.println(h);
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("寿命前三的武将:");
        Stream<Heroes> heroesStream2 = getHeroesStream();
        Stream<Heroes> age = heroesStream2.sorted((a, b) -> -((a.getDeath() - a.getBirth()) - (b.getDeath() - b.getBirth())));
        age.limit(3).forEach(h->{
            System.out.println(h);
        });
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("女性寿命最高的武将：");
        Stream<Heroes> heroesStream3 = getHeroesStream();
        //方法一
        Optional<Heroes> nage = heroesStream3.filter(a -> a.getSex().equals("女")).max((a, b) ->-((b.getDeath() - b.getBirth()) - (a.getDeath() - a.getBirth())));
        System.out.println(nage);
//        //方法二
//        List<Heroes> listHero = heroesStream3.collect(Collectors.toList());
//        ArrayList<Heroes> listNv = new ArrayList<>();
//        for(Heroes h:listHero){
//            if (h.getSex().equals("女")){
//                listNv.add(h);
//                listNv.sort((a,b)->((b.getDeath()-b.getBirth())-(a.getDeath()-a.getBirth())));
//            }
//        }
//
//        System.out.println(listNv);
//        System.out.println(listNv.get(0));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("武力排名前三的武将名：");
        Stream<Heroes> heroesStream4 = getHeroesStream();
        Stream<Heroes> power1 = heroesStream4.sorted((a, b) -> -((a.getPower()) - (b.getPower())));
        power1.limit(3).forEach(h->
                System.out.println(h.getName()));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("按年龄段分组:");
        Stream<Heroes> heroesStream5 = getHeroesStream();
        List<Heroes> fage = heroesStream5.sorted((a, b) -> -((a.getDeath() - a.getBirth()) - (b.getDeath() - b.getBirth()))).collect(Collectors.toList());
        ArrayList<Heroes> list = new ArrayList<>();
        ArrayList<Heroes> list1 = new ArrayList<>();
        ArrayList<Heroes> list2 = new ArrayList<>();
        ArrayList<Heroes> list3 = new ArrayList<>();
        for(Heroes h:fage){
            int agee = h.getDeath() - h.getBirth();
            if(agee>=0 && agee<=20){
                list.add(h);
            }else if(agee>=21 && agee<=40){
                list1.add(h);
            }else if(agee>=41 && agee<=60){
                list2.add(h);
            }else if(agee>=61){
                list3.add(h);
            }
        }
        System.out.println("0~20岁的武将:"+"\n"+list);
        System.out.println("21~40岁的武将:"+"\n"+list1);
        System.out.println("41~60岁的武将:"+"\n"+list2);
        System.out.println("60岁以上的的武将:"+"\n"+list3);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("按武力段分组：");
        Stream<Heroes> heroesStream6 = getHeroesStream();
        List<Heroes> fpowre = heroesStream6.sorted((a, b) -> -(a.getPower() - b.getPower())).collect(Collectors.toList());
        ArrayList<Heroes> list4 = new ArrayList<>();
        ArrayList<Heroes> list5 = new ArrayList<>();
        ArrayList<Heroes> list6 = new ArrayList<>();
        ArrayList<Heroes> list7 = new ArrayList<>();
        for(Heroes h:fage){
            int po = h.getPower();
            if(po>=90 ){
                list4.add(h);
            }else if(po>=80 && po<=89){
                list5.add(h);
            }else if(po>=70 && po<=79){
                list6.add(h);
            }else if(po<70){
                list7.add(h);
            }
        }
        System.out.println("武力值90以上的武将:"+"\n"+list4);
        System.out.println("武力值80~89岁的武将:"+"\n"+list5);
        System.out.println("武力值70~79岁的武将:"+"\n"+list6);
        System.out.println("武力值70以下的的武将:"+"\n"+list7);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("按出生地分组后并统计各组人数：");
        Stream<Heroes> heroesStream7 = getHeroesStream();
        Map<String, List<Heroes>> location2 = heroesStream7.collect(Collectors.groupingBy(h -> h.getLoc()));
        ArrayList<String> list8 = new ArrayList<>();
        int count=0;
        for(Map.Entry<String, List<Heroes>> key:location2.entrySet()){
            List<Heroes> value = key.getValue();
            String key1 = key.getKey();
            for(Heroes h:value){
               list8.add(h.getLoc());
            }
        }
        System.out.println(list8);
        HashMap<String, Integer> map = new HashMap<>();
        for(String ele:list8){
            Integer i = map.get(ele);
            if(i==null){
                map.put(ele,1);
            }else{
                map.put(ele,i+1);
            }
        }
        for(String key:map.keySet()){
            System.out.println(key+"出现了"+map.get(key)+"次");
        }
    }

    private static Stream<Heroes> getHeroesStream() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        // \t  split("\t")
        //lines.forEach(str-> System.out.println(str));

        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        // 2. 按出生地分组
        // 3. 找出寿命前三的武将
        // 4. 女性寿命最高的
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超
        return lines.map(s -> s.split("\t")).
                map(array -> new Heroes(Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6])));
    }
}
