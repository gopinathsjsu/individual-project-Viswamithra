package Utils;

import Repo.DataStorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderImpl implements ReaderFactory{

    private DataStorage stockRepository = DataStorage.getInstance();

    @Override
    public void readData(String path) {
            //String csvFile = "/Users/viswamithra/Desktop/Viswamithra_IndividualProject/files/Dataset.csv";
            String csvFile = path;
            BufferedReader br = null;

            try {
                br=new BufferedReader(new FileReader(csvFile));
                String line="";
                int c=0;
                while((line=br.readLine())!=null){
                    System.out.println("True2");
                    if(c==0){
                        c=1;
                    }
                    else{
                        String[] cont=line.split(" ");
                        stockRepository.getPrices().put(cont[1],cont[3]);
                        stockRepository.getquantities().put(cont[1], cont[2]);
                        stockRepository.getcategoryItems().put(cont[1], cont[0]);


                    }
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



    }
}
