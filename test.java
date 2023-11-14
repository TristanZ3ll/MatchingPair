import java.math.BigInteger;
public class Rational extends Number implements Comparable<Rational>{
    //Data files for numerator and denominator
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    //Construct a rational with defualt properties
    public Rational(){}

    public Rational(String newNumerator, String newDenominator){
        numerator = new BigInteger(newNumerator);
        denominator = new BigInteger(newDenominator);

        BigInteger GCD = numerator.gcd(denominator);
        switch(denominator.compareTo(BigInteger.ZERO)){
            case 1:
                this.numerator = numerator.divide(GCD);
                break;
            case -1:
                this.numerator = BigInteger.ONE.negate().multiply(numerator).divide(GCD);
                break;
        }
        this.denominator = denominator.abs().divide(GCD);

    }
        
    //returns numerator
    public BigInteger getNumerator(){
        return numerator;
    }

    public BigInteger getDenominator(){
        return denominator;
    }
    
    /** Add a rational number to this rational */
    public Rational add(Rational secondRational){
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator())); //yeah thats readable, im sure
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        System.out.println(n.toString()+ " " + d.toString());
        return(new Rational(n.toString(), d.toString()));
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational){
        
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
         BigInteger d = denominator.multiply(secondRational.getDenominator());
         return(new Rational(n.toString(),d.toString()));
    }
    //Multiply a rational number from this rational
     public Rational multiply(Rational secondRational){
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
         return(new Rational(n.toString(),d.toString()));
        }
        //divide a rational number from this rational

    public Rational divide(Rational secondRational){
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
         return(new Rational(n.toString(),d.toString()));
         }

         @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
       else
         return numerator + "/" + denominator;
     }


     @Override // Override the equals method in the Object class
     public boolean equals(Object other) {
        if ((this.subtract((Rational)(other))).getNumerator() == BigInteger.ONE)
            return true;
        else    
            return false;
     }

     @Override // Implement the abstract intValue method in Number
     public int intValue() {
        return (int)doubleValue();
     }

     @Override // Implement the abstract floatValue method in Number
     public float floatValue() {
        return (float)doubleValue();
    }
    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() * 1 / denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }
    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        return(this.subtract(o).getNumerator().compareTo(BigInteger.ZERO));
    }
}