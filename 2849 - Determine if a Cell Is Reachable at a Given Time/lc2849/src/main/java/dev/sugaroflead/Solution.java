package dev.sugaroflead;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int distanceX = Math.abs(fx - sx);
        int distanceY = Math.abs(fy - sy);

        if (distanceX == 0 && distanceY == 0) {
            return t != 1;
        }


        if (t >= Math.max(distanceX, distanceY)) {
            return true;
        }

        return false;
    }

    public boolean isReachableAtTime_oneliner(int sx, int sy, int fx, int fy, int t) {
        return fx == sx && fy == sy ? t != 1 : t >= Math.max(Math.abs(fx - sx), Math.abs(fy - sy));
    }
}