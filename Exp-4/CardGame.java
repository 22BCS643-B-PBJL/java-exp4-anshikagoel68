import java.util.*;
class Card {
    String symbol;
    int number;
    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return symbol + " " + number;
    }
}
public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Cards : ");
        int N = scanner.nextInt();
        Map<String, List<Card>> cardMap = new TreeMap<>();
        for (int i = 1; i <= N; i++) {
            System.out.println("Enter card " + i + ": ");
            System.out.print("Symbol: ");
            String symbol = scanner.next();
            System.out.print("Number: ");
            int number = scanner.nextInt();
            Card card = new Card(symbol, number);
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(card);
        }
        System.out.println("Distinct Symbols are : ");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        for (String symbol : cardMap.keySet()) {
            List<Card> cards = cardMap.get(symbol);
            System.out.println("Cards in " + symbol + " Symbol");
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card);
                sum += card.getNumber();
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }
    }
}
