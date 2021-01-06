import designModel.controller.TopFactory;
import designModel.service.AbstractFactory;
import designModel.service.ICar;

public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory obj = new TopFactory();
        ICar car = obj.createCar();
    }
}
