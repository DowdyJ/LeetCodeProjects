package dev.sugaroflead.lc705;

public class MyHashSet {
    int[] data;

    public MyHashSet() {
        data = new int[31260];
    }
    
    public void add(int key) {
        int mask = 1 << getSubIndex(key);
        data[getIndex(key)] |= mask;
    }
    
    public void remove(int key) {
        int mask = 1 << getSubIndex(key);
        data[getIndex(key)] &= ~(mask);
    }
    
    public boolean contains(int key) {
        return (data[getIndex(key)] & (1 << getSubIndex(key))) != 0;
    }

    public int getSubIndex(int key) {
        return key % 32;
    }

    public int getIndex(int key) {
        return key / 32;
    }
}
