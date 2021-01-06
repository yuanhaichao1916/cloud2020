import designModel.controller.CarSimpleFactory;
import designModel.service.ICar;

public class EasyCarTest {
    public static void main(String[] args) {
        // 从工厂中穿件对象
        ICar car = CarSimpleFactory.create("toptype");
    }
}
