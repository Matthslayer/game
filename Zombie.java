public class Zombie extends Musuh implements BisaLoot {
    public Zombie() {
        // memanggil construktor kelas induk abstrak
        super("Zombie ngesot", 150);
    }

    // wajib ada : dipaksa java untuk mengoverride
    @Override
    public void jatuhkanLoot() {
        System.out.println(this.namaMusuh + " jatuhkan exp+50 dan item dasar!");
    }

    @Override
    public void suaraKhas(){
    System.out.println("ggrrr... brainss..");
   }
    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh + "mengejar mencakar dan mengigit! player -20 hp");
    }
}
