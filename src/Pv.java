import java.util.UUID;
public class Pv extends Ns {
    private UUID u;
    private Pd p;
    private boolean inVolG;
    private Vg v;
    public Pv(String n, Pd pd){
        super(n,pd.getSize());
        p=pd;
        u=UUID.randomUUID();
        inVolG=false;
    }

    public UUID getU() { return u; }
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
        s+="[ "+u.toString()+"]";
        return s;
    }
}
