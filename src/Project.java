import Utils.CardReaderImpl;
import Utils.ExitUtility;
import Utils.FileReaderImpl;
import Utils.ReaderFactory;

public class Project {

    public static void main(String[] args) {

    System.out.println("Main executing");
        processRead(args);
    }
    private static void processRead(String[] args) {
        {
            ReaderFactory fileReader = new FileReaderImpl();
            ReaderFactory cardReader = new CardReaderImpl();
            // cardReader.readData("/Users/viswamithra/Downloads/IndividualProject_Viswamithra/resources/CreditCards.csv");
            // fileReader.readData("/Users/viswamithra/Downloads/IndividualProject_Viswamithra/resources/Dataset.csv");
            // placeOrder("/Users/viswamithra/Downloads/IndividualProject_Viswamithra/resources/Sample Input File.csv");
            cardReader.readData(args[0]);
            fileReader.readData(args[1]);
            placeOrder(args[2]);
        
        }
    }

    private static void  placeOrder(String path) {

        ExitUtility eu = new ExitUtility();
        eu.outputWriter(path);

    }
}
