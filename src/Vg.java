import java.util.ArrayList;
import java.util.UUID;

public class Vg extends Nsu{
    private ArrayList<Pv> pv = new ArrayList<Pv>();
    private ArrayList<Lv> lv = new ArrayList<Lv>();
    private String available;
    public Vg(String n,String s,Pv p){
        super(n,p.getSize());
        pv.add(p);
        available=p.getSize();
    }
    public void addLv(Lv l){
        lv.add(l);
        int s = Integer.parseInt(getSize().substring(0,getSize().length()-1));
        s+=Integer.parseInt(l.getSize().substring(0,l.getSize().length()-1));
        setSize(s+"G");

        int a = Integer.parseInt(getSize().substring(0,getSize().length()-1));
        a-=Integer.parseInt(l.getSize().substring(0,l.getSize().length()-1));
        available=a+"G";
    }
    public boolean enoughSpace(String s){
        int i = Integer.parseInt(s.substring(0,s.length()-1));
        int a = Integer.parseInt(available.substring(0,available.length()-1));
        if (i<=a){return true;}
        else return false;
    }
    public void extend(Pv p){
        pv.add(p);
        int s = Integer.parseInt(getSize().substring(0,getSize().length()-1));
        s+=Integer.parseInt(p.getSize().substring(0,p.getSize().length()-1));
        setSize(s+"G");
    }
    public String vgList(){
        String s = getName()+": total:["+getSize()+"] available: ["+available+"] [";
        String pvs = "";
        for (int i =0;i<pv.size();i++){
            pvs+=pv.get(i).getName();
        }
        s+=pvs+"] ["+getUUID()+"] ";
        return s;
    }
}
