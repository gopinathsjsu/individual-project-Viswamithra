package Utils;

import Repo.DataStorage;

import java.io.*;
import java.util.HashMap;

public class ExitUtility {

        public void outputWriter(String inputPath)
        {
            DataStorage stockRepository = DataStorage.getInstance();
            System.out.println("StockRepo : " + stockRepository);
            //String inputFilePath = "/Users/viswamithra/Desktop/Viswamithra_IndividualProject/files/Sample Input File.csv";
            String inputFilePath = inputPath;
            Double amtpaid=0.0;
            HashMap<String,String> catquant=new HashMap<String,String>();
            try{
                catquant.put("Essential","3");
                catquant.put("Luxury","5");
                catquant.put("Misc","6");
                int error=0;
                PrintWriter writer = new PrintWriter("/Users/viswamithra/Downloads/IndividualProject_Viswamithra/resources/output.txt");
                FileWriter cwriter = new FileWriter("/Users/viswamithra/Downloads/IndividualProject_Viswamithra/resources/CreditCards.csv" ,true);
                BufferedWriter out=new BufferedWriter(cwriter);
                BufferedReader br3=new BufferedReader(new FileReader(inputFilePath));
                String line2="";
                int c2=0;
                while((line2=br3.readLine())!=null){
                    if(c2==0){
                        c2=1;
                    }else{
                        String[] ans=line2.split(" ");
                        String item=ans[0];
                        Double quanty=Double.parseDouble(ans[1]);
                        String cardn=ans[2]+" "+ ans[3] + " "+ ans[4]+" " + ans[5];
                        if(Double.parseDouble(catquant.get(stockRepository.getcategoryItems().get(item)))>0){

                            if(Double.parseDouble(stockRepository.getquantities().get(item))>=quanty){

                                amtpaid+=quanty*Double.parseDouble(stockRepository.getPrices().get(item));
                                Double x=Double.parseDouble(stockRepository.getquantities().get(item));
                                x=x-quanty;
                                stockRepository.getquantities().put(item,Double.toString(x));
                                x=Double.parseDouble(catquant.get(stockRepository.getcategoryItems().get(item)));
                                x=x-quanty;
                                catquant.put(stockRepository.getcategoryItems().get(item),Double.toString(x));
                                if(!stockRepository.getcards().contains(cardn)){
                                    out.newLine();
                                    out.write(cardn);
                                    stockRepository.getcards().add(cardn);
                                }

                            }
                            else{
                                writer.write("Please correct the quantities"+" \n" +"Items with incorrect quantities" +"\n" + item+"\n");
                                error=1;
                                break;
                            }
                        }
                        else{
                            writer.write("Please correct quantities of one of the items: "+item+"\n" + " \n");
                            writer.write("Items with incorrect quantities: " + item);
                            error=1;
                            break;
                        }


                    }
                }
                System.out.println(amtpaid);
                if(error==0){
                    writer.write("Amt Paid\n");
                    writer.write(Double.toString(amtpaid));
                }
                out.close();
                
                writer.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }

}
