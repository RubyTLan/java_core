class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts;
    private static double totalMoney;


    public BankAccount(double checkingBalance,double savingsBalance){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        numberOfAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void deposit(double amount){
        System.out.println("Please enter account type:checking or saving?");
        String accountType=System.console().readLine();
        if(accountType.equals("checking")){
            this.checkingBalance=this.checkingBalance+amount;

        }else if(accountType.equals("saving")){
             this.savingsBalance+=amount;
        }
        totalMoney+=amount;
    }
    public void withdraw(double amount){
        System.out.println("Please enter account type:checking or saving?");
        String accountType=System.console().readLine();
        if(accountType.equals("checking") && this.checkingBalance>=amount ){
            this.checkingBalance-=amount;
        }else if(accountType.equals("saving") && this.savingsBalance>=amount){
             this.savingsBalance-=amount;
        }else{System.out.println("Error!");}
        totalMoney-=amount;
    }
    public void total(){
        System.out.println(this.checkingBalance+this.savingsBalance);
    }
}
