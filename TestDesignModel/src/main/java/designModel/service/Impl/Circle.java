package designModel.service.Impl;

import designModel.service.Ishape;

import java.util.Scanner;

public class Circle implements Ishape {
    float r;
    @Override
    public Boolean input() {
        System.out.println("请输入半径：");
        Scanner s = new Scanner(System.in);
        r = s.nextFloat();
        return true;
    }

    @Override
    public float getArea() {
        float s = (float) Math.PI*r*r;
        return s;
    }
}
