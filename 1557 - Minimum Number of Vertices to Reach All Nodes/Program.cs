using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.IO;
using System.Linq;

namespace LC1557 
{
    public class Program {
        public static int Main(string[] args) {

            Solution s = new Solution();

            //[[0,1],[0,2],[2,5],[3,4],[4,2]]
            List<int> answer = s.FindSmallestSetOfVertices(6, new List<List<int>>() {
                new List<int>() {0,1},
                new List<int>() {0,2},
                new List<int>() {2,5},
                new List<int>() {3,4},
                new List<int>() {4,2},
            });

            foreach (int i in answer) {
                Console.WriteLine(i);
            }


            return 0;
        }
    }


    public class Solution {
        public List<int> FindSmallestSetOfVertices(int n, List<List<int>> edges) {
            
            HashSet<int> valuesWithParent = new HashSet<int>();
            HashSet<int> nodeKeys = new HashSet<int>();

            foreach (var edge in edges) {
                if (!valuesWithParent.Contains(edge[1]))
                    valuesWithParent.Add(edge[1]);
                if (!nodeKeys.Contains(edge[0]))
                    nodeKeys.Add(edge[0]);
            }
            
            nodeKeys.ExceptWith(valuesWithParent);
            return nodeKeys.ToList();
        }
    }
}




