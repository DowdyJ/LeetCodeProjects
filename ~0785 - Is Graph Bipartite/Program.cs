﻿using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.IO;
using System.Linq;

namespace LC785;

public class Solution {
    public static int Main(string[] args) {
        var s = new Solution();
        //[1,2,3],[0,2],[0,1,3],[0,2]

        int[][] graph1 = new int[][] {
            new int[] {1, 3},
            new int[] {0, 2},
            new int[] {1, 3},
            new int[] {0, 2}
            };


        int[][] graph2 = new int[][] {
            new int[] {1, 2, 3},
            new int[] {0,2},
            new int[] {0, 1, 3},
            new int[] {0,2}
            };

        int[][] graph3 = new int[][] {
new int[] {50,51,53,55,56,57,58,59,61,63,64,65,66,68,70,71,73,74,75,76,78,79,80,81,82,84,85,86,87,88,90,91,93,94,95,96,97,98}
,new int[] {50,52,54,56,57,58,59,60,61,63,64,65,67,68,69,71,73,74,75,76,77,78,80,81,82,85,87,88,89,91,92,94,97,98,99}
,new int[] {50,51,53,54,56,57,58,59,61,62,63,66,67,68,70,71,72,73,74,75,76,78,79,80,82,83,85,86,87,89,90,91,92,93,94,95,97,98}
,new int[] {51,52,53,54,57,58,59,62,63,64,65,66,67,71,72,73,74,75,76,78,80,81,82,83,85,86,87,88,89,90,91,92,93,94,97,98,99}
,new int[] {50,51,53,54,56,58,59,61,62,63,64,65,66,67,68,70,71,72,73,76,79,81,83,84,85,86,87,88,89,90,91,92,93,94,95,97,98}
,new int[] {50,53,55,58,59,61,62,63,64,65,66,67,68,69,72,73,74,75,77,79,80,83,85,86,87,88,89,91,92,93,94,95,96,98,99}
,new int[] {50,51,52,54,55,56,57,58,59,60,61,62,63,64,65,66,69,70,74,75,76,77,78,81,82,83,84,85,86,87,90,93,94,95,96,97,98}
,new int[] {50,51,52,53,55,57,58,59,60,61,62,63,66,67,69,70,71,73,74,76,78,79,80,81,82,83,84,85,86,87,88,90,91,93,94,96,97,98,99}
,new int[] {51,53,56,57,58,59,61,64,66,67,68,69,72,73,74,75,77,80,81,82,84,85,86,88,89,90,91,94,96,97,98,99}
,new int[] {50,51,53,54,55,56,57,58,59,60,61,62,63,64,66,68,69,70,71,72,73,74,75,76,77,78,79,85,87,88,89,90,91,92,93,97,98,99}
,new int[] {51,52,53,54,55,56,57,60,61,62,64,66,67,69,71,72,73,75,77,78,79,80,83,84,85,86,88,90,91,92,93,94,95,97}
,new int[] {51,53,54,55,57,58,62,63,64,67,68,69,70,71,72,73,74,76,78,79,81,82,83,84,85,88,90,94,95,97,98}
,new int[] {53,54,55,56,57,58,59,61,63,64,65,66,68,69,70,71,72,74,75,76,77,78,80,82,83,84,85,86,87,90,92,93,94,95,97,98,99}
,new int[] {52,53,55,56,57,59,60,63,64,66,72,73,74,77,79,83,84,85,86,87,89,90,91,92,93,94,95,96,97}
,new int[] {50,51,52,53,54,56,57,58,59,60,61,62,63,64,66,67,68,69,70,71,72,74,75,76,78,79,81,83,84,85,87,88,90,93,94,95,96,99}
,new int[] {50,51,53,54,55,58,59,60,62,63,64,67,68,69,71,72,73,75,76,78,79,80,81,82,83,84,85,86,87,88,89,90,91,94,96,97,98,99}
,new int[] {50,51,52,53,54,55,56,57,58,59,60,62,64,65,66,67,68,69,70,72,73,74,75,76,77,78,80,81,82,84,85,86,87,88,89,92,93,94,95,96,97,99}
,new int[] {50,51,52,53,54,55,56,57,58,59,60,61,63,64,65,66,67,69,70,71,72,74,75,78,80,81,82,83,84,85,86,88,89,90,91,92,93,94,95,97,98,99}
,new int[] {50,51,52,53,54,55,56,57,58,59,61,62,63,64,66,68,71,73,74,75,77,78,80,81,82,85,86,87,89,90,91,92,93,94,95,96,97,98,99}
,new int[] {50,51,52,53,54,55,56,57,58,60,61,62,63,64,65,66,67,69,70,72,75,77,78,79,80,81,82,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99}
,new int[] {50,51,52,53,54,55,56,57,58,59,60,61,62,64,65,66,68,69,70,72,73,74,82,87,88,91,93,94,96,99}
,new int[] {50,51,52,56,58,60,61,62,63,64,66,68,69,71,73,75,76,77,79,80,82,83,84,85,86,88,92,93,94,95,96,97,98}
,new int[] {51,52,53,54,55,56,57,58,59,60,61,62,64,65,67,68,70,71,72,73,74,75,76,77,78,79,80,82,83,84,85,87,88,89,90,91,93,94,95,96,98,99}
,new int[] {52,53,54,55,56,57,58,59,60,61,64,65,66,67,68,69,70,71,72,74,75,76,77,78,79,84,85,86,87,88,90,91,92,94,95,96,97,98,99}
,new int[] {51,53,55,56,57,58,59,60,62,63,64,66,67,68,70,71,72,73,74,75,76,78,79,83,84,85,86,87,88,89,90,91,93,94,96,99}
,new int[] {50,51,52,53,54,57,59,60,61,62,63,65,66,67,68,69,70,71,72,74,75,76,78,80,81,82,83,84,85,86,87,91,92,93,94,96,97,98,99}
,new int[] {50,51,52,53,54,55,57,58,59,60,61,62,64,65,67,68,70,71,74,75,76,77,79,80,82,83,85,86,87,90,91,92,93,94,96,97}
,new int[] {50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,69,70,71,72,73,75,76,77,78,79,80,81,83,86,87,88,89,90,91,92,94,95,96,97,98,99}
,new int[] {50,52,53,56,58,59,61,63,64,65,66,67,68,69,70,71,72,73,75,77,80,81,82,83,84,85,86,88,93,94,95,96,99}
,new int[] {50,51,53,54,55,57,59,61,63,64,65,66,67,68,69,70,72,73,76,77,78,79,80,83,87,89,90,92,93,94,95,96,97,98}
,new int[] {50,51,52,54,55,56,57,59,60,62,63,64,65,66,68,69,70,72,73,74,75,76,77,78,79,81,82,83,84,86,87,91,92,94,95,97,99}
,new int[] {50,51,52,53,55,56,59,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,82,83,84,85,86,87,88,91,92,94,97,98,99}
,new int[] {50,51,53,59,61,62,63,65,66,67,68,69,70,71,72,74,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,95,96,97,98,99}
,new int[] {50,53,54,55,56,57,59,61,62,63,64,65,67,68,69,70,71,73,75,77,78,81,83,85,86,87,89,90,92,94,95,96,97,98,99}
,new int[] {50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,67,68,71,72,73,74,75,77,80,82,83,84,85,86,88,89,90,91,92,93,94,95,96,97,98,99}
,new int[] {50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,95,96,98,99} 
,new int[] {50,51,52,53,54,56,57,58,59,61,62,63,64,65,68,69,70,71,72,73,74,75,76,78,79,80,82,84,85,86,87,88,90,92,93,94,95,96,97}
,new int[] {50,52,53,55,56,60,61,62,63,64,66,67,68,69,70,74,75,76,78,79,80,81,82,84,85,86,88,89,90,91,92,96,97}
,new int[] {50,51,52,53,54,55,56,57,58,59,60,61,62,64,65,67,68,69,70,72,73,76,77,78,79,80,81,82,84,85,87,88,89,91,92,94,95,96,97}
,new int[] {50,51,52,55,56,57,58,59,60,61,62,66,67,70,72,73,74,77,78,79,80,82,83,84,85,87,88,89,91,92,93,94,96,97,98,99}
,new int[] {50,51,52,54,56,58,59,61,63,64,65,66,67,68,69,71,72,73,75,78,79,80,81,82,83,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99}
,new int[] {50,51,52,53,54,55,57,59,60,61,62,63,64,66,67,68,70,71,72,73,76,77,78,80,81,83,85,86,87,88,89,90,93,95,97,98}
,new int[] {50,51,54,55,57,58,59,60,61,62,63,64,65,66,68,69,71,73,74,75,76,79,82,83,85,86,87,88,91,92,93,94,95,96,97,98}
,new int[] {50,52,54,55,56,58,59,60,61,62,63,64,66,67,68,69,70,71,74,76,78,79,80,81,82,83,84,85,86,87,88,89,92,94,95,97,98,99}
,new int[] {50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,67,70,72,73,74,76,77,79,80,81,83,84,86,87,88,89,90,91,92,94,95,96,97,98}
,new int[] {50,51,52,56,57,58,60,62,63,64,65,66,69,71,72,73,74,75,76,77,78,79,80,81,83,84,85,86,88,89,90,91,94,97,99}
,new int[] {51,52,53,54,55,58,59,60,61,62,63,64,65,68,70,71,73,74,75,76,77,78,80,81,82,83,85,87,89,91,92,93,94,95,96,98}
,new int[] {50,51,52,54,55,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,79,80,81,82,83,84,85,89,90,91,93,94,95,96,97,98,99}
,new int[] {51,52,53,54,55,56,57,58,60,62,63,64,65,67,68,70,71,72,73,74,75,76,77,78,79,80,81,82,85,87,88,90,91,92,93,94,95,96,99}
,new int[] {50,51,52,53,54,56,58,59,60,61,62,63,65,67,68,69,70,71,72,74,76,77,78,79,80,81,82,84,85,86,87,89,90,91,92,94,96,97,98,99}
,new int[] {0,1,2,4,5,6,7,9,14,15,16,17,18,19,20,21,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,47,49}
,new int[] {0,2,3,4,6,7,8,9,10,11,14,15,16,17,18,19,20,21,22,24,25,26,27,29,30,31,32,34,35,36,38,39,40,41,42,44,45,46,47,48,49}
,new int[] {1,3,6,7,10,13,14,16,17,18,19,20,21,22,23,25,26,27,28,30,31,34,35,36,37,38,39,40,41,43,44,45,46,47,48,49}
,new int[] {0,2,3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,41,44,46,48,49}
,new int[] {1,2,3,4,6,9,10,11,12,14,15,16,17,18,19,20,22,23,25,26,29,30,33,35,36,38,40,41,42,43,46,47,48,49}
,new int[] {0,5,6,7,9,10,11,12,13,15,16,17,18,19,20,22,23,24,26,27,29,30,31,33,34,35,37,38,39,41,42,43,44,46,47,48}
,new int[] {0,1,2,4,6,8,9,10,12,13,14,16,17,18,19,20,21,22,23,24,27,28,30,31,33,34,35,36,37,38,39,40,43,44,45,48,49}
,new int[] {0,1,2,3,6,7,8,9,10,11,12,13,14,16,17,18,19,20,22,23,24,25,26,27,29,30,33,34,35,36,38,39,41,42,44,45,47,48}
,new int[] {0,1,2,3,4,5,6,7,8,9,11,12,14,15,16,17,18,19,20,21,22,23,24,26,27,28,34,35,36,38,39,40,42,43,44,45,46,47,48,49}
,new int[] {0,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17,18,20,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,38,39,40,41,42,43,44,46,49}
,new int[] {1,6,7,9,10,13,14,15,16,17,19,20,21,22,23,24,25,26,27,30,31,34,35,37,38,39,41,42,43,44,45,46,48,49}
,new int[] {0,1,2,4,5,6,7,8,9,10,12,14,17,18,19,20,21,22,23,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,46,47,49}
,new int[] {2,3,4,5,6,7,9,10,11,14,15,16,18,19,20,21,22,24,25,26,27,30,31,32,33,34,35,36,37,38,39,41,42,43,44,45,46,47,48,49}
,new int[] {0,1,2,3,4,5,6,7,9,11,12,13,14,15,17,18,19,21,24,25,27,28,29,30,31,32,33,34,35,36,37,40,41,42,43,44,45,46,47,48,49}
,new int[] {0,1,3,4,5,6,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28,29,30,33,34,35,36,37,38,40,41,42,43,44,45,46,47,48}
,new int[] {0,1,3,4,5,6,12,16,17,19,20,22,23,25,26,28,29,30,31,32,33,35,36,38,40,42,45,46,47,48,49}
,new int[] {0,2,3,4,5,6,7,8,9,10,12,13,14,16,17,18,19,20,21,23,24,25,27,28,29,30,31,32,34,35,37,39,40,41,42,43,44,45,47}
,new int[] {1,2,3,4,5,7,8,10,11,14,15,16,17,19,22,23,24,25,26,28,29,31,32,33,34,35,37,38,39,40,41,43,44,47,48,49}
,new int[] {0,1,2,4,5,8,9,11,12,14,15,16,18,20,21,22,23,24,25,26,28,29,30,31,32,33,34,36,37,38,40,41,42,43,46,47,48,49}
,new int[] {1,5,6,7,8,9,10,11,12,14,15,16,17,19,20,21,23,25,27,28,29,30,31,32,33,35,36,37,38,40,42,43,45,47,49}
,new int[] {0,2,4,6,7,9,11,12,14,16,17,19,20,22,23,24,25,26,27,28,29,30,31,32,33,35,36,37,38,39,41,43,44,46,47,48,49}
,new int[] {0,1,2,3,4,7,9,10,11,12,14,15,17,18,21,22,23,24,25,26,27,28,31,32,33,34,35,36,40,41,42,43,45,46,47,48,49}
,new int[] {2,3,4,5,8,9,10,11,12,13,14,15,16,17,19,20,22,23,24,25,27,28,29,30,31,32,34,35,36,38,39,40,41,44,45,47,48,49}
,new int[] {0,1,2,3,4,5,7,8,9,10,11,13,15,16,18,20,21,22,24,27,28,29,30,31,33,34,35,36,38,39,40,41,42,44,45,46,47,48}
,new int[] {0,1,2,3,5,6,7,8,9,11,12,13,14,16,17,18,20,22,23,24,25,26,30,31,32,34,35,36,37,39,42,43,44,45,46,47,48,49}
,new int[] {0,1,2,3,5,6,8,9,10,12,14,15,16,17,18,19,21,22,23,24,25,26,27,28,30,31,33,34,35,36,37,40,42,45,46,47,48}
,new int[] {0,1,2,3,4,6,7,9,11,12,14,15,16,21,22,23,24,25,26,27,29,30,31,35,36,37,38,41,42,43,44,45,46,47,48,49}
,new int[] {1,5,6,8,9,10,12,13,16,18,19,21,22,23,26,27,28,29,30,31,32,33,34,35,38,39,41,44,45,46,48,49}
,new int[] {0,1,2,3,6,7,9,10,11,12,14,15,16,17,18,19,22,23,24,25,27,29,30,31,32,33,35,36,37,38,39,40,41,43,45,46,48,49}
,new int[] {0,2,4,5,7,9,10,11,13,14,15,19,21,22,23,24,26,27,29,30,31,32,35,36,37,38,39,40,42,43,44,45,47,48,49}
,new int[] {0,1,2,3,5,7,8,10,12,15,16,17,18,19,21,22,25,26,27,28,29,31,32,34,35,36,37,38,39,40,41,43,44,45,46,47,48,49}
,new int[] {0,1,3,4,6,7,8,11,14,15,16,17,18,19,25,27,28,30,32,33,35,37,38,40,41,43,44,45,46,47,48,49}
,new int[] {0,1,2,3,6,7,8,11,12,15,16,17,18,19,20,21,22,25,26,28,30,31,32,34,35,36,37,38,39,40,42,43,46,47,48,49}
,new int[] {2,3,4,5,6,7,10,11,12,13,14,15,17,21,22,24,25,26,27,28,29,30,31,32,33,34,35,39,40,41,42,43,44,45,46,47}
,new int[] {0,4,6,7,8,10,11,12,13,14,15,16,17,21,22,23,24,25,28,30,31,32,34,35,36,37,38,39,43,44,45,47,49}
,new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,28,31,32,33,34,35,36,37,38,39,40,41,42,43,45,46,47,48,49}
,new int[] {0,2,3,4,5,6,7,8,10,12,13,15,16,17,18,19,21,23,24,25,26,27,28,30,31,32,33,34,35,36,37,40,41,42,43,44,45,49}
,new int[] {0,1,2,3,4,5,6,7,9,12,13,14,15,16,18,19,20,22,23,24,25,26,27,29,30,31,32,33,35,36,38,39,40,41,42,43,44,46,48,49}
,new int[] {0,1,3,4,5,7,8,9,10,11,14,15,16,17,19,20,21,22,23,24,27,28,31,32,34,35,36,37,38,39,40,41,42,43,44,45,48}
,new int[] {1,2,3,4,5,8,9,13,15,16,17,18,19,22,24,27,29,32,33,34,35,37,38,39,40,41,43,44,45,46,47,49}
,new int[] {0,2,3,4,6,7,8,9,10,11,12,13,14,15,17,18,19,22,23,24,26,27,29,32,33,34,35,36,37,40,41,44,45,47,48,49}
,new int[] {0,1,2,3,4,5,7,8,9,10,13,15,17,18,19,20,22,23,24,25,26,27,30,31,32,34,35,37,38,39,40,42,44,45,46,47,48,49}
,new int[] {1,2,3,4,5,9,10,12,13,16,17,18,19,21,23,25,26,27,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44,46,48,49}
,new int[] {0,2,3,4,5,6,7,9,10,12,13,14,16,17,18,19,20,21,22,24,25,26,28,29,34,35,36,39,40,41,42,46,47,48}
,new int[] {0,1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,33,34,36,38,39,40,42,43,44,45,46,47,48,49}
,new int[] {0,2,4,5,6,10,11,12,13,14,16,17,18,19,21,22,23,27,28,29,30,32,33,34,35,36,38,40,41,42,43,44,46,47,48}
,new int[] {0,5,6,7,8,13,14,15,16,18,19,20,21,22,23,24,25,26,27,28,29,32,33,34,35,36,37,38,39,40,42,44,46,47,48,49}
,new int[] {0,1,2,3,4,6,7,8,9,10,11,12,13,15,16,17,18,19,21,23,25,26,27,29,30,31,32,33,34,36,37,38,39,40,41,42,43,44,45,47,49}
,new int[] {0,1,2,3,4,5,6,7,8,9,11,12,15,17,18,19,21,22,23,25,27,29,31,32,33,34,35,39,40,41,42,43,44,46,47,49}
,new int[] {1,3,5,7,8,9,12,14,15,16,17,18,19,20,22,23,24,25,27,28,30,31,32,33,34,35,39,40,43,45,47,48,49}
        };

