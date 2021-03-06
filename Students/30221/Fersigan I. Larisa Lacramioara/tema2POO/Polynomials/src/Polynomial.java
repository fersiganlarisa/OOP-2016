
public class Polynomial {

	 private int[] coef;  // coefficients
	    private int deg;	//degree
	    // a * x^b
	    public Polynomial(int a, int b) {
	        coef = new int[b+1];
	        coef[b] = a;
	        deg = degree();
	    }
	    public int degree() {
	        int d = 0;
	        for (int i = 0; i < coef.length; i++)
	            if (coef[i] != 0)
	            	d = i;
	        return d;
	    }
	    //Sum c = a + b
	    public Polynomial add(Polynomial b) {
	    	Polynomial a = this;
	    	Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
	        for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
	        for (int i = 0; i <= b.deg; i++) c.coef[i] += b.coef[i];
	        c.deg = c.degree();
	        return c;
	    }
	    //substract c=a-b
	    public Polynomial substract(Polynomial b) {
	    	Polynomial a = this;
	    	Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
	        for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
	        for (int i = 0; i <= b.deg; i++) c.coef[i] -= b.coef[i];
	        c.deg = c.degree();
	        return c;
	    }
	    //multiply (a * b)
	    public Polynomial multiply(Polynomial b) {
	    	Polynomial a = this;
	    	Polynomial c = new Polynomial(0, a.deg + b.deg);
	        for (int i = 0; i <= a.deg; i++)
	            for (int j = 0; j <= b.deg; j++)
	                c.coef[i+j] += (a.coef[i] * b.coef[j]);
	        c.deg = c.degree();
	        return c;
	    }
	    //multiply with scalar
	    public Polynomial multiplyScalar(int j) {
	    	Polynomial a = this;
	    	Polynomial c = new Polynomial(0, a.deg);
	        for (int i = 0; i <= a.deg; i++)
    			c.coef[i] += j * a.coef[i];
    		c.deg = c.degree();
    		return c;
	    }
	    public String toString() {
	        if (deg ==  0) return "" + coef[0];
	        if (deg ==  1) return coef[1] + "x + " + coef[0];
	        String s = coef[deg] + "x^" + deg;
	        for (int i = deg-1; i >= 0; i--) {
	            if      (coef[i] == 0) continue;
	            else if (coef[i]  > 0) s = s + " + " + ( coef[i]);
	            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
	            if      (i == 1) s = s + "x";
	            else if (i >  1) s = s + "x^" + i;
	        }
	        return s;
	    }
	    public int evaluate(int x) {
	        int p = 0;
	        for (int i = deg; i >= 0; i--)
	            p = coef[i] + (x * p);
	        return p;
	    }    
	  }
