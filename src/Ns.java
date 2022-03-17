public class Ns {
    private String name;
    private String size;
    public Ns(String n, String s){
        name=n;
        size=s;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String printNs(){
        return(name+": ["+size+"] ");
    }
}
