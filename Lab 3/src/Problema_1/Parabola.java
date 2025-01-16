package Problema_1;

public class Parabola
{
    private int a, b, c;

    Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] varf()
    {
        double x,y;
        x=-b/(2*a);
        y=(-(b*b)+4*a*c)/4*a;
        return new double[]{x,y};
    }

    public double mijloc(Parabola p)
    {
        double x,y;
        double[] varf1=this.varf() ,varf2=p.varf() ;
        x=(varf1[0]+varf2[0])/2;
        y=(varf1[1]+varf2[1])/2;
        double hypot = Math.hypot(x, y);
        return hypot;
    }

    @Override
    public String toString()
    {
        return "f(x)= " + a +"*x^2+"+ b + "*x+"+ c;
    }
}
