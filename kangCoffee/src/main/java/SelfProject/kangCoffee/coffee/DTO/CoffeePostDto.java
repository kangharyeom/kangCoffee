package SelfProject.kangCoffee.coffee.DTO;

import javax.validation.constraints.*;

public class CoffeePostDto {
    @Min(1)
    private long coffeeId;
    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣]*$")
    private String korName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String engName;

    @Min(100L)
    @Max(50000L)
    private long price;


    public Long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Long coffeeId) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
