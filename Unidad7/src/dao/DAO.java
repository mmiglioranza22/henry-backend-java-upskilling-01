package dao;

import java.util.ArrayList;
import java.util.List;

public interface DAO<T, K> {
    public List<T> getTarjetas();

    public T getTarjeta(K id);
}
