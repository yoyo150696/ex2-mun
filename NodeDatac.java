package api;

public class NodeDatac implements NodeData{
    private GeoLocation pos;
    private int id;
    public NodeDatac(int id){
        this.id=id;
    }
    @Override
    public int getKey() {
        return this.id;
    }

    @Override
    public GeoLocation getLocation() {
        return pos;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setWeight(double w) {

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

    @Override
    public void setLocation(GeoLocation p) {
      this.pos=p;
    }
}
