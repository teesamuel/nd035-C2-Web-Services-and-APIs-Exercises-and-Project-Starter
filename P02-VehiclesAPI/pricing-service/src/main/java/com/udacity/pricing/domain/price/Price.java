package com.udacity.pricing.domain.price;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    public Price(String usd, BigDecimal bigDecimal) {
    }

    public Price(Long id, String currency, BigDecimal price, Long vehicleId) {
        this.id = id;
        this.currency = currency;
        this.price = price;
        this.vehicleId = vehicleId;
    }

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
