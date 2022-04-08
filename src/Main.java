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
                boolean b = true;
                for (int ind=0; ind<list.getPds().size();ind++){
                    if (list.getPds().get(ind).getName().equals(name)){
                        b=false;
                    }
                }
                if (b) {
                Pd p = new Pd(name,size);
                list.addPd(p);
                System.out.println("Drive "+name+" installed\n"); }
                else { System.out.println("Drive already installed"); }
            }
            if (command.indexOf("pvcreate")!=-1){
                String c = command.substring(command.indexOf(" ")+1);
                String name = c.substring(0,c.indexOf(" "));
                String drive = c.substring(c.indexOf(" "));
                boolean b = true;
                for (int i=0;i<list.getPvs().size();i++){
                    if (list.getPvs().get(i).getName().equals(name)){
                        b=false;
                    }
                }
                boolean exists=false;
                int index = 0;
                for (int in = 0;in<list.getPds().size();in++){
                    if (list.getPds().get(in).getName().equals())
                }
            }
        }
    }
}
