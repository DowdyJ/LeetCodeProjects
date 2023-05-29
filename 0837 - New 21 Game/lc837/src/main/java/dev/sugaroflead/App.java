package dev.sugaroflead;

public class App 
{
    public static void main( String[] args )
    {
        App a = new App();
        System.out.println("ODDS " + a.hueristicCheck(21, 17, 10));
    }

    public double new21Game(int n, int k, int maxPts) {

        return hueristicCheck(n, k, maxPts);
    }

    // works with sufficient runs
    private double hueristicCheck(int n, int k, int maxPts) {
        int currentPoints = 0;
        final int totalDraws = 10000000;
        int drawsPerformed = 0;
        int lessThanNDraws = 0;
        while (++drawsPerformed < totalDraws) {
            while (currentPoints < k) {
                currentPoints += Math.round(Math.random() * maxPts);
            }

            if (currentPoints <= n)
                lessThanNDraws++;

            currentPoints = 0;
        }

        return (double)lessThanNDraws / (double)totalDraws;
    }
}
