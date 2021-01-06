package designModel.service;

import designModel.service.AbstractFactory;
import designModel.service.IBus;
import designModel.service.ICar;

public abstract class AbstractFactory2 extends AbstractFactory {
    public abstract ICar createCar();
}
