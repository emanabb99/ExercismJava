class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        boolean canFastAttack = false;
        if (!knightIsAwake) {
            canFastAttack = true;
        }
        return canFastAttack;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean canSpy = true;
        if(!knightIsAwake && !archerIsAwake && !prisonerIsAwake){
            canSpy = false;
        }
        return canSpy;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean canSignalPrisoner = false;
        if (prisonerIsAwake && !archerIsAwake){
            canSignalPrisoner = true;
        }
        return canSignalPrisoner;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean canFreePrisoner = false;
        if (petDogIsPresent) {
            if(!knightIsAwake && !archerIsAwake) {
                canFreePrisoner = true;
            }
            else if(knightIsAwake && !archerIsAwake && !prisonerIsAwake){
                canFreePrisoner = true;
            }
            else if (knightIsAwake && prisonerIsAwake && !archerIsAwake){
                canFreePrisoner = true;
            }
        }
        else {
            if (prisonerIsAwake && !archerIsAwake && !knightIsAwake){
                canFreePrisoner = true;
            }
        }
        return canFreePrisoner;
    }
}
