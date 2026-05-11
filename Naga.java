public class Naga extends Musuh implements BisaTerbang, BisaLoot {
    public Naga() { super("Naga Suki Liar", 500); 
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + " menggigit! Pemain -30 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Suara: *ROAAAARRRR!!!*");
    }

    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuh + " terbang tinggi! Sulit diserang.");
    }

    @Override
    public void seranganUdara() {
        System.out.println(this.namaMusuh + " menyemburkan badai api! Pemain -80 HP.");
    }

    @Override
    public void jatuhkanLoot() {
        System.out.println(this.namaMusuh + " jatuhkan exp+100 dan item sisik naga api!");
    }
}