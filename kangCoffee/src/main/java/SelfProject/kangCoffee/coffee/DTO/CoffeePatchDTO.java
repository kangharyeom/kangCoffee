package SelfProject.kangCoffee.coffee.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CoffeePatchDTO {
    @NotEmpty
    @Min(1)
    private long coffeeId;
    @NotEmpty
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣]*$")
    private String korName;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String engName;

    @NotEmpty
    @Min(100)
    @Max(50000)
    private long price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
