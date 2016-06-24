package dennis.taschenrechner;

public class Taschenrechner {
	public int add(int x, int y) throws IntegerOverflowException {
		try {
			return Math.addExact(x, y);
		} catch (ArithmeticException e) {
			throw new IntegerOverflowException();
		}
	}

	public int sub(int x, int y) throws IntegerOverflowException{
		try{
			return Math.subtractExact(x, y);
		}catch(ArithmeticException e){
			throw new IntegerOverflowException();
		}
	}
	
	public int mul(int x, int y) throws IntegerOverflowException{
		try{
		return Math.multiplyExact(x, y);
		}catch(ArithmeticException e){
			throw new IntegerOverflowException();
		}
	}
	public static void main(String[] args) throws IntegerOverflowException{
		int grosserWert = 2;
		Taschenrechner tr = new Taschenrechner();
		try{
		while(true){
			grosserWert = tr.mul(grosserWert, 2);
			System.out.println(grosserWert);
		}
		}catch(IntegerOverflowException e){
			System.out.println("Wert ist zu groß " + grosserWert);
		}
	}
}
