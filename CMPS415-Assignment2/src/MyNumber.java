//import org.graalvm.compiler.core.common.util.IntList;
import java.util.Arrays;
public class MyNumber 
{
	private int value;
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int isPrime()
	{
		for(int x = 2; x < value; x++)
		{
			if(value % x == 0)
			{
				return -1;
			}
		}
		return 0;
	}
	public String printPrime()
	{
		if(this.isPrime() == 0)
		{
			return(this.value + " is Prime");
		}
		else
		{
			return(this.value + " is not Prime");
		}
	}
	public int isEven()
	{
		if(value % 2 == 0)
		{
			return(0);
		}
		else
		{
			return(-1);
		}
	}
	public String printEven()
	{
		if(this.isEven() == 0)
		{
			return(this.value + " is Even");
		}
		else
		{
			return(this.value + " is not Even");
		}
	}
	public int [] findFactors()
	{
		int[] factors = new int[0];
		for(int x = 1; x <= this.value; x++)
		{
			if(this.value % x == 0)
			{
				factors = Arrays.copyOf(factors, factors.length + 1);
				factors[factors.length - 1] = x;
			}
		}
		return factors;
	}
	public String printFactors()
	{
		int[] factors = this.findFactors();
		String sFactors = "";
		for(int x = 0; x < factors.length; x++)
		{
			if(sFactors.equals(""))
			{
				sFactors = sFactors + factors[x];
			}
			else
			{
				sFactors = sFactors + "," + factors[x];
			}
			
		}
		return sFactors;
	}
}