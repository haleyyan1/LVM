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
                String drive = c.substring(c.indexOf(" ")+1);
                if (list.getPds().size()==0){
                    System.out.println("No physical drives exist");
                }
                boolean b = true;
                for (int i=0;i<list.getPvs().size();i++){
                    if (list.getPvs().get(i).getName().equals(name)){
                        b=false;
                    }
                }
                if (!b){
                    System.out.println("Physical volume name "+name+" already exists");
                }
                else {
                    boolean bo = false;
                for (int in = 0;in<list.getPds().size();in++){
                    if (list.getPds().get(in).getName().equals(drive)&&!list.getPds().get(in).isTaken()){
                        list.addPv(new Pv(name,list.getPds().get(in)));
                        list.getPds().get(in).setTaken();
                        System.out.println(name+" created");
                        bo=true;
                        break;
                    }
                    else if (list.getPds().get(in).getName().equals(drive)&&list.getPds().get(in).isTaken()){
                        System.out.println("Drive "+drive+" already has volume");
                        bo=true;
                    }
                }
                if (!bo){
                    System.out.println("Physical drive "+drive+" does not exist");
                }
                }
            }
            if (command.indexOf("vgcreate")!=-1){
                String c = command.substring(command.indexOf(" ")+1);
                String name = c.substring(0,c.indexOf(" "));
                String pvName = c.substring(c.indexOf(" ")+1);
                boolean exists=false;
                for (int in = 0; in<list.getVgs().size();in++){
                    if (list.getVgs().get(in).getName().equals(name)){
                        exists=true;
                    }
                }
                if (exists){
                    System.out.println("Volume group "+name+" already exists");
                }
                else {
                boolean b = false;
                for (int i = 0;i<list.getPvs().size();i++){
                    if (list.getPvs().get(i).getName().equals(pvName)&&!list.getPvs().get(i).isInVolG()){
                        Vg v = new Vg(name,"s",list.getPvs().get(i));
                        list.addVg(v);
                        list.getPvs().get(i).setInVolG(v);
                        System.out.println(name+" created");
                        b=true;
                    }
                    else if (list.getPvs().get(i).getName().equals(pvName)){
                        System.out.println("Physical volume "+pvName+" is part of another volume group");
                        b=true;
                    }
                }
                if (!b){
                    System.out.println("Physical volume "+pvName+" does not exist");
                } }
            }
            if (command.indexOf("vgextend")!=-1){
                String c = command.substring(command.indexOf(" ")+1);
                String vgName = c.substring(0,c.indexOf(" "));
                String pvName = c.substring(c.indexOf(" ")+1);
                boolean vgExists = false;
                for (int i = 0; i<list.getVgs().size();i++){
                    if (list.getVgs().get(i).getName().equals(vgName)){
                        vgExists=true;
                    }
                }
                boolean pvExists = false;
                for (int i = 0; i<list.getPvs().size();i++){
                    if (list.getPvs().get(i).getName().equals(pvName)){
                        pvExists=true;
                    }
                }
                if (!vgExists){
                    System.out.println("Volume group "+vgName+" does not exist");
                }
                else if (!pvExists){
                    System.out.println("Physical volume "+pvName+" does not exist");
                }
                else {
                    for (int i = 0; i<list.getPvs().size();i++){
                        if (list.getPvs().get(i).getName().equals(pvName)){
                            if (list.getPvs().get(i).isInVolG()){
                                System.out.println("Physical volume "+pvName+" is part of another volume group");
                            }
                            else {
                                for (int ind = 0; ind<list.getVgs().size();ind++){
                                    if (list.getVgs().get(ind).getName().equals(vgName)){
                                        list.getVgs().get(ind).extend(list.getPvs().get(i));
                                    }
                                }
                                System.out.println(pvName+" added to "+vgName);
                            }
                        }
                    }
                }
            }
            if (command.indexOf("lvcreate")!=-1){
                String c = command.substring(command.indexOf(" ")+1);
                String lvName = c.substring(0,c.indexOf(" "));
                String second = c.substring(c.indexOf(" ")+1);
                String size = second.substring(0,second.indexOf(" "));
                String vgName = second.substring(second.indexOf(" ")+1);
                boolean exists = false;
                for (int i = 0; i<list.getLvs().size();i++){
                    if (list.getLvs().get(i).getName().equals(lvName)){
                        System.out.println("Logical volume "+lvName+" already exists");
                        exists=true;
                    }
                }
                if (!exists){
                    boolean b = false;
                    for (int i = 0;i<list.getVgs().size();i++){
                        if (list.getVgs().get(i).getName().equals(vgName)){
                            b=true;
                        }
                    }
                    if (b) {
                        for (int i = 0;i<list.getVgs().size();i++){
                            if (list.getVgs().get(i).getName().equals(vgName)){
                                if (list.getVgs().get(i).enoughSpace(size)){
                                    list.addLv(new Lv(lvName, size, list.getVgs().get(i)));
                                    System.out.println(lvName+" created");
                                }
                                else{
                                    System.out.println("Not enough space");
                                }
                            }
                        }
                    }
                    else {
                        System.out.println(vgName+" does not exist");
                    }
                }
            }
            if (command.indexOf("list-drive")!=-1){
                for (int i = 0; i<list.getPds().size();i++){
                    System.out.println(list.getPds().get(i).printNs());
                }
            }
            if (command.indexOf("pvlist")!=-1){
                for (int i = 0;i<list.getPvs().size();i++){
                    System.out.println(list.getPvs().get(i).pvList());
                }
            }
            if (command.indexOf("vglist")!=-1){
                for (int i = 0; i<list.getVgs().size();i++){
                    System.out.println(list.getVgs().get(i).vgList());
                }
            }
            if (command.indexOf("lvlist")!=-1){
                for (int i = 0; i<list.getLvs().size();i++){
                    System.out.println(list.getLvs().get(i).lvList());
                }
            }
        }
        if (command.equals("exit")){
            System.out.println("Goodbye");
        }
    }
}
