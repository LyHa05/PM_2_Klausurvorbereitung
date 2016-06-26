package thomas.a07;


public class Ueberlauf {
	
	public Integer lauf(int x, int y)throws IntegerOverflowException{
		
		try{
			return Math.addExact(x, y);
		}catch(ArithmeticException e){
			throw new IntegerOverflowException("Wert ist zu groß!");
		}
		
		
		}
	
	
	
	public static void main(String[] args) throws IntegerOverflowException {
		Ueberlauf u=new Ueberlauf();
		try{
			for(int i=0; true ; i +=100000){
				System.out.println(u.lauf(i,i));
				
			}
			
		}catch(IntegerOverflowException e){
			System.out.println("Wert ist zu groß ");
		}
	}

	}


