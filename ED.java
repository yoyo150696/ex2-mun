package Ex2.src.api;

public class ED implements EdgeData{
    int src;
    int dest;
    double weight;
    public ED(int src,double weight,int dest){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
    @Override
    public int getSrc() {
        return src;
    }

    @Override
    public int getDest() {
        return dest;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public void setTag(int t) {

    }
}
