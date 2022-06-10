import java.math.BigInteger;
import java.util.HashMap;

public class test
{
    HashMap<String, BigInteger> memo = new HashMap<>();
    public BigInteger gridTraveller(BigInteger m, BigInteger n)
    {

        String key = m.intValue() + "," + n.intValue();

       if(memo.containsKey(key)) return memo.get(key);
       if(m.compareTo(BigInteger.ONE) == 0 && n.compareTo(BigInteger.ONE) == 0) return BigInteger.ONE;
       if(m.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ZERO;
       memo.put(key, gridTraveller(m.subtract(BigInteger.ONE), n).add(gridTraveller(m, n.subtract(BigInteger.ONE))));
       return memo.get(key);
    }

    public static void main(String...args)
    {
        test obj = new test();
        System.out.println(obj.gridTraveller(BigInteger.ONE,BigInteger.ONE));
        System.out.println(obj.gridTraveller(BigInteger.TWO,BigInteger.valueOf(3)));
        System.out.println(obj.gridTraveller(BigInteger.valueOf(3),BigInteger.TWO));
        System.out.println(obj.gridTraveller(BigInteger.valueOf(3),BigInteger.valueOf(3)));
        System.out.println(obj.gridTraveller(BigInteger.valueOf(18),BigInteger.valueOf(18)));
    }
}
