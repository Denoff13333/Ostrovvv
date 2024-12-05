class Plant {
    private int growthStage;

    public Plant() {
        this.growthStage = 1;
    }

    public void grow() {
        if (growthStage < 5) {
            growthStage++;
        }
    }

    public boolean isMature() {
        return growthStage == 5;
    }

    @Override
    public String toString() {
        return isMature() ? "🌳" : "🌱";
    }
}
