package designModel.controller;

import designModel.service.AbstractFactory1;
import designModel.service.IBus;
import designModel.service.ICar;
import designModel.service.Impl.factory.TopCar;
import designModel.service.Impl.factory.UpBus;

public class TopFactory extends AbstractFactory1 {

    @Override
    public ICar createCar() {
        return new TopCar();
    }

    @Override
    public IBus createBus() {
        return new UpBus();
    }
}
