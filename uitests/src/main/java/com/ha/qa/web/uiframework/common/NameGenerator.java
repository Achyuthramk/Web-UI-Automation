package com.ha.qa.web.uiframework.common;

import java.util.Random;

public class NameGenerator {

    public static String generate(){
        String name = new String();
        char[] ar ={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
                ,'l', 'm', 'n', 'o', 'p', 'q', 'r','s','t','u', 'v','w','x', 'y', 'z'};

        for (int i=0; i<4;i++)
        {
            Random randonm = new Random();
            name += ar[randonm.nextInt(ar.length)];

        }
        return name;
    }
}
