import java.util.ArrayList;
//Needs uuid
public class Vg extends Ns{
    private ArrayList<Pv> pv;
    public Vg(String n,String s,Pv p){
        super(n,s);
        pv.add(p);
    }
    public void extend(Pv p){
        pv.add(p);
        int s = Integer.parseInt(getSize().substring(0,getSize().length()-1));
        s+=Integer.parseInt(p.getSize().substring(0,p.getSize().length()-1));
        setSize(s+"G");
    }
    public String vgList(){
        String s = getName()+": total:["+getSize()+"] available:"

    }
}
