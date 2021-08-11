package pl.basicstuff.dmcompanionapp.data.bond;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BondService {
    private final BondRepository bondRepository;

    public void saveBond(Bond bond) {
        bondRepository.save(bond);
    }

    public void updateBond(Bond bond) {
        bondRepository.save(bond);
    }

    public void deleteBond(Bond bond) {
        bondRepository.delete(bond);
    }

    public List<Bond> bondsList() {
        return bondRepository.findAll();
    }

    public Bond findBondById(Long id) {
        return bondRepository.findBondById(id);
    }

    public String getRandomBond() {
        Random random = new Random();
        List<Bond> bonds = bondsList();
        Bond randomBond = bonds.get(random.nextInt(bonds.size()));
        String resultBond = randomBond.getDescription();
        int rollAgain = random.nextInt(10);
        if (rollAgain == 9) {
            bonds.remove(randomBond);
            resultBond = resultBond + "\n" + bonds.get(random.nextInt(bonds.size())).getDescription();
        }

        return resultBond;
    }
}
