package com.netease.cowork.ynote.script;

import org.junit.Test;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 6:18 下午
 */
public class StringUtils {
    @Test
    public void testStrUtils() {
        String src = "\nweixinobU7Vjnxlc19DPHtvMyLDfE6URfQ\n\t" +
                "\nfanminghe6666@163.com\n\t" +
                "\nweixinobU7VjlEaeTp0crssqR9jGCJ1JkA\n\t" +
                "\ndashan9489@163.com\n\t" +
                "\nweixinobU7Vjk4Ch5LKQOO4IfodhgKgPes\n\t" +
                "\nyjchdu@163.com\n\t" +
                "\nqq80F91ABE252DFC253DFD2D6EC6B85C6E\n\t" +
                "\nweixinobU7VjmJHc-8TDS1giZT_WRVlIYQ\n\t" +
                "\nweixinobU7VjoNR9Gjp1gHT1XH0JgWkWqQ\n\t" +
                "\nweixinobU7VjropIeXuJzCGkKfiEt2lQLM\n\t" +
                "\nweixinobU7Vjj-g_AZ3K89X67D2-zu4Rvk\n\t" +
                "\nxstmas@163.com\n\t" +
                "\n2653625765@qq.com\n\t" +
                "\nmagxye@163.com\n\t" +
                "\nyleimedia@163.com\n\t" +
                "\nbarryok678@163.com\n\t" +
                "\nweixinobU7VjrTHHFbYpCKEheqzJPN-mDw\n\t" +
                "\nweixinobU7VjhDaHlGGd8iD0iNhWs8sppk\n\t" +
                "\nlilypadbaby@126.com\n\t" +
                "\nweixinobU7Vjn9E9N20V2tEerKRJt9Ri2A\n\t" +
                "\nshanechao@163.com\n\t" +
                "\nm15088745656@163.com\n\t" +
                "\nweixinobU7VjstRWHjePbZtMxbAniE2OfI\n\t" +
                "\nweixinobU7VjoAg0YEJGf3GdoeAeFVlE4Y\n\t" +
                "\nweixinobU7Vji-m-SC0HxIantaSE3riCbk\n\t" +
                "\nweixinobU7VjrD2UaJ1HPko3JNHNC-e1mw\n\t" +
                "\ngis_zhong@yeah.net\n\t" +
                "\nweixinobU7VjlC6DsffLZGcSpyw2qMwDfk\n\t" +
                "\nqqB76955FD76F203133D08FE2089DDE0AE\n\t" +
                "\nweixinobU7VjlEaeTp0crssqR9jGCJ1JkA\n\t" +
                "\nwuxianglutong@126.com\n\t" +
                "\ntraceyhao@163.com\n\t" +
                "\nbaidi1976@163.com\n\t" +
                "\nweixinobU7Vjv9ouhNuzL9q1wLt1hVGIdg\n\t" +
                "\nyd.2d9ac29983bc4671a\n\t" +
                "\nzhejiangclx@163.com\n\t" +
                "\nqq6B915E9A0D405FEF51C040B086EE967E\n\t" +
                "\nweixinobU7VjuSoHd-1Iy4wSLlUszrha8o\n\t" +
                "\nweixinobU7VjpRx0F53MsNZmYuiElwzveM\n\t" +
                "\nyb.yuan@126.com\n\t" +
                "\nweixinobU7VjlEaeTp0crssqR9jGCJ1JkA\n\t" +
                "\nweixinobU7VjoI_NbSpTNqt1RgjTgLt35Y\n\t" +
                "\nweixinobU7VjoNR9Gjp1gHT1XH0JgWkWqQ\n\t" +
                "\nweixinobU7VjvGeLPmwDZKTIO-LPPjEomY\n\t" +
                "\nweixinobU7VjgvyoRg48lNriWQmqanrLe4\n\t" +
                "\nweixinobU7VjlEaeTp0crssqR9jGCJ1JkA\n\t" +
                "\nweixinobU7VjoI_NbSpTNqt1RgjTgLt35Y\n\t" +
                "\nweixinobU7VjpbPvA0hfvmA3-vZMrlKkoM\n\t" +
                "\nweixinobU7VjlEaeTp0crssqR9jGCJ1JkA\n\t";

        String desStr = src.replace("\n","'").replace("\t",",");
        System.out.println(desStr);
    }
}
