package com.example.data;

public class Pair<K, V> implements KeyValue<K, V>{
    private String currency;
    private String price;
    public Pair(String currency, String price){
        this.currency = currency;
        this.price = price;
    }

    @Override
    public K getKey() {
        return (K)this.currency;
    }

    @Override
    public V getValue() {
        return (V)this.price;
    }
}
