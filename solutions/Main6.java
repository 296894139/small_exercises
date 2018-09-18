import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main6 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {


            double x0 = in.nextFloat();
            double y0 = in.nextFloat();
            double z0 = in.nextFloat();
            double x1 = in.nextFloat();
            double y1 = in.nextFloat();
            double z1 = in.nextFloat();
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(3);
            nf.setRoundingMode(RoundingMode.UP);
            double r = Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0));

            double v=4.0/3.0*Math.acos(-1)*r*r*r;
            System.out.printf("%.3f",r);
            System.out.print(" ");
            System.out.printf("%.3f",v);

        }
    }
}
