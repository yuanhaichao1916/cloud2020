package designModel.service.designModel;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getUniqueInstance(){
        // 先判断对象是否已经实例过，没有实例过才能进入加锁代码
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
