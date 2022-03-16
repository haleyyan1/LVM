import java.util.ArrayList;
public class Vg {
    private String na;
    private ArrayList<Pv> pv;
    public Vg(String nam,Pv p){
        na=nam;
        pv.add(p);
    }
    public void extend(Pv p){
        pv.add(p);
    }
}
