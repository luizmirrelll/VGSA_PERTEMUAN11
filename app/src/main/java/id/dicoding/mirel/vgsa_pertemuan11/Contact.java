package id.dicoding.mirel.vgsa_pertemuan11;

public class Contact {

    int id_contact;
    String nama_contact;
    String numberHP_contact;

    public Contact(int id, String name, String _phone_number) {
        this.id_contact = id;
        this.nama_contact = name;
        this.numberHP_contact = _phone_number;
    }

    public Contact(String name, String _phone_number) {
        this.nama_contact = name;
        this.numberHP_contact = _phone_number;
    }

    public Contact() {

        int a = 0;
    }

    public int getID() {

        return this.id_contact;
    }

    public void setID(int id) {

        this.id_contact = id;
    }

    public String getName() {

        return this.nama_contact;
    }

    public void setName(String name) {

        this.nama_contact = name;
    }

    public String getPhoneNumber() {

        return this.numberHP_contact;
    }

    public void setPhoneNumber(String phone_number) {

        this.numberHP_contact = phone_number;
    }
}
