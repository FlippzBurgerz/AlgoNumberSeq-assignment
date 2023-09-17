package algo.numbersequence;
/**
 * Calculate numbers in the number sequence starting with { 0, 1, 2 }
 * where additional numbers are calculated using the formula:
 * n = (n - 1) + (n - 3) resulting in the sequence
 * { 0, 1, 2, 2, 3, 5, 7, 10, 15, 22, 32, 47, 69, 101 } etc.
 * using a recursive algorithm.
 */
public class NumberSequenceRecursive implements NumberSequence {
	//tiden för metoden dubblas för varje n, det betyder att tids komplexiteten för denna metod är O(2^n)
	@Override
	public long calculate(long n) {
		//skapar ett if statement som returnerar värdet n där värdet på n är mellan 0 och 3
		if (n > 0 && n < 3) //körs bara om n uppfyller kravet, körs bara en gång. O(1)
		{
			return n;
		}
		//skapar ett else if statement som returnerar värdet 0 där n är lika med 0 eller har ett negativt värde
		else if (n <= 0) //körs bara om n uppfyller kravet, körs bara en gång. O(1)
		{
			return 0;
		}
		//(behöver inget else statement, då koden här körs ifall n inte uppfyller kraven för de två tidigare if statements)
		// returnerar det rekursivt beräknade värdet av n
		// där värdet innan platsen n och värdet 3 platser innan n summeras

			return (calculate(n - 1) + calculate(n - 3)); //pga att det är två anrop för calculate i den här raden som kommer gå igenom metoden n ggr så får vi O(2^n)

		// TODO Implement a recursive solution.
	}
}