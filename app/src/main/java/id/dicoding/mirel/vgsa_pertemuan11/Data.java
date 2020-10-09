package id.dicoding.mirel.vgsa_pertemuan11;

public class Data {
    private String id_data,nama_data,alamat_data;
    public Data(){

    }
    public Data(String id,String name,String address){
        this.id_data = id;
        this.nama_data = name;
        this.alamat_data = address;
    }

    public String getId(){

        return id_data;
    }
    public void setId(String id){

        this.id_data = id;
    }
    public String getName(){

        return nama_data;
    }
    public void setName(String name){

        this.nama_data = name;
    }
    public String getAddress(){

        return alamat_data;
    }
    public void setAddress(String address){

        this.alamat_data = address;
    }
}
