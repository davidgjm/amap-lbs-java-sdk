package com.davidgjm.cloud.lbs.amap.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class GpsLocation {
    @NotNull
    @Size(min = -180, max = 180)
    private BigDecimal longitude;

    @NotNull
    @Size(min = -90, max = 90)
    private BigDecimal latitude;

    public GpsLocation(@NotNull @Size(min = -180, max = 180) BigDecimal longitude, @NotNull @Size(min = -90, max = 90) BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GpsLocation that = (GpsLocation) o;
        return Objects.equals(getLongitude(), that.getLongitude()) &&
                Objects.equals(getLatitude(), that.getLatitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongitude(), getLatitude());
    }

    @Override
    public String toString() {
        return "GpsLocation{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public String asFieldValue() {
        return longitude.toPlainString() + ',' + latitude.toPlainString();
    }

    /**
     * Creates this object from the provided string form coordinates
     * @param longi longitude
     * @param lati latitude
     * @return a object representing the coordinates
     */
    public static GpsLocation from(@NotNull @NotBlank String longi, @NotNull @NotBlank String lati) {
        return new GpsLocation(BigDecimal.valueOf(Double.parseDouble(longi)), BigDecimal.valueOf(Double.parseDouble(lati)));
    }
}
