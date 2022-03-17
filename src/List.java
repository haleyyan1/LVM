import java.util.ArrayList;
public class List {
    private ArrayList<Pd> pds;
    private ArrayList<Pv> pvs;
    private ArrayList<Vg> vgs;
    private ArrayList<Lv> lvs;
    public List(){
        pds=new ArrayList<Pd>();
        pvs=new ArrayList<Pv>();
        vgs=new ArrayList<Vg>();
        lvs=new ArrayList<Lv>();
    }
    public void addPd(Pd p){
        pds.add(p);
    }
    public void addPv(Pv p){
        pvs.add(p);
    }
    public void addVg(Vg v){
        vgs.add(v);
    }
    public void addLv(Lv l){
        lvs.add(l);
    }

}