        if (s.IsBipartite(graph1)) {
            Console.WriteLine("1 Was bipartite");
        } else {
            Console.WriteLine("1 Wasn't bipartite");
        }

        if (s.IsBipartite(graph2)) {
            Console.WriteLine("2 Was bipartite");
        } else {
            Console.WriteLine("2 Wasn't bipartite");
        }

        if (s.IsBipartite(graph3)) {
            Console.WriteLine("3 Was bipartite");
        } else {
            Console.WriteLine("3 Wasn't bipartite");
        }

        ParseGarbage();
        return 0;
    }
    
    public bool IsBipartite(int[][] graph) {
        Color[] graphColor = new Color[graph.Length];

        graphColor[0] = Color.Red;
        
        for (int i = 0; i < graph.Length; ++i) { // For each node
            for (int j = 0; j < graph[i].Length; ++j) { // For each connected edge in node
                int connectedNode = graph[i][j];
                if (graphColor[connectedNode] == Color.Uncolored) {
                    graphColor[connectedNode] = graphColor[i] == Color.Red ? Color.Blue : Color.Red;
                } else if (graphColor[connectedNode] != Color.Uncolored && graphColor[connectedNode] == graphColor[i]) {
                    Console.WriteLine($"Failed at {connectedNode}, {i}");
                    return false;
                }
            }
        }

        return true;
    }

    private static void ParseGarbage() {
        string g = "[[50,51,53,55,56,57,58,59,61,63,64,65,66,68,70,71,73,74,75,76,78,79,80,81,82,84,85,86,87,88,90,91,93,94,95,96,97,98],[50,52,54,56,57,58,59,60,61,63,64,65,67,68,69,71,73,74,75,76,77,78,80,81,82,85,87,88,89,91,92,94,97,98,99],[50,51,53,54,56,57,58,59,61,62,63,66,67,68,70,71,72,73,74,75,76,78,79,80,82,83,85,86,87,89,90,91,92,93,94,95,97,98],[51,52,53,54,57,58,59,62,63,64,65,66,67,71,72,73,74,75,76,78,80,81,82,83,85,86,87,88,89,90,91,92,93,94,97,98,99],[50,51,53,54,56,58,59,61,62,63,64,65,66,67,68,70,71,72,73,76,79,81,83,84,85,86,87,88,89,90,91,92,93,94,95,97,98],[50,53,55,58,59,61,62,63,64,65,66,67,68,69,72,73,74,75,77,79,80,83,85,86,87,88,89,91,92,93,94,95,96,98,99],[50,51,52,54,55,56,57,58,59,60,61,62,63,64,65,66,69,70,74,75,76,77,78,81,82,83,84,85,86,87,90,93,94,95,96,97,98],[50,51,52,53,55,57,58,59,60,61,62,63,66,67,69,70,71,73,74,76,78,79,80,81,82,83,84,85,86,87,88,90,91,93,94,96,97,98,99],[51,53,56,57,58,59,61,64,66,67,68,69,72,73,74,75,77,80,81,82,84,85,86,88,89,90,91,94,96,97,98,99],[50,51,53,54,55,56,57,58,59,60,61,62,63,64,66,68,69,70,71,72,73,74,75,76,77,78,79,85,87,88,89,90,91,92,93,97,98,99],[51,52,53,54,55,56,57,60,61,62,64,66,67,69,71,72,73,75,77,78,79,80,83,84,85,86,88,90,91,92,93,94,95,97],[51,53,54,55,57,58,62,63,64,67,68,69,70,71,72,73,74,76,78,79,81,82,83,84,85,88,90,94,95,97,98],[53,54,55,56,57,58,59,61,63,64,65,66,68,69,70,71,72,74,75,76,77,78,80,82,83,84,85,86,87,90,92,93,94,95,97,98,99],[52,53,55,56,57,59,60,63,64,66,72,73,74,77,79,83,84,85,86,87,89,90,91,92,93,94,95,96,97],[50,51,52,53,54,56,57,58,59,60,61,62,63,64,66,67,68,69,70,71,72,74,75,76,78,79,81,83,84,85,87,88,90,93,94,95,96,99],[50,51,53,54,55,58,59,60,62,63,64,67,68,69,71,72,73,75,76,78,79,80,81,82,83,84,85,86,87,88,89,90,91,94,96,97,98,99],[50,51,52,53,54,55,56,57,58,59,60,62,64,65,66,67,68,69,70,72,73,74,75,76,77,78,80,81,82,84,85,86,87,88,89,92,93,94,95,96,97,99],[50,51,52,53,54,55,56,57,58,59,60,61,63,64,65,66,67,69,70,71,72,74,75,78,80,81,82,83,84,85,86,88,89,90,91,92,93,94,95,97,98,99],[50,51,52,53,54,55,56,57,58,59,61,62,63,64,66,68,71,73,74,75,77,78,80,81,82,85,86,87,89,90,91,92,93,94,95,96,97,98,99],[50,51,52,53,54,55,56,57,58,60,61,62,63,64,65,66,67,69,70,72,75,77,78,79,80,81,82,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99],[50,51,52,53,54,55,56,57,58,59,60,61,62,64,65,66,68,69,70,72,73,74,82,87,88,91,93,94,96,99],[50,51,52,56,58,60,61,62,63,64,66,68,69,71,73,75,76,77,79,80,82,83,84,85,86,88,92,93,94,95,96,97,98],[51,52,53,54,55,56,57,58,59,60,61,62,64,65,67,68,70,71,72,73,74,75,76,77,78,79,80,82,83,84,85,87,88,89,90,91,93,94,95,96,98,99],[52,53,54,55,56,57,58,59,60,61,64,65,66,67,68,69,70,71,72,74,75,76,77,78,79,84,85,86,87,88,90,91,92,94,95,96,97,98,99],[51,53,55,56,57,58,59,60,62,63,64,66,67,68,70,71,72,73,74,75,76,78,79,83,84,85,86,87,88,89,90,91,93,94,96,99],[50,51,52,53,54,57,59,60,61,62,63,65,66,67,68,69,70,71,72,74,75,76,78,80,81,82,83,84,85,86,87,91,92,93,94,96,97,98,99],[50,51,52,53,54,55,57,58,59,60,61,62,64,65,67,68,70,71,74,75,76,77,79,80,82,83,85,86,87,90,91,92,93,94,96,97],[50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,69,70,71,72,73,75,76,77,78,79,80,81,83,86,87,88,89,90,91,92,94,95,96,97,98,99],[50,52,53,56,58,59,61,63,64,65,66,67,68,69,70,71,72,73,75,77,80,81,82,83,84,85,86,88,93,94,95,96,99],[50,51,53,54,55,57,59,61,63,64,65,66,67,68,69,70,72,73,76,77,78,79,80,83,87,89,90,92,93,94,95,96,97,98],[50,51,52,54,55,56,57,59,60,62,63,64,65,66,68,69,70,72,73,74,75,76,77,78,79,81,82,83,84,86,87,91,92,94,95,97,99],[50,51,52,53,55,56,59,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,82,83,84,85,86,87,88,91,92,94,97,98,99],[50,51,53,59,61,62,63,65,66,67,68,69,70,71,72,74,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,95,96,97,98,99],[50,53,54,55,56,57,59,61,62,63,64,65,67,68,69,70,71,73,75,77,78,81,83,85,86,87,89,90,92,94,95,96,97,98,99],[50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,67,68,71,72,73,74,75,77,80,82,83,84,85,86,88,89,90,91,92,93,94,95,96,97,98,99],[50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,95,96,98,99],[50,51,52,53,54,56,57,58,59,61,62,63,64,65,68,69,70,71,72,73,74,75,76,78,79,80,82,84,85,86,87,88,90,92,93,94,95,96,97],[50,52,53,55,56,60,61,62,63,64,66,67,68,69,70,74,75,76,78,79,80,81,82,84,85,86,88,89,90,91,92,96,97],[50,51,52,53,54,55,56,57,58,59,60,61,62,64,65,67,68,69,70,72,73,76,77,78,79,80,81,82,84,85,87,88,89,91,92,94,95,96,97],[50,51,52,55,56,57,58,59,60,61,62,66,67,70,72,73,74,77,78,79,80,82,83,84,85,87,88,89,91,92,93,94,96,97,98,99],[50,51,52,54,56,58,59,61,63,64,65,66,67,68,69,71,72,73,75,78,79,80,81,82,83,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99],[50,51,52,53,54,55,57,59,60,61,62,63,64,66,67,68,70,71,72,73,76,77,78,80,81,83,85,86,87,88,89,90,93,95,97,98],[50,51,54,55,57,58,59,60,61,62,63,64,65,66,68,69,71,73,74,75,76,79,82,83,85,86,87,88,91,92,93,94,95,96,97,98],[50,52,54,55,56,58,59,60,61,62,63,64,66,67,68,69,70,71,74,76,78,79,80,81,82,83,84,85,86,87,88,89,92,94,95,97,98,99],[50,51,52,53,55,56,57,58,59,60,61,62,63,64,66,67,70,72,73,74,76,77,79,80,81,83,84,86,87,88,89,90,91,92,94,95,96,97,98],[50,51,52,56,57,58,60,62,63,64,65,66,69,71,72,73,74,75,76,77,78,79,80,81,83,84,85,86,88,89,90,91,94,97,99],[51,52,53,54,55,58,59,60,61,62,63,64,65,68,70,71,73,74,75,76,77,78,80,81,82,83,85,87,89,91,92,93,94,95,96,98],[50,51,52,54,55,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,79,80,81,82,83,84,85,89,90,91,93,94,95,96,97,98,99],[51,52,53,54,55,56,57,58,60,62,63,64,65,67,68,70,71,72,73,74,75,76,77,78,79,80,81,82,85,87,88,90,91,92,93,94,95,96,99],[50,51,52,53,54,56,58,59,60,61,62,63,65,67,68,69,70,71,72,74,76,77,78,79,80,81,82,84,85,86,87,89,90,91,92,94,96,97,98,99],[0,1,2,4,5,6,7,9,14,15,16,17,18,19,20,21,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,47,49],[0,2,3,4,6,7,8,9,10,11,14,15,16,17,18,19,20,21,22,24,25,26,27,29,30,31,32,34,35,36,38,39,40,41,42,44,45,46,47,48,49],[1,3,6,7,10,13,14,16,17,18,19,20,21,22,23,25,26,27,28,30,31,34,35,36,37,38,39,40,41,43,44,45,46,47,48,49],[0,2,3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,41,44,46,48,49],[1,2,3,4,6,9,10,11,12,14,15,16,17,18,19,20,22,23,25,26,29,30,33,35,36,38,40,41,42,43,46,47,48,49],[0,5,6,7,9,10,11,12,13,15,16,17,18,19,20,22,23,24,26,27,29,30,31,33,34,35,37,38,39,41,42,43,44,46,47,48],[0,1,2,4,6,8,9,10,12,13,14,16,17,18,19,20,21,22,23,24,27,28,30,31,33,34,35,36,37,38,39,40,43,44,45,48,49],[0,1,2,3,6,7,8,9,10,11,12,13,14,16,17,18,19,20,22,23,24,25,26,27,29,30,33,34,35,36,38,39,41,42,44,45,47,48],[0,1,2,3,4,5,6,7,8,9,11,12,14,15,16,17,18,19,20,21,22,23,24,26,27,28,34,35,36,38,39,40,42,43,44,45,46,47,48,49],[0,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17,18,20,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,38,39,40,41,42,43,44,46,49],[1,6,7,9,10,13,14,15,16,17,19,20,21,22,23,24,25,26,27,30,31,34,35,37,38,39,41,42,43,44,45,46,48,49],[0,1,2,4,5,6,7,8,9,10,12,14,17,18,19,20,21,22,23,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,46,47,49],[2,3,4,5,6,7,9,10,11,14,15,16,18,19,20,21,22,24,25,26,27,30,31,32,33,34,35,36,37,38,39,41,42,43,44,45,46,47,48,49],[0,1,2,3,4,5,6,7,9,11,12,13,14,15,17,18,19,21,24,25,27,28,29,30,31,32,33,34,35,36,37,40,41,42,43,44,45,46,47,48,49],[0,1,3,4,5,6,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28,29,30,33,34,35,36,37,38,40,41,42,43,44,45,46,47,48],[0,1,3,4,5,6,12,16,17,19,20,22,23,25,26,28,29,30,31,32,33,35,36,38,40,42,45,46,47,48,49],[0,2,3,4,5,6,7,8,9,10,12,13,14,16,17,18,19,20,21,23,24,25,27,28,29,30,31,32,34,35,37,39,40,41,42,43,44,45,47],[1,2,3,4,5,7,8,10,11,14,15,16,17,19,22,23,24,25,26,28,29,31,32,33,34,35,37,38,39,40,41,43,44,47,48,49],[0,1,2,4,5,8,9,11,12,14,15,16,18,20,21,22,23,24,25,26,28,29,30,31,32,33,34,36,37,38,40,41,42,43,46,47,48,49],[1,5,6,7,8,9,10,11,12,14,15,16,17,19,20,21,23,25,27,28,29,30,31,32,33,35,36,37,38,40,42,43,45,47,49],[0,2,4,6,7,9,11,12,14,16,17,19,20,22,23,24,25,26,27,28,29,30,31,32,33,35,36,37,38,39,41,43,44,46,47,48,49],[0,1,2,3,4,7,9,10,11,12,14,15,17,18,21,22,23,24,25,26,27,28,31,32,33,34,35,36,40,41,42,43,45,46,47,48,49],[2,3,4,5,8,9,10,11,12,13,14,15,16,17,19,20,22,23,24,25,27,28,29,30,31,32,34,35,36,38,39,40,41,44,45,47,48,49],[0,1,2,3,4,5,7,8,9,10,11,13,15,16,18,20,21,22,24,27,28,29,30,31,33,34,35,36,38,39,40,41,42,44,45,46,47,48],[0,1,2,3,5,6,7,8,9,11,12,13,14,16,17,18,20,22,23,24,25,26,30,31,32,34,35,36,37,39,42,43,44,45,46,47,48,49],[0,1,2,3,5,6,8,9,10,12,14,15,16,17,18,19,21,22,23,24,25,26,27,28,30,31,33,34,35,36,37,40,42,45,46,47,48],[0,1,2,3,4,6,7,9,11,12,14,15,16,21,22,23,24,25,26,27,29,30,31,35,36,37,38,41,42,43,44,45,46,47,48,49],[1,5,6,8,9,10,12,13,16,18,19,21,22,23,26,27,28,29,30,31,32,33,34,35,38,39,41,44,45,46,48,49],[0,1,2,3,6,7,9,10,11,12,14,15,16,17,18,19,22,23,24,25,27,29,30,31,32,33,35,36,37,38,39,40,41,43,45,46,48,49],[0,2,4,5,7,9,10,11,13,14,15,19,21,22,23,24,26,27,29,30,31,32,35,36,37,38,39,40,42,43,44,45,47,48,49],[0,1,2,3,5,7,8,10,12,15,16,17,18,19,21,22,25,26,27,28,29,31,32,34,35,36,37,38,39,40,41,43,44,45,46,47,48,49],[0,1,3,4,6,7,8,11,14,15,16,17,18,19,25,27,28,30,32,33,35,37,38,40,41,43,44,45,46,47,48,49],[0,1,2,3,6,7,8,11,12,15,16,17,18,19,20,21,22,25,26,28,30,31,32,34,35,36,37,38,39,40,42,43,46,47,48,49],[2,3,4,5,6,7,10,11,12,13,14,15,17,21,22,24,25,26,27,28,29,30,31,32,33,34,35,39,40,41,42,43,44,45,46,47],[0,4,6,7,8,10,11,12,13,14,15,16,17,21,22,23,24,25,28,30,31,32,34,35,36,37,38,39,43,44,45,47,49],[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,28,31,32,33,34,35,36,37,38,39,40,41,42,43,45,46,47,48,49],[0,2,3,4,5,6,7,8,10,12,13,15,16,17,18,19,21,23,24,25,26,27,28,30,31,32,33,34,35,36,37,40,41,42,43,44,45,49],[0,1,2,3,4,5,6,7,9,12,13,14,15,16,18,19,20,22,23,24,25,26,27,29,30,31,32,33,35,36,38,39,40,41,42,43,44,46,48,49],[0,1,3,4,5,7,8,9,10,11,14,15,16,17,19,20,21,22,23,24,27,28,31,32,34,35,36,37,38,39,40,41,42,43,44,45,48],[1,2,3,4,5,8,9,13,15,16,17,18,19,22,24,27,29,32,33,34,35,37,38,39,40,41,43,44,45,46,47,49],[0,2,3,4,6,7,8,9,10,11,12,13,14,15,17,18,19,22,23,24,26,27,29,32,33,34,35,36,37,40,41,44,45,47,48,49],[0,1,2,3,4,5,7,8,9,10,13,15,17,18,19,20,22,23,24,25,26,27,30,31,32,34,35,37,38,39,40,42,44,45,46,47,48,49],[1,2,3,4,5,9,10,12,13,16,17,18,19,21,23,25,26,27,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44,46,48,49],[0,2,3,4,5,6,7,9,10,12,13,14,16,17,18,19,20,21,22,24,25,26,28,29,34,35,36,39,40,41,42,46,47,48],[0,1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,33,34,36,38,39,40,42,43,44,45,46,47,48,49],[0,2,4,5,6,10,11,12,13,14,16,17,18,19,21,22,23,27,28,29,30,32,33,34,35,36,38,40,41,42,43,44,46,47,48],[0,5,6,7,8,13,14,15,16,18,19,20,21,22,23,24,25,26,27,28,29,32,33,34,35,36,37,38,39,40,42,44,46,47,48,49],[0,1,2,3,4,6,7,8,9,10,11,12,13,15,16,17,18,19,21,23,25,26,27,29,30,31,32,33,34,36,37,38,39,40,41,42,43,44,45,47,49],[0,1,2,3,4,5,6,7,8,9,11,12,15,17,18,19,21,22,23,25,27,29,31,32,33,34,35,39,40,41,42,43,44,46,47,49],[1,3,5,7,8,9,12,14,15,16,17,18,19,20,22,23,24,25,27,28,30,31,32,33,34,35,39,40,43,45,47,48,49]]";
        string r = "";
        for (int i = 0; i < g.Length; ++i) {
            if (g[i] == '[')
                r += "new int[] {";
            else if (g[i] == ']')
                r += "}\n";
            else {
                r = r + g[i];
            }
        }

        //Console.WriteLine(r);
    }

    enum Color {
        
        Uncolored,
        Red,
        Blue,
    };
}