package dev.sugaroflead.lc1376;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public class Employee {
        public Employee() {
            this.subordinates = new ArrayList<>();
        }
        public int informTime;
        public List<Employee> subordinates;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; ++i) {
            employees[i] = new Employee();
            employees[i].informTime = informTime[i];
        }

        for (int i = 0; i < n; ++i) {
            if (manager[i] != -1)
                employees[manager[i]].subordinates.add(employees[i]);
        }

        int[] result = new int[] {0};
        DFS(employees[headID], result);

        return result[0];
    }


    private void DFS(Employee employee, int[] accumulatedTimeTaken) {
        if (employee.subordinates.size() == 0)
            return;

        ArrayList<Integer> results = new ArrayList<Integer>() {};

        accumulatedTimeTaken[0] += employee.informTime;
        
        int[] timeTaken = new int[1];
        for (Employee e : employee.subordinates) {
            timeTaken[0] = accumulatedTimeTaken[0];
            DFS(e, timeTaken);
            results.add(timeTaken[0]);
        }
        
        accumulatedTimeTaken[0] = Collections.max(results);

        return;
    }
}
