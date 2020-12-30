package designModel.service.Impl;

import designModel.service.Ishape;

import java.util.Scanner;

public class Rect implements Ishape {
    float width,height;
    @Override
    public Boolean input() {
        System.out.println("请输入宽、高：");
        Scanner scanner = new Scanner(System.in);
        width = scanner.nextFloat();
        height = scanner.nextFloat();
        return true;
    }

    @Override
    public float getArea() {
        float s = width*height;
        return s;
    }
}
