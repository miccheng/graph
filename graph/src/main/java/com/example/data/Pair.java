package com.example.data;

public class Pair<K, V> implements KeyValue<K, V>{
    private String currency;
    private String content;
    public Pair(String symbol, String str){
        currency=symbol;
        this.content=str;
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }


}
