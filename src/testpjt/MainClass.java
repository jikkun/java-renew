package testpjt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        char c = 'a';
        logger.debug("c = {}", c);

        int i = 10;
        logger.debug("i = {}", i);

        double d = 1.258;
        logger.debug("d = {}", d);

        boolean b = false;
        logger.debug("b = {}", b);

        String s = "Hello Java World!!";
        logger.debug("s = {}", s);

        // 자동(묵시적) 형 변환
        // 작은 공간의 메모리에서 큰 공간의 메모리로 이동
        byte by = 10;
        int in = by;
        logger.debug("in = {}", in);

        // 명시적 형변환
        // 큰 공간의 메모리에서 작은 공간의 메모리로 이동
        int iVar = 100;
        byte bVar = (byte) iVar;
        logger.debug("bVar = {}", bVar);

        iVar = 123456;
        bVar = (byte) iVar;
        logger.debug("bVar = {}", bVar); // 데이터 유실
    }

}
