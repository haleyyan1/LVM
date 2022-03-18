import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the LVM system! Enter your commands: \n");
        String command="";
        List list = new List();
        while (!command.equals("exit")){
            System.out.print("cmd# ");
            command=s.nextLine();
            if (command.indexOf("install-drive")!=-1){
                int i = command.indexOf(" ")+1;
                String com = command.substring(i);
                int in = com.indexOf(" ");
                String name = com.substring(0,in);
                String size = com.substring(in+1);
                Pd p = new Pd(name,size);
                list.addPd(p);
                System.out.println("Drive "+name+" installed\n");
            }
            if (command.indexOf("pvcreate")!=-1){
                System.out.println()
            }
        }
    }
}
