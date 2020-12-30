package designModel.service.Impl;

import designModel.service.Ishape;

public class ShapeProc {
    private Ishape shape;

    public ShapeProc(Ishape shape) {
        this.shape = shape;
    }
    public float process(){
        shape.input();
        float area = shape.getArea();
        return area;
    }
}
