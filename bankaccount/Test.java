public class Test {
	public static void main(String[] args) {
		BankAccount account1=new BankAccount(0.0,0.0);
        BankAccount account2=new BankAccount(0.0,0.0);
		account1.deposit(10.0);
        System.out.println(account1);
        // System.out.println(numberOfAccounts);
        System.out.println(account1.getCheckingBalance());
		// account1.withdraw(5);
		// account2.deposit(20);
		// account1.withdraw(10);
		// System.out.println(account1.getCheckingBalance());
		// System.out.println(account2.getCheckingBalance());
		// account1.total();
		// account2.total();
		// System.out.println(int numberOfAccounts);
		// System.out.println(double totalMoney);

	}

}
