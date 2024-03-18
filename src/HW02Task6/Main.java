package HW02Task6;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static final Double g = 10.0;

    public static void main(String[] args) {

    }

    public static List<Double> calculateAccelerations(
            Double M1,
            Double M2,
            Double M3,
            Double myu1,
            Double myu2,
            Double myu3)
    {
        List<Double> accelerations = new ArrayList<>();
        Double T = calculateTension(M1, M2, M3, myu1, myu2, myu3);
        Double a1 = (T * (1 + myu1) + M1 * myu1 * g)/(M1 + M3);
        Double a2 = myu2 * g - T/M2;
        Double a3 = T/M3 - g - myu3 * a1;
        accelerations.add(a1);
        accelerations.add(a2);
        accelerations.add(a3);
        return accelerations;
    }

    public static Double calculateMaximalDistance(List<Double> accelerations, Double L)
    {
        Double t = calculateTimeToReachMaxVelocity(L, accelerations.get(2));
        return accelerations.get(1) * t * t;
    }

    public static Double calculateTimeToReachMaxVelocity(Double L, Double a3)
    {
        return Math.sqrt(2 * L / a3);
    }

    public static Double calculateMaxVelocity(Double a1, Double t)
    {
        return a1 * t;
    }

    public static Double calculateTension(
            Double M1,
            Double M2,
            Double M3,
            Double myu1,
            Double myu2,
            Double myu3)
    {
        return (-1 * g * (myu2 + 1) + ((M1 * myu1 * g)/(M1 + M3)) * (1 - myu3))
                /((1 + myu1)/(M1 + M3) * (myu3 - 1) - 1/M2 - 1/M3);
    }
}

