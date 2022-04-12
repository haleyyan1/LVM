public class Lv extends Nsu{
    //needs uuid
    private Vg v;
    public Lv(String n, String s, Vg v){
        super(n,s);
        this.v=v;
    }
    public String lvList(){
        return printNs()+"["+v.getName()+"] ["+getUUID()+"] ";
    }
}
