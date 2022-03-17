public class Pd extends Ns{
    private boolean taken;

    public Pd(String n, String s){
        super(n,s);
        taken=false;
    }

    public boolean isTaken() { return taken; }
    public void setTaken() { taken=true; }

}
