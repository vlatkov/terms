package com.terms.domen;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.Email;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "first_name")
    @Size(max = 100)
    private String firstName;

    @Column(nullable = false, name = "last_name")
    @Size(max = 100)
    private String lastName;

    @Column(nullable = true, name = "user_name")
    @Size(max = 100)
    private String userName;

    @Column(nullable = true, name = "password")
    @Size(max = 256)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = true, name = "new_password")
    @Size(max = 256)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String newPassword;


    @Column(nullable = true, name = "address")
    private String address;

    @Column(nullable = true, name = "phone")
    @Size(min = 8, max = 15)
    private String phone;

    @Email
    @Column(nullable = false, name = "email")
    @Size(min = 5, max = 50)
    private String email;

    @Transient
    @Column(nullable = false, name = "created_date")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date createdDate;

    @Transient
    @Column(nullable = true, name = "valid_from")
    private Date validFrom;

    @Column(nullable = true, name = "valid_to")

    private Date validTo;

    @Column(name = "confirm_password_token")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPasswordToken;

    @Column(name = "token_expiration_date", nullable = true)
    @Nullable
    private Date tokenExpirationDate;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "img_url", nullable = true)
    @Size(max = 256)
    private String imgUrl;

    @Column(name = "last_password_reset_date", nullable = true)
    @Nullable
    private Date lastPasswordResetDate;


  /*  @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;*/

    @ManyToMany
    @Nullable
    @JoinTable(
            name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> authorities;

    @ManyToMany
    @Nullable
    @JoinTable(
            name = "region_user",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id", referencedColumnName = "id")})
    private List<Region> regions;

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    /* public Region getRegion() {
            return region;
        }

        public void setRegion(Region region) {
            this.region = region;
        }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getConfirmPasswordToken() {
        return confirmPasswordToken;
    }

    public void setConfirmPasswordToken(String confirmPasswordToken) {
        this.confirmPasswordToken = confirmPasswordToken;
    }

    public Date getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Date tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", confirmPasswordToken='" + confirmPasswordToken + '\'' +
                ", tokenExpirationDate=" + tokenExpirationDate +
                ", active=" + active +
                ", imgUrl='" + imgUrl + '\'' +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
