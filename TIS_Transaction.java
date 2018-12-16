public class TIS_Transaction {
public static MHS_Main talkToBank = new MHS_Main();

  public static TIS_TransactionStatus  makeTransaction(String accountNr, double ticketPrice){

    String result = talkToBank.purchaseTicket(accountNr, ticketPrice);

    if(result.equals("Wrong AccountNr")){
      return new TIS_TransactionStatus(false, "");
    }else if(result.equals("Insufficient Funds")){
      return new TIS_TransactionStatus(false, "");
    }else if(result.equals("Nordea") || result.equals("Handelsbanken") ||
              result.equals("SEB") || result.equals("Swedbank")){
        return new TIS_TransactionStatus(true, result);
    } else {
      //what to do if we get something unexpected?
      return new TIS_TransactionStatus(false, "");
    }
  }
}
