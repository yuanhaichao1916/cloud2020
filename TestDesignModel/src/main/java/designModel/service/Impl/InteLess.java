package designModel.service.Impl;

import designModel.service.ILess;
import org.springframework.stereotype.Service;

@Service
public class InteLess implements ILess<Integer> {

    @Override
    public boolean less(Integer x, Integer y) {
        return x<y;
    }
}
