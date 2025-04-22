package project.flux.api.v1.models.common.enums;

public enum DeliveryType {
	ECONOMICAL(1.15),
	CONVENTIONAL(1.45),
	FAST(1.75);

    private final double price;

    DeliveryType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}