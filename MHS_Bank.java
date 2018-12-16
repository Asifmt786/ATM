import java.util.ArrayList;

public class MHS_Bank {
  public static ArrayList<MHS_BankAccount> bankList = new ArrayList();
  MHS_BankAccount No = new MHS_BankAccount("Nordea", "1234575590", 50990.30);
  MHS_BankAccount Ha = new MHS_BankAccount("Handelsbanken", "1423598090", 20.25);
  MHS_BankAccount SE = new MHS_BankAccount("SEB", "5531877890", -150.12);
  MHS_BankAccount Sw = new MHS_BankAccount("Swedbank", "9915690349", 420.48);

  public void setupAccounts(){
    bankList.add(No);
    bankList.add(Ha);
    bankList.add(SE);
    bankList.add(Sw);
  }

  public boolean addAccount(String bankName, String accountNr, double balance){
    if(accountGoodFormat(bankName, accountNr) && !accountExists(accountNr)) {
      MHS_BankAccount accnew = new MHS_BankAccount();
      accnew.setBankName(bankName);
      accnew.setAccountNumber(accountNr);
      accnew.setBalance(balance);
      bankList.add(accnew);
      return true;
    } else {
      return false;
    }
  }

  public boolean accountGoodFormat(String bankName, String accountNumber) {
    boolean good = false;
    if(!(accountNumber.length() == 10)) {
      return false;
    }
    switch(bankName){
      case "Nordea":
        if(accountNumber.substring(0, 4).contains("1234")) {
          good = true;
        }
        break;
      case "Handelsbanken":
        if(accountNumber.substring(0, 4).contains("1423")) {
          good = true;
        }
        break;
      case "SEB":
        if(accountNumber.substring(0, 4).contains("5531")) {
          good = true;
        }
        break;
      case "Swedbank":
        if(accountNumber.substring(0, 5).contains("99156")
        && accountNumber.substring(9).contains("9")) {
          good = true;
        }
        break;
      default:
        good = false;
        break;
    }
    return good;
  }

  public boolean accountExists(String accountNumber) {
    boolean found = false;
    for(int i = 0; i < bankList.size(); i++) {
      if(bankList.get(i).getAccountNumber().contains(accountNumber)) {
        found = true;
      }
    }
    return found;
  }
  public static String makePurchase(String accountNumber, double ticketPrice) {
    String result = "";

    //Karin testar
    System.out.println("Number of accounts in list: "+ bankList.size());

    for(int i = 0; i < bankList.size(); i++) {
      if(bankList.get(i).getAccountNumber().contains(accountNumber)) {
        if(bankList.get(i).purchase(ticketPrice)) {
          result = bankList.get(i).getBankName();
          break;
        } else {
          result = "Insufficient Funds";
          break;
        }
      } else {
        result = "Wrong AccountNr";
      }
    }
    return result;
  }
}
