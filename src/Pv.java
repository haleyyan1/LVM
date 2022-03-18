import java.util.UUID;
public class Pv extends Nsu {
    private Pd p;
    private boolean inVolG;
    private Vg v;
    public Pv(String n, Pd pd){
        super(n,pd.getSize());
        p=pd;
        inVolG=false;
    }

    public Pd getP() { return p; }
    public boolean isInVolG() { return inVolG; }

    public void setInVolG(Vg v){
        inVolG=true;
        this.v=v;
    }
    public String pvList(){
        String s = printNs();
        if (inVolG) {
            s+="["+v.getName()+"] ";
        }
        s+="[ "+getUUID()+"]";
        return s;
    }
}
