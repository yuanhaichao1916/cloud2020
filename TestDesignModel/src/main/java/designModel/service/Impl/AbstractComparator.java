package designModel.service.Impl;

import designModel.service.IComparator;

public class AbstractComparator<T> implements IComparator {
    @Override
    public boolean equal(Object x, Object y) {
        return true;
    }

    @Override
    public boolean less(Object x, Object y) {
        return true;
    }
}
