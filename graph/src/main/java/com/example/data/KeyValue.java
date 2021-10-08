package com.example.data;

public interface KeyValue<K, V> {

    /**
     * Returns the key
     * @return the key
     */
    K getKey();

    /**
     * Returns the value
     * @return the value
     */
    V getValue();

}