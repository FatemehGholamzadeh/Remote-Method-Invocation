package DS.RMI;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Server implements Account {

    private HashMap<Integer,Integer> balanceTable;
    private HashMap<Integer,String> nameTable;


    public Server(){
        balanceTable = new HashMap<>();
        nameTable = new HashMap<>();
        balanceTable.put(1234,9000);
        nameTable.put(1234,"Fatemeh Gholamzadeh");
        balanceTable.put(8888,22000);
        nameTable.put(8888,"Mitra Mohandes");
        balanceTable.put(3434,80000);
        nameTable.put(3434,"Hasti Nikui");
    }

    @Override
    public int withdraw(int id,int amount) {
        int newBalance = balanceTable.get(id)+amount;
        balanceTable.replace(id,newBalance);
        return newBalance;
    }

    @Override
    public int deposit(int id, int amount) {
        int newBalance = balanceTable.get(id)-amount;
        balanceTable.replace(id,newBalance);
        return newBalance;
    }

    @Override
    public int getBalance(int id) {
        return balanceTable.get(id);
    }

    @Override
    public boolean startsWith(int id, char ch) {
        String name = nameTable.get(id);
        return name.startsWith(Character.toString(ch));
    }

    @Override
    public String getName(int id) {
        return nameTable.get(id);
    }

    @Override
    public double check(int id) {
        int a = balanceTable.get(id);
        return Double.valueOf(a);
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Server server = new Server();
        Registry registry = new Registry();
        registry.bind("Account", server);
    }

}








