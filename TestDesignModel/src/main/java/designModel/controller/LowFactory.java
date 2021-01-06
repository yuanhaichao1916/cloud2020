package designModel.controller;

import designModel.service.AbstractFactory2;
import designModel.service.ICar;
import designModel.service.Impl.factory.LowCar;

public class LowFactory extends AbstractFactory2 {

    @Override
    public ICar createCar() {
        return new LowCar();
    }
}
