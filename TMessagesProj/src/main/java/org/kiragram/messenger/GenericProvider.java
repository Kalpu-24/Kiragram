package org.kiragram.messenger;

public interface GenericProvider<F, T> {
    T provide(F obj);
}
