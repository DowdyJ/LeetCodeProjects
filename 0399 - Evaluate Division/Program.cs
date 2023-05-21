using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.IO;
using System.Linq;

namespace LC785;

public class Solution {
    public static int Main(string[] args) {
        var s = new Solution();
        
        foreach (double n in s.CalcEquation(
            new List<List<string>>() {
                new List<string>() {"a", "b"},
                new List<string>() {"b", "c"}
            },
            new double[] {2.0, 3.0},
            new List<List<string>>() {
                new List<string>() {"a","c"},
                new List<string>() {"b","a"},
                new List<string>() {"a","e"},
                new List<string>() {"a","a"},   
                new List<string>() {"x","x"},               
            }
            )) {
                Console.WriteLine(n.ToString());
            }
        return 0;
    }

    public double[] CalcEquation(List<List<string>> equations, double[] values, List<List<string>> queries) {
        Dictionary<string, List<EquationData>> nodeDataDictionary = MakeGraphDictionary(equations, values, queries);

        List<double> queryResults = new List<double>(queries.Count);
        HashSet<string> seenNodes = new HashSet<string>();

        foreach (var query in queries) {
            seenNodes.Clear();
            double resultValue = ResolveQueryDFS(query[0], query[1], 1, nodeDataDictionary, seenNodes);
            queryResults.Add(resultValue);
        }

        return queryResults.ToArray();
    }


    private double ResolveQueryDFS(string destinationNode, string currentNode, double queryResult, Dictionary<string, List<EquationData>> graphData, HashSet<string> visitedNodes) {
        if (!graphData.ContainsKey(destinationNode) || !graphData.ContainsKey(currentNode))
            return -1;

        if (currentNode == destinationNode)
            return queryResult;

        if (!visitedNodes.Contains(currentNode))
            visitedNodes.Add(currentNode);
        
        foreach (EquationData ed in graphData[currentNode]) {
            if (visitedNodes.Contains(ed.var))
                continue;

            visitedNodes.Add(ed.var);

            double result = ResolveQueryDFS(
                destinationNode, 
                ed.var, 
                queryResult * ed.result, 
                graphData, 
                visitedNodes);

            if (result != -1)
                return result;
        }

        return -1;
    }

    private Dictionary<string, List<EquationData>> MakeGraphDictionary(List<List<string>> equations, double[] values, List<List<string>> queries) {
        Dictionary<string, List<EquationData>> equationDictionary = new();

        int valueIndex = 0;

        foreach (var equation in equations) {
            AddEquationData(equationDictionary, equation, values[valueIndex]);
            valueIndex++;
        }

        return equationDictionary;
    }

    private void AddEquationData(Dictionary<string, List<EquationData>> equationDictionary, IList<string> equation, double result) {

        if (!equationDictionary.ContainsKey(equation[0])) {
            equationDictionary.Add(equation[0], new List<EquationData>());
        }

        equationDictionary[equation[0]].Add(new EquationData(equation[1], 1 / result));

        if (!equationDictionary.ContainsKey(equation[1])) {
            equationDictionary.Add(equation[1], new List<EquationData>());
        }

        equationDictionary[equation[1]].Add(new EquationData(equation[0], result));

        return;
    }


    private struct EquationData {
        public EquationData(string var, double result) {
            this.var = var;
            this.result = result;
        }

        public readonly string var;
        public readonly double result;
    };
}