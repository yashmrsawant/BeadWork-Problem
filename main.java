/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beadworkproblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Yash M Sawant 
 * For the sake of the quote "Only God and I know what i
 * am doing when i wrote this, now only He knows" Small description 
 * Standard convention : Anti-clockwise
 *
 * Any regular polygon of n vertices is supposed to have centre at origin O(0,
 * 0) and <code>Sides</code> is an array of sides n which denotes length of side
 * connected to that index assuming anti-clockwise convention and also the
 * inclination with the x-axis <code>beads</code> is 2D array of size 2*n
 * denoting beads on the surface one column is for x-coordinate and another for
 * y-coordinate.
 */
public class BeadWorkProblem {

    /**
     * @param args the command line arguments
     */
    static double[][] beads = null;
    static double[][] sides = null;

    public static void main(String[] args) {
        int n = 0;
        final int radius = 1;//in standard unit
        try {
            n = Integer.parseInt(
                    (new BufferedReader(new InputStreamReader(System.in))).readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * <code>Sides['index'][0]</code> denoting length
         * <code>Sides['index'][1]</code> denoting angle with x-axis.
         */
        sides = new double[n][2];

        /**
         * <code>beads['index'][0]</code> denoting x
         * <code>beads['index'][1]</code> denoting y
         * <code>beads['index'][2]</code> denoting velocity
         * <code>beads['index'][3]</code> denoting the angle of the velocity
         * vector.
         */
        beads = new double[n][3];

        double theta = (Math.PI * 2) / n;
        for (int i = 0; i < n; i++) {
            beads[i][0] = radius * Math.cos(theta * i);
            beads[i][1] = radius * Math.sin(theta * i);
            if (i != 0) {
                //Calculating sides for id not equal to 1
                sides[i][0] = Math.sqrt(Math.pow((beads[i - 1][0] - beads[(i + 1) % n][0]), 2.0)
                        + Math.pow((beads[i - 1][1] - beads[(i + 1) % n][1]), 2.0));
            }
            /*
             * Code Segment calculating the angle of inclination of sides with x-axis
             */
            sides[i][1] = Math.atan((Math.sin(theta * ((i + 1) % n)) - Math.sin(theta * i))
                    / (Math.cos(theta * ((i + 1) % n)) - Math.sin(theta * i))) * (180 / Math.PI);
            System.out.println(sides[i][1]);
        }
        //Calculating side for id = 0;
        sides[0][1] = Math.sqrt(Math.pow((beads[1][0] - beads[n - 1][0]), 2.0)
                + Math.pow((beads[1][1] - beads[n - 1][1]), 2.0));
        int id = 0;
        try {
            id = Integer.parseInt(
                    (new BufferedReader(new InputStreamReader(System.in))).readLine());
        } catch (Exception e) {
        }
        changeIn(id, n);
    }

    public static void changeIn(int id, int n) {
        //Change in id
        boolean[] changes = new boolean[n];
        for (int i = 0; i < n; i++) {
            changes[i] = false;
        }
        changes[id] = true;
        try {
            beads[id][0] = Integer.parseInt(
                    (new BufferedReader(new InputStreamReader(System.in))).readLine());
            beads[id][1] = Integer.parseInt(
                    (new BufferedReader(new InputStreamReader(System.in))).readLine());
        } catch (Exception e) {
        }
        final double dx = 0.000000001;
        final double dy = 0.000000001;

        while (true) {
            for (int i = 0; i < n; i++) {
                if (changes[i] == true) {
                    if (i == 0) {
                        changes[n - 1] = true;
                        changes[1] = true;
                    } else {
                        changes[i - 1] = true;
                        changes[i + 1] = true;
                    }
                    changes[i] = false;
                    //Calculate the angle to move wrt axis presumed
                    double thetaInDeg = thetaCalc(i);
                }
            }
        }
    }

    public static double thetaCalc(int id) {
        /*
         * Supposed to return the angle in degrees to which bead with id <code>id</code> is 
         * experiencing accelaration
         */
        return 0.0;
    }
}
