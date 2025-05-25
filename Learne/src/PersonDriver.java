import java.util.ArrayList;

public class PersonDriver {

	public static void main (String [] args)
	{
		PersonDriver t = new PersonDriver ();
		t.testPerson();
		
	}
	
	public void testPerson ()
	{
		Person [] personArray = fillArrayWithPersonObjects ();
		printPersonObjects(personArray);
	}
	
	private Person [] fillArrayWithPersonObjects ()
	{
		Person[] temp = new Person[5];
		temp[0] = new Person ("Fred", 32, false);
		temp[1] = new Person ("Jill", 22, true);
		temp[2] = new Person ("Mike", 21, true);
		temp[3] = new Person ("Sam", 25, false);
		temp[4] = new Person ("Mary", 22, true);
		temp[4] = new Person ("Lily", 28, false);
		// temp[2] =
		// temp[3] =
		// temp[4] =
		return temp;
	}
	
	private void printPersonObjects(Person[] pa)
	{
		for (int i = 0; i < 2; i++)
		{
			System.out.println (pa[i].toString());
		}
	}

}