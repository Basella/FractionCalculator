public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException();
        } else if (den < 0) {
            this.numerator = - num;
            this.denominator = Math.abs(den);
        } else {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public Fraction (int n) {
        this.numerator = n;
        this.denominator = 1;
    }

    public Fraction () {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return (this.numerator + " / " + this.denominator);
    }

    public double toDouble () {
        return (double) numerator / denominator;
    }

    public Fraction add (Fraction other) {
        int num =(this.numerator * other.denominator) + (other.numerator * this.denominator);
        int dem= (this.denominator * other.denominator);
        return new Fraction(num, dem);
    }

    public Fraction subtract (Fraction other) {
        int num =(this.numerator * other.denominator) - (other.numerator * this.denominator);
        int dem= (this.denominator * other.denominator);
        return new Fraction(num, dem);
    }

    public Fraction multiply (Fraction other) {
        int num =(this.numerator * other.denominator) * (other.numerator * this.denominator);
        int dem= (this.denominator * other.denominator);
        return new Fraction(num, dem);
    }

    public Fraction divide (Fraction other) {
        int num =(this.numerator * other.denominator) / (other.numerator * this.denominator);
        int dem= (this.denominator * other.denominator);
        return new Fraction(num, dem);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction otherAdd = (Fraction) other;
            if (otherAdd.equals(this)) {
                return true;
            }
        }
        return true;
    }

    public void toLowestTerms () {
        int gcdValue = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator/gcdValue;
        this.denominator = this.numerator/gcdValue;
    }

    public static int gcd(int num, int den) {
        while (num != 0 && den != 0){
            int div = num % den;
            num = den;
            den = div;
        }
        return num;
    }
}