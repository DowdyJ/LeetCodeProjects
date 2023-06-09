﻿using System.Collections.Generic;


public class SnapshotArray {

    List<Dictionary<int, int>> snaps = new();

    Dictionary<int, int> lastChangedIndex = new();
    HashSet<int> changedSinceLastSnap = new();

    bool anyChangeSinceLastSnap = false;
    int[] lastArr;
    int[] curArr;

    public SnapshotArray(int length) {
        curArr = new int[length];
        lastArr = new int[length];
    }
    
    public void Set(int index, int val) {
        this.curArr[index] = val;
        anyChangeSinceLastSnap = true;

        if (lastChangedIndex.ContainsKey(index))
            lastChangedIndex[index] = snaps.Count;
        else
            lastChangedIndex.Add(index, snaps.Count);

        changedSinceLastSnap.Add(index);
    }
    
    public int Snap() {

        Dictionary<int, int> diffs = new();

        if (anyChangeSinceLastSnap) {
            foreach (var i in changedSinceLastSnap) {
                if (curArr[i] != lastArr[i]) {
                    diffs.Add(i, curArr[i]);
                }
            }

            lastArr = (int[])curArr.Clone();
        }

        changedSinceLastSnap.Clear();

        anyChangeSinceLastSnap = false;
        snaps.Add(diffs);
        return snaps.Count - 1;
    }
    
    public int Get(int index, int snap_id) {

        if (!lastChangedIndex.ContainsKey(index))
            return 0;

        int result = 0;

        int i = lastChangedIndex[index];

        if (i >= snaps.Count)
            i--;
        
        if (i > snap_id)
            i = snap_id;

        for (; i >= 0; --i) {
            if (snaps[i].TryGetValue(index, out result))
                return result;
        }

        return 0;
    }
}
