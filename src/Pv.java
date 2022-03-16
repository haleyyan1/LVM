import java.util.UUID;
public class Pv extends Ns{
    private String n;
    private UUID u;
    public Pv(String na, String s,String name){
        super(na,s);
        n=name;
        u=UUID.randomUUID();
    }
}
