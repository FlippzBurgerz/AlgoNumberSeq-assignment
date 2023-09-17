package algo.numbersequence;

import java.util.ArrayList;

/**
 * Calculate numbers in the number sequence starting with { 0, 1, 2 }
 * where additional numbers are calculated using the formula:
 * n = (n - 1) + (n - 3) resulting in the sequence
 * { 0, 1, 2, 2, 3, 5, 7, 10, 15, 22, 32, 47, 69, 101 } etc. using
 * an iterative algorithm.
 */
public class NumberSequenceIterative implements NumberSequence {

	//metodens tidskomplexitet är O(1) + O(1) + O(n) = O(n)
	@Override
	public long calculate(long n) {

		//skapar ett if statement som returnerar värdet n där värdet på n är mellan 0 och 3
		if (n > 0 && n < 3) //O(1) för körs bara om n uppfyller kravet, och körs bara en gång
		{
			return n;
		}
		//skapar ett else if statement som returnerar värdet 0 där n är lika med 0 eller har ett negativt värde
		else if (n <= 0) //O(1) körs bara om n uppfyller kravet, och körs bara en gång
		{
			return 0;
		}
		//tre första nummer som är rätt, och en temp variabel vi kommer använda för att lagra ett
		// värde som kommer behövas för att röra det hela framåt i kedjan
		int tal1 = 0;
		int tal2 = 1;
		int tal3 = 2;
		int temp;
		//skapar en for loop som börjar på indexplats 3 och som kom iterera genom all platser av n
		for(int i = 3; i <= n; i++) //O(n) körs n antal gånger, ifall n blir större så körs den fler gånger
		{
			//vi rör oss framåt i n med hjälp av att öka värderna med varje loop dvs tal1 får värdet av tal2,
			// tal2 får värdet av temp som är startvärdet av tal3 i början av loopen, temp behövs pga att vi ändrar
			// värdet av variabel tal3 till (tal3 + tal1) för att få nya värdet av tal3, trots detta
			// så måste tal2 ha loppstart värdet av tal3 för att loopen sak kunna röra sig framåt

			//här lagras startvärdet av tal3 i temp
			// temp = 2, 2, 3, 5, 7
			temp = tal3;

			//här får tal3 sitt nya värde för nästa loop
			// tal3 = 2, 3, 5, 7, 10
			tal3 = (tal3 + tal1);

			//här får tal1 värdet av tal2
			//tal1 = 1, 2, 2, 3, 5
			tal1 = tal2;

			//här får tal2 sitt nya värde, som är startvärdet tal3
			//hade innan värdet på tal3 blev förändrat inför nästa loop
			//tal2 = 2, 2, 3, 5, 7
			tal2 = temp;
		}

		return tal3;

		// TODO Implement an iterative solution.
	}
}