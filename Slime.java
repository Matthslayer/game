public class Slime extends Musuh implements BisaLoot {
    public Slime() {
        // memanggil construktor kelas induk abstrak
        super("Slime asli ngawi", 50);
    }

    // wajib ada : dipaksa java untuk mengoverride
    @Override
    public void jatuhkanLoot() {
        System.out.println(this.namaMusuh + " jatuhkan exp+10 dan item dasar!");
    }
    @Override
    public void suaraKhas(){
    System.out.println("blubb  bluubbb");
   }
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + "melompat dan menyiram cairam asam! player -15 hp");
    }
}
