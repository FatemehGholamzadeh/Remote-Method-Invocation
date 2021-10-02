package DS.RMI;


public interface Account extends Remote {
    int withdraw(int id,int amount);
    int deposit(int id,int amount);
    int getBalance(int id);
    boolean startsWith(int id, char ch);
    String getName(int id);
    double check(int id);

}
