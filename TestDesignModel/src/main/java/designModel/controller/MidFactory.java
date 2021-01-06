package designModel.controller;

import designModel.service.AbstractFactory1;
import designModel.service.IBus;
import designModel.service.ICar;
import designModel.service.Impl.factory.MidBus;
import designModel.service.Impl.factory.MidCar;

public class MidFactory extends AbstractFactory1 {

    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
