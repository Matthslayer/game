public abstract class Musuh {
    protected String namaMusuh;
    protected int healthPoint;

    // Constructor: otomatis dijalankan saat object diciptakan
    public Musuh(String nama, int hp) {
        this.namaMusuh = nama;
        this.healthPoint = hp;
    }

    // concrete method - tetap bisa diwariskan utuh
    public void terimaDamage(int damage) {
        this.healthPoint -= damage;
        System.out.println(this.namaMusuh + "terkena serangan biasa. Sisa HP:" + this.healthPoint);
    }

    public abstract void suaraKhas();
    //Abstrak method - tanpa body
    public abstract void serangPemain();
}