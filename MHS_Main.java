public class MHS_Main {
  public static MHS_Bank allBanks = new MHS_Bank();

  public MHS_Main() {
    allBanks.setupAccounts();
  }
  public static String purchaseTicket(String accountNr, Double ticketPrice) {
    return allBanks.makePurchase(accountNr, ticketPrice);
  }

}
