import java.util.UUID;
public class Nsu extends Ns{
    private UUID uuid = UUID.randomUUID();
    public Nsu(String n, String s){
        super(n,s);
    }
    public String getUUID(){
        return uuid.toString();
    }
}
