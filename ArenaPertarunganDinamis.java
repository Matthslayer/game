import java.util.Scanner;
import java.util.ArrayList;

public class ArenaPertarunganDinamis {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Musuh> gelombangMonster = new ArrayList<>();
        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Naga());
        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Zombie());

        System.out.println("\n=====================================");
        System.out.println("   ARENA RPG: GELOMBANG MONSTER ");
        System.out.println("=====================================");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        while (isBermain && !gelombangMonster.isEmpty()) {

            System.out.println("\n------ STATUS MONSTER ------");

            for (int i = 0; i < gelombangMonster.size(); i++) {
                Musuh m = gelombangMonster.get(i);
                System.out.println((i + 1) + ". " + m.namaMusuh +
                                   " (HP: " + m.healthPoint + ")");
            }

            System.out.println("0. Kabur dari petarungan");
            System.out.print("\nPilih target monster: ");

            try {

                int pilihanTarget = input.nextInt();

                // Kabur
                if (pilihanTarget == 0) {
                    System.out.println("Cupu bet lu lari terbirit-birit");
                    isBermain = false;
                    continue;
                }

                // Validasi target
                if (pilihanTarget < 1 ||
                    pilihanTarget > gelombangMonster.size()) {

                    System.out.println("LIHAT bener-bener ANGKA nya :D");
                    continue;
                }

                int indeksMonster = pilihanTarget - 1;
                Musuh target = gelombangMonster.get(indeksMonster);

                System.out.print("Masukin kekuatan serangan lu (10 - 100): ");
                int power = input.nextInt();

                // Validasi damage
                if (power < 10 || power > 100) {
                    throw new SeranganTidakValidException(
                        "HARUS antara 10 - 100!"
                    );
                }

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");

                target.terimaDamage(power);

                // Monster mati
                if (target.healthPoint <= 0) {

                    System.out.println(
                        target.namaMusuh + " hancur menjadi debu!"
                    );

                    if (target instanceof DropItem) {
                        DropItem loot = (DropItem) target;
                        loot.dropItem();
                    }

                    gelombangMonster.remove(indeksMonster);
                }

                // Giliran monster
                System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");

                for (int i = 0; i < gelombangMonster.size(); i++) {

                    Musuh monsterAktif = gelombangMonster.get(i);

                    if (monsterAktif.healthPoint > 0) {

                        monsterAktif.suaraKhas();

                        if (monsterAktif instanceof BisaTerbang) {

                            System.out.println(
                                "[PERINGATAN! SERANGAN UDARA TERDETEKSI]"
                            );

                            BisaTerbang monsterTerbang =
                                (BisaTerbang) monsterAktif;

                            monsterTerbang.lepasLandas();
                            monsterTerbang.seranganUdara();

                        } else {

                            monsterAktif.serangPemain();
                        }
                    }
                }

                // Cek semua monster mati
                if (gelombangMonster.isEmpty()) {
                    System.out.println(
                        "\nYa ya congrats, lu menang."
                    );
                    isBermain = false;
                }

            } catch (SeranganTidakValidException e) {

                System.out.println("ERROR: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Input harus angka!");
                input.nextLine(); // bersihin buffer
            }

            System.out.println(
                "\n---------------------------------------------"
            );
        }

        input.close();
        System.out.println("\nGame Over.");
    }
}
    

