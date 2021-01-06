package designModel.controller;

import designModel.service.ICar;
import designModel.service.Impl.factory.LowCar;
import designModel.service.Impl.factory.MidCar;
import designModel.service.Impl.factory.TopCar;

public class CarSimpleFactory {
    public static final String TOPTYPE = "toptype";
    public static final String MIDTYPE = "midtype";
    public static final String LOWTYPE = "lowtype";

    public static ICar create(String mark) {
        ICar car = null;
        if (mark.equals(TOPTYPE)) {
            car = new TopCar();
        }
        if (mark.equals(MIDTYPE)) {
            car = new MidCar();
        }
        if (mark.equals(LOWTYPE)) {
            car = new LowCar();
        }
        return car;
    }
}
