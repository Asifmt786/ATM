public class MHS_BankAccount {
    private String bankName = "";
    private String accountNr = "";
    private double balance = 0.0;

    public MHS_BankAccount(){

    }
    public MHS_BankAccount(String bankNameing, String AccountNring, double balanceing) {
      this.bankName = bankNameing;
      this.accountNr = AccountNring;
      this.balance = balanceing;
    }

    public void setBankName(String name) {
      bankName = name;
    }
    public void setAccountNumber(String number) {
      accountNr = number;
    }
    public void setBalance(double money) {
      balance = money;
    }
    public String getBankName() {
      return bankName;
    }
    public String getAccountNumber() {
      return accountNr;
    }
    public double getBalance() {
      return balance;
    }
    public boolean purchase(double price) {
      if(price > balance) {
        return false;
      } else {
        balance = balance - price;
        return true;
      }
    }
  }
