import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] c = new int[14];
        for (int i = 2; i < 16; i++) {
            c[i - 2] = i;
        }

        double[] x = new double[12];
        for (int j = 0; j < 12; j++) {
            x[j] = rand.nextDouble(-15, 8);
        }

        double[][] twoDimArray = new double[14][12];
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 12; j++) {
                if (c[i] == 14) twoDimArray[i][j] = Math.tan(Math.sin(Math.atan((x[j] - 3.5) / 23)));
                else if (c[i] == 2 || c[i] == 3 || c[i] == 4 || c[i] == 5 || c[i] == 9 || c[i] == 10 || c[i] == 15) {
                    twoDimArray[i][j] = Math.tan(Math.pow((Math.pow((((3 / 4) - Math.tan(x[j])) / 2), (0.25 / x[j]))), x[j]));
                } else {
                    twoDimArray[i][j] = Math.sin((Math.log(4 / (2 * Math.PI + Math.abs(x[j])))) * (Math.log(Math.sqrt(2 * Math.PI / (5 + Math.abs(x[j])))) - 1));
                }
            }
        }
        for (double[] row : twoDimArray) {
            //for (double i : row) {
            for(int i = 0; i < row.length; i++){
                String str = String.format("%.3f", row[i]);
                System.out.printf("%15s", str);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}