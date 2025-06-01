package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MountainBike mtb = context.getBean("mountainBike", MountainBike.class);
        KidsBike kids = context.getBean("kidsBike", KidsBike.class);
        BMXBike bmx = context.getBean("bmxBike", BMXBike.class);

        mtb.info();
        kids.info();
        bmx.info();

        context.close();
    }
}
