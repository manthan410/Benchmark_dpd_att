
interface CharacterAbility {
    void useAbility();
}
class WarriorAbility implements CharacterAbility {
    @Override
    public void useAbility() {
    }
}
class MageAbility implements CharacterAbility {
    @Override
    public void useAbility() {
    }
}
class GameCharacter {
    private CharacterAbility ability;
    public void setAbility(CharacterAbility ability) {
        this.ability = ability;
    }
    public void performAbility() {
        ability.useAbility();
    }
}
