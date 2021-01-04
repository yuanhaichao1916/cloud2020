package designModel.controller;

import designModel.service.IComparator;

public class Algorithm<T> {
    IComparator<T> cmp; //比较器，是AbstractComparator的子类

    public Algorithm(IComparator<T> cmp) {
        this.cmp = cmp; //初始化比较器
    }

    public T median(T x, T y, T z) {
        if (cmp.less(x, y))
            return cmp.less(y, z) ? y : cmp.less(x, z) ? z : x;
        else
            return cmp.less(x, z) ? x : cmp.less(y, z) ? z : y;
    }

    public boolean push_heap(T[] t, int h, int j, T v) {
        for (int i = (h - 1) / 2; j < h && cmp.less(t[i], v); i = (h - 1) / 2) {
            t[h] = t[i];
            h = i;
        }
        t[h] = v;
        return true;
    }

    public boolean pop_heap(T[] t, int m, int i) {
        t[i] = t[0];
        adjust_heap(t, 0, m);
        return true;
    }

    public boolean sort_heap(T[] t, int l) {
        for (; l > 1; --l) {
            pop_heap(t, l - 1, l - 1);
        }
        return true;
    }

    public boolean adjust_heap(T[] t, int pos, int nSize) {
        int j = pos;
        T v = t[pos];
        int k = 2 * pos + 2;
        for (; k < nSize; k = 2 * k + 2) {
            if (cmp.less(t[k], t[k - 1])) {
                --k;
            }
            t[pos] = t[k];
            pos = k;
        }
        if (k == nSize) {
            t[pos] = t[k - 1];
            pos = k - 1;
        }
        push_heap(t, pos, j, v);
        return true;
    }

    public boolean make_heap(T[] t, int nSize) {
        if (nSize >= 2) { //保证至少有两个元素
            for (int i = nSize / 2; i > 0; ) {
                --i;
                adjust_heap(t, i, nSize);
            }
        }
        return true;
    }

    public boolean partial_sort(T[] t, int nSize) {
        int total = t.length;
        make_heap(t, nSize);
        for (int i = nSize; i < total; i++) {
            if (cmp.less(t[i], t[0])) {
                pop_heap(t, nSize, i);
            }
        }
        sort_heap(t, nSize);
        return true;
    }
}
