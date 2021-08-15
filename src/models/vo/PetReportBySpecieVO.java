package models.vo;


public class PetReportBySpecieVO {

    private int count;
    private String specie;
        
    public PetReportBySpecieVO() { }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }   
}