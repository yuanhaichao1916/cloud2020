package designModel.service;

public interface IShape2 {
    // 多态函数定义
    public Object dispatch(int nId, Object in);
    public int query(String strId);
}
